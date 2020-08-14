package com.github.dylanz666.constant;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public enum AllureAttachmentTypeEnum {
    TEXT_PLAIN("text/plain"),
    IMAGE_PNG("image/png"),
    APPLICATION_JSON("application/json");

    private String value;

    AllureAttachmentTypeEnum(String value) {
        this.value = value;
    }

    public static String getValue(String type) {
        for (AllureAttachmentTypeEnum typeEnum : AllureAttachmentTypeEnum.values()) {
            if (typeEnum.toString().equals(type)) {
                return typeEnum.value;
            }
        }
        return null;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static AllureAttachmentTypeEnum getType(String value) {
        for (AllureAttachmentTypeEnum typeEnum : AllureAttachmentTypeEnum.values()) {
            if (typeEnum.value.equals(value)) {
                return typeEnum;
            }
        }
        return null;
    }
}
