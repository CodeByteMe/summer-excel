package tk.jfree.summer.excel;

/**
 * Excel 行列转换计算
 * @author Cheng.Wei
 */
public class ExcelCellConversion {
    /**
     * Excel 列转序号
     * @param col 列号 A、B ...AA、AB ...
     * @return 返回序号
     */
    public static int getColumn(String col) {
        int column = -1;
        char[] cs = col.toUpperCase().toCharArray();
        for (int i = 0, length = cs.length; i < length; i++) {
            column += (cs[i] - 64) * Math.pow(26, (cs.length - 1 - i));
        }
        return column;
    }


    /**
     * Excel 序号转列
     * @param index 列转行后的序号 A-> 0 、B->1 ...
     * @return 返回序号
     */
    public static String getIndex(int index) {
        int num = 65;
        String colName = "";
        do {
            if (colName.length() > 0) {
                index--;
            }
            int remainder = index % 26;
            colName = ((char) (remainder + num)) + colName;
            index =  ((index - remainder) / 26);
        } while (index > 0);
        return colName;
    }
}
