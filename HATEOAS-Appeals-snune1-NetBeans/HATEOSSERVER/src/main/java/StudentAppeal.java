
		import javax.xml.bind.annotation.XmlAccessType;
		import javax.xml.bind.annotation.XmlAccessorType;
		import javax.xml.bind.annotation.XmlElement;
		import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class StudentAppeal {

	public StudentAppeal() {
	}
		    @XmlElement
		    private String studentappealid;
		    @XmlElement
		    private String studentid;
		    @XmlElement
		    private String appealcomment;
		    @XmlElement
		    private String appealStatus;

		   
		    public String getstudentappealid() {
		        return studentappealid;
		    }

		 
		    public void setstudentappealid(String studentappealid) {
		        this.studentappealid = studentappealid;
		    }

		
		    public String getStudentId() {
		        return studentid;
		    }

		  
		    public void setStudentId(String studentid) {
		        this.studentid = studentid;
		    }

		   
		    public String getAppealcomment() {
		        return appealcomment;
		    }

		    
		    public void setAppealcomment(String appealcomment) {
		        this.appealcomment = appealcomment;
		    }

		   
		    public String getAppealStatus() {
		        return appealStatus;
		    }

		   
		    public void setAppealStatus(String appealStatus) {
		        this.appealStatus = appealStatus;
		    }
		
	}


