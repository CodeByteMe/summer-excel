package tk.jfree.summer.excel.reflection.invoker;

import org.apache.poi.ss.usermodel.Cell;

/**
 * @author Cheng.Wei
 */
public interface Invoker {
    /**
     * 复制
     * @param target
     * @param cell
     * @return
     */
    boolean invoke(Object target, Cell cell);
}
