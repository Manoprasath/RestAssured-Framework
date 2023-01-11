package com.marusputin.pojo;

import lombok.Builder;
import lombok.Getter;

/**
 * POJO class for Location specification
 */
@Getter
@Builder
public class Location {
    private double lat;
    private double lng;
}
