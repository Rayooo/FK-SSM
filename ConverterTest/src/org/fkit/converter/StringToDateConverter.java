package org.fkit.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ray on 2017/3/9.
 */
public class StringToDateConverter implements Converter<String, Date> {

    //日期类型模版
    private String datePattern;

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    //Converter<S,T>接口的类型转换方法
    @Override
    public Date convert(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(this.datePattern);
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("日期转换失败");
            return null;
        }
    }
}
