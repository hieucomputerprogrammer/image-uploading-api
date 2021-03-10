package io.hieu.imageuploadingapi.service;

import io.hieu.imageuploadingapi.dto.model.ImageDto;

import java.util.List;

public interface ImageService {
    void addImage(ImageDto imageDto);

    List<ImageDto> findAll();

    ImageDto findById(Long id);

    ImageDto update(Long id, ImageDto imageDto);

    void deleteById(Long id);

    void deleteAll();
}