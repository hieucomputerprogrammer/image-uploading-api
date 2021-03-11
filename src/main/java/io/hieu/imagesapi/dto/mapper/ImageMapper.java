package io.hieu.imagesapi.dto.mapper;

import io.hieu.imagesapi.domain.Image;
import io.hieu.imagesapi.dto.model.ImageDto;

public class ImageMapper {
    public static ImageDto toDto(Image image) {
        ImageDto imageDto = new ImageDto();
        imageDto.setId(image.getId());
        imageDto.setImageAsBase64Format(image.getImageAsBase64Format());
        imageDto.setImageTitle(image.getImageTitle());
        imageDto.setOwnerName(image.getOwnerName());
        imageDto.setOwnerPhoneNumber(image.getOwnerPhoneNumber());
        imageDto.setOwnerEmail(image.getOwnerEmail());

        return imageDto;
    }

    public static Image toEntity(ImageDto imageDto) {
        Image image = new Image();
        image.setId(imageDto.getId());
        image.setImageAsBase64Format(imageDto.getImageAsBase64Format());
        image.setImageTitle(imageDto.getImageTitle());
        image.setOwnerName(imageDto.getOwnerName());
        image.setOwnerPhoneNumber(imageDto.getOwnerPhoneNumber());
        image.setOwnerEmail(imageDto.getOwnerEmail());

        return image;
    }
}