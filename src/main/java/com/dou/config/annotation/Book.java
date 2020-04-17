package com.dou.config.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;

/**
 * javadoc -d D:\doc com.dou.config.annotation -encoding utf-8 -charset utf-8
 */
@Documented
@Inherited
public @interface Book {

    /**
     * 书名
     * @return 书名
     */
    String name();

    /**
     * 出版日期
     * @return 出版日期
     */
    String publishDate();

    /**
     * 作者
     * @return 作者
     */
    String author();
}
