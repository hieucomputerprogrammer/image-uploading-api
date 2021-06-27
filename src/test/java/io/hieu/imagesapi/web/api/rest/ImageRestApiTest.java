package io.hieu.imagesapi.web.api.rest;

import io.hieu.imagesapi.service.dto.ImageDto;
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
                "Monalisa - Portrait Photo",
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
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );

        Mockito.when(this.imageService.findById(imageDto.getId())).thenReturn(imageDto);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImageById(imageDto.getId());
        Assert.assertTrue(imagesResponseEntity.hasBody());
        Assert.assertEquals(imageDto, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImageById_NotFound() {
        Long id = Mockito.anyLong();
        Mockito.when(this.imageService.findById(id)).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("Image with ID number: " + id + " does not exist.", HttpStatus.NOT_FOUND), this.imageRestApi.getImageById(id));
    }

    @Test
    public void testGetImagesByImageTitle_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByImageTitle("Monalisa - Portrait Photo")).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesByImageTitle("Monalisa - Portrait Photo");
        Assert.assertTrue(imagesResponseEntity.hasBody());
        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesByImageTitle_NoImagesFound() {
        String imageTitle = Mockito.anyString();
        Mockito.when(this.imageService.findAllByImageTitle(imageTitle)).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images with title: " + imageTitle + " exists.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesByImageTitle(imageTitle));
    }

    @Test
    public void testGetImagesByOwnerName_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByOwnerName(imageDto.getOwnerName())).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesByOwnerName(imageDto.getOwnerName());
        Assert.assertTrue(imagesResponseEntity.hasBody());
        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesByOwnerName_NoImagesFound() {
        String ownerName = Mockito.anyString();
        Mockito.when(this.imageService.findAllByOwnerName(ownerName)).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images created by owner: " + ownerName + " found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesByOwnerName(ownerName));
    }

    @Test
    public void testGetImagesByOwnerPhoneNumber_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByOwnerPhoneNumber(imageDto.getOwnerPhoneNumber())).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesByOwnerPhoneNumber(imageDto.getOwnerPhoneNumber());
        Assert.assertTrue(imagesResponseEntity.hasBody());
        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesByOwnerPhoneNumber_NoImagesFound() {
        String ownerPhoneNumber = Mockito.anyString();
        Mockito.when(this.imageService.findAllByOwnerPhoneNumber(ownerPhoneNumber)).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images created by owner with phone number: " + ownerPhoneNumber + " found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesByOwnerPhoneNumber(ownerPhoneNumber));
    }

    @Test
    public void testGetImagesByOwnerEmail_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByOwnerEmail(imageDto.getOwnerEmail())).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesByOwnerEmail(imageDto.getOwnerEmail());
        Assert.assertTrue(imagesResponseEntity.hasBody());
//        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesByOwnerEmail_NoImagesFound() {
        String ownerEmail = Mockito.anyString();
        Mockito.when(this.imageService.findAllByOwnerEmail(ownerEmail)).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images created by owner with email: " + ownerEmail + " found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesByOwnerEmail(ownerEmail));
    }

    @Test
    public void testGetImagesSortedByIdAscending_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByIdAsc()).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesSortedByIdAscending();
        Assert.assertTrue(imagesResponseEntity.hasBody());
        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesSortedByIdAscending_NoImagesFound() {
        Mockito.when(this.imageService.findAllByIdAsc()).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesSortedByIdAscending());
    }

    @Test
    public void testGetImagesSortedByIdDescending_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByIdDesc()).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesSortedByIdDescending();
        Assert.assertTrue(imagesResponseEntity.hasBody());
        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesSortedByIdDescending_NoImagesFound() {
        Mockito.when(this.imageService.findAllByIdDesc()).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesSortedByIdDescending());
    }

    @Test
    public void testGetImagesSortedByImageAsBase64FormatAscending_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByImageAsBase64FormatAsc()).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesSortedByImageAsBase64FormatAscending();
        Assert.assertTrue(imagesResponseEntity.hasBody());
//        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesSortedByImageAsBase64FormatAscending_NoImagesFound() {
        Mockito.when(this.imageService.findAllByImageAsBase64FormatAsc()).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesSortedByImageAsBase64FormatAscending());
    }

    @Test
    public void testGetImagesSortedByImageAsBase64FormatDescending_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByImageAsBase64FormatDesc()).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesSortedByImageAsBase64FormatDescending();
        Assert.assertTrue(imagesResponseEntity.hasBody());
//        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesSortedByImageAsBase64FormatDescending_NoImagesFound() {
        Mockito.when(this.imageService.findAllByImageAsBase64FormatDesc()).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesSortedByImageAsBase64FormatDescending());
    }

    @Test
    public void testGetImagesSortedByImageTitleAscending_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByImageTitleAsc()).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesSortedByImageTitleAscending();
        Assert.assertTrue(imagesResponseEntity.hasBody());
