package serviceWeb;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ServiceWeb {
private static WebResource service=null;
	
	public static WebResource getService() {
		if(service==null)
			new ServiceWeb();
		return service;
	}
	public ServiceWeb() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		service = client.resource(getBaseURI());
	}
	
	
	  private static URI getBaseURI() {
		 //si localhost est 8080 , faudra remplace 9090 par 8080 
		  return UriBuilder.fromUri("http://localhost:9090/serviceWeb/rest/").build();
	}
}
