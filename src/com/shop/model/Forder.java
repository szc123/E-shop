package com.shop.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Forder entity. @author MyEclipse Persistence Tools
 */

public class Forder implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Status status;
	private String name;
	private String phone;
	private String remark;
	private Date date;
	private Double total;
	private String post;
	private String address;
	private Set<Sorder> sorders = new HashSet<Sorder>();

	// Constructors

	/** default constructor */
	public Forder() {
	}

	/** minimal constructor */
	public Forder(Date date) {
		this.date = date;
	}

	/** full constructor */
	public Forder(User user, Status status, String name, String phone,
			String remark, Date date, Double total, String post,
			String address, Set<Sorder> sorders) {
		this.user = user;
		this.status = status;
		this.name = name;
		this.phone = phone;
		this.remark = remark;
		this.date = date;
		this.total = total;
		this.post = post;
		this.address = address;
		this.sorders = sorders;
	}

	// Property accessors

	public Forder(HashSet<Sorder> sorders) {
		super();
		this.sorders=sorders;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Sorder> getSorders() {
		return this.sorders;
	}

	public void setSorders(Set<Sorder> sorders) {
		this.sorders = sorders;
	}

}