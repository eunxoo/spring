package com.sparta.week04.utils;

import com.sparta.week04.dto.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component // 이제부터, @RequiredArgsConstructor와 함께 사용할 경우 스프링이 자동으로 생성합니다.
public class NaverShopSearch {
    public String search(String query){
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "9GYWFUJjR_t97B7H54Kk");
        headers.add("X-Naver-Client-Secret", "E_7Fsw0hpa");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public List<ItemDto> fromJSONtoItems(String result) {
        JSONObject rjson = new JSONObject(result); // 문자열 정보를 JSONObject로 바꾸기
        JSONArray items  = rjson.getJSONArray("items"); // JSONObject에서 items 배열 꺼내기
        List<ItemDto> ret = new ArrayList<>();
        for (int i=0; i<items.length(); i++) { //JSONArray로 for문 돌기
            JSONObject itemJson = items.getJSONObject(i);
            ItemDto itemDto = new ItemDto(itemJson);
            ret.add(itemDto);
        }
        return ret;
    }

    public static void main(String[] args){
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        naverShopSearch.search("아이맥");
    }
}