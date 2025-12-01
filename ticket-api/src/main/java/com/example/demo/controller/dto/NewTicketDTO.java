package com.example.demo.controller.dto;

/*
 * -- C -> Mother of All Languages
 * -- Turing Complete Language
 * -- LINGUAGEM DECLARATIVA (linguagem de pedidos)
 * CREATE TABLE users (
 *      name VARCHAR(20) NOT NULL CHECK LEN(name) >= 3 
 * )
 */

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*item VARCHAR(255),
    to_do VARCHAR(255),
    details VARCHAR(255),
    place VARCHAR(255),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP, */

public record NewTicketDTO(
        @NotNull(message = "É obrigatório o criador")
        int creator,
        @NotNull(message = "É obrigatório o destinatário")
        int destinatary,
        @NotBlank(message = "É obrigatório o item")
        String item,
        @NotBlank(message = "É obrigatório a ação")
        String to_do,
        String details,
        @NotBlank(message = "É obrigatório o lugar")
        String place
)  {

}
