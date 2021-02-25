package progettop1;

public class parsingdata {
	//parsingdata sarà la superclasse grazie alla quale i parser otterranno i dati di openweather
		
		//qui è presente la stringa che prenderà la key della api di openweather
		
		private String Apikey;
		
		//costruttore della  classe Parsing
		
		public parsingdata(String Apikey) {
			this.Apikey="90d633aa3a3b9ee7a810ac3bf027dbd7";
		}

		
		//getters and setters generati per  dare e settare Apikey
		public String getApikey() {
			return Apikey;
		}

		public void setApikey(String apikey) {
			Apikey = apikey;
		}
	}
