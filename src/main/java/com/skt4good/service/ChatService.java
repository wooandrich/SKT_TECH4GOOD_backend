package com.skt4good.service;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatgptService chatgptService;

    public String getChatResponse(String prompt) {
        return chatgptService.sendMessage(prompt);
    }

    public String getImageResponse(String prompt) {
        return chatgptService.imageGenerate(prompt);
    }
}
