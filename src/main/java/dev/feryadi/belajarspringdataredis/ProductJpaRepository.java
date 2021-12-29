package dev.feryadi.belajarspringdataredis;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Feryadialoi
 * @date 12/12/2021 8:30 PM
 */
public interface ProductJpaRepository extends JpaRepository<ProductEntity, String> {
}
