package cn.dylanz.autoservice.domain;

import cn.dylanz.autoservice.constant.RequestMethodEnum;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class AllureSteps implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<AllureAttachment> info;
    private RequestMethodEnum method;
    private String url;
    private String requestBody;
    private Response response;
}
