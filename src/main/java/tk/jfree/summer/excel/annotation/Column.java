package tk.jfree.summer.excel.annotation;

import tk.jfree.summer.excel.type.TypeHandler;
import tk.jfree.summer.excel.type.UnknownTypeHandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel 列注解
 * @author Cheng.Wei
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Column {
    /**
     * 返回列的名称
     * @return 字母坐标A,B,C,D....
     */
    String name();

    /**
     * 返回列的描述信息
     * @return 列描述信息，默认空""
     */
    String notes() default "";

    /**
     * 返回一中格式 如时间格式， yyyy-MM-dd ...
     * @return 返回格式
     */
    String format() default "";

    /**
     * 返回数据类型解析器
     * @return 默认返回 UnknownTypeHandler
     */
    Class<? extends TypeHandler<?>> typeHandler() default UnknownTypeHandler.class;
}
