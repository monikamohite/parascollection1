package career.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import career.parascollectionbackend1.dao.CategoryDao;
import career.parascollectionbackend1.dto.Category;

@Controller
public class Parascontroller {
	@Autowired
	CategoryDao categoryDao;
@RequestMapping(value= {"/","/parascollection/","parascollection/"})
public ModelAndView index()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","Home");
	mv.addObject("categories", categoryDao.list());
	mv.addObject("userClickHome",true);
	return mv;
}

@RequestMapping("/about")
public ModelAndView about()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","About");
	mv.addObject("userClickAbout",true);
	return mv;
}

@RequestMapping("/contact")
public ModelAndView contact()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title","Contact");
	mv.addObject("userClickContact",true);
	return mv;
}


@RequestMapping(value="/show/all/products")
public ModelAndView showAllProducts()
{
ModelAndView mv=new ModelAndView("page");
mv.addObject("title", "All Products");
mv.addObject("categories", categoryDao.list());
mv.addObject("userClickAllProducts",true);
return mv;
}
@RequestMapping(value="/show/category/{id}/products")
public ModelAndView showCategoryProducts(@PathVariable("id")int id)
{
//CategoryDAO to fetch single category
Category category=null;
category=categoryDao.get(id);
ModelAndView mv=new ModelAndView("page");
mv.addObject("title",category.getName());
//passing the all category
mv.addObject("categories", categoryDao.list());
//passing the single category.
mv.addObject("category", category);
mv.addObject("userClickCategoryProducts",true);
return mv;
}
}
