package com.epam.xmlparser.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category {
	private List<Subcategory> subcategories;
	
	public Category() {
		subcategories = new ArrayList<Subcategory>();
	}
	
	public List<Subcategory> getSubcategories() {
		return Collections.unmodifiableList(subcategories);
	}

	@Override
	public String toString() {
		return "Category [subcategories=" + subcategories + "]";
	}
}
