package com.shop.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */
//����Ա�ĳ־û���
public class Account implements java.io.Serializable {

	// Fields

	private Integer id;
	private String login;
	private String name;
	private String pass;
	private Set<Category> categories = new HashSet<Category>(0);

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(String login, String name, String pass, Set<Category> categories) {
		this.login = login;
		this.name = name;
		this.pass = pass;
		this.categories = categories;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	//@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="account")
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}