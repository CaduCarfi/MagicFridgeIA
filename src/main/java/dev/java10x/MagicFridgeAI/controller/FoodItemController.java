package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.model.FoodItem;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    //POST
    @PostMapping
    public ResponseEntity<FoodItem> criar(@RequestBody FoodItem foodItem) {
        FoodItem salvo = foodItemService.salvar(foodItem);
        return ResponseEntity.ok(salvo);
    }

    //GET
    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> buscar(@PathVariable Long id) {
        return foodItemService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //GET
    @GetMapping
    public ResponseEntity<List<FoodItem>> listar() {
        List<FoodItem> lista = foodItemService.listar();
        return ResponseEntity.ok(lista);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> atualizar(@RequestBody FoodItem foodItem, @PathVariable Long id) {
        return foodItemService.buscarPorId(id)
                .map(itemExistente -> {
                    foodItem.setId(itemExistente.getId());
                    FoodItem atualizado = foodItemService.atualizar(foodItem);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        foodItemService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
