package infinite11.ComplaintProjectJSP;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAO {
	Connection connection;
	PreparedStatement pst;
	
	public String AddComplaint(Complaint complaint) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into complaint (ComplaintId,ComplaintType,CDescription,ComplaintDate,Severit,Status"+
				"values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, complaint.getComplaintId());
		pst.setString(2, complaint.getComplaintType());
		pst.setString(3, complaint.getCDescription());
		pst.setDate(4, (Date) complaint.getComplaintDate());
		pst.setString(5, complaint.getSeverity());
		pst.setString(6, complaint.getStatus());
		pst.executeUpdate();
		return "Complaint Added ";
	}
	
	public Complaint[] showAllComplaint() throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from complaint";
		pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		List<Complaint> complaintList = new ArrayList<Complaint>();
		Complaint complaint = null;
		while(res.next()) {
			complaint = new Complaint();
			complaint.setComplaintId(res.getString("ComplaintId"));
			complaint.setComplaintType(res.getString("Complainttype"));
			complaint.setCDescription(res.getString("CDescription"));
			complaint.setComplaintDate(res.getDate("ComplaintDate"));
			complaint.setSeverity(res.getString("Severity"));
			complaint.setStatus(res.getString("Status"));
			complaintList.add(complaint);
		}
		return complaintList.toArray(new Complaint[complaintList.size()]);
	}
	public Complaint searchComplaint(String ComplaintId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from complaint where ComplaintId=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, ComplaintId);
		ResultSet res = pst.executeQuery();
		Complaint complaint = null;
		if(res.next()) {
			complaint = new Complaint();
			complaint.setComplaintId(res.getString("ComplaintId"));
			complaint.setComplaintType(res.getString("ComplaintType"));
			complaint.setCDescription(res.getString("CDescription"));
			complaint.setComplaintDate(res.getDate("ComplaintDate"));
			complaint.setSeverity(res.getString("Severity"));
			complaint.setStatus(res.getString("Status"));
		}
		return complaint;
		
		
	}

}



