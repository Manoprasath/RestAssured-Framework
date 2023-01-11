package com.marusputin.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * All framework related constants
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FrameworkConstants {
    public static final String INPUT_JSON_FOLDER_PATH = System.getProperty("user.dir") + "/src/test/resources/testdata";
    public static final String RESPONSE_JSON_FOLDER_PATH = System.getProperty("user.dir") + "/src/test/resources/output/";
    public static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir") + "/src/test/resources/output/";
    public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config.properties";
}
