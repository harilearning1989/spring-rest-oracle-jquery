package com.web.demo.async;

import com.web.demo.dtos.IndiaStatesDTO;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import static com.web.demo.utils.ExecutorServiceUtil.getTheExecutorService;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class ReadIndiaStatesSupplier implements Supplier<List<IndiaStatesDTO>> {
    @Override
    public List<IndiaStatesDTO> get() {
        try {
            CompletableFuture<String> compFuture1
                    = supplyAsync(() -> "csv/IndiaStates1.csv", getTheExecutorService());
            CompletableFuture<Void> future1 = compFuture1
                    .thenAccept(new DownloadEmpConsumer());

            CompletableFuture<String> compFuture2
                    = supplyAsync(() -> "csv/IndiaStates2.csv", getTheExecutorService());
            CompletableFuture<Void> future2 = compFuture2
                    .thenAccept(new DownloadEmpConsumer());

            future1.get();
            future2.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<IndiaStatesDTO> listCrop = new ArrayList<>();
        CompletableFuture<List<IndiaStatesDTO>> fileReadFuture1 =
                supplyAsync(() -> {
                    System.out.println("fileReadFuture1 Thread Name===" + Thread.currentThread().getName());
                    try {
                        return new CsvToBeanBuilder(new FileReader("D:/DataFiles/Downloaded/csv/IndiaStates1.csv"))
                                .withType(IndiaStatesDTO.class)
                                .build()
                                .parse();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    return null;
                }, getTheExecutorService());
        CompletableFuture<List<IndiaStatesDTO>> fileReadFuture2 =
                supplyAsync(() -> {
                    System.out.println("fileReadFuture2 Thread Name===" + Thread.currentThread().getName());
                    try {
                        return new CsvToBeanBuilder(new FileReader("D:/DataFiles/Downloaded/csv/IndiaStates2.csv"))
                                .withType(IndiaStatesDTO.class)
                                .build()
                                .parse();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    return null;
                }, getTheExecutorService());
        try {
            listCrop = fileReadFuture1.get();
            listCrop.addAll(fileReadFuture2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return listCrop;
    }
}
