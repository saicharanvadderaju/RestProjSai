package Resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlace(String name, String language, String address)
	{
AddPlace ap=new AddPlace();
		
		ap.setAccuracy(50);
		ap.setName(name);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setAddress(address);
		ap.setWebsite("http://google.com");
		ap.setLanguage(language);
		
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		
		ap.setTypes(myList);
		
		Location l=new Location();
		l.setLat(-38.383694);
		l.setLng(33.428362);
		ap.setLocation(l);
		
		return ap;
	}
	
	public String deletePlacePayload(String Placeid)
	{
		return "{\r\n" + 
				"  \"place_id\": \""+Placeid+"\"\r\n" + 
				"}";
	}

}
