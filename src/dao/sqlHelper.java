package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlHelper {
	private static Connection ct = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://192.168.88.130/teacher";
	private static String user = "vivian";
	private static String password = "Vivian666!";
	public static void initialize(String s) {
		try {
			Class.forName(driver);
			ct = DriverManager.getConnection(url,user,password);
			ps = ct.prepareStatement(s,Statement.RETURN_GENERATED_KEYS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static ResultSet query(String s ,String[]params){
		try {
			initialize(s);
			
			for(int i = 0; i<params.length;i++) {
				ps.setString(i+1, params[i]);				
			}
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return rs;	
	}
	
	public static Integer update(String s ,String[]params){
		try {
			initialize(s);
			
			for(int i = 0; i< params.length;i++) {
				ps.setString(i+1, params[i]);
			}
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()){
				return rs.getInt(1);
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}
		
	public static void close() {
		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(ct!=null)ct.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}