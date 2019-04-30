package tk.jfree.summer.excel.type;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import tk.jfree.summer.excel.annotation.Column;

import java.lang.reflect.Field;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 转换 java.sql.Date
 * @author Cheng.Wei
 */
public class DateTypeHandler implements TypeHandler<java.sql.Date> {
    private final Field field;

    public DateTypeHandler(Field field) {
        this.field = field;
    }

    @Override
    public Date get(Cell cell) throws Exception {
        if (CellType.NUMERIC == cell.getCellType()) {
            return new Date(cell.getDateCellValue().getTime());
        }
        java.util.Date date = new SimpleDateFormat(field.getAnnotation(Column.class).format()).parse(cell.getStringCellValue());
        return new Date(date.getTime());
    }
}
