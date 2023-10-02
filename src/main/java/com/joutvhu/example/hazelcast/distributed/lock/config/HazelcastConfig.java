package com.joutvhu.example.hazelcast.distributed.lock.config;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@EnableCaching
@Configuration
@ImportResource({"classpath:hazelcast.xml"})
public class HazelcastConfig {
    /**
     * Config cache manager to use distributed cache
     */
    @Bean("hazelcastCacheManager")
    public CacheManager hazelcastCacheManager(HazelcastInstance hazelcast) {
        return new HazelcastCacheManager(hazelcast);
    }
}
