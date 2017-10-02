package career.parascollectionbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import career.parascollectionbackend.dao.CategoryDao;
import career.parascollectionbackend.dto.Category;

@Transactional
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{
@Autowired
SessionFactory sessionFactory;
 
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}

	@Override
	public List<Category> list() {
		String selectquery="from Category where active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectquery);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public boolean add(Category category) {
try {
	sessionFactory.getCurrentSession().persist(category);
	return true;
} catch (Exception e) {
	return false;
}
		
	}

	@Override
	public boolean update(Category category) {
	 try {
		 sessionFactory.getCurrentSession().update(category);
		return true;
	} catch (Exception e) {
		return false;
	}
		
	}

	@Override
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
