package com.thinkltp.webrestful.jsonplaceholderapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private RestTemplate restTemplate;

    String baseUrl = "https://jsonplaceholder.typicode.com";
    StringBuilder stringBuilder = new StringBuilder(baseUrl);

    String POSTS = "/posts";

    @Override
    public List<Map<String, Object>> getPosts() {
        HttpEntity<Void> httpEntity  = new HttpEntity<>(getHttpHeaders());
        String url = stringBuilder.append(POSTS).toString();
        var response = restTemplate.exchange(url, HttpMethod.GET,  httpEntity, List.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> getPostById(int id) {
        String url = stringBuilder.append(POSTS).append("/").append(id).toString();
        System.out.println("url: " + url);
        HttpEntity<Void> httpEntity  = new HttpEntity<>(getHttpHeaders());
        var response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Map.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> createPost(Map<String, Object> payload) {
        String url = stringBuilder.append(POSTS).toString();
        HttpEntity<Map> httpEntity  = new HttpEntity<>(payload, getHttpHeaders());
        var response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> updatePost(Map<String, Object> payload, int id) {
        String url = stringBuilder.append(POSTS).append("/").append(id).toString();
        System.out.println("url: " + url);
        HttpEntity<Map> httpEntity  = new HttpEntity<>(payload, getHttpHeaders());
        var response  = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Map.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> deletePost(int id) {
        String url = stringBuilder.append(POSTS).append("/").append(id).toString();
        System.out.println("url: " + url);
        HttpEntity<Map> httpEntity  = new HttpEntity<>(getHttpHeaders());
        var response  = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                httpEntity,
                Map.class
        );
        return response.getBody();
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
