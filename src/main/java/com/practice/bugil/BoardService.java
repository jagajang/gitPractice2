package com.practice.bugil;

import com.practice.bugil.Entity.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BoardService {
    private List<Post> MiniRepository = new ArrayList(Arrays.asList(
            new Post(0, "title", "text", "author"),
            new Post(1, "제목", "내용", "작성자"),
            new Post(2, "테스트0", "테스트1", "테스트2")));

    public List<Post> getPosts() {
        return MiniRepository;
    }

    public Post getPostByIndex(int index) {
        return MiniRepository.get(index);
    }

    public void addPost(String title, String author, String text) {
        MiniRepository.add(new Post(MiniRepository.size(), title, author, text));
    }
}
