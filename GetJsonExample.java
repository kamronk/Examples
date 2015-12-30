package reddit.scraping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetJsonExample {

	public static void main(String[] args) {

		try {
			
			//Make connection and open it
			URL urlObject = new URL("https://bittrex.com/api/v1.1/public/getmarkets");
			BufferedReader in = new BufferedReader(new InputStreamReader(urlObject.openStream()));

			//Process response from server, collect into response body
			String inputLine;
			String responseBody = "";
			while ((inputLine = in.readLine()) != null){
				responseBody += inputLine;
			}
			
			//Close connection
			in.close();
			
			//Create a json parser
			JSONParser parser = new JSONParser();

			//Store response body as json object
			JSONObject result;
			result = (JSONObject) parser.parse(responseBody);
			
			//Get json values
			System.out.println(result.get("success"));

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
