package ws.soap.client.async;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import ws.soap.client.handler.HelloServiceClientHandlerResolver;

public class HelloServiceClientAsync {

	public static void main(String[] args) {
		HelloServiceService service = new HelloServiceService();
		service.setHandlerResolver(new HelloServiceClientHandlerResolver());
		HelloService port = service.getHelloServicePort();
		//port.sayHelloWorldAsync(new MyHandler());
		port.sayHelloAsync("Server", new MyHandler1());
		try{
			System.out.println("Main Thread name:- "   + Thread.currentThread().getName());
			Thread.sleep(500);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	/**
	 * Though this handler is async , unless the main thread has any specific task to do it will terminate evetually causing the other threads to also exit.
	 * To test the async functionality therefore we have to keep the main thread busy. 
	 *  
	 * @author isapkbo
	 *
	 */
	static class MyHandler implements AsyncHandler<SayHelloWorldResponse>{

		@Override
		public void handleResponse(Response<SayHelloWorldResponse> arg0) {
			System.out.println("Within MyHandler class's handleResponse() method, Thread name:- " + Thread.currentThread().getName());
			try{
				SayHelloWorldResponse sayHelloWorldResponse = arg0.get();
				System.out.println("Details:- \n" + sayHelloWorldResponse.getReturn());
			}catch(Exception e){
				e.printStackTrace();
			}

		}
	}

	static class MyHandler1 implements AsyncHandler<SayHelloResponse>{

		@Override
		public void handleResponse(Response<SayHelloResponse> arg0) {
			System.out.println("Within MyHandler1 class's handleResponse() method, Thread name:- " + Thread.currentThread().getName());
			try{
				SayHelloResponse sayHelloResponse = arg0.get();
				System.out.println("Details:- \n" + sayHelloResponse.getReturn());
			}catch(Exception e){
				e.printStackTrace();
			}

		}


	}


}
