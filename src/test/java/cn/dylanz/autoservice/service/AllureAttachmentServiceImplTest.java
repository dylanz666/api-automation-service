package cn.dylanz.autoservice.service;

import cn.dylanz.autoservice.constant.AllureAttachmentFileExtensionEnum;
import cn.dylanz.autoservice.constant.AllureAttachmentTypeEnum;
import cn.dylanz.autoservice.domain.AllureAttachment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : dylanz
 * @since : 08/06/2020
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AllureAttachmentServiceImplTest {
    @Autowired
    private AllureAttachmentServiceImpl allureAttachmentService;

    @Test
    public void testAddAttachment_typeIsTextPlain() {
        AllureAttachment allureAttachment = new AllureAttachment();
        allureAttachment.setName("test");
        allureAttachment.setType(AllureAttachmentTypeEnum.TEXT_PLAIN);
        allureAttachment.setContent("test 1");
        allureAttachment.setFileExtension(AllureAttachmentFileExtensionEnum.TXT);

        Boolean result = allureAttachmentService.addAttachment(allureAttachment);

        Assert.assertTrue(result);
    }

    @Test
    public void testAddAttachment_typeIsApplicationJson() {
        AllureAttachment allureAttachment = new AllureAttachment();
        allureAttachment.setName("test");
        allureAttachment.setType(AllureAttachmentTypeEnum.APPLICATION_JSON);
        allureAttachment.setContent("test 1");
        allureAttachment.setFileExtension(AllureAttachmentFileExtensionEnum.TXT);

        Boolean result = allureAttachmentService.addAttachment(allureAttachment);

        Assert.assertTrue(result);
    }

    @Test
    public void testAddAttachment_typeIsImagePng() {
        AllureAttachment allureAttachment = new AllureAttachment();
        allureAttachment.setName("test");
        allureAttachment.setType(AllureAttachmentTypeEnum.IMAGE_PNG);
        allureAttachment.setContent("test 1");
        allureAttachment.setFileExtension(AllureAttachmentFileExtensionEnum.PNG);

        Boolean result = allureAttachmentService.addAttachment(allureAttachment);

        Assert.assertTrue(result);
    }

    @Test
    public void testAddAttachment_fileIsJson() {
        AllureAttachment allureAttachment = new AllureAttachment();
        allureAttachment.setName("test");
        allureAttachment.setType(AllureAttachmentTypeEnum.APPLICATION_JSON);
        allureAttachment.setContent("test 1");
        allureAttachment.setFileExtension(AllureAttachmentFileExtensionEnum.JSON);

        Boolean result = allureAttachmentService.addAttachment(allureAttachment);

        Assert.assertTrue(result);
    }

    @Test
    public void testAddAttachment_nullAttachment() {
        AllureAttachment allureAttachment = new AllureAttachment();

        Boolean result = allureAttachmentService.addAttachment(allureAttachment);

        Assert.assertFalse(result);
    }
}
