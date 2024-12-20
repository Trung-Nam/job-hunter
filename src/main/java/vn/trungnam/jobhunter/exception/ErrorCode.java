package vn.trungnam.jobhunter.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error"),
    INVALID_KEY(1001,"Invalid message key!"),
    USER_EXISTED(1002,"User existed!"),
    USER_NOT_FOUND(1002,"User not found!"),
    USERNAME_INVALID(1004, "Username must be at least 3 characters"),
    PASSWORD_INVALID(1005,"Password must be at least 8 characters")
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
