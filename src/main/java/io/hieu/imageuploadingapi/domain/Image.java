package io.hieu.imageuploadingapi.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private byte[] imageAsBase64Format;
    private String imageTitle;
    private String ownerName;
    private String ownerPhoneNumber;
    private String ownerEmail;

    public Image() {
    }

    public Image(byte[] imageAsBase64Format, String imageTitle, String ownerName, String ownerPhoneNumber, String ownerEmail) {
        this.imageAsBase64Format = imageAsBase64Format;
        this.imageTitle = imageTitle;
        this.ownerName = ownerName;
        this.ownerPhoneNumber = ownerPhoneNumber;
        this.ownerEmail = ownerEmail;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
        Image image = (Image) o;
        return Objects.equals(Id, image.Id) &&
                Arrays.equals(imageAsBase64Format, image.imageAsBase64Format) &&
                Objects.equals(imageTitle, image.imageTitle) &&
                Objects.equals(ownerName, image.ownerName) &&
                Objects.equals(ownerPhoneNumber, image.ownerPhoneNumber) &&
                Objects.equals(ownerEmail, image.ownerEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Image{" +
                "Id=" + Id +
                ", imageAsBase64Format=" + Arrays.toString(imageAsBase64Format) +
                ", imageTitle='" + imageTitle + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerPhoneNumber='" + ownerPhoneNumber + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                '}';
    }
}