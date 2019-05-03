package tk.jfree.summer.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据模型注解
 * @author Cheng.Wei
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    /**
     * 数据起始行（默认第一行）
     * @return
     */
    int first() default 1;

    /**
     * 工作表名
     * 默认参数将无法保证读取的准确性
     * @return
     */
    String sheet() default "";
}
