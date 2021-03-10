package io.hieu.imageuploadingapi.web.api.rest;

import io.hieu.imageuploadingapi.dto.model.ImageDto;
import io.hieu.imageuploadingapi.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageRestApi {
    private final Logger logger = LoggerFactory.getLogger(ImageRestApi.class);
    private final ImageService imageService;

    @Autowired
    public ImageRestApi(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<?> addImage(@RequestBody ImageDto imageDto) {
        this.logger.info("INFO: Image REST API - addImage() method called.");
        this.logger.debug("DEBUG: Image REST API - addImage() method called.");
        this.logger.trace("TRACE: Image REST API - addImage() method called.");
        this.logger.warn("WARN: Image REST API - addImage() method called.");
        this.logger.error("ERROR: Image REST API - addImage() method called.");

        try {
            this.imageService.addImage(imageDto);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return new ResponseEntity<String>("Unknown error(s) occured adding new image.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<?> getImages() {
        this.logger.info("INFO: Image REST API - getImages() method called.");
        this.logger.debug("DEBUG: Image REST API - getImages() method called.");
        this.logger.trace("TRACE: Image REST API - getImages() method called.");
        this.logger.warn("WARN: Image REST API - getImages() method called.");
        this.logger.error("ERROR: Image REST API - getImages() method called.");

        if (this.imageService.findAll().isEmpty()) {
            try {
                return new ResponseEntity<String>("No images exists.", HttpStatus.NO_CONTENT);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving all images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAll(), HttpStatus.OK);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving all images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findImageById(@PathVariable("id") Long id) {
        this.logger.info("INFO: Image REST API - findImageById() method called.");
        this.logger.debug("DEBUG: Image REST API - findImageById() method called.");
        this.logger.trace("TRACE: Image REST API - findImageById() method called.");
        this.logger.warn("WARN: Image REST API - findImageById() method called.");
        this.logger.error("ERROR: Image REST API - findImageById() method called.");

        if (this.imageService.findById(id) == null) {
            try {
                return new ResponseEntity<String>("Image with ID number: " + id + " does not exist.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving image with ID number: " + id + "." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<ImageDto>(this.imageService.findById(id), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving image with ID number: " + id + "." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateImage(@PathVariable("id") Long id, @RequestBody ImageDto imageDto) {
        this.logger.info("INFO: Image REST API - updateImage() method called.");
        this.logger.debug("DEBUG: Image REST API - updateImage() method called.");
        this.logger.trace("TRACE: Image REST API - updateImage() method called.");
        this.logger.warn("WARN: Image REST API - updateImage() method called.");
        this.logger.error("ERROR: Image REST API - updateImage() method called.");

        if (this.imageService.findById(id) == null) {
            try {
                return new ResponseEntity<String>("You don't have any images with ID number: " + id + ".", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured looking for image with ID number: " + id + " to update.",  HttpStatus.BAD_REQUEST);
            }
        } else {
            try {
                return new ResponseEntity<ImageDto>(this.imageService.update(id, imageDto), HttpStatus.OK);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured looking for image with ID number: " + id + " to update.",  HttpStatus.BAD_REQUEST);
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImageById(@PathVariable("id") Long id) {
        this.logger.info("INFO: Image REST API - deleteImageById() method called.");
        this.logger.debug("DEBUG: Image REST API - deleteImageById() method called.");
        this.logger.trace("TRACE: Image REST API - deleteImageById() method called.");
        this.logger.warn("WARN: Image REST API - deleteImageById() method called.");
        this.logger.error("ERROR: Image REST API - deleteImageById() method called.");

        if (this.imageService.findById(id) == null) {
            try {
                return new ResponseEntity<String>("You don't have any images with ID number: " + id + ".", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured looking for image with ID number: " + id + " to delete.",  HttpStatus.BAD_REQUEST);
            }
        } else {
            try {
                this.imageService.deleteById(id);
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured looking for image with ID number: " + id + " to delete.",  HttpStatus.BAD_REQUEST);
            }
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllImages() {
        this.logger.info("INFO: Image REST API - deleteAllImages() method called.");
        this.logger.debug("DEBUG: Image REST API - deleteAllImages() method called.");
        this.logger.trace("TRACE: Image REST API - deleteAllImages() method called.");
        this.logger.warn("WARN: Image REST API - deleteAllImages() method called.");
        this.logger.error("ERROR: Image REST API - deleteAllImages() method called.");

        if (this.imageService.findAll().isEmpty()) {
            try {
                return new ResponseEntity<String>("You don't have any images to delete.", HttpStatus.NO_CONTENT);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving all images to delete.",  HttpStatus.BAD_REQUEST);
            }
        } else {
            try {
                this.imageService.deleteAll();
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving all images to delete.",  HttpStatus.BAD_REQUEST);
            }
        }
    }
}