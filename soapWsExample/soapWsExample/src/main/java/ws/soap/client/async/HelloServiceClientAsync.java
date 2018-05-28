package ws.soap.client.async;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import ws.soap.client.async.HelloService;
import ws.soap.client.async.HelloServiceService;

public class HelloServiceClientAsync {

	public static void main(String[] args) {

		HelloServiceService service = new HelloServiceService();
		HelloService port = service.getHelloServicePort();
		port.sayHelloWorldAsync(new MyHandler());
		try{
			System.out.println("Called sayHelloWorldAsync(), running the next statement");
		}catch(Exception e ){
			e.printStackTrace();
		}
	}

	static class MyHandler implements AsyncHandler<SayHelloWorldResponse>{

		public void handleResponse(Response<SayHelloWorldResponse> arg0) {

			try{
				SayHelloWorldResponse response = arg0.get();
				System.out.println("Response from hello world service after the async call :- " + response.getReturn());
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
