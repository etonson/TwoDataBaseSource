/**
 * 
 */
package com.example.twodatabasesource.datasource.source1.entities;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Ramesh Fadatare
 *
 */
@Entity
@Table(name="ORDERS")
@Data
public class Order
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="CUST_NAME")
	private String customerName;
	@Column(name="CUST_EMAIL")
	private String customerEmail;

}
