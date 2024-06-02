/**
 * 
 */
package com.example.twodatabasesource.datasource.source2.repositories;

import com.example.twodatabasesource.datasource.source2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Ramesh Fadatare
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

}

