package com.pharmacy.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.pharmacy.model.Medicine;

public class MedicineDaoImpl implements MedicineDao{
	Connection conn;

	@Override
	public void createMedicine(Medicine m) throws SQLException {
		String sql = "INSERT INTO MEDICINES VALUES(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, m.getId());
		pstmt.setString(2, m.getName());
		pstmt.setBigDecimal(3, m.getPrice());
		pstmt.setInt(4, m.getQuantity());
		int count = pstmt.executeUpdate();
		System.out.println(count+" row has been inserted sucessfully");
		conn.close();
		pstmt.close();
	}

	@Override
	public List<Medicine> showMedicines() throws SQLException {
		List<Medicine> Med = new ArrayList<>();
		String sql = "SELECT * FROM MEDICINES";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			Med.add(new Medicine(rs.getInt(1), rs.getString(2), rs.getBigDecimal(3), rs.getInt(4)));
		}
		conn.close();
		st.close();
		rs.close();
		return Med;
	}

	@Override
	public void upMedicine(Medicine m) throws SQLException {
		String sql = "UPDATE MEDICINES SET NAME = ?, PRICE = ?, QUANTITY =? WHERE ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m.getName());
		pstmt.setBigDecimal(2, m.getPrice());
		pstmt.setInt(3, m.getQuantity());
		pstmt.setInt(4, m.getId());
		int count = pstmt.executeUpdate();
		System.out.println(count+" row(s) has been Updated sucessfully");
		conn.close();
		pstmt.close();
	}

	
	@Override
	public void delMedicine(int id) throws SQLException {
		String sql = "DELETE FROM MEDICINES WHERE ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		int count = pstmt.executeUpdate();
		System.out.println(count + " row(s) deleted successfully ");
		conn.close();
		pstmt.close();
	}

	@Override
	public void connect() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/PharmacyDB";
		String user = "root";
		String pwd = "#Tiwari0101";
		conn = DriverManager.getConnection(url, user, pwd);
		
	}

	@Override
	public Medicine getMedicineByid(int id) throws SQLException {
		String sql = "SELECT * FROM MEDICINES WHERE ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		Medicine med = null;
		if (rs.next()) {
			med = new Medicine(rs.getInt("id"), rs.getString("name"), rs.getBigDecimal("price"),
					rs.getInt("quantity"));
		}
		conn.close();
		pstmt.close();
		rs.close();
		return med;
	}

	@Override
	public String GetMedicineName(int id) throws SQLException {
		String med;
		String sql = "{call getMedicineName(?,?)}";
		CallableStatement cst = conn.prepareCall(sql);
		cst.setInt(1,id);
		cst.registerOutParameter(2, Types.VARCHAR);
		cst.execute();
		med = cst.getString(2);
		cst.close();
		return med;
	}

	@Override
	public List<Medicine> showAllMedicines() throws SQLException {
		
		throw new UnsupportedOperationException("Unimplemented method 'showAllMedicines'");
	}

}
