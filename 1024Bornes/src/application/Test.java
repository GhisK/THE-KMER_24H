package application;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		api_pages_jaunes appj = new api_pages_jaunes("https://api.apipagesjaunes.fr/pros/find?what=plombier&where=rennes&app_id=d140a6f6&app_key=26452728b034374bccb462e880bfb0e5&return_urls=true");
		appj.recuperer_donnees_localisation();

	}

}
