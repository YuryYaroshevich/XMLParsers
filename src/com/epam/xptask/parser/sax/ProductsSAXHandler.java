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

import static com.epam.xptask.parser.ProductsXMLElement.*;

public class ProductsSAXHandler implements ContentHandler {
	private List<Category> categories;

	private Category currCategory;

	private Subcategory currSubcategory;

	private Good currGood;

	private String currXMLElement;

	private static final String NAME_ATTR = "name";

	public ProductsSAXHandler() {
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

	private void processCategoryElement(Attributes atts) {
		currCategory = new Category(atts.getValue(NAME_ATTR));
		categories.add(currCategory);
	}

	private void processSubcategoryElement(Attributes atts) {
		currSubcategory = new Subcategory(atts.getValue(NAME_ATTR));
		currCategory.addSubcategory(currSubcategory);
	}

	private void processGoodElement() {
		currGood = new Good();
		currSubcategory.addGood(currGood);
	}

	private void processProducerElement() {
		currXMLElement = PRODUCER_ELEM;
	}

	private void processModelElement() {
		currXMLElement = MODEL_ELEM;
	}

	private void processDateOfIssueElement() {
		currXMLElement = DATE_OF_ISSUE_ELEM;
	}

	private void processColorElement() {
		currXMLElement = COLOR_ELEM;
	}

	private void processPriceElement() {
		currXMLElement = PRICE_ELEM;
	}

	private void processNotInStockElement() {
		currGood.markAsNotInStock();
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (currXMLElement == null) {
			return;
		}
		String value = new String(ch, start, length).trim();
		if (PRODUCER_ELEM.equals(currXMLElement)) {
			currGood.setProducer(value);
		} else if (MODEL_ELEM.equals(currXMLElement)) {
			currGood.setModel(value);
		} else if (DATE_OF_ISSUE_ELEM.equals(currXMLElement)) {
			currGood.setDateOfIssue(value);
		} else if (COLOR_ELEM.equals(currXMLElement)) {
			currGood.setColor(value);
		} else if (PRICE_ELEM.equals(currXMLElement)) {
			currGood.setPrice(Integer.valueOf(value));
		}
	}

	public void endElement(String arg0, String arg1, String arg2)
			throws SAXException {
		currXMLElement = null;
	}

	public void endPrefixMapping(String arg0) throws SAXException {
	}

	public void ignorableWhitespace(char[] arg0, int arg1, int arg2)
			throws SAXException {
	}

	public void processingInstruction(String arg0, String arg1)
			throws SAXException {
	}

	public void setDocumentLocator(Locator arg0) {
	}

	public void skippedEntity(String arg0) throws SAXException {
	}

	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {
	}
}
