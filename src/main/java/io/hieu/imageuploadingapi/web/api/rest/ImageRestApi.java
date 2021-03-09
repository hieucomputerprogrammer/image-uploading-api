package io.hieu.imageuploadingapi.web.api.rest;

import io.hieu.imageuploadingapi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageRestApi {
    private final ImageService imageService;

    @Autowired
    public ImageRestApi(ImageService imageService) {
        this.imageService = imageService;
    }
}