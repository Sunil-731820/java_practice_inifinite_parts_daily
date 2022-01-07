package infinite11.ComplaintProjectJSP;

import java.util.Date;
import java.sql.*;

public class Complaint {
	private String ComplaintId;
	private String ComplaintType;
	private String CDescription;
	private Date ComplaintDate;
	private String Severity;
	private String Status;
	public String getComplaintId() {
		return ComplaintId;
	}
	public void setComplaintId(String complaintId) {
		ComplaintId = complaintId;
	}
	public String getComplaintType() {
		return ComplaintType;
	}
	public void setComplaintType(String complaintType) {
		ComplaintType = complaintType;
	}
	public String getCDescription() {
		return CDescription;
	}
	public void setCDescription(String cDescription) {
		CDescription = cDescription;
	}
	public Date getComplaintDate() {
		return ComplaintDate;
	}
	public void setComplaintDate(Date complaintDate) {
		ComplaintDate = complaintDate;
	}
	public String getSeverity() {
		return Severity;
	}
	public void setSeverity(String severity) {
		Severity = severity;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
	

}
