package ws.soap.publisher;

import javax.xml.ws.Endpoint;

import ws.soap.HelloService;

public class HelloServicePublisher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String url = "http://localhost:10000/helloMsg";
		System.out.println("Publishing service at endpoint :- " + url);
        Endpoint.publish(url, new HelloService());
	}

}
