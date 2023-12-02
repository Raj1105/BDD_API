package resource;

public enum ReusableMethod {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	private String httpMethods;

	ReusableMethod(String httpMethods) {
		this.httpMethods = httpMethods;
	}
	
	public String getMethods() {
		return httpMethods;
	}

}
