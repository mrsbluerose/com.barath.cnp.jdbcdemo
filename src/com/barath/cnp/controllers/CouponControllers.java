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
 * Servlet implementation class CouponControllers
 */
@WebServlet("/coupons")
public class CouponControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponDAO dao = new CouponDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CouponControllers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String couponCode = request.getParameter("couponCode");
		String discount = request.getParameter("discount");
		String expDate = request.getParameter("expDate");
		
		Coupon coupon = new Coupon();
		coupon.setCode(couponCode);
		coupon.setDiscount(new BigDecimal(discount));
		coupon.setExpDate(expDate);
		
		dao.save(coupon);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Product Created!!</b>");
		out.print("<br/><a href='/candpapp'>Home</a>");
	}

}
