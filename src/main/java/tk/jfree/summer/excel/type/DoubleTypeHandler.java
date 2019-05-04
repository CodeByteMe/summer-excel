package tk.jfree.summer.excel.type;

import org.apache.poi.ss.usermodel.Cell;

import java.lang.reflect.Field;

/**
 * 转换 java.lang.Double
 * @author Cheng.Wei
 *
 */
public class DoubleTypeHandler extends AbstractTypeHandler<java.lang.Double>{
    public DoubleTypeHandler(Field field) {
        super(field);
    }

    @Override
    public Double get(Cell cell) throws Exception {
        double v = cell.getNumericCellValue();
        return v == 0 ? null : v;
    }
}
