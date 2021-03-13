package io.hieu.imagesapi.web.api.rest;

import io.hieu.imagesapi.dto.model.ImageDto;
import io.hieu.imagesapi.service.ImageService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ImageRestApiTest {
    @Mock
    private ImageService imageService;

    @InjectMocks
    private ImageRestApi imageRestApi;

    @Before
    public void setUp() throws Exception {
        this.imageRestApi = new ImageRestApi(this.imageService);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addImage() {
    }

    @Test
    public void testGetImages_ImagesExist() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Hieu Minh Le - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        Mockito.when(this.imageService.findAll()).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImages();
        Assert.assertTrue(imagesResponseEntity.hasBody());
        Assert.assertEquals(imagesResponseEntity.getBody(), imageDtos);
        Assert.assertEquals(imagesResponseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetImages_NoImagesExist() {
        Mockito.when(this.imageService.findAll()).thenReturn(Collections.emptyList());
        Assert.assertEquals(new ResponseEntity<String>("No images exists.", HttpStatus.NO_CONTENT), this.imageRestApi.getImages());
    }

    @Test
    public void testGetImageById_Found() {
    }

    @Test
    public void testGetImageById_NotFound() {
    }

    @Test
    public void testGetImagesByImageTitle_ImagesFound() {
    }

    @Test
    public void testGetImagesByImageTitle_NoImagesFound() {
    }

    @Test
    public void testGetImagesByOwnerName_ImagesFound() {
    }

    @Test
    public void testGetImagesByOwnerName_NoImagesFound() {
    }

    @Test
    public void testGetImagesByOwnerPhoneNumber_ImagesFound() {
    }

    @Test
    public void testGetImagesByOwnerPhoneNumber_NoImagesFound() {
    }

    @Test
    public void testGetImagesByOwnerEmail_ImagesFound() {
    }

    @Test
    public void testGetImagesByOwnerEmail_NoImagesFound() {
    }

    @Test
    public void updateImage_SelectedImageWithIdFound() {
    }

    @Test
    public void updateImage_SelectedImageWithIdNotFound() {
    }

    @Test
    public void deleteImageById_SelectedImageWithIdFound() {
    }

    @Test
    public void deleteImageById_SelectedImageWithIdNotFound() {
    }

    @Test
    public void deleteAllImages() {
    }
}