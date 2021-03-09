package io.hieu.imageuploadingapi.web.controller;

import io.hieu.imageuploadingapi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/open-api")
    public String openApi() {
        return "redirect:/swagger-ui.html";
    }
}