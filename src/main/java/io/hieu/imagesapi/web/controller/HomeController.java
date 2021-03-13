package io.hieu.imagesapi.web.controller;

import io.hieu.imagesapi.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final ImageService imageService;

    @Autowired
    public HomeController(ImageService imageService) {
        this.imageService = imageService;
    }

//    @GetMapping({"", "/", "/home"})
//    public String home() {
//        this.logger.info("INFO: Home Controller - home() method called.");
//        this.logger.debug("DEBUG: Home Controller - home() method called.");
//        this.logger.trace("TRACE: Home Controller - home() method called.");
//        this.logger.warn("WARN: Home Controller - home() method called.");
//        this.logger.error("ERROR: Home Controller - home() method called.");
//
//        return "home/index";
//    }

    @GetMapping({"/open-api", "/swagger"})
    public String openApi() {
        this.logger.info("INFO: Home Controller - openApi() method called. Redirecting to /swagger-ui.html endpoint.");
        this.logger.debug("DEBUG: Home Controller - openApi() method called. Redirecting to /swagger-ui.html endpoint.");
        this.logger.trace("TRACE: Home Controller - openApi() method called. Redirecting to /swagger-ui.html endpoint.");
        this.logger.warn("WARN: Home Controller - openApi() method called. Redirecting to /swagger-ui.html endpoint.");
        this.logger.error("ERROR: Home Controller - openApi() method called. Redirecting to /swagger-ui.html endpoint.");

        return "redirect:/swagger-ui.html";
    }
}