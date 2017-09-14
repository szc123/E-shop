package com.shop.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Status entity. @author MyEclipse Persistence Tools
 */

public class Status implements java.io.Serializable {

	// Fields

	private Integer id;
	private String status;
	private Set forders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Status() {
	}

	/** full constructor */
	public Status(String status, Set forders) {
		this.status = status;
		this.forders = forders;
	}

	// Property accessors

	public Status(Integer id) {
		// TODO Auto-generated constructor stub
		this.id=id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getForders() {
		return this.forders;
	}

	public void setForders(Set forders) {
		this.forders = forders;
	}

}