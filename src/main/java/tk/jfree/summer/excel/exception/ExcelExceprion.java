package tk.jfree.summer.excel.exception;

/**
 * @author Cheng.Wei
 */
public class ExcelExceprion extends RuntimeException{
    public ExcelExceprion() {
        super();
    }

    public ExcelExceprion(String message) {
        super(message);
    }

    public ExcelExceprion(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcelExceprion(Throwable cause) {
        super(cause);
    }
}
