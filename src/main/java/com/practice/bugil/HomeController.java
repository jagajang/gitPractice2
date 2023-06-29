package com.practice.bugil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    private BoardService boardService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/board";
    }

    @GetMapping("/board")
    public String board(Model model) {
        model.addAttribute("posts", boardService.getPosts());

        return "board";
    }

    @GetMapping("/post")
    public String post(
            @RequestParam("postid") int postid,
            Model model) {

        model.addAttribute("post", boardService.getPostByIndex(postid));

        return "post";
    }

    @GetMapping("/add")
    public String addPostByGet(
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("text") String text) {
        boardService.addPost(title, author, text);

        return "redirect:board";
    }

    @GetMapping("/addpost")
    public String addPost() {
        return "add";
    }

    @PostMapping("/addpost")
    public String addPostByPost(
            String title,
            String author,
            String text) {

        boardService.addPost(title, author, text);

        return "redirect:board";
    }
}