package com.epam.xptask.parser.stax;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.epam.xptask.product.Category;
import com.epam.xptask.product.Good;
import com.epam.xptask.product.Subcategory;

import static com.epam.xptask.parser.ProductsXMLElement.*;

public class ProductsStAXHandler {
	private static final String NAME_ATTR = "name";

	// for concatenating prefix and local name of element
	private static final String COLON = ":";

	public List<Category> getCategories(XMLStreamReader reader)
			throws XMLStreamException {
		List<Category> categories = new ArrayList<Category>();
		Category category = null;
		Subcategory subcategory = null;
		Good good = null;
		// this variable will contain part of document where reader read during
		// the current iteration
		int readerLocation;
		String elementName;
		while (reader.hasNext()) {
			readerLocation = reader.next();
			if (readerLocation == XMLStreamConstants.START_ELEMENT) {
				elementName = reader.getPrefix() + COLON
						+ reader.getLocalName();
				if (isCategoryElement(elementName)) {
					category = buildCategory(reader);
					categories.add(category);
				} else if (isSubcategoryElement(elementName)) {
					subcategory = buildSubcategory(reader);
					category.addSubcategory(subcategory);
				} else if (isGoodElement(elementName)) {
					good = new Good();
					subcategory.addGood(good);
				} else if (isProducerElement(elementName)) {
					good.setProducer(reader.getElementText());
				} else if (isModelElement(elementName)) {
					good.setModel(reader.getElementText());
				} else if (isDateOfIssueElement(elementName)) {
					good.setDateOfIssue(reader.getElementText());
				} else if (isColorElement(elementName)) {
					good.setColor(reader.getElementText());
				} else if (isPriceElement(elementName)) {
					good.setPrice(Integer.valueOf(reader.getElementText()));
				} else if (isNotInStockElement(elementName)) {
					good.markAsNotInStock();
				}
			}
		}
		return categories;
	}

	private static Category buildCategory(XMLStreamReader reader) {
		return new Category(reader.getAttributeValue(null, NAME_ATTR));
	}

	private static Subcategory buildSubcategory(XMLStreamReader reader) {
		return new Subcategory(reader.getAttributeValue(null, NAME_ATTR));
	}
}
