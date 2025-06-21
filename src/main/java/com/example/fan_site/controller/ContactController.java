package com.example.fan_site.controller;

import com.example.fan_site.model.Inquiry;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String showForm(Model model) {
        model.addAttribute("inquiry", new Inquiry());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitForm(@ModelAttribute("inquiry") @Valid Inquiry inquiry,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "contact";
        }

        // 仮：コンソール出力（本番ではメール送信に置き換える）
        System.out.println("名前：" + inquiry.getName());
        System.out.println("メール：" + inquiry.getEmail());
        System.out.println("メッセージ：" + inquiry.getMessage());

        model.addAttribute("message", "お問い合わせありがとうございます！");
        return "contact";
    }
}
