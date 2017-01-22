package application;


import java.awt.Event;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

	private final String USER_AGENT = "Mozilla/5.0";
	JSONParser parser = new JSONParser();
	public static void main(String[] args) throws Exception {

		api_pages_jaunes http = new api_pages_jaunes();

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
		
BufferedReader bis = new BufferedReader (new FileReader("D:\\Devoirs\\4eme_annee_ensim\\PJ 24H\\THE-KMER_24H\\1024Bornes\\rsc\\Mappy\\api-ajax-mappy-5.4.1-12\\dist\\mappy.html"));


		
		List<String> mappy = new ArrayList<String>();
		boolean id;
		String str;
		while((str = bis.readLine()) != null){
			mappy.add(str);
		}
		bis.close();
		for(String s : mappy )
			System.out.println(s);


		String marker = null;
		BufferedWriter bos = new BufferedWriter(new FileWriter("D:\\Devoirs\\4eme_annee_ensim\\PJ 24H\\THE-KMER_24H\\1024Bornes\\rsc\\Mappy\\api-ajax-mappy-5.4.1-12\\dist\\mappy.html"));
		
		
		for(String s : mappy ){
			id = s.equals("});");
			if(id){
				bos.newLine();
				bos.write(s);
				System.out.println("l"+localite.size());
				for(Entry<BigDecimal, BigDecimal> e : localite.entrySet()){
					System.out.println("----");
					marker = "var marker = L.marker(["+e.getKey() + "," + e.getValue() +"]).addTo(Map);";
					bos.newLine();
					bos.write(marker);
					marker = null;
					System.out.println(marker);
				}
			}else{
				bos.newLine();
				bos.write(s);
			}
		}
		bos.close();
	}
}



/*package application;

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
	static HashMap  <BigDecimal, BigDecimal> coordonnees;
	static ArrayList<BigDecimal> lat = new ArrayList<BigDecimal>();
	static ArrayList<BigDecimal> lon = new ArrayList<BigDecimal>();
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
					System.out.print("valeur=null");
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
					this.lat.add(lat);
				}

				String longitude=text.substring(1,10);

				String sub2=text.substring(11);
				String [] subtext2 =sub2.split("}");
				if(longitude.equals("longitude")){
					lon = new BigDecimal(subtext2[0]);
					this.lon.add(lon);
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
}*/