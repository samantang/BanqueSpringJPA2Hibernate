package com.saliou.banque.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Role implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRole;
	private String roleName;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user_id;
	
	
	
	/**
	 * @return the idRole
	 */
	public Long getIdRole() {
		return idRole;
	}
	/**
	 * @param idRole the idRole to set
	 */
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * 
	 */
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param roleName
	 */
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	
	
	/**
	 * @param roleName
	 * @param user_id
	 */
	public Role(String roleName, User user_id) {
		super();
		this.roleName = roleName;
		this.user_id = user_id;
	}
	
	
}

