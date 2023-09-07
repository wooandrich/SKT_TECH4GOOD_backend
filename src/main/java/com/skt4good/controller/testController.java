package com.skt4good.controller;

import com.skt4good.service.ChatService;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/chat-gpt")
public class testController {

    private final ChatService chatService;
    private final ChatgptService chatgptService;

    @PostMapping("")
    public String test(@RequestBody String question) {
        return chatService.getChatResponse(
                "사용자가 글을 쓰면 {진로고민, 심리, 인간관계, 건강, 취미, 취업, 실패} 중에 가장 가까운 키워드 하나를 알려줘 :"
                + question);
    }
}
