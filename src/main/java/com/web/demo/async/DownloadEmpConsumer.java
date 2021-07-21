package com.web.demo.async;

import com.web.demo.utils.CommonUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Consumer;

public class DownloadEmpConsumer implements Consumer<String> {
    @Override
    public void accept(String fileName) {
        System.out.println("DownloadEmpConsumer Thread Name====" + Thread.currentThread().getName());
        String sUrl = "https://raw.githubusercontent.com/harilearning1989/DataFiles/master/" + fileName;
        URL url = null;
        try {
            url = new URL(sUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        File file = null;
        if (CommonUtils.isWindows()) {
            file = new File("D:/DataFiles/Downloaded/" + fileName);
        } else if (CommonUtils.isLinux()) {
            file = new File("D:/DataFiles/Downloaded/" + fileName);
        }
        copyURLToFile(url, file);
    }

    public static void copyURLToFile(URL url, File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory())
                    throw new IOException("File '" + file + "' is a directory");
                if (!file.canWrite())
                    throw new IOException("File '" + file + "' cannot be written");
            } else {
                File parent = file.getParentFile();
                if ((parent != null) && (!parent.exists()) && (!parent.mkdirs())) {
                    throw new IOException("File '" + file + "' could not be created");
                }
            }

            if (!file.exists()) {
                FileOutputStream output = new FileOutputStream(file);
                InputStream input = url.openStream();
                byte[] buffer = new byte[4096];
                int n = 0;
                while (-1 != (n = input.read(buffer))) {
                    output.write(buffer, 0, n);
                }
                input.close();
                output.close();
                System.out.println("File '" + file + "' downloaded successfully!");
            } else {
                System.out.println("File '" + file + "' already downloaded!");
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }
}
