package cn.dylanz.autoservice.constant;

/**
 * @author : dylanz
 * @since : 08/06/2020
 **/
public enum AllureAttachmentFileExtensionEnum {
    TXT(".txt"),
    PNG(".png"),
    JSON(".json");

    private String value;

    AllureAttachmentFileExtensionEnum(String value) {
        this.value = value;
    }

    public static String getValue(String extensionName) {
        for (AllureAttachmentFileExtensionEnum extensionEnum : AllureAttachmentFileExtensionEnum.values()) {
            if (extensionEnum.toString().equals(extensionName)) {
                return extensionEnum.value;
            }
        }
        return null;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static AllureAttachmentFileExtensionEnum getExtensionName(String value) {
        for (AllureAttachmentFileExtensionEnum extensionEnum : AllureAttachmentFileExtensionEnum.values()) {
            if (extensionEnum.value.equals(value)) {
                return extensionEnum;
            }
        }
        return null;
    }
}
