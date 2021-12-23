package infinite.AgentDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AgentSearch {
	public static void main(String[] args) throws SQLException {
		int AgentID;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Agent ID here For searching the agent ");
		AgentID = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agentdatabase",
					"root","root");
			String cmd = "select *from Agent where AgentID=?";
			PreparedStatement pst = conn.prepareStatement(cmd);
			pst.setInt(1, AgentID);
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				System.out.println("The Agent Name is " + res.getString("Name"));
				System.out.println("The Agent City is " + res.getString("City"));
				System.out.println("The Gender is "+ res.getString("GENDER"));
				System.out.println("The martialStatus is "+ res.getInt("MaritalStatus"));
				System.out.println("The Premium of the Agent is " + res.getDouble("Premium"));
			}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
