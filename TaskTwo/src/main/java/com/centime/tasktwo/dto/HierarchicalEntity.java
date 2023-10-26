package com.centime.tasktwo.dto;

import java.util.List;

public class HierarchicalEntity {
	private Long id;
	private Long parentId;
	private String name;
	private String color;
	private List<HierarchicalEntity> children;

	public HierarchicalEntity() {
		// Default constructor
	}

	public HierarchicalEntity(Long id, Long parentId, String name, String color) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public List<HierarchicalEntity> getChildren() {
		return children;
	}

	public void setChildren(List<HierarchicalEntity> children) {
		this.children = children;
	}
}
