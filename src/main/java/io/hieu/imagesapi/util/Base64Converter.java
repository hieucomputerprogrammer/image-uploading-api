package io.hieu.imagesapi.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Base64Converter {
    public static String imageToBase64(File imageFilePath) throws IOException {
        byte[] imageFile = FileUtils.readFileToByteArray(imageFilePath);
        String imageAsBase64String = Base64.getEncoder().encodeToString(imageFile);

        return imageAsBase64String;
    }

    public static void base64ToImage(String imageAsBase64String, String imageLocation) throws IOException {
        byte[] image = Base64.getDecoder().decode(imageAsBase64String);
        FileUtils.writeByteArrayToFile(new File(imageLocation), image);
    }
}