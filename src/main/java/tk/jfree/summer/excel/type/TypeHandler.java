package tk.jfree.summer.excel.type;


import org.apache.poi.ss.usermodel.Cell;


/**
 * 数据转换接口、需要定制转换，须实现该接口且构造实现类 java.lang.reflect.Field 为入参的方法
 * 参考：
 * @see tk.jfree.summer.excel.type.IntegerTypeHandler
 * @see tk.jfree.summer.excel.type.DateTypeHandler
 *
 * @author Cheng.Wei
 */
public interface TypeHandler<V> {
    /**
     * 获取当前单元格内容
     * @param cell
     * @return
     * @throws Exception
     */
    V get(Cell cell) throws Exception;
}
