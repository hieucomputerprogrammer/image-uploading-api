package io.hieu.imageuploadingapi.repository.mybatis;

import io.hieu.imageuploadingapi.domain.Image;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ImageMyBatisRepository {
    @Insert("INSERT INTO image(image_as_base64_format, image_title, owner_name, owner_phone_number, owner_email) " +
            "VALUES(#{imageAsBase64Format}, #{imageTitle}, #{ownerName}, #{ownerPhoneNumber}, #{ownerEmail})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Image image);

    @Select("SELECT id AS id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image")
    List<Image> findAll();

    @Select("SELECT id AS id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image " +
            "WHERE id=#{id}")
    Image findById(Long id);

    @Update("UPDATE image " +
            "SET image_as_base64_format=#{image.imageAsBase64Format}, " +
            "image_title=#{image.imageTitle}, " +
            "owner_name=#{image.ownerName}, " +
            "owner_phone_number=#{image.ownerPhoneNumber}, " +
            "owner_email=#{image.ownerEmail} " +
            "WHERE id=#{image.id}")
    int update(Long id, Image image);

    @Delete("DELETE FROM image")
    int deleteAll();

    @Delete("DELETE FROM image WHERE id=#{id}")
    int deleteById(Long id);
}