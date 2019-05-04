package tk.jfree.summer.excel.type;

import org.apache.poi.ss.usermodel.Cell;

import java.lang.reflect.Field;
import java.text.DecimalFormat;

/**
 * java.lang.Long
 * @author Cheng.Wei
 *
 */
public class LongTypeHandler extends AbstractTypeHandler<java.lang.Long>{
    public LongTypeHandler(Field field) {
        super(field);
    }

    @Override
    public Long get(Cell cell) throws Exception {
        double v = cell.getNumericCellValue();
        return v == 0 ? null : Long.parseLong(new DecimalFormat("#").format(v));
    }
}
