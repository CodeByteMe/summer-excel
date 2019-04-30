package tk.jfree.summer.excel.type;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import tk.jfree.summer.excel.annotation.Column;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 转换 java.util.Date
 * @author Cheng.Wei
 */
public class DateTimeTypeHandler implements TypeHandler<java.util.Date> {
    private final Field field;

    public DateTimeTypeHandler(Field field) {
        this.field = field;
    }

    @Override
    public Date get(Cell cell) throws Exception{
        if (CellType.NUMERIC == cell.getCellType()) {
            return cell.getDateCellValue();
        }
        return new SimpleDateFormat(field.getAnnotation(Column.class).format()).parse(cell.getStringCellValue());
    }
}
