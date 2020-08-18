package com.github.dylanz666.domain;

import org.springframework.stereotype.Service;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
@Service
public interface IAllureStepsService<T> {
    Boolean addSteps(T AllureSteps);
}
