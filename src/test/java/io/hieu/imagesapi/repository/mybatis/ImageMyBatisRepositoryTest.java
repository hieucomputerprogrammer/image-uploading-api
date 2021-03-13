package io.hieu.imagesapi.repository.mybatis;

import io.hieu.imagesapi.domain.Image;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ImageMyBatisRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Mock
    private ImageMyBatisRepository imageMyBatisRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        Image image = new Image(
                "TESTING".getBytes(),
                "TEST IMAGE",
                "Hieu Minh Le",
                "+84908109633",
                "hieu.minhle@outlook.com"
        );
        Image savedImage = this.imageMyBatisRepository.insert(image);
        Assert.assertNotNull(savedImage);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findAllByImageTitle() {
    }

    @Test
    public void findAllByOwnerName() {
    }

    @Test
    public void findAllByOwnerPhoneNumber() {
    }

    @Test
    public void findAllByOwnerEmail() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteAll() {
    }

    @Test
    public void deleteById() {
    }
}