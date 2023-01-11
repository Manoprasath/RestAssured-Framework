package com.marusputin.util;

import com.github.javafaker.Address;

/**
 * Business layer between tests and FakerUtils
 */
public final class RandomUtils {
    private RandomUtils(){}

    public static int getNumber() {
        return FakerUtils.getNumberBetween(1, 100);
    }

    public static Address getAddress() {
        return FakerUtils.getAddress();
    }
}
