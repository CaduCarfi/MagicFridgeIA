package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.model.FoodItem;
import dev.java10x.MagicFridgeAI.repository.FoodItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public FoodItem salvar(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public Optional<FoodItem> buscarPorId(Long id) {
        return foodItemRepository.findById(id);
    }

    public List<FoodItem> listar() {
        return foodItemRepository.findAll();
    }

    public FoodItem atualizar(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public void excluir(Long id) {
        foodItemRepository.deleteById(id);
    }


}
