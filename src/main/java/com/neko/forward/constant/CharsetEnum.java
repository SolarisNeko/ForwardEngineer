package com.neko.forward.constant;

/**
 * @author LHJ
 * @date 2021/7/5
 */
public enum CharsetEnum {
    UTF8("utf8"),
    UTF8MB4("utf8mb4")
    ;


    private String charset;

    CharsetEnum(String charset) {
        this.charset = charset;
    }

    public String getCharset() {
        return charset;
    }
}
