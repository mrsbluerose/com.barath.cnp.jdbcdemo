package com.barath.cnp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barath.cnp.dao.CouponDAO;
import com.barath.cnp.model.Coupon;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/coupons") //creates the url for the html form to be submitted to
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponDAO dao = new CouponDAO();
       
    public CouponController() {
        super(); 
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		if(action.contentEquals("create")) {
			createCoupon(request,response);
		} else if (action.contentEquals("find")) {
			findCoupon(request,response);
		}
	}

	private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("code");
		String discount = request.getParameter("discount");
		String expDate = request.getParameter("expDate");
		
		Coupon coupon = new Coupon();
		coupon.setCode(code);
		coupon.setDiscount(new BigDecimal(discount));
		coupon.setExpDate(expDate);
		
		dao.save(coupon);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Coupon Created!!</b>");
		out.print("<br/><a href='/candpapp'>Home</a>");
	}
	
	public void findCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String couponCode = request.getParameter("code");
		Coupon coupon = dao.findByCode(couponCode);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Coupon Details: </b>");
		out.print(coupon);
		out.print("<br/><a href='/candpapp'>Home</a>");
		
	}

}
