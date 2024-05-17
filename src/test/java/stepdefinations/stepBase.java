package stepdefinations;

import com.utils.Base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class stepBase extends Base{
	@BeforeAll
	public static void serverStart() throws Throwable {
		builder = new AppiumServiceBuilder();
		String IpAddress = System.getProperty("IpAddress")!=null ? System.getProperty("IpAddress"):loadProperties().getProperty("portNumber");
		builder.withIPAddress(IpAddress);
		int portNumber = Integer.parseInt(System.getProperty("portNumber")!=null ? System.getProperty("portNumber"):pro.getProperty("portNumber"));
		builder.usingPort(portNumber);
		service = AppiumDriverLocalService.buildService(builder);
		service.start();	
	}
	@AfterAll
	public static void serverStop() {
		if(service!=null) {
			service.start();
		}		
	}
}
