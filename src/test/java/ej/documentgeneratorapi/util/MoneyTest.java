package ej.documentgeneratorapi.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MoneyTest {

    @Test
    public void formatDecimal_LongValue_StringDecimal() {
        String amount = NumberFormatter.formatDecimal(1L);
        assertEquals("1", amount);
    }

    @Test
    public void formatDecimal_LongValueNull_Null() {
        assertNull(NumberFormatter.formatDecimal(null));
    }

    @Test
    public void formatDecimalWithReplace_DoubleValue_StringDecimalWithReplaces() {
        String amount = NumberFormatter.formatDecimalWithReplace(1.0);
        assertEquals("1,00", amount);
    }

    @Test
    public void formatDecimalWithReplace_DoubleValueNull_Null() {
        assertNull(NumberFormatter.formatDecimalWithReplace((Double) null));
    }

    @Test
    public void formatDecimalWithReplace_LongValue_StringDecimalWithReplaces() {
        String amount = NumberFormatter.formatDecimalWithReplace(1L);
        assertEquals("1", amount);
    }

    @Test
    public void formatDecimalWithReplace_LongValueNull_Null() {
        assertNull(NumberFormatter.formatDecimalWithReplace((Long) null));
    }

    @Test
    public void formatDecimalWithReplace_BigDecimalValue_StringDecimalWithReplaces() {
        String amount = NumberFormatter.formatDecimalWithReplace(BigDecimal.valueOf(2.0));
        assertEquals("2,00", amount);
    }

    @Test
    public void formatDecimalWithReplace_BigDecimalValueNull_Null() {
        assertNull(NumberFormatter.formatDecimalWithReplace((BigDecimal) null));
    }

    @Test
    public void formatDecimalWithReplace_BigDecimalValueAndScale_StringDecimalWithReplaces() {
        String amount = NumberFormatter.formatDecimalWithReplace(BigDecimal.valueOf(2.16),3);
        assertEquals("2,160", amount);
    }

    @Test
    public void formatCurrencyByGermany_BigDecimalValue_StringDecimalInGermanyCurrencyStyle() {
        String amount = NumberFormatter.formatCurrencyByGermany(BigDecimal.valueOf(1000));
        assertEquals("1.000", amount);
    }

    @Test
    public void formatCurrencyBySlovakia_BigDecimalValue_StringDecimalInSlovakiaCurrencyStyle() {
        String amount = NumberFormatter.formatCurrencyBySlovakia(BigDecimal.valueOf(1000));
        assertEquals("1 000,00".length(), amount.length());
    }

}
