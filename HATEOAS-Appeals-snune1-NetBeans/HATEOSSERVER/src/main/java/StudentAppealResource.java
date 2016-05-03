import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
@Path("/appeal")
public class StudentAppealResource {
              Response response;

	public StudentAppealResource() {
        }
@GET
@Path("/{StudentAppealId}")
@Produces("application/vnd-cse564-appeals+xml")
   public Response getStudentAppeal(@PathParam("StudentAppealId") String StudentAppealId){
       StudentAppeal StudentAppeal = StudentAppealsRepository.StudentAppealsRep.get(StudentAppealId);
       response = Response.ok().entity(new StudentAppealRepresentation(StudentAppeal)).build();
       return response;
   }
   
@POST
@Consumes("application/vnd-cse564-appeals+xml")
@Produces("application/vnd-cse564-appeals+xml")
   public StudentAppealRepresentation createStudentAppeal(StudentAppeal StudentAppeal){
      StudentAppeal.setstudentappealid(java.util.UUID.randomUUID().toString());
      StudentAppeal.setAppealStatus("Not Processed");
      StudentAppealsRepository.StudentAppealsRep.put(StudentAppeal.getstudentappealid(), StudentAppeal);
      return new StudentAppealRepresentation(StudentAppeal);
   }
@DELETE
@Path("/{StudentAppealId}")
@Produces("application/vnd-cse564-appeals+xml")
   public Response removeAppeal(@PathParam("StudentAppealId") String StudentAppealId){
       StudentAppeal StudentAppeal1 = StudentAppealsRepository.StudentAppealsRep.get(StudentAppealId);
       StudentAppeal StudentAppeal2 = StudentAppealsRepository.StudentAppealsRep.remove(StudentAppealId);
       response = Response.ok().entity(new StudentAppealRepresentation(StudentAppeal2)).build();
       return response;
       
   }
 
@PUT
@Path("/{StudentAppealId}/{Appealcomment}")
@Produces("application/vnd-cse564-appeals+xml")
   public Response getAppeal(@PathParam("Appealcomment") String comment,@PathParam("StudentAppealId") String StudentAppealId){
       StudentAppeal StudentAppeal = StudentAppealsRepository.StudentAppealsRep.get(StudentAppealId);
       StudentAppeal.setAppealcomment(comment);
       response = Response.ok().entity(new StudentAppealRepresentation(StudentAppeal)).build();
       return response;
   }
   
   
}
