package Resources;

public enum Apiresources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceApI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	
	Apiresources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
