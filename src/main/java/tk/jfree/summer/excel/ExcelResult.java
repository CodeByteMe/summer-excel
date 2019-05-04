package tk.jfree.summer.excel;


import java.util.List;

/**
 * 数据读取结果
 * @author Cheng.Wei
 */
public class ExcelResult<T> {
    /**sheet name*/
    private String sheet;
    /**首行（不含表头）*/
    private Integer firstRow;
    /**最后一行*/
    private Integer lastRow;
    /**读取的数据*/
    private List<T> data;


    public String getSheet() {
        return this.sheet;
    }

    public void setSheet(String sheet) {
        this.sheet = sheet;
    }

    public Integer getFirstRow() {
        return this.firstRow;
    }

    public void setFirstRow(Integer firstRow) {
        this.firstRow = firstRow;
    }

    public Integer getLastRow() {
        return this.lastRow;
    }

    public void setLastRow(Integer lastRow) {
        this.lastRow = lastRow;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static <T> ExcelResult.ExcelResultBuilder<T> builder() {
        return new ExcelResult.ExcelResultBuilder();
    }

    @Override
    public String toString() {
        return "ExcelResult(sheet=" + this.getSheet() + ", firstRow=" + this.getFirstRow() + ", lastRow=" + this.getLastRow() + ", data=" + this.getData() + ")";
    }

    public ExcelResult(String sheet, Integer firstRow, Integer lastRow, List<T> data) {
        this.sheet = sheet;
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.data = data;
    }

    public ExcelResult() {
    }

    public static class ExcelResultBuilder<T> {
        private String sheet;
        private Integer firstRow;
        private Integer lastRow;
        private List<T> data;

        ExcelResultBuilder() {
        }

        public ExcelResult.ExcelResultBuilder<T> sheet(String sheet) {
            this.sheet = sheet;
            return this;
        }

        public ExcelResult.ExcelResultBuilder<T> firstRow(Integer firstRow) {
            this.firstRow = firstRow;
            return this;
        }

        public ExcelResult.ExcelResultBuilder<T> lastRow(Integer lastRow) {
            this.lastRow = lastRow;
            return this;
        }

        public ExcelResult.ExcelResultBuilder<T> data(List<T> data) {
            this.data = data;
            return this;
        }

        public ExcelResult<T> build() {
            return new ExcelResult(this.sheet, this.firstRow, this.lastRow, this.data);
        }

        @Override
        public String toString() {
            return "ExcelResult.ExcelResultBuilder(sheet=" + this.sheet + ", firstRow=" + this.firstRow + ", lastRow=" + this.lastRow + ", data=" + this.data + ")";
        }
    }
}
