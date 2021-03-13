package io.hieu.imagesapi.service.impl;

import io.hieu.imagesapi.domain.Image;
import io.hieu.imagesapi.dto.mapper.ImageMapper;
import io.hieu.imagesapi.dto.model.ImageDto;
import io.hieu.imagesapi.repository.mybatis.ImageMyBatisRepository;
import io.hieu.imagesapi.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<ImageDto> findAllPaginated(int page) {
        this.logger.info("INFO: Image Service - findAllPaginated() method called.");
        this.logger.debug("DEBUG: Image Service - findAllPaginated() method called.");
        this.logger.trace("TRACE: Image Service - findAllPaginated() method called.");
        this.logger.warn("WARN: Image Service - findAllPaginated() method called.");
        this.logger.error("ERROR: Image Service - findAllPaginated() method called.");

        int size = 5;
        if (this.imageMyBatisRepository.findAllPaginated(page, size).isEmpty()) {
            return null;
        } else {
            try {
                List<Image> images = this.imageMyBatisRepository.findAllPaginated(page, size);
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
    public List<ImageDto> findAllByIdAsc() {
        this.logger.info("INFO: Image Service - findAllByIdAsc() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByIdAsc() method called.");
        this.logger.trace("TRACE: Image Service - findAllByIdAsc() method called.");
        this.logger.warn("WARN: Image Service - findAllByIdAsc() method called.");
        this.logger.error("ERROR: Image Service - findAllByIdAsc() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByIdAsc();
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
    public List<ImageDto> findAllByIdDesc() {
        this.logger.info("INFO: Image Service - findAllByIdDesc() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByIdDesc() method called.");
        this.logger.trace("TRACE: Image Service - findAllByIdDesc() method called.");
        this.logger.warn("WARN: Image Service - findAllByIdDesc() method called.");
        this.logger.error("ERROR: Image Service - findAllByIdDesc() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByIdDesc();
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
    public List<ImageDto> findAllByImageAsBase64FormatAsc() {
        this.logger.info("INFO: Image Service - findAllByImageAsBase64FormatAsc() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByImageAsBase64FormatAsc() method called.");
        this.logger.trace("TRACE: Image Service - findAllByImageAsBase64FormatAsc() method called.");
        this.logger.warn("WARN: Image Service - findAllByImageAsBase64FormatAsc() method called.");
        this.logger.error("ERROR: Image Service - findAllByImageAsBase64FormatAsc() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByImageAsBase64FormatAsc();
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
    public List<ImageDto> findAllByImageAsBase64FormatDesc() {
        this.logger.info("INFO: Image Service - findAllByImageAsBase64FormatDesc() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByImageAsBase64FormatDesc() method called.");
        this.logger.trace("TRACE: Image Service - findAllByImageAsBase64FormatDesc() method called.");
        this.logger.warn("WARN: Image Service - findAllByImageAsBase64FormatDesc() method called.");
        this.logger.error("ERROR: Image Service - findAllByImageAsBase64FormatDesc() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByImageAsBase64FormatDesc();
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
    public List<ImageDto> findAllByImageTitleAsc() {
        this.logger.info("INFO: Image Service - findAllByImageTitleAsc() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByImageTitleAsc() method called.");
        this.logger.trace("TRACE: Image Service - findAllByImageTitleAsc() method called.");
        this.logger.warn("WARN: Image Service - findAllByImageTitleAsc() method called.");
        this.logger.error("ERROR: Image Service - findAllByImageTitleAsc() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByImageTitleAsc();
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
    public List<ImageDto> findAllByImageTitleDesc() {
        this.logger.info("INFO: Image Service - findAllByImageTitleDesc() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByImageTitleDesc() method called.");
        this.logger.trace("TRACE: Image Service - findAllByImageTitleDesc() method called.");
        this.logger.warn("WARN: Image Service - findAllByImageTitleDesc() method called.");
        this.logger.error("ERROR: Image Service - findAllByImageTitleDesc() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByImageTitleDesc();
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
    public List<ImageDto> findAllByOwnerNameAsc() {
        this.logger.info("INFO: Image Service - findAllByOwnerNameAsc() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByOwnerNameAsc() method called.");
        this.logger.trace("TRACE: Image Service - findAllByOwnerNameAsc() method called.");
        this.logger.warn("WARN: Image Service - findAllByOwnerNameAsc() method called.");
        this.logger.error("ERROR: Image Service - findAllByOwnerNameAsc() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByOwnerNameAsc();
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
    public List<ImageDto> findAllByOwnerNameDesc() {
        this.logger.info("INFO: Image Service - findAllByOwnerNameDesc() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByOwnerNameDesc() method called.");
        this.logger.trace("TRACE: Image Service - findAllByOwnerNameDesc() method called.");
        this.logger.warn("WARN: Image Service - findAllByOwnerNameDesc() method called.");
        this.logger.error("ERROR: Image Service - findAllByOwnerNameDesc() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByOwnerNameDesc();
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
    public List<ImageDto> findAllByOwnerPhoneNumberAsc() {
        this.logger.info("INFO: Image Service - findAllByOwnerPhoneNumberAsc() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByOwnerPhoneNumberAsc() method called.");
        this.logger.trace("TRACE: Image Service - findAllByOwnerPhoneNumberAsc() method called.");
        this.logger.warn("WARN: Image Service - findAllByOwnerPhoneNumberAsc() method called.");
        this.logger.error("ERROR: Image Service - findAllByOwnerPhoneNumberAsc() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByOwnerPhoneNumberAsc();
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
    public List<ImageDto> findAllByOwnerPhoneNumberDesc() {
        this.logger.info("INFO: Image Service - findAllByOwnerPhoneNumberDesc() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByOwnerPhoneNumberDesc() method called.");
        this.logger.trace("TRACE: Image Service - findAllByOwnerPhoneNumberDesc() method called.");
        this.logger.warn("WARN: Image Service - findAllByOwnerPhoneNumberDesc() method called.");
        this.logger.error("ERROR: Image Service - findAllByOwnerPhoneNumberDesc() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByOwnerPhoneNumberDesc();
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
    public List<ImageDto> findAllByOwnerEmailAsc() {
        this.logger.info("INFO: Image Service - findAllByOwnerEmailAsc() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByOwnerEmailAsc() method called.");
        this.logger.trace("TRACE: Image Service - findAllByOwnerEmailAsc() method called.");
        this.logger.warn("WARN: Image Service - findAllByOwnerEmailAsc() method called.");
        this.logger.error("ERROR: Image Service - findAllByOwnerEmailAsc() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByOwnerEmailAsc();
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
    public List<ImageDto> findAllByOwnerEmailDesc() {
        this.logger.info("INFO: Image Service - findAllByOwnerEmailDesc() method called.");
        this.logger.debug("DEBUG: Image Service - findAllByOwnerEmailDesc() method called.");
        this.logger.trace("TRACE: Image Service - findAllByOwnerEmailDesc() method called.");
        this.logger.warn("WARN: Image Service - findAllByOwnerEmailDesc() method called.");
        this.logger.error("ERROR: Image Service - findAllByOwnerEmailDesc() method called.");

        try {
            List<Image> images = this.imageMyBatisRepository.findAllByOwnerEmailDesc();
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