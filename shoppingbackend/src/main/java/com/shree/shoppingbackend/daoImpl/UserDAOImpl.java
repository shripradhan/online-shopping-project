package com.shree.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shree.shoppingbackend.dao.UserDAO;
import com.shree.shoppingbackend.dto.Address;
import com.shree.shoppingbackend.dto.Cart;
import com.shree.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User objUser) {
		try {
			sessionFactory.getCurrentSession().persist(objUser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean addAddress(Address objAddress) {
		try {
			sessionFactory.getCurrentSession().persist(objAddress);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart objCart) {
		try {
			sessionFactory.getCurrentSession().update(objCart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User findUserByEmail(String email) {
		String selectQuery = "FROM User where email = :email";
		try {
			
			return sessionFactory.getCurrentSession().createQuery(selectQuery, User.class).setParameter("email", email).getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		String sqlQuery = "FROM Address WHERE user = :user AND billing = :billing";
		try {
			
			return sessionFactory.getCurrentSession()
						.createQuery(sqlQuery,Address.class)
						.setParameter("user", user)
						.setParameter("billing", true).getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddress(User user) {
		String sqlQuery = "FROM Address WHERE user = :user AND shipping = :shipping";
		try {
			
			return sessionFactory.getCurrentSession()
						.createQuery(sqlQuery,Address.class)
						.setParameter("user", user)
						.setParameter("shipping", true).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addCart(Cart objCart) {
		try {
			sessionFactory.getCurrentSession().persist(objCart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*@Override
	public boolean deleteUser(User objUser) {
		try {
			sessionFactory.getCurrentSession().delete(objUser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}*/

}
