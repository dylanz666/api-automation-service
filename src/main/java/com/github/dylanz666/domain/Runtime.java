package com.github.dylanz666.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author : dylanz
 * @since : 08/18/2020
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Runtime implements Serializable {
    private static final long serialVersionUID = 1L;

    private String env;
}
