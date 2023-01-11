package com.marusputin.util;

import com.marusputin.constants.FrameworkConstants;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This utility is to read and write external file contents
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileUtils {

    @SneakyThrows
    public static String readJsonAndGetAsString(String fileName) {
        return new String(Files.readAllBytes(Path.of(Paths.get(FrameworkConstants.INPUT_JSON_FOLDER_PATH) + fileName)));
    }

    @SneakyThrows
    public static void storeStringAsJsonFile(String fileName, Response response) {
        Files.write(Paths.get(FrameworkConstants.RESPONSE_JSON_FOLDER_PATH + fileName + ".json"),
                response.asByteArray());
    }
}
