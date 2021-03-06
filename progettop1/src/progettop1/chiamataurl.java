package progettop1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

import org.json.JSONObject;
import org.json.simple.JSONValue;


public class chiamataurl {

	public static void main(String[] args) {
		//String url = "https://api.dropboxapi.com/2/files/list_folder";
				String url = "https://api.openweathermap.org/data/2.5/weather?q=";
				try {

					HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
					openConnection.setRequestMethod("london");
					openConnection.setRequestProperty("appid",
							"aa0854721ceebf98625f7753971cd283");
					openConnection.setRequestProperty("Content-Type", "application/json");
					openConnection.setRequestProperty("Accept", "application/json");
					openConnection.setDoOutput(true);
					/*String jsonBody = "{\r\n" + "    \"path\": \"\",\r\n" + "    \"recursive\": true,\r\n"
							+ "    \"include_media_info\": false,\r\n" + "    \"include_deleted\": false,\r\n"
							+ "    \"include_has_explicit_shared_members\": false,\r\n"
							+ "    \"include_mounted_folders\": true,\r\n" + "    \"include_non_downloadable_files\": true\r\n"
							+ "}";*/
					/*String jsonBody = "{\r\n" + 
							"    \"path\": \"/Photos/Sample Album/img001.jpg\",\r\n" + 
							"    \"include_media_info\": true,\r\n" + 
							"    \"include_deleted\": false,\r\n" + 
							"    \"include_has_explicit_shared_members\": false\r\n" + 
							"}";*/

					String jsonBody="{\r\n"
							+ "     \"id\": 2643743,\r\n"
							+ "     \"name\": \"London\",\r\n"
							+ "     \"cod\": 200,\r\n"
							+ "     \"pressure\": 1012\r\n"
							+ "}";
					try (OutputStream os = openConnection.getOutputStream()) {
						byte[] input = jsonBody.getBytes("utf-8");
						os.write(input, 0, input.length);
					}

					InputStream in = openConnection.getInputStream();

					String data = "";
					String line = "";
					try {
						InputStreamReader inR = new InputStreamReader(in);
						BufferedReader buf = new BufferedReader(inR);

						while ((line = buf.readLine()) != null) {
							data += line;
							System.out.println(line);
						}
					} finally {
						in.close();
					}
					JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
					System.out.println("OK");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			

	}

}
