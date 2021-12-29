package dev.feryadi.belajarspringdataredis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * @author Feryadialoi
 * @date 12/12/2021 5:58 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("product")
public class ProductRedisHash {
    @Id
    private String id;
    private String name;
    private Long price;
}
