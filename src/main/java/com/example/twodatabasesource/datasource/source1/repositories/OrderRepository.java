/**
 * 
 */
package com.example.twodatabasesource.datasource.source1.repositories;

import com.example.twodatabasesource.datasource.source1.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ramesh Fadatare
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer>{
}
