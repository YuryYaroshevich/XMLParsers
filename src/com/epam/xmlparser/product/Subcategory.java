package com.epam.xmlparser.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subcategory {
	private List<Good> goods;
	
	public Subcategory() {
		goods = new ArrayList<Good>();
	}
	
	public List<Good> getGoods() {
		return Collections.unmodifiableList(goods);
	}

	@Override
	public String toString() {
		return "Subcategory [goods=" + goods + "]";
	}
}
