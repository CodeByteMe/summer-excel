package tk.jfree.summer.excel.type;

import org.apache.poi.ss.usermodel.Cell;
import tk.jfree.summer.excel.ExcelCellValue;

import java.lang.reflect.Field;

/**
 * 默认情况下不支持特殊格式数据赋值 如：java.util.Date 等，部分参数转换失败
 * 可定制参数转换
 * @see tk.jfree.summer.excel.type.AbstractTypeHandler
 * @see tk.jfree.summer.excel.type.TypeHandler
 * @author Cheng.Wei
 */
public class UnknownTypeHandler extends AbstractTypeHandler<Object> {

    public UnknownTypeHandler(Field field) {
        super(field);
    }

    @Override
    public Object get(Cell cell) throws Exception {
        return ExcelCellValue.get(cell);
    }
}
