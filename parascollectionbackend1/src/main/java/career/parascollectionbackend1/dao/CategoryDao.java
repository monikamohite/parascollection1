package career.parascollectionbackend1.dao;

import java.util.List;

import career.parascollectionbackend1.dto.Category;

public interface CategoryDao {
	
		public Category get(int id);
		public List<Category> list();
		boolean add(Category category);
		boolean update(Category category);
		boolean delete(Category category);
}
