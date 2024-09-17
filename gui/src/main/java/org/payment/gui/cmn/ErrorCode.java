package org.payment.gui.cmn;

public enum ErrorCode implements Code {
    DB_NO_RECORDS_FOUND("0401"), SUCCESS("0000");
    private String code;

    private ErrorCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
