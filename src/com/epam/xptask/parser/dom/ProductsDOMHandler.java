package com.epam.xptask.parser.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.epam.xptask.product.Category;
import com.epam.xptask.product.Good;
import com.epam.xptask.product.Subcategory;

public class ProductsDOMHandler {
	private Element root;

	// XML elements
	private static final String PREFIX = "pr:";
	private static final String CATEGORY_ELEM = PREFIX + "category";
	private static final String SUBCATEGORY_ELEM = PREFIX + "subcategory";
	private static final String GOOD_ELEM = PREFIX + "good";
	private static final String PRODUCER_ELEM = PREFIX + "producer";
	private static final String MODEL_ELEM = PREFIX + "model";
	private static final String DATE_OF_ISSUE_ELEM = PREFIX + "date-of-issue";
	private static final String COLOR_ELEM = PREFIX + "color";
	private static final String PRICE_ELEM = PREFIX + "price";

	private static final String NAME_ATTR = "name";

	public ProductsDOMHandler(Element root) {
		this.root = root;
	}

	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		NodeList categoryNodes = root.getElementsByTagName(CATEGORY_ELEM);
		for (int i = 0; i < categoryNodes.getLength(); i++) {
			Element categoryElem = (Element) categoryNodes.item(i);
			Attr nameAttr = (Attr) categoryElem.getAttributes().getNamedItem(
					NAME_ATTR);
			Category category = new Category(nameAttr.getValue());
			categories.add(category);
			NodeList subcategoryNodes = categoryElem
					.getElementsByTagName(SUBCATEGORY_ELEM);
			for (int j = 0; j < subcategoryNodes.getLength(); j++) {
				Element subcategoryNode = (Element) subcategoryNodes.item(j);
				nameAttr = (Attr) subcategoryNode.getAttributes().getNamedItem(
						NAME_ATTR);
				Subcategory subcategory = new Subcategory(nameAttr.getValue());
				category.addSubcategory(subcategory);
				NodeList goodNodes = subcategoryNode
						.getElementsByTagName(GOOD_ELEM);
				for (int k = 0; k < goodNodes.getLength(); k++) {
					Element goodElem = (Element) goodNodes.item(k);
					Good good = new Good();
					good.setProducer(getChildValue(goodElem, PRODUCER_ELEM));
					good.setModel(getChildValue(goodElem, MODEL_ELEM));
					good.setDateOfIssue(getChildValue(goodElem,
							DATE_OF_ISSUE_ELEM));
					good.setColor(getChildValue(goodElem, COLOR_ELEM));
					setGoodShopingState(good, goodElem);
					subcategory.addGood(good);
				}
			}
		}
		return categories;
	}
	
	private static void processCategoryElement(Element categoryElem) {
		
	}

	private static void setGoodShopingState(Good good, Element goodElem) {
		Element priceElem = getChildByName(goodElem, PRICE_ELEM);
		if (priceElem != null) {
			Node price = priceElem.getFirstChild();
			good.setPrice(Integer.valueOf(price.getNodeValue()));
		} else {
			good.markAsNotInStock();
		}
	}

	private static Element getChildByName(Element parent, String childName) {
		NodeList nodeList = parent.getElementsByTagName(childName);
		return (Element) nodeList.item(0);
	}

	private static String getChildValue(Element parent, String childName) {
		Element child = getChildByName(parent, childName);
		Node text = child.getFirstChild();
		return text.getNodeValue();
	}
}
