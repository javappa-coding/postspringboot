package com.javappa.postspringboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item extends AbstractEntity<Long> {

	@Column(length = 255)
	private String name;

	@Column(length = 4000)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}