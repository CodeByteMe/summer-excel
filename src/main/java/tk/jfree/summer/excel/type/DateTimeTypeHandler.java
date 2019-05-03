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
public class DateTimeTypeHandler extends AbstractTypeHandler<Date> {

    public DateTimeTypeHandler(Field field) {
        super(field);
    }

    @Override
    public Date get(Cell cell) throws Exception{
        if (CellType.NUMERIC == cell.getCellType()) {
            return cell.getDateCellValue();
        }
        return new SimpleDateFormat(getField().getAnnotation(Column.class).format()).parse(cell.getStringCellValue());
    }
}
