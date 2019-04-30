package tk.jfree.summer.excel.annotation;

import tk.jfree.summer.excel.type.TypeHandler;
import tk.jfree.summer.excel.type.UnknownTypeHandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel 行注释
 * @author Cheng.Wei
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Column {
    /**
     * 列的名称,对应字母坐标A,B,C,D....
     * @return
     */
    String name();

    /**
     * 表格列文字描述
     * @return
     */
    String notes() default "";

    /**
     * 格式化
     * @return
     */
    String format() default "";

    /**
     * 解析器
     * @return
     */
    Class<? extends TypeHandler<?>> typeHandler() default UnknownTypeHandler.class;
}
