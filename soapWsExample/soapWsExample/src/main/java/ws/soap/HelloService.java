package ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloService {
	/**
	 * Generate the msg wrapper classes using command:- 
	 * wsgen -keep -cp . ws.soap.HelloService
	 * 
	 * Otherwise will encounter exception while publishing:- 
	 * Exception in thread "main" com.sun.xml.ws.model.RuntimeModelerException: 
	 * runtime modeler error: 
	 * Wrapper class ws.soap.jaxws.SayHelloWorld is not found. Have you run APT to generate them?	 * 
	 *
	 * @return
	 */

	@WebMethod    
	public String sayHelloWorld(){
		System.out.println("Within sayHelloWorld()");
		return "Hello, this is the sample msg from SOAP service method sayHello";
	}

	@WebMethod
	public String sayHello(String msg){
		System.out.println("Within sayHelloWorld("+ msg +")");
		return "Hello " + msg;


	}


}
