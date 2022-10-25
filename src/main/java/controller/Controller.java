package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans product = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// dao.testeConexao();
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			productos(request, response);
		} else if (action.equals("/select")) {
			listProduct(request, response);
		} else if (action.equals("/delete")) {
			deleteProduct(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/insert")) {
			insertProduct(request, response);
		} else if (action.equals("/update")) {
			editProduct(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	protected void productos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> list = dao.listProducts();
		request.setAttribute("productos", list);
		RequestDispatcher rd = request.getRequestDispatcher("carrinho.jsp");
		rd.forward(request, response);

	}

	protected void insertProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		product.setIdProd(request.getParameter("idProd"));
		product.setNomeProd(request.getParameter("nomeProd"));
		product.setValorProd(request.getParameter("valor"));
		product.setQuantidade(request.getParameter("quantidade"));
		product.setTotal(request.getParameter("total"));

		dao.insertContact(product);

		response.sendRedirect("main");

	}

	// editar produtos
	protected void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id do produto que será editado
		String idProd = request.getParameter("idProd");
		// setar variável JavaBeans
		product.setIdProd(idProd);

		dao.selectProduct(product);

		request.setAttribute("idProd", product.getIdProd());
		request.setAttribute("nomeProd", product.getNomeProd());
		request.setAttribute("valor", product.getValorProd());
		request.setAttribute("quantidade", product.getQuantidade());
		request.setAttribute("total", product.getTotal());
		// encaminha ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	protected void editProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setar as variaveis JavBeans
		product.setIdProd(request.getParameter("idProd"));
		product.setNomeProd(request.getParameter("nomeProd"));
		product.setValorProd(request.getParameter("valor"));
		product.setQuantidade(request.getParameter("quantidade"));
		product.setTotal(request.getParameter("total"));

		dao.updateProduct(product);
		// redireciona para metodo carrinho.jsp
		response.sendRedirect("main");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idProd = request.getParameter("idProd");
		product.setIdProd(idProd);
		dao.deleteProduct(product);
		response.sendRedirect("main");
	}

}
