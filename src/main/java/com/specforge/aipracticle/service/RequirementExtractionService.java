package com.specforge.aipracticle.service;

import com.specforge.aipracticle.dto.RequirementExtractionRequestDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class RequirementExtractionService {
    private final ChatClient chatClient;

    RequirementExtractionService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
    public String extractRequirements(RequirementExtractionRequestDto requirement){
        String prompt = """
                You are a professional software requirements analyst.

                Extract software requirements from the project description.

                Rules:
                - Separate functional and non-functional requirements.
                - Write each requirement clearly.
                - Do not invent functionality.
                - Identify vague or incomplete requirements.
                - Use simple, professional language.

                Project description:
                %s
                """.formatted(requirement.description());
        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();


    }
}
