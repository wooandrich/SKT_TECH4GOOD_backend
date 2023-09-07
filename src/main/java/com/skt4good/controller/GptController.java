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
import java.util.StringTokenizer;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/chat-gpt")
public class GptController {

    private final ChatService chatService;
    private final ChatgptService chatgptService;

    /**
     * 키워드 뽑기
     */
    @PostMapping("")
    public List<String> test(@RequestBody String question) {
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String response = chatService.getChatResponse(
                    "사용자가 글을 쓰면 {사회생활, 미래설계, 인간관계, 건강, 실패} 중에 가장 가까운 키워드 하나를 알려줘 : "
                            + question);

            response = response.replaceAll("\n", "");
            response = response.replaceAll(":", "");
            response = response.replaceAll("키워드", "");
            response = response.replaceAll("Answer", "");
            response = response.replaceAll(" ", "");
            arr.add(response);
        }

        return arr;
    }

    /**
     * 노인같은 채팅서비스
     */
    @PostMapping("/older")
    public String chat(@RequestBody String chat) {
        return chatService.getChatResponse("노인이라고 생각하고 질문에 답변을 해줘 주어는 저는 이라고 해야돼 : " + chat);
    }

    /**
     * 채팅한 내용을 바탕으로 이미지 만들기
     */
    @PostMapping("/getCardData")
    public String Image(@RequestBody String fullChat) {
        return chatService.getImageResponse(fullChat);
    }

}
