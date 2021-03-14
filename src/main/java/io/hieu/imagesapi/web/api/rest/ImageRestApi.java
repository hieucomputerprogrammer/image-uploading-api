package io.hieu.imagesapi.web.api.rest;

import com.lowagie.text.DocumentException;
import io.hieu.imagesapi.dto.model.ImageDto;
import io.hieu.imagesapi.service.ImageService;
import io.hieu.imagesapi.service.impl.ExportToMsExcelServiceImpl;
import io.hieu.imagesapi.service.impl.ExportToPdfServiceImpl;
import io.hieu.imagesapi.util.Base64Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageRestApi {
    private final Logger logger = LoggerFactory.getLogger(ImageRestApi.class);
    private final ImageService imageService;

    @Autowired
    public ImageRestApi(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<?> addImage(final @RequestBody ImageDto imageDto) {
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

    @GetMapping("/page/{page}")
    public ResponseEntity<?> getImagesPaginated(final @PathVariable("page") int page) {
        this.logger.info("INFO: Image REST API - getImagesPaginated() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesPaginated() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesPaginated() method called.");
        this.logger.warn("WARN: Image REST API - getImagesPaginated() method called.");
        this.logger.error("ERROR: Image REST API - getImagesPaginated() method called.");

        if (this.imageService.findAllPaginated(page).isEmpty()) {
            try {
                return new ResponseEntity<String>("No images exists.", HttpStatus.NO_CONTENT);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving all images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllPaginated(page), HttpStatus.OK);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving all images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getImageById(final @PathVariable("id") Long id) {
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

    @GetMapping("/filter-by/image-title/{imageTitle}")
    public ResponseEntity<?> getImagesByImageTitle(final @PathVariable("imageTitle") String imageTitle) {
        this.logger.info("INFO: Image REST API - getImagesByImageTitle() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesByImageTitle() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesByImageTitle() method called.");
        this.logger.warn("WARN: Image REST API - getImagesByImageTitle() method called.");
        this.logger.error("ERROR: Image REST API - getImagesByImageTitle() method called.");

        if (this.imageService.findAllByImageTitle(imageTitle) == null) {
            try {
                return new ResponseEntity<String>("No images with title: " + imageTitle + " exists.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images with title: " + imageTitle + "." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByImageTitle(imageTitle), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images with title: " + imageTitle + "." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/filter-by/owner-name/{ownerName}")
    public ResponseEntity<?> getImagesByOwnerName(final @PathVariable("ownerName") String ownerName) {
        this.logger.info("INFO: Image REST API - getImagesByOwnerName() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesByOwnerName() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesByOwnerName() method called.");
        this.logger.warn("WARN: Image REST API - getImagesByOwnerName() method called.");
        this.logger.error("ERROR: Image REST API - getImagesByOwnerName() method called.");

        if (this.imageService.findAllByOwnerName(ownerName) == null) {
            try {
                return new ResponseEntity<String>("No images created by owner: " + ownerName + " found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images created by owner: " + ownerName + "." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByOwnerName(ownerName), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images created by owner: " + ownerName + "." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/filter-by/owner-phone-number/{ownerPhoneNumber}")
    public ResponseEntity<?> getImagesByOwnerPhoneNumber(final @PathVariable("ownerPhoneNumber") String ownerPhoneNumber) {
        this.logger.info("INFO: Image REST API - getImagesByOwnerPhoneNumber() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesByOwnerPhoneNumber() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesByOwnerPhoneNumber() method called.");
        this.logger.warn("WARN: Image REST API - getImagesByOwnerPhoneNumber() method called.");
        this.logger.error("ERROR: Image REST API - getImagesByOwnerPhoneNumber() method called.");

        if (this.imageService.findAllByOwnerPhoneNumber(ownerPhoneNumber) == null) {
            try {
                return new ResponseEntity<String>("No images created by owner with phone number: " + ownerPhoneNumber + " found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images created by owner with phone number: " + ownerPhoneNumber + "." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByOwnerPhoneNumber(ownerPhoneNumber), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images created by owner with phone number: " + ownerPhoneNumber + "." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/filter-by/owner-email/{ownerEmail}")
    public ResponseEntity<?> getImagesByOwnerEmail(final @PathVariable("ownerEmail") String ownerEmail) {
        this.logger.info("INFO: Image REST API - getImagesByOwnerEmail() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesByOwnerEmail() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesByOwnerEmail() method called.");
        this.logger.warn("WARN: Image REST API - getImagesByOwnerEmail() method called.");
        this.logger.error("ERROR: Image REST API - getImagesByOwnerEmail() method called.");

        if (this.imageService.findAllByOwnerEmail(ownerEmail) == null) {
            try {
                return new ResponseEntity<String>("No images created by owner with email: " + ownerEmail + " found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images created by owner with email: " + ownerEmail + "." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByOwnerPhoneNumber(ownerEmail), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images created by owner with email: " + ownerEmail + "." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/sort-by/id/ascending")
    public ResponseEntity<?> getImagesSortedByIdAscending() {
        this.logger.info("INFO: Image REST API - getImagesSortedByIdAscending() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesSortedByIdAscending() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesSortedByIdAscending() method called.");
        this.logger.warn("WARN: Image REST API - getImagesSortedByIdAscending() method called.");
        this.logger.error("ERROR: Image REST API - getImagesSortedByIdAscending() method called.");

        if (this.imageService.findAllByIdAsc() == null) {
            try {
                return new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByIdAsc(), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/sort-by/id/descending")
    public ResponseEntity<?> getImagesSortedByIdDescending() {
        this.logger.info("INFO: Image REST API - getImagesSortedByIdDescending() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesSortedByIdDescending() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesSortedByIdDescending() method called.");
        this.logger.warn("WARN: Image REST API - getImagesSortedByIdDescending() method called.");
        this.logger.error("ERROR: Image REST API - getImagesSortedByIdDescending() method called.");

        if (this.imageService.findAllByIdDesc() == null) {
            try {
                return new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByIdDesc(), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/sort-by/image-as-base-64-format/ascending")
    public ResponseEntity<?> getImagesSortedByImageAsBase64FormatAscending() {
        this.logger.info("INFO: Image REST API - getImagesSortedByImageAsBase64FormatAsscending() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesSortedByImageAsBase64FormatAsscending() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesSortedByImageAsBase64FormatAsscending() method called.");
        this.logger.warn("WARN: Image REST API - getImagesSortedByImageAsBase64FormatAsscending() method called.");
        this.logger.error("ERROR: Image REST API - getImagesSortedByImageAsBase64FormatAsscending() method called.");

        if (this.imageService.findAllByImageAsBase64FormatAsc() == null) {
            try {
                return new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByIdDesc(), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/sort-by/image-as-base-64-format/descending")
    public ResponseEntity<?> getImagesSortedByImageAsBase64FormatDescending() {
        this.logger.info("INFO: Image REST API - getImagesSortedByImageAsBase64FormatDescending() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesSortedByImageAsBase64FormatDescending() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesSortedByImageAsBase64FormatDescending() method called.");
        this.logger.warn("WARN: Image REST API - getImagesSortedByImageAsBase64FormatDescending() method called.");
        this.logger.error("ERROR: Image REST API - getImagesSortedByImageAsBase64FormatDescending() method called.");

        if (this.imageService.findAllByImageAsBase64FormatDesc() == null) {
            try {
                return new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByImageAsBase64FormatDesc(), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/sort-by/image-title/ascending")
    public ResponseEntity<?> getImagesSortedByImageTitleAscending() {
        this.logger.info("INFO: Image REST API - getImagesSortedByImageTitleAscending() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesSortedByImageTitleAscending() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesSortedByImageTitleAscending() method called.");
        this.logger.warn("WARN: Image REST API - getImagesSortedByImageTitleAscending() method called.");
        this.logger.error("ERROR: Image REST API - getImagesSortedByImageTitleAscending() method called.");

        if (this.imageService.findAllByImageTitleAsc() == null) {
            try {
                return new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByImageTitleAsc(), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/sort-by/image-title/descending")
    public ResponseEntity<?> getImagesSortedByImageTitleDescending() {
        this.logger.info("INFO: Image REST API - getImagesSortedByImageTitleDescending() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesSortedByImageTitleDescending() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesSortedByImageTitleDescending() method called.");
        this.logger.warn("WARN: Image REST API - getImagesSortedByImageTitleDescending() method called.");
        this.logger.error("ERROR: Image REST API - getImagesSortedByImageTitleDescending() method called.");

        if (this.imageService.findAllByImageTitleDesc() == null) {
            try {
                return new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByImageTitleDesc(), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/sort-by/owner-name/ascending")
    public ResponseEntity<?> getImagesSortedByOwnerNameAscending() {
        this.logger.info("INFO: Image REST API - getImagesSortedByOwnerNameAscending() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesSortedByOwnerNameAscending() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesSortedByOwnerNameAscending() method called.");
        this.logger.warn("WARN: Image REST API - getImagesSortedByOwnerNameAscending() method called.");
        this.logger.error("ERROR: Image REST API - getImagesSortedByOwnerNameAscending() method called.");

        if (this.imageService.findAllByOwnerNameAsc() == null) {
            try {
                return new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByOwnerNameAsc(), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/sort-by/owner-name/descending")
    public ResponseEntity<?> getImagesSortedByOwnerNameDescending() {
        this.logger.info("INFO: Image REST API - getImagesSortedByOwnerNameDescending() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesSortedByOwnerNameDescending() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesSortedByOwnerNameDescending() method called.");
        this.logger.warn("WARN: Image REST API - getImagesSortedByOwnerNameDescending() method called.");
        this.logger.error("ERROR: Image REST API - getImagesSortedByOwnerNameDescending() method called.");

        if (this.imageService.findAllByOwnerNameDesc() == null) {
            try {
                return new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByOwnerNameDesc(), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/sort-by/owner-phone-number/ascending")
    public ResponseEntity<?> getImagesSortedByOwnerPhoneNumberAscending() {
        this.logger.info("INFO: Image REST API - getImagesSortedByOwnerPhoneNumberAscending() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesSortedByOwnerPhoneNumberAscending() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesSortedByOwnerPhoneNumberAscending() method called.");
        this.logger.warn("WARN: Image REST API - getImagesSortedByOwnerPhoneNumberAscending() method called.");
        this.logger.error("ERROR: Image REST API - getImagesSortedByOwnerPhoneNumberAscending() method called.");

        if (this.imageService.findAllByOwnerPhoneNumberAsc() == null) {
            try {
                return new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByOwnerPhoneNumberAsc(), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/sort-by/owner-phone-number/descending")
    public ResponseEntity<?> getImagesSortedByOwnerPhoneNumberDescending() {
        this.logger.info("INFO: Image REST API - getImagesSortedByOwnerPhoneNumberDescending() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesSortedByOwnerPhoneNumberDescending() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesSortedByOwnerPhoneNumberDescending() method called.");
        this.logger.warn("WARN: Image REST API - getImagesSortedByOwnerPhoneNumberDescending() method called.");
        this.logger.error("ERROR: Image REST API - getImagesSortedByOwnerPhoneNumberDescending() method called.");

        if (this.imageService.findAllByOwnerPhoneNumberDesc() == null) {
            try {
                return new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByOwnerPhoneNumberDesc(), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/sort-by/owner-email/ascending")
    public ResponseEntity<?> getImagesSortedByOwnerEmailAscending() {
        this.logger.info("INFO: Image REST API - getImagesSortedByOwnerEmailAscending() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesSortedByOwnerEmailAscending() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesSortedByOwnerEmailAscending() method called.");
        this.logger.warn("WARN: Image REST API - getImagesSortedByOwnerEmailAscending() method called.");
        this.logger.error("ERROR: Image REST API - getImagesSortedByOwnerEmailAscending() method called.");

        if (this.imageService.findAllByOwnerEmailAsc() == null) {
            try {
                return new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByOwnerEmailAsc(), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/sort-by/owner-email/descending")
    public ResponseEntity<?> getImagesSortedByOwnerEmailDescending() {
        this.logger.info("INFO: Image REST API - getImagesSortedByOwnerEmailDescending() method called.");
        this.logger.debug("DEBUG: Image REST API - getImagesSortedByOwnerEmailDescending() method called.");
        this.logger.trace("TRACE: Image REST API - getImagesSortedByOwnerEmailDescending() method called.");
        this.logger.warn("WARN: Image REST API - getImagesSortedByOwnerEmailDescending() method called.");
        this.logger.error("ERROR: Image REST API - getImagesSortedByOwnerEmailDescending() method called.");

        if (this.imageService.findAllByOwnerEmailDesc() == null) {
            try {
                return new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                return new ResponseEntity<List<ImageDto>>(this.imageService.findAllByOwnerEmailDesc(), HttpStatus.FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/convert-base64-to-image/{id}")
    public ResponseEntity<?> convertBase64ToImage(final @PathVariable("id") Long id) {
        this.logger.info("INFO: Image REST API - convertBase64ToImage() method called.");
        this.logger.debug("DEBUG: Image REST API - convertBase64ToImage() method called.");
        this.logger.trace("TRACE: Image REST API - convertBase64ToImage() method called.");
        this.logger.warn("WARN: Image REST API - convertBase64ToImage() method called.");
        this.logger.error("ERROR: Image REST API - convertBase64ToImage() method called.");

        if (this.imageService.findById(id) == null) {
            try {
                return new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured retrieving images." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        } else {
            try {
                ImageDto imageDto = this.imageService.findById(id);
//                byte[] imageAsBase64Format = Base64.getDecoder().decode(imageDto.getImageAsBase64Format().toString().getBytes());
//                String imageAsBase64FormatAsJavaString = new String(imageAsBase64Format);
                Base64Converter.base64ToImage(new String(imageDto.getImageAsBase64Format()), "classpath:/resources/static/img/Base 64 Decoded Images/");
                return new ResponseEntity<String>("Successfully converted Base64 code to image.", HttpStatus.OK);
            } catch (Exception exception) {
                return new ResponseEntity<String>("Unknown error(s) occured converting Base64 code to image." + exception.toString(), HttpStatus.NOT_ACCEPTABLE);
            }
        }
    }

    @GetMapping("/export-to-pdf")
    public void exportToPdf(HttpServletResponse httpServletResponse) throws DocumentException, IOException {
        httpServletResponse.setContentType("application/pdf");
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateTime = dateFormat.format(new Date());

        String httpResponseHeaderKey = "Content-Disposition";
        String httpResponseHeaderValue = "attachment; filename=Images_" + currentDateTime + ".pdf";
        httpServletResponse.setHeader(httpResponseHeaderKey, httpResponseHeaderValue);

        ExportToPdfServiceImpl exportTopdfServiceImpl = new ExportToPdfServiceImpl(this.imageService.findAll());
        exportTopdfServiceImpl.export(httpServletResponse);
    }

    @GetMapping("/export-to-microsoft-excel")
    public void exportToMsExcel(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setContentType("application/octet-stream");
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateTime = dateFormatter.format(new Date());

        String httpResponseHeaderKey = "Content-Disposition";
        String httpResponseHeaderValue = "attachment; filename=Images_" + currentDateTime + ".xlsx";
        httpServletResponse.setHeader(httpResponseHeaderKey, httpResponseHeaderValue);

        ExportToMsExcelServiceImpl exportToMsExcelServiceImpl = new ExportToMsExcelServiceImpl(this.imageService.findAll());
        exportToMsExcelServiceImpl.export(httpServletResponse);
    }

    @GetMapping("/export-to-csv")
    public void exportToCsv(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setContentType("text/csv");
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Images_" + currentDateTime + ".csv";
        httpServletResponse.setHeader(headerKey, headerValue);

        List<ImageDto> imageDtos = this.imageService.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(httpServletResponse.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Image ID", "Image as Base64 Format", "Image Title", "Owner Name", "Owner Phone Number", "Owner E-Mail"};
        String[] nameMapping = {"id", "imageAsBase64Format", "imageTitle", "ownerName", "ownerPhoneNumber", "ownerEmail"};

        csvWriter.writeHeader(csvHeader);

        for (ImageDto imageDto : imageDtos) {
            csvWriter.write(imageDto, nameMapping);
        }

        csvWriter.close();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateImage(final @PathVariable("id") Long id, final @RequestBody ImageDto imageDto) {
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
    public ResponseEntity<?> deleteImageById(final @PathVariable("id") Long id) {
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