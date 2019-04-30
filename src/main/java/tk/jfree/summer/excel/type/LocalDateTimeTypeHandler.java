package tk.jfree.summer.excel.type;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import tk.jfree.summer.excel.annotation.Column;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 转换 java.time.LocalDateTime
 * @author Cheng.Wei
 */
  
public class LocalDateTimeTypeHandler implements TypeHandler<LocalDateTime> {
    private final Field field;

    public LocalDateTimeTypeHandler(Field field) {
        this.field = field;
    }

    private static final Map<String, DateTimeFormatter> LOCAL_DATE_TIME_FORMATTER =  new ConcurrentHashMap<>();
    @Override
    public LocalDateTime get(Cell cell) throws Exception {
        if (CellType.NUMERIC == cell.getCellType()) {
            return LocalDateTime.ofInstant(cell.getDateCellValue().toInstant(), ZoneId.systemDefault());
        }
        String format = field.getAnnotation(Column.class).format();
        if (!LOCAL_DATE_TIME_FORMATTER.containsKey(format)){
            LOCAL_DATE_TIME_FORMATTER.put(format, DateTimeFormatter.ofPattern(format));
        }
        return LocalDateTime.parse(cell.getStringCellValue(), LOCAL_DATE_TIME_FORMATTER.get(format));
    }
}
