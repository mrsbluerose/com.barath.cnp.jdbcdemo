package com.barath.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.barath.cnp.model.Coupon;
import com.barath.cnp.model.Product;
import com.barath.cnp.util.ConnectionUtil;

public class ProductDAO {

	public void save(Product product) {
		Connection connection;
		try {
			connection = ConnectionUtil.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO product (name,description,price) values(?,?,?)");
			statement.setString(1,  product.getName());
			statement.setString(2, product.getDescription());
			statement.setBigDecimal(3,  product.getPrice());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
