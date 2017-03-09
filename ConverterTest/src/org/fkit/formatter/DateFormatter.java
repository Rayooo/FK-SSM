package org.fkit.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ray on 2017/3/9.
 */
public class DateFormatter implements Formatter<Date> {

    //日期类型模版
    private String datePattern;
    //日期格式化对象
    private SimpleDateFormat dateFormat;

    //构造器
    public DateFormatter(String datePattern) {
        this.datePattern = datePattern;
        this.dateFormat = new SimpleDateFormat(datePattern);
    }

    //解析文本字符串，返回一个Formatter<T>的T类型对象
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        try {
            return dateFormat.parse(s);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    //显示formatter<T>的T类型对象
    @Override
    public String print(Date date, Locale locale) {
        return dateFormat.format(date);
    }
}
