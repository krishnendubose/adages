package ws.soap.client;

public class HelloServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        HelloServiceService service = new HelloServiceService();
        HelloService port = service.getHelloServicePort();
        System.out.println("Service call output is :- \n" + port.sayHelloWorld());
	}

}
