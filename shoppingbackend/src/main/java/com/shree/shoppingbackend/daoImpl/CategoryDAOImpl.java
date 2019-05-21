package com.shree.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shree.shoppingbackend.dao.CategoryDAO;
import com.shree.shoppingbackend.dto.Category;

@Repository("objCategory")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

/*	private static List<Category> categories = new ArrayList<Category>();

	static {
		Category category = new Category();
		category.setId(0);
		category.setName("Television");
		categories.add(category);

		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		categories.add(category);

		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		categories.add(category);

		category = new Category();
		category.setId(4);
		category.setName("Desktop");
		categories.add(category);
	}
*/
	

	@Override
	public boolean addCategory(Category category) {
		try {

			// add Category object to Database table
			Session ses = sessionFactory.getCurrentSession();
			ses.persist(category);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}

	}
	
	/*
	 * Getting single category based on category id
	 * */
	@Override
	public Category get(int id) {
		Session ses = sessionFactory.getCurrentSession();
		Category category = ses.get(Category.class, Integer.valueOf(id));
		return category;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Category> listCategory() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active ORDER BY name";
		Session ses = sessionFactory.getCurrentSession();
		
		
		Query<Category> query = ses.createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		List<Category> listCategory = query.getResultList();
		return listCategory;
	}

	/*
	 * Update single category in the table
	 * */
	@Override
	public boolean updateCategory(Category category) {
		try {
			// update Category object to Database table
			Session ses = sessionFactory.getCurrentSession();
			ses.update(category);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		category.setActive(false);
		try {
			// add Category object to Database table
			Session ses = sessionFactory.getCurrentSession();
			ses.update(category);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}
	}

}
