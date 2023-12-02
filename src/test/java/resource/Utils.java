package resource;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification request;
	public RequestSpecification requestResponseSpecification() throws IOException {
		if(request == null) {
		PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));
		request = new RequestSpecBuilder().setBaseUri(globalData())
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(stream))
				.addFilter(ResponseLoggingFilter.logResponseTo(stream))
				.setContentType(ContentType.JSON).build();
		return request;
		}
		else {
			return request;
		}
	}
	
	public static String globalData() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\resource\\globalData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String basePath = prop.getProperty("baseURL");
		return basePath;
	}
	
	public String getJsonData(Response respone, String keyValue) {
		String res1 = respone.asString();
		JsonPath js = new JsonPath(res1);
		String jsonData = js.get(keyValue);
		return jsonData;
	}

}
