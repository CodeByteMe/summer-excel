package tk.jfree.summer.excel.type;

import org.apache.poi.ss.usermodel.Cell;

import java.lang.reflect.Field;
import java.text.DecimalFormat;

/**
 * 转换 java.lang.Integer
 * @author Cheng.Wei
 */
public class IntegerTypeHandler extends AbstractTypeHandler<Integer> {
    public  IntegerTypeHandler(Field field){super(field);}
    @Override
    public Integer get(Cell cell) throws Exception {
        return Integer.parseInt(new DecimalFormat("#").format(cell.getNumericCellValue()));
    }
}
