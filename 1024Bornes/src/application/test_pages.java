package application;


import java.awt.Event;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.json.Json;
import javax.json.stream.JsonParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class test_pages {

	private final String USER_AGENT = "Mozilla/5.0";
	JSONParser parser = new JSONParser();
	public static void main(String[] args) throws Exception {

		test_pages http = new test_pages();

		System.out.println("Send Http GET request");
		String url = "https://api.apipagesjaunes.fr/pros/find?what=boulangerie&where=nantes&app_id=d140a6f6&app_key=26452728b034374bccb462e880bfb0e5&return_urls=true";
		http.sendGet(url);
		http.parse();

	}

	// HTTP GET request
	private String sendGet(String Url) throws Exception {

		String url = Url;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();

	}

	void parse() throws Exception
	{
		BigDecimal value = null;
		BigDecimal lon = null;
		BigDecimal lat = null;
		String cle = null;
		int j=1;
		int i=0;
		int taille;

		String result =  sendGet("https://api.apipagesjaunes.fr/pros/find?what=plombier&where=rennes&app_id=d140a6f6&app_key=26452728b034374bccb462e880bfb0e5&return_urls=true");
		HashMap <BigDecimal, BigDecimal> localite =  new HashMap<BigDecimal, BigDecimal>();
		ArrayList<HashMap> valeur = new ArrayList<HashMap>();

		try (JsonParser parser = Json.createParser(new StringReader(result))) {
			javax.json.stream.JsonParser.Event event = null;

			while (parser.hasNext()) {

				event = parser.next();
				switch (event) {
				case KEY_NAME:
					cle =  parser.getString();
					break;

				case VALUE_NUMBER:
					if (!parser.isIntegralNumber()) {
						value = parser.getBigDecimal();
						HashMap <String, BigDecimal> coord =  new HashMap<String, BigDecimal>();
						coord.put(cle, value);
						valeur.add(coord);
					}


				case VALUE_NULL:
					//System.out.print("valeur=null");
					break;
				}
			}



			taille=valeur.size();
			while(taille>0)
			{

				String text=valeur.get(i).toString();
				String latitude=text.substring(1,9);

					String sub=text.substring(10);
				String [] subtext =sub.split("}");
				if(latitude.equals("latitude")){
				 lat = new BigDecimal(subtext[0]);
				System.out.println(lat);
				}


				String longitude=text.substring(1,10);

					String sub2=text.substring(11);
				String [] subtext2 =sub2.split("}");
				if(longitude.equals("longitude")){
				 lon = new BigDecimal(subtext2[0]);
				System.out.println(lon);
				}
				localite.put(lat, lon);
				taille--;
				i++;
			}


			System.out.println(localite.toString());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		}}

