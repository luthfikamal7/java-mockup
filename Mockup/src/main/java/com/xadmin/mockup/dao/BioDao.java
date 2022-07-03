package com.xadmin.mockup.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.mockup.bean.Biodata;


public class BioDao {
	private String jdbcURL = "jdbc:mysql://localhost:3360/userdb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static final String INSERT_BIO_SQL = "INSERT INTO biodata" + "  (nama, posisi, noktp, ttl, gender, "
			+ "agama, golDarah, status, alamatKtp, alamatTinggal, email, nohp, orgTerdekat, userId) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SELECT_BIO_BY_ID = "select * from biodata where id =?";
	private static final String SELECT_ALL_BIO = "select * from biodata";

	private static final String DELETE_BIO_SQL = "delete from biodata where id = ?;";
	private static final String UPDATE_BIO_SQL = "update biodata set name =?, posisi=?, noktp =?,"
			+ "ttl=?, gender=?, agama=?, golDarah=?, status=?, alamatKtp=?, alamatTinggal=?,"
			+ "email=?, nohp=?, orgTerdekat=?, userId=? where id = ?;";
	
	public BioDao() {
		
	}
	
	//Connection 
	protected Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	
	// Insert User
	public void insertBio(Biodata bio) throws SQLException {
		System.out.println(INSERT_BIO_SQL);
		try (Connection con = getConnection();
				PreparedStatement prepState = con.prepareStatement(INSERT_BIO_SQL)){
			prepState.setString(1, bio.getNama());
			prepState.setString(2, bio.getPosisi());
			prepState.setString(3, bio.getNoktp());
			prepState.setString(4, bio.getTtl());
			prepState.setString(5, bio.getGender());
			prepState.setString(6, bio.getAgama());
			prepState.setString(7, bio.getGolDarah());
			prepState.setString(8, bio.getStatus());
			prepState.setString(9, bio.getAlamatKtp());
			prepState.setString(10, bio.getAlamatTinggal());
			prepState.setString(11, bio.getEmail());
			prepState.setString(12, bio.getNohp());
			prepState.setString(13, bio.getOrgTerdekat());
			prepState.setString(14, bio.getUserId());
			
			System.out.println(prepState);
			prepState.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			printSQLException(e);
		}
	}
	
	
	
	// Select Biodata with ID
	public Biodata selectBiodata(int id) {
		Biodata bio = null;
		try (Connection con = getConnection();
				PreparedStatement prepState = con.prepareStatement(SELECT_BIO_BY_ID)){
			prepState.setInt(1, id);
			System.out.println(prepState);
			ResultSet res = prepState.executeQuery();
			
			while(res.next()) {
				String nama = res.getString("nama");
				String posisi = res.getString("posisi");
				String noktp = res.getString("noktp");
				String ttl = res.getString("ttl");
				String gender = res.getString("gender");
				String agama = res.getString("agama");
				String golDarah = res.getString("golDarah");
				String status = res.getString("status");
				String alamatKtp = res.getString("alamatKtp");
				String alamatTinggal = res.getString("alamatTinggal");
				String email = res.getString("email");
				String nohp = res.getString("nohp");
				String orgTerdekat = res.getString("orgTerdekat");
				String userId = res.getString("userId");
				
				bio = new Biodata(id, userId, nama, posisi, noktp, ttl, gender, agama, golDarah, status, alamatKtp, alamatTinggal, email, nohp, orgTerdekat);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			printSQLException(e);
		}
		
		return bio;
		
	}
	
	// Select All Biodata
	public List<Biodata> selectAll(){
		List<Biodata> bio = new ArrayList<>();
		try(Connection con = getConnection();
				PreparedStatement prepState = con.prepareStatement(SELECT_ALL_BIO)){
			System.out.println(prepState);
			ResultSet res = prepState.executeQuery();
			
			while(res.next()) {
				int id = res.getInt("id");
				String userId = res.getString("userId");
				String nama = res.getString("nama");
				String posisi = res.getString("posisi");
				String noktp = res.getString("noktp");
				String ttl = res.getString("ttl");
				String gender = res.getString("gender");
				String agama = res.getString("agama");
				String golDarah = res.getString("golDarah");
				String status = res.getString("status");
				String alamatKtp = res.getString("alamatKtp");
				String alamatTinggal = res.getString("alamatTinggal");
				String email = res.getString("email");
				String nohp = res.getString("nohp");
				String orgTerdekat = res.getString("orgTerdekat");
				bio.add(new Biodata(id, userId, nama, posisi, noktp, ttl, gender, agama, golDarah, status, alamatKtp, alamatTinggal, email, nohp, orgTerdekat));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			printSQLException(e);
		}
		return bio;
	}
	
	
	// Update
	public boolean updateBio(Biodata bio) throws SQLException {
		Boolean updateResult = null;
		try(Connection con = getConnection();
				PreparedStatement prepState = con.prepareStatement(UPDATE_BIO_SQL)){
			System.out.println("Updated :"+prepState);
			prepState.setString(1, bio.getNama());
			prepState.setString(2, bio.getPosisi());
			prepState.setString(3, bio.getNoktp());
			prepState.setString(4, bio.getTtl());
			prepState.setString(5, bio.getGender());
			prepState.setString(6, bio.getAgama());
			prepState.setString(7, bio.getGolDarah());
			prepState.setString(8, bio.getStatus());
			prepState.setString(9, bio.getAlamatKtp());
			prepState.setString(10, bio.getAlamatTinggal());
			prepState.setString(11, bio.getEmail());
			prepState.setString(12, bio.getNohp());
			prepState.setString(13, bio.getOrgTerdekat());
			prepState.setString(14, bio.getUserId());
			
			updateResult = prepState.executeUpdate() > 0;
			
		}
		return updateResult;
		
	}
	
	// Delete
	public boolean deleteBio(int id ) throws SQLException {
		Boolean deleteResult = null;
		try(Connection con = getConnection();
				PreparedStatement prepState = con.prepareStatement(DELETE_BIO_SQL)){
			prepState.setInt(1, id);
			deleteResult = prepState.executeUpdate() >0;
		}
		return deleteResult;
	}
	
	
	// Exception Function
	private void printSQLException(SQLException ex) {
		// TODO Auto-generated method stub
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
		
	}
	
}
