import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Link {
    
   
    @XmlAttribute(name = "rel")
    private String rel;
    @XmlAttribute(name = "uri")
    private String uri;

    @XmlAttribute(name = "mediaType")
    private String mediaType;

   
    Link() {
      
    }

    public Link(String name, String uri, String mediaType) {
      
        
        this.rel = name;
        this.uri = uri;
        this.mediaType = mediaType;

    }

    

    public String getRelValue() {
      
        return rel;
    }

    public URI getUri() {
        
        try {
            URI local_uri = new URI(uri);
           
            return local_uri;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMediaType() {
       
        return mediaType;
    }
}
