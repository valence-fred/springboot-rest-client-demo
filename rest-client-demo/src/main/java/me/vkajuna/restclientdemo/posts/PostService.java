package me.vkajuna.restclientdemo.posts;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class PostService {

    RestClient restClient;

    public PostService() {
        this.restClient = RestClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public List<Post>findAll() {
        return restClient.get().uri("/posts").retrieve().body(new ParameterizedTypeReference<List<Post>>() {});
    }


    public Post findById(Integer id) {
        return restClient.get().uri("/posts/{id}", id).retrieve().body(Post.class);
    }

    public Post create(Post post) {
        return restClient.post().body(post).retrieve().body(Post.class);
    }

    public Post update(Integer id, Post post) {
        return restClient.put().uri("/posts/{id}", id).body(post).retrieve().body(Post.class);
    }

    public void delete(Integer id) {
        restClient.delete().uri("/posts/{id}", id).retrieve().body(String.class);
    }
}
