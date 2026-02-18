package com.deskmate.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Moneyutils {
    private Moneyutils() {}

    public static BigDecimal parse(String input) {
        try {
            return new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid money value: " + input);
        }
    }
}