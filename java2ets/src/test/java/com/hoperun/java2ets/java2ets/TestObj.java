package com.hoperun.java2ets.java2ets;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class TestObj implements Serializable {

    private String value1;
    private String value2;
    private ArrayList<String> value3;
    
}
