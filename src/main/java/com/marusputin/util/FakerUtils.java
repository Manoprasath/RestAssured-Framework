package com.marusputin.util;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

/**
 * Contains wrapper methods of JavaFaker class
 */
public final class FakerUtils {
    private static final Faker FAKER = new Faker();

    private FakerUtils() {
    }

    static int getNumberBetween(int startValue, int endValue) {
        return FAKER.number().numberBetween(startValue, endValue);
    }

    static Address getAddress() {
        return FAKER.address();
    }

}
