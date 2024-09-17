package org.payment.commons.constants;



public enum Constants {
    OK("OK"),
    ERROR("ERROR"),
    SUCCESS("SUCCESS"),
    FAILURE("FAILURE"), SEMI_COLON_DELIMITER(";"), COMMA_DELIMITER(",");
    Constants(String value) {
        this.value = value;
    }
    private String value;
    public String getValue() {
        return value;
    }

}
