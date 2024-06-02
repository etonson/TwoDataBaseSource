/**
 * 
 */
package com.example.twodatabasesource.datasource.source2.entities;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Ramesh Fadatare
 *
 */
@Entity
@Table(name="USERS")
@Data
public class User
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false, unique=true)

	private String email;
	private boolean disabled;
	@OneToMany(mappedBy="user")
	private Set<Address> addresses;
	
	public User()
	{
	}

	public User(Integer id, String name, String email)
	{
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public User(Integer id, String name, String email, boolean disabled)
	{
		this.id = id;
		this.name = name;
		this.email = email;
		this.disabled = disabled;
	}
}
