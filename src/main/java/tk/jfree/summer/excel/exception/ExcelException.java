package tk.jfree.summer.excel.exception;

/**
 * @author Cheng.Wei
 */
public class ExcelException extends RuntimeException{
    public ExcelException() {
        super();
    }

    public ExcelException(String message) {
        super(message);
    }

    public ExcelException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcelException(Throwable cause) {
        super(cause);
    }
}
