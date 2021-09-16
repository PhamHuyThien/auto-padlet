
package com.thiendz.tool.autopadlet.util.enums;

public enum RandomType {

    STR_UPPER, STR_LOWER, NUMBER;

    @Override
    public String toString() {
        final String STR_UPPER = "QWERTYUIOPASDFGHJKLZXCVBNM";
        final String STR_LOWER = "qwertyuiopasdfghjklzxcvbnm";
        final String NUMBER = "1234567890";
        switch (this) {
            case STR_LOWER:
                return STR_LOWER;
            case STR_UPPER:
                return STR_UPPER;
            case NUMBER:
                return NUMBER;
            default:
                return "";
        }
    }
}
