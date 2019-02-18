package brayan.rojas.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
	
	private String user;
	private String password;
	private String url;
	private Connection conn;
	private Statement stm;
	private SQLException sql;
	private ResultSet rs;
	
	public Conexion() {
		
		setConnect();
		conectar();
		
	}
	
	private void setConnect(){
		this.user = "HR";
		this.password = "12345";
		this.url = "jdbc:oracle:thin:@localhost:1521:XE";
		this.conn = null;
		this.stm = null;
	}
	
	private void conectar(){
		/**
		 * se realiza instancia de la clase sql exception
		 * para lanzar errores a nivel general, y no nos de 
		 * error de nullPointerException
		*/
		
		if (sql == null) {
			sql = new SQLException();
		}
		
		try{
			// get driver
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver").newInstance());
			// get conex
			conn = DriverManager.getConnection(url,user,password);
			System.out.println(this.url+this.user);
			if (conn != null)
					System.out.println("Conexion exitosa");
			else{
				System.err.println("Error conectando a la BD");
				System.err.println("el error es: "+sql.getMessage());
			}
			
		}catch(ClassNotFoundException ex){
			ex.getMessage();
		}catch(IllegalAccessException ex){
			ex.getMessage();
		}catch (InstantiationException ex) {
			ex.getMessage();
		}catch(SQLException ex){
			ex.getMessage();
		}
	}
	
	
	public Connection cerrarConexion(){
		try{
			if (conn != null) {
				System.out.println("CERRANDO CONEXION...");
				 conn.close();
			}
		}catch(SQLException ex){
			ex.getMessage();
		}
		return conn;
	}
	
	public Connection coneccionBD(){
		
		if (conn != null) {
			System.out.println("retornando conexion");
			return this.conn;
		}
		return conn;
	}

}
