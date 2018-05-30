package ws.soap.client.handler;

import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class HelloServiceClientSoapHandler implements SOAPHandler<SOAPMessageContext> {

	public void close(MessageContext arg0) {
		// TODO Auto-generated method stub

	}

	public boolean handleFault(SOAPMessageContext arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean handleMessage(SOAPMessageContext mctx) {
		// TODO Auto-generated method stub
		Boolean outbound = (Boolean) mctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		SOAPMessage msg = null;
		try{
			msg = mctx.getMessage();

		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
		if (outbound){
			System.out.println("Outgoing SOAP msg is :- \n");			
		}else {
			System.out.println("Incoming SOAP msg is :- \n" );
		}
		try {
			msg.writeTo(System.out);
			System.out.println("\n");
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}

		return true;
	}

	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
