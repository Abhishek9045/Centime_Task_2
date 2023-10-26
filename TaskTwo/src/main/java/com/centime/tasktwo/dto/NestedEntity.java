package com.centime.tasktwo.dto;

import java.util.List;

public class NestedEntity {
	private String name;
	private String color;
	private List<NestedEntity> subClasses;
	
	public NestedEntity() {}

	public NestedEntity(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public void setSubClasses(List<NestedEntity> subClasses) {
		this.subClasses = subClasses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<NestedEntity> getSubClasses() {
		return subClasses;
	}
}
