package com.epam.igorpystovit;

import java.util.IntSummaryStatistics;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {

        System.out.println(IntStream.range(1,5).summaryStatistics());
    }
}
