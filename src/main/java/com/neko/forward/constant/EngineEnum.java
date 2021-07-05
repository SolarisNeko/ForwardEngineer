package com.neko.forward.constant;

/**
 * @author LHJ
 * @date 2021/7/5
 */
public enum EngineEnum {
    MYISAM("MyISAM"),
    INNODB("InnoDB")
    ;


    private String engine;

    EngineEnum() {
    }

    EngineEnum(String engine) {
        this.engine = engine;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
