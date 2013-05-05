package com.epam.xptask.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.xptask.command.ICommand;
import com.epam.xptask.command.creator.CommandCreator;
import com.epam.xptask.exception.XPLogicalException;
import com.epam.xptask.exception.XPTechnicalException;

public class ParserController extends HttpServlet {
	private static final long serialVersionUID = 7688907932488576018L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ICommand command = CommandCreator.createCommand(request);
		String page;
		try {
			page = command.execute(request);
		} catch (XPTechnicalException e) {
			e.printStackTrace();
			throw new ServletException(e);
		} catch (XPLogicalException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}
