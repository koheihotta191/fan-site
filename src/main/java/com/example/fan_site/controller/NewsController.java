package com.example.fan_site.controller;

import com.example.fan_site.entity.News;
import com.example.fan_site.repository.NewsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin/news")
public class NewsController {

    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("/new")
    public String showNewsForm(Model model) {
        model.addAttribute("news", new News());
        return "admin/news_form";
    }

    @PostMapping("/new")
    public String submitNews(@ModelAttribute News news) {
        news.setPostedAt(LocalDateTime.now());
        newsRepository.save(news);
        return "redirect:/";
    }
}
