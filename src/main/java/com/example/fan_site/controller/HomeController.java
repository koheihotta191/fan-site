package com.example.fan_site.controller;

import com.example.fan_site.repository.NewsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.fan_site.entity.News;

import java.util.List;

@Controller
public class HomeController {

    private final NewsRepository newsRepository;

    public HomeController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<News> newsList = newsRepository.findAllByOrderByCreatedAtDesc();
        model.addAttribute("newsList", newsList);
        return "index";
    }
}
