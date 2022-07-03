package com.xadmin.mockup.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.xadmin.mockup.bean.Biodata;
import com.xadmin.mockup.dao.BioDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class BioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private BioDao userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		userDao = new BioDao();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBio(request, response);
				break;
			case "/delete":
				deleteBio(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBio(request, response);
				break;
			case "/list":
				listBio(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("bio-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	//Insert Bio
	private void insertBio(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, SQLException {
		String nama = request.getParameter("nama");
		String posisi = request.getParameter("posisi");
		String noktp = request.getParameter("noktp");
		String ttl = request.getParameter("ttl");
		String gender = request.getParameter("gender");
		String agama = request.getParameter("agama");
		String golDarah = request.getParameter("golDarah");
		String status = request.getParameter("status");
		String alamatKtp = request.getParameter("alamatKtp");
		String alamatTinggal = request.getParameter("alamatTinggal");
		String email = request.getParameter("email");
		String nohp = request.getParameter("nohp");
		String orgTerdekat = request.getParameter("orgTerdekat");
		String userId = request.getParameter("userId");
		 
		Biodata newBio = new Biodata(userId, nama, posisi, noktp, ttl, gender, agama, golDarah, status, alamatKtp, alamatTinggal, email, nohp, orgTerdekat);
		
		userDao.insertBio(newBio);
		response.sendRedirect("list");
	}
	
	
	// Delete Bio
	private void deleteBio(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt("id");
		try {
			userDao.deleteBio(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	
	// Show Edit Bio
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException,IOException,ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		Biodata currBio;
		try {
			currBio = userDao.selectBiodata(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("bio-form.jsp");
			request.setAttribute("user", currBio);
			dispatcher.forward(	request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	// Upadate Bio
	private void updateBio(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt("id");
		String nama = request.getParameter("nama");
		String posisi = request.getParameter("posisi");
		String noktp = request.getParameter("noktp");
		String ttl = request.getParameter("ttl");
		String gender = request.getParameter("gender");
		String agama = request.getParameter("agama");
		String golDarah = request.getParameter("golDarah");
		String status = request.getParameter("status");
		String alamatKtp = request.getParameter("alamatKtp");
		String alamatTinggal = request.getParameter("alamatTinggal");
		String email = request.getParameter("email");
		String nohp = request.getParameter("nohp");
		String orgTerdekat = request.getParameter("orgTerdekat");
		String userId = request.getParameter("userId");
		
		Biodata chBio = new Biodata(userId, nama, posisi, noktp, ttl, gender, agama, golDarah, status, alamatKtp, alamatTinggal, email, nohp, orgTerdekat);
		userDao.updateBio(chBio);
		response.sendRedirect("list");
	}
	
	private void listBio(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		try {
			List<Biodata> bioList = userDao.selectAll();
			request.setAttribute("listBio",bioList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("bio-list.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



}
