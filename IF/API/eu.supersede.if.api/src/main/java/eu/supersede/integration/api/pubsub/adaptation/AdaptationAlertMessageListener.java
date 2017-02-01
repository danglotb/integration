package eu.supersede.integration.api.pubsub.adaptation;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.json.JsonUtils;

public class AdaptationAlertMessageListener implements MessageListener{
	private Alert alert;
	private boolean messageReceived = false;
	
	public void onMessage(Message message) {
		try {
			String json = ((TextMessage) message).getText();
			System.out.println("Got the Json Message : " + json);
			this.alert = JsonUtils.deserializeJsonStringAsObject(json, Alert.class);
			messageReceived = true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public Alert getAlert (){
		return this.alert;
	}
	
	public boolean isMessageReceived (){
		return this.messageReceived;
	}
	
	public void resetMessageReceived(){
		this.messageReceived = false;
	}
}