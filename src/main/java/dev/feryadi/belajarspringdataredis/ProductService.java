package dev.feryadi.belajarspringdataredis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 12/12/2021 8:24 PM
 */
@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRedisRepository productRedisRepository;

    @Autowired
    private ProductJpaRepository productJpaRepository;


    public List<ProductResponse> getProducts() {
        return productJpaRepository.findAll().stream()
                .map(this::mapProductEntityToProductResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse getProduct(String productId) {
        Optional<ProductRedisHash> optionalProductRedisHash = productRedisRepository.findById(productId);
        if (optionalProductRedisHash.isPresent()) {
            log.info("getProduct = get from redis");
            return mapProductRedisHashToProductResponse(optionalProductRedisHash.get());
        } else {
            Optional<ProductEntity> optionalProductEntity = productJpaRepository.findById(productId);
            if (optionalProductEntity.isPresent()) {
                log.info("getProduct = get from mysql");
                ProductEntity productEntity = optionalProductEntity.get();
                productRedisRepository.save(new ProductRedisHash(
                        productEntity.getId(),
                        productEntity.getName(),
                        productEntity.getPrice()
                ));
                return mapProductEntityToProductResponse(productEntity);
            } else {
                return null;
            }
        }
    }

    private ProductResponse mapProductRedisHashToProductResponse(ProductRedisHash productRedisHash) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(productRedisHash.getId());
        productResponse.setName(productRedisHash.getName());
        productResponse.setPrice(productRedisHash.getPrice());
        return productResponse;
    }

    private ProductResponse mapProductEntityToProductResponse(ProductEntity productEntity) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(productEntity.getId());
        productResponse.setName(productEntity.getName());
        productResponse.setPrice(productEntity.getPrice());
        return productResponse;
    }
}
