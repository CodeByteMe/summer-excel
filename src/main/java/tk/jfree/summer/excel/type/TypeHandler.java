package tk.jfree.summer.excel.type;


import org.apache.poi.ss.usermodel.Cell;


/**
 * 数据转换接口、定制转换
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
