package io.hieu.imageuploadingapi.service.impl;

import io.hieu.imageuploadingapi.domain.Image;
import io.hieu.imageuploadingapi.dto.mapper.ImageMapper;
import io.hieu.imageuploadingapi.dto.model.ImageDto;
import io.hieu.imageuploadingapi.repository.mybatis.ImageMyBatisRepository;
import io.hieu.imageuploadingapi.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    private final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);
    private final ImageMyBatisRepository imageMyBatisRepository;

    @Autowired
    public ImageServiceImpl(ImageMyBatisRepository imageMyBatisRepository) {
        this.imageMyBatisRepository = imageMyBatisRepository;
    }

    @Override
    public void addImage(ImageDto imageDto) {
        this.logger.info("INFO: Image Service - addImage() method called.");
        this.logger.debug("DEBUG: Image Service - addImage() method called.");
        this.logger.trace("TRACE: Image Service - addImage() method called.");
        this.logger.warn("WARN: Image Service - addImage() method called.");
        this.logger.error("ERROR: Image Service - addImage() method called.");

        try {
            this.imageMyBatisRepository.insert(ImageMapper.toEntity(imageDto));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<ImageDto> findAll() {
        this.logger.info("INFO: Image Service - findAll() method called.");
        this.logger.debug("DEBUG: Image Service - findAll() method called.");
        this.logger.trace("TRACE: Image Service - findAll() method called.");
        this.logger.warn("WARN: Image Service - findAll() method called.");
        this.logger.error("ERROR: Image Service - findAll() method called.");

        if (this.imageMyBatisRepository.findAll().isEmpty()) {
            return null;
        } else {
            try {
                List<Image> images = this.imageMyBatisRepository.findAll();
                List<ImageDto> imageDtos = new ArrayList<ImageDto>();
                for (Image image : images) {
                    imageDtos.add(ImageMapper.toDto(image));
                }

                return imageDtos;
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<ImageDto> findAllByImageTitle(String imageTitle) {
        this.logger.info("INFO: Image Service - findAllByImageTitle() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByImageTitle() method called.");
        this.logger.trace("TRACE: Image Service - findAllByImageTitle() method called.");
        this.logger.warn("WARN: Image Service - findAllByImageTitle() method called.");
        this.logger.error("ERROR: Image Service - findAllByImageTitle() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByImageTitle(imageTitle);
            List<ImageDto> imageDtos = new ArrayList<ImageDto>();
            for (Image image : images) {
                imageDtos.add(ImageMapper.toDto(image));
            }

            return imageDtos;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ImageDto> findAllByOwnerName(String ownerName) {
        this.logger.info("INFO: Image Service - findAllByOwnerName() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByOwnerName() method called.");
        this.logger.trace("TRACE: Image Service - findAllByOwnerName() method called.");
        this.logger.warn("WARN: Image Service - findAllByOwnerName() method called.");
        this.logger.error("ERROR: Image Service - findAllByOwnerName() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByOwnerName(ownerName);
            List<ImageDto> imageDtos = new ArrayList<ImageDto>();
            for (Image image : images) {
                imageDtos.add(ImageMapper.toDto(image));
            }

            return imageDtos;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ImageDto> findAllByOwnerPhoneNumber(String ownerPhoneNumber) {
        this.logger.info("INFO: Image Service - findAllByOwnerPhoneNumber() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByOwnerPhoneNumber() method called.");
        this.logger.trace("TRACE: Image Service - findAllByOwnerPhoneNumber() method called.");
        this.logger.warn("WARN: Image Service - findAllByOwnerPhoneNumber() method called.");
        this.logger.error("ERROR: Image Service - findAllByOwnerPhoneNumber() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByOwnerPhoneNumber(ownerPhoneNumber);
            List<ImageDto> imageDtos = new ArrayList<ImageDto>();
            for (Image image : images) {
                imageDtos.add(ImageMapper.toDto(image));
            }

            return imageDtos;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ImageDto> findAllByOwnerEmail(String ownerEmail) {
        this.logger.info("INFO: Image Service - findAllByOwnerEmail() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByOwnerEmail() method called.");
        this.logger.trace("TRACE: Image Service - findAllByOwnerEmail() method called.");
        this.logger.warn("WARN: Image Service - findAllByOwnerEmail() method called.");
        this.logger.error("ERROR: Image Service - findAllByOwnerEmail() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByOwnerEmail(ownerEmail);
            List<ImageDto> imageDtos = new ArrayList<ImageDto>();
            for (Image image : images) {
                imageDtos.add(ImageMapper.toDto(image));
            }

            return imageDtos;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public ImageDto findById(Long id) {
        this.logger.info("INFO: Image Service - findById() method called.");
        this.logger.debug("DEBUG: Image Service - findById() method called.");
        this.logger.trace("TRACE: Image Service - findById() method called.");
        this.logger.warn("WARN: Image Service - findById() method called.");
        this.logger.error("ERROR: Image Service - findById() method called.");

        try {
            return ImageMapper.toDto(this.imageMyBatisRepository.findById(id));
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public ImageDto update(Long id, ImageDto imageDto) {
        this.logger.info("INFO: Image Service - update() method called.");
        this.logger.debug("DEBUG: Image Service - update() method called.");
        this.logger.trace("TRACE: Image Service - update() method called.");
        this.logger.warn("WARN: Image Service - update() method called.");
        this.logger.error("ERROR: Image Service - update() method called.");

        if (this.imageMyBatisRepository.findById(id) != null) {
            try {
                Image image = this.imageMyBatisRepository.findById(id);
                image.setId(imageDto.getId());
                image.setImageTitle(imageDto.getImageTitle());
                image.setOwnerName(imageDto.getOwnerName());
                image.setOwnerPhoneNumber(imageDto.getOwnerPhoneNumber());
                image.setOwnerEmail(imageDto.getOwnerEmail());
                this.imageMyBatisRepository.update(id, image);

                return ImageMapper.toDto(image);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            return null;
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        this.logger.info("INFO: Image Service - deleteById() method called.");
        this.logger.debug("DEBUG: Image Service - deleteById() method called.");
        this.logger.trace("TRACE: Image Service - deleteById() method called.");
        this.logger.warn("WARN: Image Service - deleteById() method called.");
        this.logger.error("ERROR: Image Service - deleteById() method called.");

        if (this.imageMyBatisRepository.findById(id) != null) {
            try {
                this.imageMyBatisRepository.deleteById(id);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void deleteAll() {
        this.logger.info("INFO: Image Service - deleteAll() method called.");
        this.logger.debug("DEBUG: Image Service - deleteAll() method called.");
        this.logger.trace("TRACE: Image Service - deleteAll() method called.");
        this.logger.warn("WARN: Image Service - deleteAll() method called.");
        this.logger.error("ERROR: Image Service - deleteAll() method called.");

        if (!this.imageMyBatisRepository.findAll().isEmpty()) {
            try {
                this.imageMyBatisRepository.deleteAll();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}