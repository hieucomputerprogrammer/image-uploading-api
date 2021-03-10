package io.hieu.imageuploadingapi.dto.model;

import java.util.Arrays;
import java.util.Objects;

public class ImageDto {
    private Long id;
    private byte[] imageAsBase64Format;
    private String imageTitle;
    private String ownerName;
    private String ownerPhoneNumber;
    private String ownerEmail;

    public ImageDto() {
    }

    public ImageDto(Long id, byte[] imageAsBase64Format, String imageTitle, String ownerName, String ownerPhoneNumber, String ownerEmail) {
        this.id = id;
        this.imageAsBase64Format = imageAsBase64Format;
        this.imageTitle = imageTitle;
        this.ownerName = ownerName;
        this.ownerPhoneNumber = ownerPhoneNumber;
        this.ownerEmail = ownerEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImageAsBase64Format() {
        return imageAsBase64Format;
    }

    public void setImageAsBase64Format(byte[] imageAsBase64Format) {
        this.imageAsBase64Format = imageAsBase64Format;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageDto imageDto = (ImageDto) o;
        return Objects.equals(id, imageDto.id) &&
                Arrays.equals(imageAsBase64Format, imageDto.imageAsBase64Format) &&
                Objects.equals(imageTitle, imageDto.imageTitle) &&
                Objects.equals(ownerName, imageDto.ownerName) &&
                Objects.equals(ownerPhoneNumber, imageDto.ownerPhoneNumber) &&
                Objects.equals(ownerEmail, imageDto.ownerEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ImageDto{" +
                "id=" + id +
                ", imageAsBase64Format=" + Arrays.toString(imageAsBase64Format) +
                ", imageTitle='" + imageTitle + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerPhoneNumber='" + ownerPhoneNumber + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                '}';
    }
}