package infinite.AgentDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentShow {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agentdatabase",
					"root","root");
			String cmd = "select *from Agent";
			PreparedStatement pst = conn.prepareStatement(cmd);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				System.out.println("_----------------------------------------");
				System.out.println("the Agent Id  \n" + res.getInt("AgentID"));
				System.out.println("The Agent Name \n " + res.getString("Name"));
				System.out.println(" the City\n " + res.getString("City"));
				System.out.println("The Gender is \n " + res.getString("GENDER"));
				System.out.println("Martialstatus is \n " + res.getInt("MaritalStatus"));
				System.out.println("The preminum is  \n" + res.getDouble("Premium"));
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
