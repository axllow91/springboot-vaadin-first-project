package com.mrn.firstproject;

import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class Service {

    private String url = "https://jsonplaceholder.typicode.com/posts/1";
    private String postsUrl = "https://jsonplaceholder.typicode.com/posts";

    RestTemplate restTemplate = new RestTemplate();

    // Here we are mapping our Post model to the JSON object from remoteplace
    Post post = restTemplate.getForObject(url,Post.class);

    int showUserid() {
        return post.getUserId();
    }

    int showId() {
        return post.getId();
    }

    String showTitle() {
        return post.getTitle();
    }

    String showBody() {
        return post.getBody();
    }

    public String showPost() {
        return post.getBody();
    }
}
