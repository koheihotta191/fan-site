package com.example.fan_site.controller;

import com.example.fan_site.entity.News;
import com.example.fan_site.repository.NewsRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/news")
public class NewsController {

    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    // 投稿フォーム表示（管理者限定）
    @PreAuthorize("isAuthenticated()") // あとで "hasRole('ADMIN')" に変更可能
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("news", new News());
        return "new";  // templates/new.html を表示
    }

    // 投稿処理
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String createNews(@ModelAttribute News news) {
        newsRepository.save(news);
        return "redirect:/";  // 投稿後トップページへリダイレクト
    }
}
