package io.hieu.imagesapi.repository.redis;

import io.hieu.imagesapi.domain.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public class ImageRedisRepository {
    private static final String HASH_KEY = "IMAGE";
    private RedisTemplate redisTemplate;

    @Autowired
    public ImageRedisRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(Image image) {
        this.redisTemplate.opsForHash().put(this.HASH_KEY, image.getId(), image);
    }

    public List<Image> findAll() {
        return this.redisTemplate.opsForHash().values(this.HASH_KEY);
    }

    public Image findById(Long id) {
        return (Image) this.redisTemplate.opsForHash().get(this.HASH_KEY, id);
    }

    public void update(Image image) {
        this.save(image);
    }

    public String deleteById(Long id) {
        this.redisTemplate.opsForHash().delete(this.HASH_KEY, id);
        return "Image with ID number: " + id + " is removed.";
    }
}