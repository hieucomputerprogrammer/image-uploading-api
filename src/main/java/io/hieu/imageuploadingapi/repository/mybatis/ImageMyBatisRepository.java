package io.hieu.imageuploadingapi.repository.mybatis;

import io.hieu.imageuploadingapi.domain.Image;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ImageMyBatisRepository {
    @Insert("INSERT INTO image(id, image_as_base65_format, image_title, owner_name, owner_phone_number, owner_email) " +
            "VALUES(#{id}, #{imageAsBase64Format}, #{imageTitle}, #{ownerName}, #{ownerPhoneNumber}, #{ownerEmail});")
    int insert(Image image);

    @Select("SELECT * FROM image;")
    List<Image> findAll();

    @Select("SELECT * FROM image WHERE id = #{id};")
    Image findById(Long id);

    @Update("UPDATE image " +
            "image_as_base65_format=#{imageAsBase64Format}, " +
            "image_title=#{imageTitle}, " +
            "owner_name=#{ownerName}, " +
            "owner_phone_number=#{ownerPhoneNumber}, " +
            "owner_email=#{ownerEmail} " +
            "WHERE id=#{id};")
    int update(Image image);

    @Delete("DELETE FROM image;")
    int deleteAll();

    @Delete("DELETE FROM image WHERE id=#{id}")
    int deleteById(Long id);
}