package com.epam.xptask.parser;

import java.util.List;

import com.epam.xptask.parser.exception.ParserLogicalException;
import com.epam.xptask.parser.exception.ParserTechnicalException;
import com.epam.xptask.product.Category;

public interface ProductsXMLParser {
	List<Category> parse(String xml) throws ParserLogicalException,
			ParserTechnicalException;
}
