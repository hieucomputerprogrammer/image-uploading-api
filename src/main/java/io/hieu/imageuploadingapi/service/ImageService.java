package io.hieu.imageuploadingapi.service;

import io.hieu.imageuploadingapi.dto.model.ImageDto;

import java.util.List;

public interface ImageService {
    void addImage(ImageDto imageDto);

    List<ImageDto> findAll();

    List<ImageDto> findAllByImageTitle(String imageTitle);

    List<ImageDto> findAllByOwnerName(String ownerName);

    List<ImageDto> findAllByOwnerPhoneNumber(String ownerPhoneNumber);

    List<ImageDto> findAllByOwnerEmail(String ownerEmail);

    ImageDto findById(Long id);

    ImageDto update(Long id, ImageDto imageDto);

    void deleteById(Long id);

    void deleteAll();
}