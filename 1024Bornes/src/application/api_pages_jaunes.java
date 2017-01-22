package application;

import java.math.BigDecimal;
import java.util.HashMap;
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

public class api_pages_jaunes {

	private static final String USER_AGENT = null;
	HashMap <BigDecimal, BigDecimal> coordonnees;
	String url;

	public api_pages_jaunes(String Url){
		this.coordonnees = new  HashMap <BigDecimal, BigDecimal>();
		this.url=Url;
	}

	public void recuperer_donnees_localisation() throws Exception{
		final String USER_AGENT = "Mozilla/5.0";
		JSONParser parser = new JSONParser();
		api_pages_jaunes http = new api_pages_jaunes(url);
		System.out.println("Send Http GET request");
		try {
			http.SendGet(url);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			http.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// HTTP GET request
	public String SendGet(String Url) throws Exception {

		this.url = Url;

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

	public void parse() throws Exception
	{
		BigDecimal value = null;
		BigDecimal lon = null;
		BigDecimal lat = null;
		String cle = null;
		int j=1;
		int i=0;
		int taille;

		String result =  SendGet(url);
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
				}

				String longitude=text.substring(1,10);

				String sub2=text.substring(11);
				String [] subtext2 =sub2.split("}");
				if(longitude.equals("longitude")){
					lon = new BigDecimal(subtext2[0]);
				}
				coordonnees.put(lat, lon);
				taille--;
				i++;
			}
			System.out.println("coordonees de localisation: ");
			for (Entry<BigDecimal, BigDecimal> e : coordonnees.entrySet()){
			    System.out.println(e.getKey() + " : " + e.getValue());
			}
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
