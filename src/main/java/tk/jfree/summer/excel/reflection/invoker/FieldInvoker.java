package tk.jfree.summer.excel.reflection.invoker;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import tk.jfree.summer.excel.annotation.Column;
import tk.jfree.summer.excel.type.TypeHandler;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Cheng.Wei
 */
@Slf4j
public class FieldInvoker implements Invoker {
    private static final Map<String, TypeHandler> RESULT_MAP = new ConcurrentHashMap<>();
    private final Field field;

    public FieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public boolean invoke(Object target, Cell cell) {
        try {
            Class<? extends TypeHandler<?>> clazz = field.getAnnotation(Column.class).typeHandler();
            if(!RESULT_MAP.containsKey(clazz.getName())){
                RESULT_MAP.put(clazz.getName(), clazz.getConstructor(Field.class).newInstance(field));
            }
            field.set(target, RESULT_MAP.get(clazz.getName()).get(cell));
            return true;
        } catch (Exception e) {
            log.debug("赋值操作异常:{}", e);
            return false;
        }
    }
}
