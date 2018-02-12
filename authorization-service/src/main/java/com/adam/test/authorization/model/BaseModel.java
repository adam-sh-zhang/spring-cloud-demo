package com.adam.test.authorization.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by Adam.Zhang on 2017/8/24.
 */
public class BaseModel {

    @Id
    public String id;
    public Date createdDate = new Date();
    public Date updatedDate = new Date();
}
