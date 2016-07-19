package com.domain.model;

import lombok.Data;
import java.io.Serializable;

/**
 * Created by wujianwei on 16/7/19.
 *
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String name;

    private  String password;

    private Integer loginTimes;
}
