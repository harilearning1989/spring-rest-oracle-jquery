package com.web.demo.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceUtil {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(6);

    public static ExecutorService getTheExecutorService() {
        return executorService;
    }
}
