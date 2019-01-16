package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
	
		Connection conn = null; //Connection do java.sql
		Statement st = null; //Statement do java.sql "o Statement é o comando SQL"
		ResultSet rs = null; //ResultSet do java.sql
		
		try {
			conn = DB.getConnection(); //com essa associação vamos estabelecer conexão com Banco de Dados;
		
			st = conn.createStatement();
			
			rs = st.executeQuery("SELECT * FROM coursejdbc.department");
			
			while( rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closesResultSet(rs);
			DB.closeConnectio();			
		}
		

	}

}
