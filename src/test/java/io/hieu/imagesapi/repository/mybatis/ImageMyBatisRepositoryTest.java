package io.hieu.imagesapi.repository.mybatis;

import io.hieu.imagesapi.domain.Image;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@TestPropertySource(locations = "classpath:application-test.yml")
public class ImageMyBatisRepositoryTest {
    @Mock
    private TestEntityManager testEntityManager;

    @InjectMocks
    private ImageMyBatisRepository imageMyBatisRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreateImage() {
        Image hieuMinhLe = this.testEntityManager.persist(
            new Image(
                "TESTING".getBytes(),
                "Hieu Minh Le - Portrait Photo",
                "Hieu Minh Le",
                "+84901234567",
                "hieu.minhle@outlook.com"
            )
        );
        Image savedImage = this.imageMyBatisRepository.findById(hieuMinhLe.getId());

        Assert.assertEquals(hieuMinhLe, savedImage);
        Assert.assertTrue(hieuMinhLe.getId() > 0);
    }

    @Test
    public void testFindAll() {
    }

    @Test
    public void testFindAllByImageTitle() {
    }

    @Test
    public void testFindAllByOwnerName() {
    }

    @Test
    public void testFindAllByOwnerPhoneNumber() {
    }

    @Test
    public void testFindAllByOwnerEmail() {
    }

    @Test
    public void testFindById() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testDeleteAll() {
    }

    @Test
    public void testDeleteById() {
    }
}