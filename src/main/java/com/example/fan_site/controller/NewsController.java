package com.example.fan_site.controller;

import com.example.fan_site.entity.News;
import com.example.fan_site.repository.NewsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/news")
public class NewsController {

    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("/new")
    public String newNewsForm(@ModelAttribute("news") News news) {
        return "admin/news_form";
    }

    @PostMapping("/new")
    public String createNews(@ModelAttribute News news, RedirectAttributes redirectAttributes) {
        newsRepository.save(news);
        redirectAttributes.addFlashAttribute("message", "お知らせを投稿しました。");
        return "redirect:/";
    }
}
