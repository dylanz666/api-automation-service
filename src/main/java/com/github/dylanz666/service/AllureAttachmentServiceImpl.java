package com.github.dylanz666.service;

import com.github.dylanz666.domain.AllureAttachment;
import com.github.dylanz666.domain.IAllureAttachmentService;
import io.qameta.allure.Allure;
import org.springframework.stereotype.Service;

/**
 * @author : dylanz
 * @since : 08/06/2020
 **/
@Service
public class AllureAttachmentServiceImpl implements IAllureAttachmentService<AllureAttachment> {
    @Override
    public Boolean addAttachment(AllureAttachment allureAttachment) {
        try {
            String name = allureAttachment.getName();
            String type = allureAttachment.getType() == null ? null : allureAttachment.getType().toString();
            String content = allureAttachment.getContent();
            String fileExtension = allureAttachment.getFileExtension() == null ? null : allureAttachment.getFileExtension().toString();

            Allure.addAttachment(name, type, content, fileExtension);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
