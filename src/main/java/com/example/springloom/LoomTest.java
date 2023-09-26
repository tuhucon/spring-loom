package com.example.springloom;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LoomTest {

    public static void main(String[] args) {
        System.out.println("Main start: " + Thread.currentThread());
        System.out.println("CPU cores: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Memory: " + Runtime.getRuntime().totalMemory());

        Integer maxNum = 2;

        Set<String> threadPool = new ConcurrentSkipListSet<>();

        List<Thread> threads = IntStream.range(0, maxNum + 1).mapToObj(index -> {
            return Thread.ofVirtual().unstarted(() -> {
                threadPool.add(Thread.currentThread().toString().split("/")[1]);
                if (index == 0 || index == maxNum) {
                    System.out.println("index " + index + " : " + Thread.currentThread());
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (index ==0 || index == maxNum) {
                    System.out.println("index " + index + " : " + Thread.currentThread());
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (index ==0 || index == maxNum) {
                    System.out.println("index " + index + " : " + Thread.currentThread());
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (index ==0 || index == maxNum) {
                    System.out.println("index " + index + " : " + Thread.currentThread());
                }
            });
        }).collect(Collectors.toList());

        threads.forEach(t -> t.start());
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(threadPool);
        System.out.println("Main end: " + Thread.currentThread());
    }

}
