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

    // GET: 投稿作成フォーム表示
    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String showCreateForm(Model model) {
        model.addAttribute("news", new News());
        return "news/create";
    }

    // POST: 投稿データ保存
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String createNews(@ModelAttribute News news) {
        newsRepository.save(news);
        return "redirect:/";
    }
}
