
package com.example.twodatabasesource.datasource.source2.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Ramesh Fadatare
 *
 */
@Entity
@Table(name="ADDRESSES")
@Data
public class Address
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column
	private String city;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
}
