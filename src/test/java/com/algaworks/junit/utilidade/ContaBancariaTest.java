package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ContaBancariaTest {

    private ContaBancaria contaBancaria;

    @BeforeEach
    void setup() {
        contaBancaria = new ContaBancaria(new BigDecimal("100.00"));
    }

    @DisplayName("Método para sacar")
    @Test
    void dada_uma_conta_bancaria_quando_tentar_sacar_entao_saque() {

        contaBancaria.saque(new BigDecimal("30.00"));

        assertEquals(new BigDecimal("70.00"), contaBancaria.saldo());
    }

    @DisplayName("Método para depositar")
    @Test
    void dada_uma_conta_bancaria_quando_tentar_depositar_entao_deposite() {
        contaBancaria.deposito(new BigDecimal("30.00"));

        assertEquals(new BigDecimal("130.00"), contaBancaria.saldo());
    }

    @DisplayName("Método para ver saldo")
    @Test
    void dada_uma_conta_bancaria_quando_tentar_consultar_entao_mostra_saldo() {
        assertEquals(new BigDecimal("100.00"), contaBancaria.saldo());
    }
}