package it.gameshub.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ButtonLogoutControl")
public class ButtonLogoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ButtonLogoutControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("isGestoreCatalogo");
		request.getSession().removeAttribute("isGestoreOrdini");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Homepage.jsp");
		dispatcher.forward(request, response);

	}

	// Nel caso si utilizza post la servelt funzionerà ugualmente
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response); // Richiama la doGet
	}

}