//        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesSortedByImageTitleAscending_NoImagesFound() {
        Mockito.when(this.imageService.findAllByImageTitleAsc()).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesSortedByImageTitleAscending());
    }

    @Test
    public void testGetImagesSortedByImageTitleDescending_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByImageTitleDesc()).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesSortedByImageTitleDescending();
        Assert.assertTrue(imagesResponseEntity.hasBody());
//        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesSortedByImageTitleDescending_NoImagesFound() {
        Mockito.when(this.imageService.findAllByImageTitleDesc()).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesSortedByImageTitleDescending());
    }

    @Test
    public void testGetImagesSortedByOwnerNameAscending_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByOwnerNameAsc()).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesSortedByOwnerNameAscending();
        Assert.assertTrue(imagesResponseEntity.hasBody());
//        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesSortedByOwnerNameAscending_NoImagesFound() {
        Mockito.when(this.imageService.findAllByOwnerNameAsc()).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesSortedByOwnerNameAscending());
    }

    @Test
    public void testGetImagesSortedByOwnerNameDescending_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByOwnerNameDesc()).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesSortedByOwnerNameDescending();
        Assert.assertTrue(imagesResponseEntity.hasBody());
//        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesSortedByOwnerNameDescending_NoImagesFound() {
        Mockito.when(this.imageService.findAllByOwnerNameDesc()).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesSortedByOwnerNameDescending());
    }

    @Test
    public void testGetImagesSortedByOwnerPhoneNumberAscending_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByOwnerPhoneNumberAsc()).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesSortedByOwnerPhoneNumberAscending();
        Assert.assertTrue(imagesResponseEntity.hasBody());
//        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesSortedByOwnerPhoneNumberAscending_NoImagesFound() {
        Mockito.when(this.imageService.findAllByOwnerPhoneNumberAsc()).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesSortedByOwnerPhoneNumberAscending());
    }

    @Test
    public void testGetImagesSortedByOwnerPhoneNumberDescending_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByOwnerPhoneNumberDesc()).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesSortedByOwnerPhoneNumberDescending();
        Assert.assertTrue(imagesResponseEntity.hasBody());
//        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesSortedByOwnerPhoneNumberDescending_NoImagesFound() {
        Mockito.when(this.imageService.findAllByOwnerPhoneNumberDesc()).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesSortedByOwnerPhoneNumberDescending());
    }

    @Test
    public void testGetImagesSortedByOwnerEmailAscending_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByOwnerEmailAsc()).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesSortedByOwnerEmailAscending();
        Assert.assertTrue(imagesResponseEntity.hasBody());
//        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesSortedByOwnerEmailAscending_NoImagesFound() {
        Mockito.when(this.imageService.findAllByOwnerEmailAsc()).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesSortedByOwnerEmailAscending());
    }

    @Test
    public void testGetImagesSortedByOwnerEmailDescending_ImagesFound() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        ImageDto imageDto = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        ImageDto imageDto1 = new ImageDto(
                "TESTING".getBytes(),
                "Monalisa - Full Body Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
        );
        imageDtos.add(imageDto);
        imageDtos.add(imageDto1);

        Mockito.when(this.imageService.findAllByOwnerEmailDesc()).thenReturn(imageDtos);
        ResponseEntity<?> imagesResponseEntity = this.imageRestApi.getImagesSortedByOwnerEmailDescending();
        Assert.assertTrue(imagesResponseEntity.hasBody());
//        Assert.assertEquals(imageDtos, imagesResponseEntity.getBody());
        Assert.assertEquals(HttpStatus.FOUND, imagesResponseEntity.getStatusCode());
    }

    @Test
    public void testGetImagesSortedByOwnerEmailDescending_NoImagesFound() {
        Mockito.when(this.imageService.findAllByOwnerEmailDesc()).thenReturn(null);
        Assert.assertEquals(new ResponseEntity<String>("No images found.", HttpStatus.NOT_FOUND), this.imageRestApi.getImagesSortedByOwnerEmailDescending());
    }

    @Test
    public void updateImage_SelectedImageWithIdFound() {
    }

    @Test
    public void updateImage_SelectedImageWithIdNotFound() {
    }

    @Test
    public void deleteImageById_SelectedImageWithIdFound() {
        this.imageService.deleteById(Mockito.anyLong());
    }

    @Test(expected = Exception.class)
    public void deleteImageById_SelectedImageWithIdNotFound() {
        Mockito.doThrow(new Exception()).when(this.imageService).deleteById(Mockito.anyLong());
    }

    @Test
    public void deleteAllImages() {
        this.imageService.deleteAll();
    }
}