package com.iquantex.mftp.bean;

import java.io.Serializable;
import java.util.List;

public class Bean1 implements Serializable{
    private String name;

    private List<Bean2> value;

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(List<Bean2> value) {
        this.value = value;
    }

	public String getName() {
		return name;
	}

	public List<Bean2> getValue() {
		return value;
	}
    
    
}







