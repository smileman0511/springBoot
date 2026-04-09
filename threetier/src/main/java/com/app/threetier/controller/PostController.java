package com.app.threetier.controller;

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/posts/*")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public void goToList(Model model) {
        model.addAttribute("posts", postService.getPosts());
    }

    @GetMapping("/read")
    public void goToRead(Long id, Model model) {
        model.addAttribute("post", postService.getPost(id));
    }

    @GetMapping("/update")
    public void goToUpdate(Long id, Model model) {
        model.addAttribute("post", postService.getPost(id));
    }

    @PostMapping("/update-ok")
    public RedirectView updatePost(@ModelAttribute PostVO postVO) {
        postService.updatePost(postVO);
        return new RedirectView("/posts/read?id" + postVO.getId());
    }

    @GetMapping("/delete-ok")
    public RedirectView deletePost(Long id) {
        return new RedirectView("/posts/list");
    }

}
