package tk.jfree.summer.excel.type;

import org.apache.poi.ss.usermodel.Cell;

import java.lang.reflect.Field;

/**
 * 需定制转换数据只要继承当前类并定制 {@link #get(Cell)}方法来实现
 * 参考：
 * @see IntegerTypeHandler
 * @see DateTypeHandler
 *
 * @author Cheng.Wei
 */
public abstract class AbstractTypeHandler<V> implements TypeHandler<V>{

    private final Field field;

    public AbstractTypeHandler(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public abstract V get(Cell cell) throws Exception;
}
