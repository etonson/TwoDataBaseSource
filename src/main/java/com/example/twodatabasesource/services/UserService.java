
package com.example.twodatabasesource.services;


import com.example.twodatabasesource.datasource.source2.entities.User;
import com.example.twodatabasesource.datasource.source2.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author Ramesh Fadatare
 *
 */
@Service
@Transactional(transactionManager="dataSource2TransactionManager")
public class UserService
{
	@PersistenceContext(unitName = "dataSource2EntityManagerFactory")
	private EntityManager em;
	@Autowired
	private UserRepository userRepository;

    public void  persistUsers(User user)
	{
		userRepository.save(user);
	}
	public void  persistUsers2(User user){
		em.persist(user);
	}
}
