package progettop1;

public class parsingdata {
	//parsingdata sar� la superclasse grazie alla quale i parser otterranno i dati di openweather
	
	
	public class Parsing{
		
		//qui � presente la stringa che prender� la key della api di openweather
		
		private String Apikey;
		
		//costruttore della  classe Parsing
		
		public Parsing(String Apikey) {
			this.Apikey=Apikey;
		}

		
		//getters and setters generati per  dare e settare Apikey
		public String getApikey() {
			return Apikey;
		}

		public void setApikey(String apikey) {
			Apikey = apikey;
		}
	}

}
