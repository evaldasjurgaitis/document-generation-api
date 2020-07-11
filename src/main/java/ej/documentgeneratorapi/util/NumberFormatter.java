package ej.documentgeneratorapi.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatter {

    private static final int DEFAULT_SCALE = 2;

    public static String formatDecimal(Long amount) {
        if (amount == null) return null;

        return amount.toString();
    }

    public static String formatDecimalWithReplace(Double amount) {
        if (amount == null) return null;

        return String.format("%.2f", amount).replace('.', ',');
    }

    public static String formatDecimalWithReplace(Long amount) {
        if (amount == null) return null;

        return amount.toString().replace('.', ',');
    }

    public static String formatDecimalWithReplace(BigDecimal amount) {
        return formatDecimalWithReplace(amount, DEFAULT_SCALE);
    }

    public static String formatDecimalWithReplace(BigDecimal amount, int scale) {
        if (amount == null) return null;

        return amount.setScale(scale, BigDecimal.ROUND_HALF_UP).toString().replace('.', ',');
    }

    public static String formatCurrencyByGermany(BigDecimal amount) {
        if (amount == null) return null;

        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);
        return nf.format(amount);
    }

    public static String formatCurrencyBySlovakia(BigDecimal amount) {
        if (amount == null) return null;

        NumberFormat nf = NumberFormat.getInstance(new Locale("sk", "SK"));
        nf.setMaximumFractionDigits(DEFAULT_SCALE);
        nf.setMinimumFractionDigits(DEFAULT_SCALE);
        return nf.format(amount);
    }

}
