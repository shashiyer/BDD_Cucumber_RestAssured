package resources;

import java.util.ArrayList;

import pojo.AddPlace;
import pojo.Location;
import pojo.UpdatePlace;

public class TestDataBuild {
	public AddPlace addPlacePayload(String name, String language, String address) {
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 983 893 3937");
		p.setName(name);
		p.setWebsite("https://rahulshettyacademy.com");
		
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("sdwehoe park");
		myList.add("shop");
		p.setTypes(myList);
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		return p;
	}
	
	public String deletePlacePayload(String place_Id)
	{
		return "{\r\n  \"place_id\" : \""+place_Id+"\"\r\n}";
	}
	
	public UpdatePlace updatePlacePayload(String place_id)
	{
		UpdatePlace u = new UpdatePlace();
		u.setAddress("10 winter street, India");
		u.setKey("qaclick123");
		u.setPlace_id(place_id);
		return u;
	}
}
