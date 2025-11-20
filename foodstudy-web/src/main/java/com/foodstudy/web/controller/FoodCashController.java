package com.foodstudy.web.controller;

import com.foodstudy.web.model.FoodCash;
import com.foodstudy.web.service.FoodCashService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodcash")
public class FoodCashController {

    private final FoodCashService foodCashService;

    public FoodCashController(FoodCashService foodCashService) {
        this.foodCashService = foodCashService;
    }

    // 1. Consultar saldo
    @GetMapping("/{id}/saldo")
    public float consultarSaldo(@PathVariable Long id) {
        return foodCashService.consultarSaldo(id);
    }

    // 2. Adicionar saldo
    @PostMapping("/{id}/adicionar")
    public FoodCash adicionarSaldo(@PathVariable Long id,
                                   @RequestParam float valor) {
        return foodCashService.adicionarSaldo(id, valor);
    }

    // 3. Descontar saldo
    @PostMapping("/{id}/descontar")
    public FoodCash descontarSaldo(@PathVariable Long id,
                                   @RequestParam float valor) {
        return foodCashService.descontarSaldo(id, valor);
    }
}
