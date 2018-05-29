package ws.soap.client.handler;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

public class HelloServiceClientHandlerResolver implements HandlerResolver {
	public static final String LOCAL_PART_NAME = "HelloServiceService";

	@Override
	public List<Handler> getHandlerChain(PortInfo portInfo) {
		List<Handler> handlerChain = new ArrayList<Handler>();
		QName serviceQName = portInfo.getServiceName();
		System.out.println("Service Qname :- " + serviceQName + ", localpart :-" + serviceQName.getLocalPart());
		if(serviceQName.getLocalPart().equals(LOCAL_PART_NAME)) {
			handlerChain.add(new HelloServiceClientSoapHandler());
		}
		return handlerChain;
	}

}
