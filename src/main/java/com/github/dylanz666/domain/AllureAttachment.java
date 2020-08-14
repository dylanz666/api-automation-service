package com.github.dylanz666.domain;

import com.github.dylanz666.constant.AllureAttachmentFileExtensionEnum;
import com.github.dylanz666.constant.AllureAttachmentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class AllureAttachment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private AllureAttachmentTypeEnum type;
    private String content;
    private AllureAttachmentFileExtensionEnum fileExtension;
}
