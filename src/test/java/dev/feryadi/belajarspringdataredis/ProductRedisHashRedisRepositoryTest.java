package dev.feryadi.belajarspringdataredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * @author Feryadialoi
 * @date 12/12/2021 6:01 PM
 */
@SpringBootTest
class ProductRedisHashRedisRepositoryTest {

    @Autowired
    private ProductRedisRepository productRedisRepository;

    @Test
    void test() {
        productRedisRepository.save(new ProductRedisHash(
                UUID.randomUUID().toString(),
                "product 1",
                10000L
        ));
    }

    @Test
    void testGetAll() {
        Iterable<ProductRedisHash> products = productRedisRepository.findAll();
        for (ProductRedisHash productRedisHash : products) {
            System.out.println(productRedisHash);
        }
    }
}