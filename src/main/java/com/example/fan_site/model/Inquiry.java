package com.example.fan_site.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Inquiry {

    @NotBlank(message = "名前を入力してください")
    private String name;

    @NotBlank(message = "メールを入力してください")
    @Email(message = "有効なメールアドレスを入力してください")
    private String email;

    @NotBlank(message = "メッセージを入力してください")
    private String message;

    // Getter & Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
