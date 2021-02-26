package progettop1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;
public class salvataggiodatimeteo extends parsingdata{
	
	
	private String nomecittà;
	private String units;
	
	public salvataggiodatimeteo(String Apikey,String nomecittà,String units) {
		super(Apikey);
		this.nomecittà="london";
		this.units="metric";
		
	}
	
	public String URLGenerator(String nomecittà, String units)
	{
		String URL = "https://api.openweathermap.org/data/2.5/find?"; //Crea URL 
		URL += ("?q="+nomecittà);
		URL += ("&appid=" + super.getApikey());
		URL += ("&units=" + units);
		return URL;
		}
	
	
	
	
	
	
	
	
	public Vector datiattuali (String nomecittà) throws MalformedURLException, IOException 
	{
		
		Vector<String>vett = new <String> Vector();

		URLConnection openWeather = new URL(this.URLGenerator(nomecittà, this.units)).openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(openWeather.getInputStream()));
		
		String inputLine = in.readLine();
		vett.add(inputLine);
		for (String elemento : vett) {
			   System.out.println(elemento);
			}
		return vett;
		
			
		/*String cod = (String) risposta.get("cod");
		if (cod == "200")
			throw new BadRequestException();*/
		
		//JSONArray arrayCitta = (JSONArray) risposta.get("list");
		
		/*for(int i=0; i<arrayCitta.size(); i++)
		{
			//JSONObject citta = (JSONObject) arrayCitta.get(i);
			long id = (long) citta.get("id");
			String nomeCitta = (String) citta.get("name");
			
			JSONObject coord = (JSONObject) citta.get("coord");	
			double latitude = Double.parseDouble(coord.get("lat").toString());
			double longitude = Double.parseDouble(coord.get("lon").toString());	
			
			Citta city = new Citta(nomeCitta, id, latitude, longitude);
			
			JSONObject main = (JSONObject) citta.get("main");
			double temperatura = Double.parseDouble(main.get("temp").toString());
			double temperaturaPerc = Double.parseDouble(main.get("feels_like").toString());	
			long dt = (long) citta.get("dt");
				
			JSONObject wind = (JSONObject) citta.get("wind");
			double velVento = Double.parseDouble(wind.get("speed").toString());
				
			DatoMeteo datoMeteo = new DatoMeteo(temperatura, temperaturaPerc, velVento, (dt*1000L));
				
			city.aggiungiDatoMeteo(datoMeteo);
				
			ritorno.add(city);
		}
	return ritorno;*/
		
}
	

}
