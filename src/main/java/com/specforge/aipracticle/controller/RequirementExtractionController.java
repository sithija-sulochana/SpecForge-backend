package com.specforge.aipracticle.controller;

import com.specforge.aipracticle.dto.RequirementExtractionRequestDto;
import com.specforge.aipracticle.dto.RequirementExtractionResponseDto;
import com.specforge.aipracticle.service.RequirementExtractionService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lab")
public class RequirementExtractionController {
    private  final RequirementExtractionService requirementService;



    public RequirementExtractionController(RequirementExtractionService requirementService) {
        this.requirementService = requirementService;
    }


    @PostMapping("/requirements/extract")
    public ResponseEntity<RequirementExtractionResponseDto> extractRequirements(
            @Valid @RequestBody RequirementExtractionRequestDto request) {

        String result = requirementService.extractRequirements(request);

        RequirementExtractionResponseDto response =
                new RequirementExtractionResponseDto(result, "phi3");

        return ResponseEntity.ok(response);
    }
}
