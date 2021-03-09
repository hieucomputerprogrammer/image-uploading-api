package io.hieu.imageuploadingapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageUploadingApiApplication {
    private Logger logger = LoggerFactory.getLogger(ImageUploadingApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ImageUploadingApiApplication.class, args);
    }
}