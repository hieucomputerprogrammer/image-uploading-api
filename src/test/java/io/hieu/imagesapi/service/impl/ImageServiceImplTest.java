package io.hieu.imagesapi.service.impl;

import io.hieu.imagesapi.domain.Image;
import io.hieu.imagesapi.dto.mapper.ImageMapper;
import io.hieu.imagesapi.dto.model.ImageDto;
import io.hieu.imagesapi.repository.mybatis.ImageMyBatisRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
public class ImageServiceImplTest {
    @Mock
    private ImageMyBatisRepository imageMyBatisRepository;

    @InjectMocks
    private ImageServiceImpl imageServiceImpl;

    @Before
    public void setUp() throws Exception {
        this.imageServiceImpl = new ImageServiceImpl(this.imageMyBatisRepository);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddImage() {
    }

    @Test
    public void testFindAll_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
            "TESTING".getBytes(),
            "Monalisa's Portrait Photo",
            "Hieu Minh Le",
            "+84908109633",
            "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Full Body Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAll()).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAll();

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAll_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAll()).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAll();
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllPaginate_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Full Body Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllPaginated(5, 5)).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllPaginated(5);

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllPaginate_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllPaginated(5, 5)).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllPaginated(5);
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByImageTitle_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByImageTitle("Monalisa's Portrait Photo")).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByImageTitle("Monalisa's Portrait Photo");

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByImageTitle_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByImageTitle("Monalisa's Portrait Photo")).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByImageTitle("Monalisa's Portrait Photo");
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByOwnerName_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByOwnerName("Hieu Minh Le")).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerName("Hieu Minh Le");

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByOwnerName_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByOwnerName("Hieu Minh Le")).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerName("Hieu Minh Le");
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByOwnerPhoneNumber_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByOwnerPhoneNumber("+84908109633")).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerPhoneNumber("+84908109633");

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByOwnerPhoneNumber_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByOwnerPhoneNumber("+84908109633")).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerName("+84908109633");
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByOwnerEmail_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByOwnerEmail("hieu.minhle@outlook.com")).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerEmail("hieu.minhle@outlook.com");

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByOwnerEmail_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByOwnerEmail("hieu.minhle@outlook.com")).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerEmail("hieu.minhle@outlook.com");
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindById_Found() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findById(image.getId())).thenReturn(image);
        Image foundImage = ImageMapper.toEntity(this.imageServiceImpl.findById(image.getId()));

        Assert.assertEquals(image, foundImage);
        Assert.assertEquals(image.getId(), foundImage.getId());
        Assert.assertEquals(image.getImageAsBase64Format(), foundImage.getImageAsBase64Format());
        Assert.assertEquals(image.getImageTitle(), foundImage.getImageTitle());
        Assert.assertEquals(image.getOwnerName(), foundImage.getOwnerName());
        Assert.assertEquals(image.getOwnerPhoneNumber(), foundImage.getOwnerPhoneNumber());
        Assert.assertEquals(image.getOwnerEmail(), foundImage.getOwnerEmail());
    }

    @Test
    public void testFindById_NotFound() {
        Mockito.when(this.imageMyBatisRepository.findById(Mockito.anyLong())).thenReturn(null);
        Assert.assertNull(this.imageServiceImpl.findById(Mockito.anyLong()));
    }

    @Test
    public void testFindAllByIdAsc_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByIdAsc()).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByIdAsc();

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByIdAsc_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByIdAsc()).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByIdAsc();
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByIdDesc_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByIdDesc()).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByIdDesc();

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByIdDesc_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByIdDesc()).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByIdDesc();
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByImageAsBase64FormatAsc_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByImageAsBase64FormatAsc()).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByImageAsBase64FormatAsc();

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByImageAsBase64FormatAsc_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByImageAsBase64FormatAsc()).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByImageAsBase64FormatAsc();
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByImageAsBase64FormatDesc_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByImageAsBase64FormatDesc()).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByImageAsBase64FormatDesc();

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByImageAsBase64FormatDesc_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByImageAsBase64FormatDesc()).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByImageAsBase64FormatDesc();
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByImageTitleAsc_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Full Body Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByImageTitleAsc()).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByImageTitleAsc();

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByImageTitleAsc_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByImageTitleAsc()).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByImageTitleAsc();
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByImageTitleDesc_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Full Body Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByImageTitleDesc()).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByImageTitleDesc();

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByImageTitleDesc_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByImageTitleDesc()).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByImageTitleDesc();
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByOwnerNameAsc_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Full Body Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByOwnerNameAsc()).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerNameAsc();

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByOwnerNameAsc_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByOwnerNameAsc()).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerNameAsc();
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByOwnerNameDesc_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Full Body Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByOwnerNameDesc()).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerNameDesc();

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByOwnerNameDesc_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByOwnerNameDesc()).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerNameDesc();
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByOwnerPhoneNumberAsc_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Full Body Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByOwnerPhoneNumberAsc()).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerPhoneNumberAsc();

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByOwnerPhoneNumberAsc_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByOwnerPhoneNumberAsc()).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerPhoneNumberAsc();
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByOwnerPhoneNumberDesc_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Full Body Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByOwnerPhoneNumberDesc()).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerPhoneNumberDesc();

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByOwnerPhoneNumberDesc_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByOwnerPhoneNumberDesc()).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerPhoneNumberDesc();
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByOwnerEmailAsc_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Full Body Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByOwnerEmailAsc()).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerEmailAsc();

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByOwnerEmailAsc_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByOwnerEmailAsc()).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerEmailAsc();
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testFindAllByOwnerEmailDesc_ImagesExist() {
        List<Image> images = new ArrayList<Image>();
        Image image = new Image(
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image image1 = new Image(
                "TESTING".getBytes(),
                "Monalisa's Full Body Photo",
                "Hieu",
                "0908109633",
                "MinhHieu.Le@aia.com"
        );
        images.add(image);
        images.add(image1);

        Mockito.when(this.imageMyBatisRepository.findAllByOwnerEmailDesc()).thenReturn(images);
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerEmailDesc();

        Assert.assertEquals(imageDtos.size(), images.size());
        Assert.assertEquals(imageDtos.get(0).getId(), images.get(0).getId());
        Assert.assertEquals(imageDtos.get(0).getImageAsBase64Format(), images.get(0).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(0).getImageTitle(), images.get(0).getImageTitle());
        Assert.assertEquals(imageDtos.get(0).getOwnerName(), images.get(0).getOwnerName());
        Assert.assertEquals(imageDtos.get(0).getOwnerPhoneNumber(), images.get(0).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(0).getOwnerEmail(), images.get(0).getOwnerEmail());
        Assert.assertEquals(imageDtos.get(1).getId(), images.get(1).getId());
        Assert.assertEquals(imageDtos.get(1).getImageAsBase64Format(), images.get(1).getImageAsBase64Format());
        Assert.assertEquals(imageDtos.get(1).getImageTitle(), images.get(1).getImageTitle());
        Assert.assertEquals(imageDtos.get(1).getOwnerName(), images.get(1).getOwnerName());
        Assert.assertEquals(imageDtos.get(1).getOwnerPhoneNumber(), images.get(1).getOwnerPhoneNumber());
        Assert.assertEquals(imageDtos.get(1).getOwnerEmail(), images.get(1).getOwnerEmail());
    }

    @Test
    public void testFindAllByOwnerEmailDesc_NoImagesExist() {
        Mockito.when(this.imageMyBatisRepository.findAllByOwnerEmailDesc()).thenReturn(Collections.emptyList());
        List<ImageDto> imageDtos = this.imageServiceImpl.findAllByOwnerEmailDesc();
        Assert.assertTrue(imageDtos.isEmpty());
        Assert.assertEquals(imageDtos.size(), 0);
    }

    @Test
    public void testUpdate_SelectedImageWithIdExists() {
        Long id = Mockito.anyLong();
        Image image = new Image(
                id,
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        this.imageMyBatisRepository.insert(image);

        Mockito.when(this.imageMyBatisRepository.findById(image.getId())).thenReturn(image);
        Assert.assertEquals(this.imageMyBatisRepository.findById(image.getId()), image);

        image.setImageTitle("TESTING UPDATE IMAGE FUNCTIONALITY");
        this.imageMyBatisRepository.update(image.getId(), image);
        Assert.assertEquals(image.getImageTitle(), "TESTING UPDATE IMAGE FUNCTIONALITY");
        Assert.assertEquals(this.imageServiceImpl.update(image.getId(), ImageMapper.toDto(image)), ImageMapper.toDto(image));
    }

    @Test(expected = Exception.class)
    public void testUpdate_SelectedImageWithIdNotFound() {
        Long id = Mockito.anyLong();
        Mockito.when(this.imageMyBatisRepository.findById(id)).thenReturn(null);
        ImageDto imageDto = new ImageDto(
                id,
                "TESTING".getBytes(),
                "Monalisa's Portrait Photo",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        this.imageServiceImpl.update(id, imageDto);
    }

    @Test
    public void deleteById_SelectedImageWithIdExists() {
//        Mockito.doThrow(new Exception()).when(this.imageMyBatisRepository).deleteById(Mockito.anyLong());
        this.imageServiceImpl.deleteById(Mockito.anyLong());
    }

    @Test(expected = Exception.class)
    public void deleteById_SelectedImageWithIdNotFound() {
//        this.imageServiceImpl.deleteById(-1L);
        Mockito.doThrow(new Exception()).when(this.imageMyBatisRepository).deleteById(Mockito.anyLong());
    }

    @Test
    public void deleteAll() {
    }
}