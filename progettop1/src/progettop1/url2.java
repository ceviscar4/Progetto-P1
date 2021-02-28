package progettop1;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;




public class url2 {

	public static void main(String[] args) {
		try{
			String nomecittà="Los Angeles";
			String units="metric";
			String Apikey="aa0854721ceebf98625f7753971cd283";
			
			String url2 = "api.openweathermap.org/data/2.5/forecast?q="+nomecittà + "&appid=" + Apikey + "&units=" + units;
 
			
			URL myurl=new URL(url2);
			
			URLConnection openweather=myurl.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(openweather.getInputStream()));
			
			
			String line;
			
			line=in.readLine();
			in.close();
			
			JSONObject obj =new JSONObject(line);
			Object main=obj.get("forecast");
			System.out.println(main);
			
			
			String value =main.toString();
			
			int index=(value.indexOf("pressure")+2);
			int index_end=(value.indexOf("clouds")-1);
			
			String pressure= new String();
			pressure=value.substring(index,index_end);
			
			System.out.println(pressure);
			
			FileWriter fd=new FileWriter ("pressure.txt");
			fd.write("pressione: "+pressure);
			
			fd.close();
		}
		catch(IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
            System.exit(100);
            
		}
		catch(JSONException je) {
			System.err.println(je.getMessage());
			je.printStackTrace();
			System.exit(100);
			
		}

	}

}
