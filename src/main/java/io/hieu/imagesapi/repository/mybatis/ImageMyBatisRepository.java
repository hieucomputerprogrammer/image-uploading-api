package io.hieu.imagesapi.repository.mybatis;

import io.hieu.imagesapi.domain.Image;
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
            "FROM image LIMIT #{size} OFFSET (#{size} * #{page}) - #{size}")
    List<Image> findAllPaginated(int page, int size);

    @Select("SELECT id AS id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image WHERE image_title=#{imageTitle}")
    List<Image> findAllByImageTitle(String imageTitle);

    @Select("SELECT id AS id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image WHERE owner_name=#{ownerName}")
    List<Image> findAllByOwnerName(String ownerName);

    @Select("SELECT id AS id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image WHERE owner_phone_number=#{ownerPhoneNumber}")
    List<Image> findAllByOwnerPhoneNumber(String ownerPhoneNumber);

    @Select("SELECT id AS id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image WHERE owner_phone_number=#{ownerPhoneNumber}")
    List<Image> findAllByOwnerEmail(String ownerEmail);

    @Select("SELECT id as id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image ORDER BY id ASC")
    List<Image> findAllByIdAsc();

    @Select("SELECT id as id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image ORDER BY id DESC")
    List<Image> findAllByIdDesc();

    @Select("SELECT id as id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image ORDER BY image_as_base64_format ASC")
    List<Image> findAllByImageAsBase64FormatAsc();

    @Select("SELECT id as id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image ORDER BY image_as_base64_format DESC")
    List<Image> findAllByImageAsBase64FormatDesc();

    @Select("SELECT id as id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image ORDER BY image_title ASC")
    List<Image> findAllByImageTitleAsc();

    @Select("SELECT id as id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image ORDER BY image_title DESC")
    List<Image> findAllByImageTitleDesc();

    @Select("SELECT id as id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image ORDER BY owner_name ASC")
    List<Image> findAllByOwnerNameAsc();

    @Select("SELECT id as id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image ORDER BY owner_name DESC")
    List<Image> findAllByOwnerNameDesc();

    @Select("SELECT id as id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image ORDER BY owner_phone_number ASC")
    List<Image> findAllByOwnerPhoneNumberAsc();

    @Select("SELECT id as id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image ORDER BY owner_phone_number DESC")
    List<Image> findAllByOwnerPhoneNumberDesc();

    @Select("SELECT id as id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image ORDER BY owner_email ASC")
    List<Image> findAllByOwnerEmailAsc();

    @Select("SELECT id as id, image_as_base64_format AS imageAsBase64Format, image_title AS imageTitle, owner_name AS ownerName, owner_phone_number AS ownerPhoneNumber, owner_email AS ownerEmail " +
            "FROM image ORDER BY owner_email DESC")
    List<Image> findAllByOwnerEmailDesc();

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