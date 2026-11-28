package com.specforge.aipracticle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.validation.constraints.*;

public record RequirementExtractionRequestDto(
        @NotBlank(message = "Description can't be empty")
        @Size(max = 10000, message = "Description can't be more than 10000 characters")
         String description) {



}
