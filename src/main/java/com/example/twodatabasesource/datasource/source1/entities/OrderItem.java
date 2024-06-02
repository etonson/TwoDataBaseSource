
package com.example.twodatabasesource.datasource.source1.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Ramesh Fadatare
 *
 */
@Entity
@Table(name="ORDER_ITEMS")
@Data
public class OrderItem
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String productCode;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private Order order;
}
