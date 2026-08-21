package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.model.FoodItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChatGptService {
    private final WebClient webClient;
    private final String apiKey;

    public ChatGptService(WebClient webClient, @Value("${openai.api-key}") String apiKey) {
        this.webClient = webClient;
        this.apiKey = apiKey;
    }

    public Mono<String> generateRecipe(List<FoodItem> foodItems) {
        String alimentos = foodItems.stream()
                .map(item -> String.format("%s (%s) - Quantidade: %d, Validade: %s",
                        item.getNome(), item.getCategorias(), item.getQuantidade(), item.getValidade()))
                .collect(Collectors.joining("\n"));

        String prompt = "Baseado no meu banco de dados faça uma receita com os seguintes itens:\n " + alimentos;

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4o",
                "messages", List.of(
                        Map.of("role", "system", "content", "Você é um assistente que cria receitas"),
                        Map.of("role", "user", "content", prompt)
                )
        );

        return webClient.post()
                .uri("/chat/completions")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    var choices = (List<Map<String, Object>>) response.get("choices");
                    if (choices != null && !choices.isEmpty()) {
                        var message = (Map<String, Object>) choices.get(0).get("message");
                        return message.get("content").toString();
                    }
                    return "Nenhuma receita foi gerada";
                })
                .onErrorReturn("Não foi possível gerar a receita no momento. Tente novamente mais tarde.");
    }
}