package resource;

import java.util.ArrayList;
import java.util.List;

import PoJo.jsontoJava;
import PoJo.loactionSubClass;

public class payLoad {
	
	public jsontoJava addPayloads(String name, String language, String address) {
		jsontoJava jj = new jsontoJava();
		jj.setAccuracy(50);
		jj.setAddress(address);
		jj.setPhone_number("(+91) 983 893 3937");
		jj.setWebsite("http://google.com");
		jj.setLanguage(language);
		jj.setName(name);

		List<String> myList = new ArrayList<String>();
		myList.add("football");
		myList.add("basketBall");
		jj.setTypes(myList);

		loactionSubClass l = new loactionSubClass();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		jj.setLocation(l);
		return jj;
	}
	
	public String getPlaceid(String placeID) {
		String place_id = "{\r\n"
				+ "    \"place_id\":\"" +placeID +"\"\r\n"
				+ "}\r\n"
				+ "";
		
		return place_id;
	}

}
