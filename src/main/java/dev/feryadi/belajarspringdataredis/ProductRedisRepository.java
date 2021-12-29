package dev.feryadi.belajarspringdataredis;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Feryadialoi
 * @date 12/12/2021 5:59 PM
 */
public interface ProductRedisRepository extends CrudRepository<ProductRedisHash, String> {
}
