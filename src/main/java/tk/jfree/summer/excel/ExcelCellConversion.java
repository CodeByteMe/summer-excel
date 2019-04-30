package tk.jfree.summer.excel;

/**
 * @author Cheng.Wei
 */
public class ExcelCellConversion {
    /**
     * Excel 列转序号
     * @param col
     * @return
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
     * @param index
     * @return
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
