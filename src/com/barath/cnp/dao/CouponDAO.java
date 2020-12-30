package com.barath.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.barath.cnp.model.Coupon;
import com.barath.cnp.util.ConnectionUtil;

public class CouponDAO {

	public void save(Coupon coupon) {
		Connection connection;
		try {
			connection = ConnectionUtil.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO coupon (code,discount,exp_date) values(?,?,?)");
			statement.setString(1, coupon.getCode());
			statement.setBigDecimal(2, coupon.getDiscount());
			statement.setString(3, coupon.getExpDate());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public Coupon findByCode(String code) {
		Coupon coupon = new Coupon();
		Connection connection;
		try {
			connection = ConnectionUtil.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM coupon WHERE code=?");
			statement.setString(1, code);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				coupon.setId(resultSet.getInt(1));
				coupon.setCode(resultSet.getString(2));
				coupon.setDiscount(resultSet.getBigDecimal(3));
				coupon.setExpDate(resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return coupon;
	}
}
