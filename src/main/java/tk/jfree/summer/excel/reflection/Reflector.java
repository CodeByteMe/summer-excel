package tk.jfree.summer.excel.reflection;

import lombok.extern.slf4j.Slf4j;
import tk.jfree.summer.excel.ExcelCellConversion;
import tk.jfree.summer.excel.annotation.Column;
import tk.jfree.summer.excel.reflection.invoker.FieldInvoker;
import tk.jfree.summer.excel.reflection.invoker.Invoker;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * @author Cheng.Wei
 */
@Slf4j
public class Reflector {
    private static final Map<Class<?>, Map<Integer, Invoker>> ORM_MAP = new ConcurrentHashMap<>();

    public static Map<Integer, Invoker> of(Class<?> clazz) {
        if (!ORM_MAP.containsKey(clazz)) {
            Map<Integer, Invoker> map = new HashMap<>(8);
            Stream.of(clazz.getDeclaredFields())
                    .filter(
                            field ->
                                    Optional.ofNullable(field.getAnnotation(Column.class)).isPresent())
                    .peek(field -> field.setAccessible(true))
                    .forEach(
                            field ->{
                               try {

                                   Column column = field.getAnnotation(Column.class);
                                   map.put(ExcelCellConversion.getColumn(column.name()), new FieldInvoker(field));
                               }catch (Exception e){
                                   log.debug("错误{}", e);
                               }
                            });
            ORM_MAP.put(clazz, map);
        }
        return ORM_MAP.get(clazz);
    }
}
