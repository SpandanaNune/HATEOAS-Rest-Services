import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class StudentAppealRepresentation {
	@XmlElement
    StudentAppeal appeal;
    @XmlElement
    List<Link> links;
    StudentAppealRepresentation(){}

    public StudentAppealRepresentation(StudentAppeal appeal) {
        this.appeal = appeal;
    }
    
    public StudentAppeal getAppealObj(){
        return this.appeal;
    }
	
	

}



    
    

