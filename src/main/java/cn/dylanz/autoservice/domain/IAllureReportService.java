package cn.dylanz.autoservice.domain;

import org.springframework.stereotype.Service;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
@Service
public interface IAllureReportService<T> {
    Boolean addSteps(T AllureSteps);
}
