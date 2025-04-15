package com.pharmacy.dao;

import java.sql.SQLException;
import java.util.List;

import com.pharmacy.model.Medicine;

public interface MedicineDao {
	public void connect() throws SQLException;
	public void createMedicine(Medicine m) throws SQLException;
	public List<Medicine> showMedicines() throws SQLException;
	public void upMedicine(Medicine m) throws SQLException;
	public void delMedicine(int id) throws SQLException;
	public Medicine getMedicineByid(int id) throws SQLException;
	public String GetMedicineName(int id) throws SQLException;
}
