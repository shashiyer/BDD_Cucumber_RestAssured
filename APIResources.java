package resources;

public enum APIResources {
	addPlaceAPI("/maps/api/place/add/json"), getPlaceAPI("/maps/api/place/get/json"), updatePlaceAPI("maps/api/place/update/json"),
	deletePlaceAPI("/maps/api/place/delete/json");

	private String resource;

	private APIResources(String resource) {
		// TODO Auto-generated constructor stub
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}
}