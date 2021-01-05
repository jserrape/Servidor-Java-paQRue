package com.jc.paqrue.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "user_model")
@ApiModel("Model User")
public class User {

	@ApiModelProperty(value = "The user's id", required = true, example = "1")
	private @Id @GeneratedValue Long id;
	
	@ApiModelProperty(value = "Email of the user", required = true, example = "")
	@Column(name = "email", nullable = false, unique = true) 
	private String email;

	@ApiModelProperty(value = "The name of the user", required = true, example = "")
	@Column(name = "nombre", nullable = true, unique = false) 
	private String nombre;
	
	@ApiModelProperty(value = "The password of the user", required = true, example = "")
	@Column(name = "password", nullable = false, unique = false) 
	private String password;
	
	@ApiModelProperty(value = "The rol of the user", required = true, example = "")
	@Column(name = "rol", nullable = false, unique = false) 
	private int rol;
	
	@ApiModelProperty(value = "The url to chenge the password", required = true, example = "")
	@Column(name = "urlpassword", nullable = true, unique = false) 
	private String urlpassword;
	

	public User() {
		super();
	}

	/**
	 * @param id
	 * @param email
	 * @param nombre
	 * @param password
	 * @param rol
	 * @param urlpassword
	 */
	public User(Long id, String email, String nombre, String password, int rol, String urlpassword) {
		super();
		this.id = id;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.rol = rol;
		this.urlpassword = urlpassword;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the rol
	 */
	public int getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(int rol) {
		this.rol = rol;
	}

	/**
	 * @return the urlpassword
	 */
	public String getUrlpassword() {
		return urlpassword;
	}

	/**
	 * @param urlpassword the urlpassword to set
	 */
	public void setUrlpassword(String urlpassword) {
		this.urlpassword = urlpassword;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nombre=" + nombre + ", password=" + password + ", rol=" + rol
				+ ", urlpassword=" + urlpassword + "]";
	}
	
}
