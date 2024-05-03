package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexao {
	
	private static final String USARNAME = "jbila";
	private static final String PASSEWORD = "@MellannieBila1069@";
	private static final String CONN_STRING="jdbc:mysql://localhost:3306/contato";
	
//	
	
	public static Connection connect() {
	
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(CONN_STRING,USARNAME,PASSEWORD);
			return conn;
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showConfirmDialog(null, e);
		} 
		return null;
		
		
		
		
	}
	

}
