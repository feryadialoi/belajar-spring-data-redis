package dev.feryadi.belajarspringdataredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Feryadialoi
 * @date 12/12/2021 8:42 PM
 */
@SpringBootTest
class ProductJpaRepositoryTest {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Test
    void testInsert() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName("product 3");
        productEntity.setPrice(10000L);
        productJpaRepository.save(productEntity);
    }
}