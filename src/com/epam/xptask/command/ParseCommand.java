package com.epam.xptask.command;

import static com.epam.xptask.pagegetter.PageGetter.PRODUCTS_PAGE;
import static com.epam.xptask.pagegetter.PageGetter.getPage;

import javax.servlet.http.HttpServletRequest;

import com.epam.xptask.product.Category;
import com.epam.xptask.product.Good;
import com.epam.xptask.product.Subcategory;

public class ParseCommand implements ICommand {
	private static final String PARSER_PARAM = "parser";
	
	public String execute(HttpServletRequest request) {
		String parser = request.getParameter(PARSER_PARAM);
		/*String producer, String model, String dateOfIssue,
			String color, int price*/
		Good g1 = new Good("producer1", "model1", "12/12/1121","green", 232);
		Good g2 = new Good("producer2", "model2", "12/12/1121","green", 232);
		Good g3 = new Good("producer3", "model3", "12/12/1121","green", 232);
		Good g4 = new Good("producer4", "model4", "12/12/1121","green", 232);
		Good g5 = new Good("producer5", "model5", "12/12/1121","green", 232);
		Good g6 = new Good("producer6", "model6", "12/12/1121","green", 232);
		Subcategory s1 = new Subcategory("subcat1");
		s1.addGood(g1);
		s1.addGood(g2);
		Subcategory s2 = new Subcategory("subcat2");
		s2.addGood(g3);
		s2.addGood(g4);
		s2.addGood(g5);
		Subcategory s3 = new Subcategory("subcat3");
		s3.addGood(g6);
		Category c1 = new Category("categ1");
		c1.addSubcategory(s1);
		c1.addSubcategory(s2);
		Category c2 = new Category("categ2");
		c2.addSubcategory(s3);		
		return getPage(PRODUCTS_PAGE);
	}
}
