package io.hieu.imagesapi.web.controller;

import io.hieu.imagesapi.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/images")
public class ImageController {
    private final Logger logger = LoggerFactory.getLogger(ImageController.class);
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping({"/open-api", "/swagger"})
    public String openApi() {
        this.logger.info("INFO: Image Controller - openApi() method called. Redirecting to /swagger-ui.html endpoint.");
        this.logger.debug("DEBUG: Image Controller - openApi() method called. Redirecting to /swagger-ui.html endpoint.");
        this.logger.trace("TRACE: Image Controller - openApi() method called. Redirecting to /swagger-ui.html endpoint.");
        this.logger.warn("WARN: Image Controller - openApi() method called. Redirecting to /swagger-ui.html endpoint.");
        this.logger.error("ERROR: Image Controller - openApi() method called. Redirecting to /swagger-ui.html endpoint.");

        return "redirect:/swagger-ui.html";
    }
}