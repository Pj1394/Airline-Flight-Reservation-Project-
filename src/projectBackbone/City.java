package projectBackbone;

public class City {
	
	private String cityName;
	private String cityLocation;
	private String cityID;
	
	public City(){
		cityName = "Atlanta";
		cityLocation = "Georgia";
		cityID ="ATL";
			
	}
	
	public City(String CityName, String CityLocation, String CityID){
		CityName = cityName;
		CityLocation = cityLocation;
		CityID = cityID;
	}
	
		public String getCityName() {
			return cityName;
		}
		
		public void setCityName (String cityName) {
			this.cityName = cityName;
		}
		
		public String getCityLocation(){
			return cityLocation;
		}
		public void setCityLocation (String cityLocation) {
			this.cityLocation = cityLocation;
		}
		
		public String getCityID() {
			return cityID;
		}
		
		public void setCityID(String cityID) {
			this.cityID = cityID;
		}
		
		
		public String toString() {
			return "City Name: " + cityName + "\nLocation" + cityLocation + "\nCity ID" + cityID;
		}
	}

