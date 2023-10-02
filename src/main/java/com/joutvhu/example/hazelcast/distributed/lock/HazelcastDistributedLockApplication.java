package com.joutvhu.example.hazelcast.distributed.lock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class HazelcastDistributedLockApplication {
    public static void main(String[] args) {
        SpringApplication.run(HazelcastDistributedLockApplication.class, args);
    }
}
