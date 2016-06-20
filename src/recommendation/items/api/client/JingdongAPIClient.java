package recommendation.items.api.client;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import recommendation.items.api.jd.domain.JDParagraph;
import recommendation.items.api.jd.domain.JDResponseSummary;
import recommendation.items.api.jd.domain.JDSearchResponse;

import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.mall.WareSearchRequest;

public class JingdongAPIClient extends BaseAPIClient {
	/** Jingdong Production Service endpoint */
	private static final String SERVER_URL = "https://gw.api.360buy.com/routerjson";
	private static final String APP_KEY = "553D6C9EBE50400559AAC8372AAE6662";
	private static final String APP_SECRET = "fee0459a7a4c49dab372038922b425be";
	private static final JdClient _client = new DefaultJdClient(SERVER_URL, "", APP_KEY, APP_SECRET);
	
	@Override
	public <T> T searchItems(String keyword) {
		WareSearchRequest request = new WareSearchRequest();
		request.setKey("xbox");
		request.setSortType("sort_dredisprice_desc");
		try {
			com.jd.open.api.sdk.response.mall.WareSearchResponse response = _client.execute(request);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			JDSearchResponse resp = objectMapper.readValue(response.getMsg(), ResponseWrapper.class).getJingdong_ware_search_responce();
			JDResponseSummary summary = resp.getHead().getSummary();
			System.out.println("Search " + summary.getResultCount() + " products");
			List<JDParagraph> paragrapghs = resp.getParagraphs();
			int i = 1;
			for ( JDParagraph paragrapgh : paragrapghs) {
				System.out.println( i ++ + " : "+paragrapgh.toString());
			}
		} catch (JdException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args){
		JingdongAPIClient client = new JingdongAPIClient();
		client.searchItems("PS4");
	}

}

class ResponseWrapper{

	@JsonProperty(value = "jingdong_ware_search_responce")
	JDSearchResponse response;

	public JDSearchResponse getJingdong_ware_search_responce() {
		return response;
	}

	public void setJingdong_ware_search_responce(
			JDSearchResponse jingdong_ware_search_responce) {
		this.response = jingdong_ware_search_responce;
	}
	
}
