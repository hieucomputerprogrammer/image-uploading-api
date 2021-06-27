package io.hieu.imagesapi.service;

import io.hieu.imagesapi.service.dto.ImageDto;

import java.util.List;

public interface ImageService {
    void addImage(ImageDto imageDto);

    List<ImageDto> findAll();

    List<ImageDto> findAllPaginated(int page);

    List<ImageDto> findAllByImageTitle(String imageTitle);

    List<ImageDto> findAllByOwnerName(String ownerName);

    List<ImageDto> findAllByOwnerPhoneNumber(String ownerPhoneNumber);

    List<ImageDto> findAllByOwnerEmail(String ownerEmail);

    List<ImageDto> findAllByIdAsc();

    List<ImageDto> findAllByIdDesc();

    List<ImageDto> findAllByImageAsBase64FormatAsc();

    List<ImageDto> findAllByImageAsBase64FormatDesc();

    List<ImageDto> findAllByImageTitleAsc();

    List<ImageDto> findAllByImageTitleDesc();

    List<ImageDto> findAllByOwnerNameAsc();

    List<ImageDto> findAllByOwnerNameDesc();

    List<ImageDto> findAllByOwnerPhoneNumberAsc();

    List<ImageDto> findAllByOwnerPhoneNumberDesc();

    List<ImageDto> findAllByOwnerEmailAsc();

    List<ImageDto> findAllByOwnerEmailDesc();

    ImageDto findById(Long id);

    ImageDto update(Long id, ImageDto imageDto);

    void deleteById(Long id);

    void deleteAll();
}