package com.example.fan_site.controller;

import com.example.fan_site.entity.News;
import com.example.fan_site.repository.NewsRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewsController {

    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    // GET: 投稿フォームの表示（管理者のみアクセス可能）
    @GetMapping("/news/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String showNewsForm(Model model) {
        model.addAttribute("news", new News());
        return "news_form";
    }

    // POST: 投稿データの保存（管理者のみアクセス可能）
    @PostMapping("/news/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String submitNews(@ModelAttribute News news) {
        newsRepository.save(news);
        return "redirect:/";
    }
}
