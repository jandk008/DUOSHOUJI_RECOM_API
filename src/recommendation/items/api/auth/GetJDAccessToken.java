package recommendation.items.api.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class GetJDAccessToken {
	
	private static final String ACCESS_TOKEN_URL = "https://oauth.jd.com/oauth/authorize?";
	private static final String RESPONSE_TYPE = "response_type=code";
	private static final String CLIENT_ID = "client_id=";
	private static final String REDIRECT_URI = "redirect_uri=urn:ietf:wg:oauth:2.0:oob";
	
	
	public static String getJDAccessToken(String appKey) throws IOException{
		String urlStr = ACCESS_TOKEN_URL + RESPONSE_TYPE + "&" + CLIENT_ID + appKey + "&" + REDIRECT_URI;
		URL url = new URL(urlStr); 
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestProperty("Accept-Charset", "UTF-8");
		conn.setRequestMethod("POST");
		int respCode = conn.getResponseCode();
		System.out.println(urlStr + "\n"+ respCode + " | " + conn.getResponseMessage());
		InputStream in = conn.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String s;
		while((s = reader.readLine()) != null){
			System.out.println(s);
		}
		conn.connect();
		
		return null;
	}
	public static void main (String[] args){
		try{
			getJDAccessToken("553D6C9EBE50400559AAC8372AAE6662");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
