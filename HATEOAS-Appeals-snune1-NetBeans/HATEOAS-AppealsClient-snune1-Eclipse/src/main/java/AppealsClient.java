import com.sun.jersey.api.client.ClientResponse;
import java.net.URI;
import java.net.URISyntaxException;

public class AppealsClient {

	public AppealsClient() {
	}
    private static final String BASE_URI = "http://localhost:8080/HATEOSSERVER/webresources/appeal";

    private static final String RESTBUCKS_MEDIA_TYPE = "application/vnd-cse564-appeals+xml";
 
    

    public static void main(String[] args) throws Exception{
        URI serviceUri = new URI(BASE_URI);
        appealProcess(serviceUri);
    }
    
    private static void appealProcess(URI serviceUri) throws Exception {

    com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create();
    System.out.println("Case 1. Happy case");    
    System.out.println("Going to start appeal creation at"+BASE_URI);    
    System.out.println("Started appeal creation");
    StudentAppealRepresentation appeal1 = client.resource(BASE_URI).accept(RESTBUCKS_MEDIA_TYPE).type(RESTBUCKS_MEDIA_TYPE).post(StudentAppealRepresentation.class, createStudentAppeal(1));
    System.out.println("Appeal is created at " + BASE_URI+"/"+appeal1.getAppealObj().getstudentappealid());
    System.out.println("Appeal is being Processed....");
    System.out.println("Appeal Approved");
    appeal1.getAppealObj().setAppealStatus("Appeal Approved");
    System.out.println("----------------------------------------------------");

    System.out.println("Case 2. Abandoned case");    
    System.out.println("Going to start appeal creation at"+BASE_URI);    
    System.out.println("Started appeal creation");
    StudentAppealRepresentation appeal2 = client.resource(BASE_URI).accept(RESTBUCKS_MEDIA_TYPE).type(RESTBUCKS_MEDIA_TYPE).post(StudentAppealRepresentation.class, createStudentAppeal(4));
    System.out.println("Appeal is created at " + BASE_URI+"/"+appeal2.getAppealObj().getstudentappealid());
    System.out.println("Going to delete appeal");    
    appeal2 = client.resource(BASE_URI+"/"+appeal2.getAppealObj().getstudentappealid()).accept(RESTBUCKS_MEDIA_TYPE).delete(StudentAppealRepresentation.class);
    System.out.println("Deleted the appeal at" +BASE_URI+"/"+ appeal2.getAppealObj().getstudentappealid());
        System.out.println("----------------------------------------------------");

    System.out.println("Case 3. Forgotten case");
    System.out.println("Going to start appeal creation at"+BASE_URI);    
    System.out.println("Started appeal creation");
    StudentAppealRepresentation appeal3 = client.resource(BASE_URI).accept(RESTBUCKS_MEDIA_TYPE).type(RESTBUCKS_MEDIA_TYPE).post(StudentAppealRepresentation.class, createStudentAppeal(3));
    System.out.println("Appeal is created at " + BASE_URI+"/"+appeal3.getAppealObj().getstudentappealid());
    System.out.println("Checking the status of the appeal immediately after creation");
    System.out.println("Status of the appeal with id "+appeal3.appeal.getstudentappealid()+" is "+appeal3.appeal.getAppealStatus());
    System.out.println("Checking the status of appeal after few days..");
    appeal3 = client.resource(BASE_URI+"/"+appeal3.appeal.getstudentappealid()).accept(RESTBUCKS_MEDIA_TYPE).get(StudentAppealRepresentation.class);
    System.out.println("Current status with id "+appeal3.appeal.getstudentappealid()+" is "+appeal3.appeal.getAppealStatus());
    System.out.println("Adding a comment to the professor as a follow up");
    appeal3 = client.resource(BASE_URI+"/"+appeal3.appeal.getstudentappealid()+"/Please_review_my_appeal").accept(RESTBUCKS_MEDIA_TYPE).put(StudentAppealRepresentation.class);
    System.out.println("Comment is being passed at the URI and the URI is " +BASE_URI+"/"+appeal3.appeal.getstudentappealid()+"/Please_review_my_appeal");
    System.out.println("Follow up has been made successfully");
        System.out.println("----------------------------------------------------");

    System.out.println("Case 4. Bad Start");
    System.out.println("Going to start appeal creation at"+BASE_URI+"/INCORRECT_ENTRYURI");    
    ClientResponse badstart = client.resource(BASE_URI+"/INCORRECT_ENTRYURI").accept(RESTBUCKS_MEDIA_TYPE).type(RESTBUCKS_MEDIA_TYPE).post(ClientResponse.class, createStudentAppeal(2));
    System.out.println("Bad start of the appeal for the uri "+BASE_URI+"/INCORRECT_ENTRYURI" +badstart.getStatus());
        System.out.println("----------------------------------------------------");

    System.out.println("Case 5. Bad Id");
     System.out.println("Going to start appeal creation at"+BASE_URI);    
    System.out.println("Started appeal creation");
    StudentAppealRepresentation badid= client.resource(BASE_URI).accept(RESTBUCKS_MEDIA_TYPE).type(RESTBUCKS_MEDIA_TYPE).post(StudentAppealRepresentation.class, createStudentAppeal(3));
    System.out.println("Appeal is created at " + BASE_URI+"/"+badid.getAppealObj().getstudentappealid());
    System.out.println("Checking the status of the appeal immediately after creation");
    System.out.println("Status of the appeal with id "+badid.appeal.getstudentappealid()+" is "+badid.appeal.getAppealStatus());
    System.out.println("Checking the status of appeal after few days at the URI " +BASE_URI+"/appeal/b4412f39-1780-48e3-8ec2-36ccc0a0fg82");
    ClientResponse lostid = client.resource(BASE_URI+"/appeal/b4412f39-1780-48e3-8ec2-36ccc0a0fg82").accept(RESTBUCKS_MEDIA_TYPE).get(ClientResponse.class);
    System.out.println("Lost/Forgotten id of the appeal"+ lostid.getStatus());
    
    
    }
    
    public static StudentAppeal createStudentAppeal(int i){
    StudentAppeal appeal = new StudentAppeal();
    appeal.setStudentId("564"+i);
    appeal.setAppealcomment("appeal "+i);
    return appeal;
    }    
}
