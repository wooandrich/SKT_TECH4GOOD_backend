package com.skt4good.controller;

import com.skt4good.service.ChatService;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/chat-gpt")
public class GptController {

    private final ChatService chatService;
    private final ChatgptService chatgptService;

    @PostMapping("")
    public List<String> test(@RequestBody String question) {
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arr.add(chatService.getChatResponse(
                    "사용자가 글을 쓰면 {사회생활, 미래설계, 인간관계, 건강, 실패} 중에 가장 가까운 키워드 하나를 알려줘 :"
                            + question));

        }

        return arr;
    }
}