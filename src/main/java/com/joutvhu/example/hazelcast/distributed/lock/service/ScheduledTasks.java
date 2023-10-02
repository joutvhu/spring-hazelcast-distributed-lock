package com.joutvhu.example.hazelcast.distributed.lock.service;

import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@Slf4j
@Service
public class ScheduledTasks {
    @Autowired
    private HazelcastInstance hazelcast;

    @Scheduled(cron = "0 0/5 * * * *")
    public void runJob() throws InterruptedException {
        Lock lock = hazelcast.getCPSubsystem().getLock("run-job");
        if (lock.tryLock(10, TimeUnit.SECONDS)) {
            try {
                log.info("Running JobScheduler.runJob()");
                Thread.sleep(120_000);
                log.info("Complete JobScheduler.runJob()");
            } finally {
                log.info("Unlock JobScheduler.runJob()");
                lock.unlock();
            }
        } else {
            log.info("Skip JobScheduler.runJob()");
        }
    }
}
