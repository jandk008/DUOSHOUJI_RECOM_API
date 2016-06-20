package recommendation.items.api.client;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.ItemSearch;
import com.taobao.api.request.ItemsSearchRequest;
import com.taobao.api.response.ItemsSearchResponse;

/**
 * 
 * @author ziczhou
 *
 */
public class TaobaoAPIClient extends BaseAPIClient {
	/** Taobao Production Service endpoint */
	private static final String SERVER_URL = "http://gw.api.taobao.com/router/rest";
	private static final String APP_KEY = "23362952";
	private static final String APP_SECRET = "82c170b104e3bebf347e26633f7a3b1c";
	/** Taobao default client */
	private static TaobaoClient _client = new DefaultTaobaoClient(SERVER_URL, APP_KEY, APP_SECRET);
	
	@Override
	@SuppressWarnings("unchecked")
	public ItemSearch searchItems(String keywords) {
		ItemsSearchRequest request = new ItemsSearchRequest();
		request.setFields("num_iid,title,nick,pic_url,cid,price,type,delist_time,post_fee");
		request.setQ(keywords);
		try {
			ItemsSearchResponse response = _client.execute(request);
			return response.getItemSearch();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static TaobaoClient getClient() {
		return _client;
	}
	
}
