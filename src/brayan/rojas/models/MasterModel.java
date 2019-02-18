package brayan.rojas.models;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MasterModel {
	
	private Statement stm;
	private ResultSet rs;
	private Conexion objConnect;
	private Connection conn;
	private PreparedStatement pstm;
	
	public MasterModel() {
		conectarseBD();	
	}
	
	private Connection conectarseBD(){
		if(objConnect == null){
			objConnect = new Conexion();
			conn = objConnect.coneccionBD();
		}
		return conn;
	}
	
	
	private Connection conexionCerrada(){
		try {
			if (conn.isClosed()) {
				
				objConnect = new Conexion();
				conn = objConnect.coneccionBD();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return conn;
	}
	
	public ArrayList<String> readData(String sql){
		
		conexionCerrada();
		ArrayList<String> listaEmpleos = new ArrayList<String>();
		
		try{
			stm = conn.createStatement();
			//rs = stm.executeQuery("SELECT country_id,country_name FROM countries");
			rs = stm.executeQuery(sql);
			/**
			 *Recupera el tamaño de recuperación para este objeto ResultSet.
			 *Devuelve: el tamaño de recuperación actual para este objeto ResultSet
			 *
			 */
			/*
			 * obteniendo solo los primeros 5 registros
			 * definir long en caso de recuperar demasiados regsitros, pero lo cual seria como mala practica, tener idea mejor
			 * int total = rs.getFetchSize();
			 * rs.getRow() numero del registro (fila)
			*/
			
			while (rs.next()) {
				// el get string tambien puedes establecer el numero de la columna
				//System.out.println("COUNTRY_ID:" + rs.getString("country_id") + " Country_name" + rs.getString("country_name"));
				listaEmpleos.add(rs.getString("job_title"));
			}
			stm.close();
			conn = objConnect.cerrarConexion();
			
		}catch(SQLException e){
			System.err.println("error en consulta tipo read, el error es: "+e.getMessage());
		}
		return listaEmpleos;
	}
	
	public void insertData(){
		
		try{
			// executeUpdate para;  ins,upd,del
			conexionCerrada();
			pstm = conn.prepareStatement("INSERT INTO countries(country_id,country_name,region_id) VALUES(?,?,?)");
			pstm.setString(1,"CO");
			pstm.setString(2, "COLOMBIA");
			pstm.setInt(3, 2);
			pstm.executeUpdate();
			//pstm.executeQuery(); this for a query select using prepareStatement
			pstm.close();
			
		}catch(SQLException e){
			System.err.println("error en consulta tipo insert, el error es: "+e.getMessage());
		}
		conn = objConnect.cerrarConexion();
	}
}
