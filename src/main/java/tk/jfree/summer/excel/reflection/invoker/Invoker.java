package tk.jfree.summer.excel.reflection.invoker;

import org.apache.poi.ss.usermodel.Cell;

/**
 * @author Cheng.Wei
 */
public interface Invoker {
    /**
     * 复制
     * @param target 目标对象
     * @param cell 单元格信息
     * @return true 表示赋值成功 ，否则失败
     */
    boolean invoke(Object target, Cell cell);
}
