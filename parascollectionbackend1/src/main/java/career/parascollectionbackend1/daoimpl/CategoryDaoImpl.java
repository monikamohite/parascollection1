package career.parascollectionbackend1.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import career.parascollectionbackend1.dao.CategoryDao;
import career.parascollectionbackend1.dto.Category;

@Transactional
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{
@Autowired
SessionFactory sessionFactory;

public Category get(int id) {
	// TODO Auto-generated method stub
	return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));

}

public List<Category> list() {
	String selectquery="from Category where active=:active";
	Query query=sessionFactory.getCurrentSession().createQuery(selectquery);
	query.setParameter("active", true);
	return query.getResultList();
}

public boolean add(Category category) {
	try {
		sessionFactory.getCurrentSession().persist(category);
		return true;
	} catch (Exception e) {
		return false;
	}
}

public boolean update(Category category) {
	 try {
		 sessionFactory.getCurrentSession().update(category);
		return true;
	} catch (Exception e) {
		return false;
	}
}

public boolean delete(Category category) {
	category.setActive(false);
	try {
		sessionFactory.getCurrentSession().update(category);
		return true;
	} catch (Exception e) {
    return false;
	}
}

		
	

}
