package com.epam.xptask.parser.sax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import com.epam.xptask.product.Category;
import com.epam.xptask.product.Good;
import com.epam.xptask.product.Subcategory;

public class SAXHandler implements ContentHandler {
	private List<Category> categories;

	private Category currCategory;

	private List<Subcategory> currSubcategories;

	private Subcategory currSubcategory;

	private Good currGood;
	
	private ProductsXMLElement currXMLElement;

	private static final String CATEGORY_ELEM = "pr:category";
	private static final String SUBCATEGORY_ELEM = "pr:subcategory";
	private static final String GOOD_ELEM = "pr:good";
	private static final String PRODUCER_ELEM = "pr:producer";
	private static final String MODEL_ELEM = "pr:model";
	private static final String DATE_OF_ISSUE_ELEM = "pr:date-of-issue";
	private static final String COLOR_ELEM = "pr:color";
	private static final String PRICE_ELEM = "pr:price";
	private static final String NOT_IN_STOCK_ELEM = "pr:not-in-stock";

	private static final String NAME_ATTR = "name";

	public SAXHandler() {
		super();
		categories = new ArrayList<Category>();
	}

	public List<Category> getCategories() {
		return Collections.unmodifiableList(categories);
	}

	public void startDocument() throws SAXException {
	}

	public void endDocument() throws SAXException {
	}

	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		if (isCategoryElement(qName)) {
			processCategoryElement(atts);
		} else if (isSubcategoryElement(qName)) {
			processSubcategoryElement(atts);
		} else if (isGoodElement(qName)) {
			processGoodElement();
		} else if (isProducerElement(qName)) {
			processProducerElement();
		} else if (isModelElement(qName)) {
			processModelElement();
		} else if (isDateOfIssueElement(qName)) {
			processDateOfIssueElement();
		} else if (isColorElement(qName)) {
			processColorElement();
		} else if (isPriceElement(qName)) {
			processPriceElement();
		} else if (isNotInStockElement(qName)) {
			processNotInStockElement();
		}
	}

	private boolean isCategoryElement(String qName) {
		return CATEGORY_ELEM.equals(qName);
	}

	private void processCategoryElement(Attributes atts) {
		currCategory = new Category(atts.getValue(NAME_ATTR));
		categories.add(currCategory);
	}

	private boolean isSubcategoryElement(String qName) {
		return SUBCATEGORY_ELEM.equals(qName);
	}

	private void processSubcategoryElement(Attributes atts) {
		currSubcategory = new Subcategory(atts.getValue(NAME_ATTR));
		currCategory.addSubcategory(currSubcategory);
	}

	private boolean isGoodElement(String qName) {
		return GOOD_ELEM.equals(qName);
	}

	private void processGoodElement() {
		currGood = new Good();
		currSubcategory.addGood(currGood);
	}

	private boolean isProducerElement(String qName) {
		return PRODUCER_ELEM.equals(qName);
	}

	private void processProducerElement() {
		currXMLElement = ProductsXMLElement.PRODUCER;
	}

	private boolean isModelElement(String qName) {
		return MODEL_ELEM.equals(qName);
	}

	private void processModelElement() {
		currXMLElement = ProductsXMLElement.MODEL;
	}

	private boolean isDateOfIssueElement(String qName) {
		return DATE_OF_ISSUE_ELEM.equals(qName);
	}

	private void processDateOfIssueElement() {
		currXMLElement = ProductsXMLElement.DATE_OF_ISSUE;
	}

	private boolean isColorElement(String qName) {
		return COLOR_ELEM.equals(qName);
	}

	private void processColorElement() {
		currXMLElement = ProductsXMLElement.COLOR;
	}

	private boolean isPriceElement(String qName) {
		return PRICE_ELEM.equals(qName);
	}

	private void processPriceElement() {
		currXMLElement = ProductsXMLElement.PRICE;
	}

	private boolean isNotInStockElement(String qName) {
		return NOT_IN_STOCK_ELEM.equals(qName);
	}

	private void processNotInStockElement() {
		currXMLElement = ProductsXMLElement.NOT_IN_STOCK;
	}

	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {

	}

	public void endElement(String arg0, String arg1, String arg2)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	public void endPrefixMapping(String arg0) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void ignorableWhitespace(char[] arg0, int arg1, int arg2)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	public void processingInstruction(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	public void setDocumentLocator(Locator arg0) {
		// TODO Auto-generated method stub

	}

	public void skippedEntity(String arg0) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub

	}
}
