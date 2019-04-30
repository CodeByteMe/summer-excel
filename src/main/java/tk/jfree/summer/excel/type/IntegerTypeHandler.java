package tk.jfree.summer.excel.type;

import org.apache.poi.ss.usermodel.Cell;

import java.lang.reflect.Field;
import java.text.DecimalFormat;

/**
 * 转换 java.lang.Integer
 * @author Cheng.Wei
 */
public class IntegerTypeHandler implements TypeHandler<Integer> {
    public  IntegerTypeHandler(Field field){}
    @Override
    public Integer get(Cell cell) throws Exception {
        return Integer.parseInt(new DecimalFormat("#").format(cell.getNumericCellValue()));
    }
}
