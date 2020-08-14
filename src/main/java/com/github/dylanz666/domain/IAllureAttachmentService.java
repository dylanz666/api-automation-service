package com.github.dylanz666.domain;

import org.springframework.stereotype.Service;

/**
 * @author : dylanz
 * @since : 08/06/2020
 **/
@Service
public interface IAllureAttachmentService<T> {
    Boolean addAttachment(T AllureAttachment);
}
