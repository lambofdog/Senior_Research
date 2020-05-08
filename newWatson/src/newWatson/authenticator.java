package newWatson;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.BasicAuthenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v1.Assistant;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageInput;

public class authenticator {
		// make sure to use the Assistant v1 import!

	//IamAuthenticator authenticator = new IamAuthenticator("CJmH1dY2eM63Cod-AFmOs-2ztA9VUI5pINay4Skt7QEd");
	//Assistant assistant = new Assistant("2020-04-13", authenticator);
	//assistant.setServiceUrl("https://api.us-south.assistant.watson.cloud.ibm.com/instances/7379c914-6e8d-4eb7-b160-851abcee1620");

	BasicAuthenticator authenticator = new BasicAuthenticator("mckennab@my.easternct.edu", "CSC440Research");
	Assistant assistant = new Assistant("2020-04-13");
	assistant.setServiceUrl("https://api.us-south.assistant.watson.cloud.ibm.com/instances/7379c914-6e8d-4eb7-b160-851abcee1620");
}
