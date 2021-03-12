package io.hieu.imagesapi.service;

import io.hieu.imagesapi.dto.model.ImageDto;

import java.util.List;
import java.util.Map;

public interface ImageService {
    void addImage(ImageDto imageDto);

    List<ImageDto> findAll();

    List<ImageDto> findAllPaginated(Map<String, Integer> pageable);

    List<ImageDto> findAllByImageTitle(String imageTitle);

    List<ImageDto> findAllByOwnerName(String ownerName);

    List<ImageDto> findAllByOwnerPhoneNumber(String ownerPhoneNumber);

    List<ImageDto> findAllByOwnerEmail(String ownerEmail);

    ImageDto findById(Long id);

    ImageDto update(Long id, ImageDto imageDto);

    void deleteById(Long id);

    void deleteAll();
}