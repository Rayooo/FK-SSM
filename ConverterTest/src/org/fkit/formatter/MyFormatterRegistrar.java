package org.fkit.formatter;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

/**
 * Created by Ray on 2017/3/9.
 */
public class MyFormatterRegistrar implements FormatterRegistrar {

    private DateFormatter dateFormatter;

    public MyFormatterRegistrar(DateFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    @Override
    public void registerFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addFormatter(dateFormatter);
    }
}
