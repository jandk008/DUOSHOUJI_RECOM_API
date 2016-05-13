package sharingtoearn.zidane.chow.service;


import java.util.List;

import javax.swing.RepaintManager;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.AitaobaoItem;
import com.taobao.api.domain.Area;
import com.taobao.api.request.AlibabaBaichuanAppcontentUploadRequest;
import com.taobao.api.request.AreasGetRequest;
import com.taobao.api.request.AtbItemsGetRequest;
import com.taobao.api.request.ItemsGetRequest;
import com.taobao.api.request.TimeGetRequest;
import com.taobao.api.response.AlibabaBaichuanAppcontentUploadResponse;
import com.taobao.api.response.AreasGetResponse;
import com.taobao.api.response.AtbItemsGetResponse;
import com.taobao.api.response.ItemsGetResponse;
import com.taobao.api.response.TimeGetResponse;

public class ServiceExecutor {
	private static final String SERVER_URL = "http://gw.api.taobao.com/router/rest";
	private static final String APP_KEY = "23362952";
	private static final String APP_SECRET = "82c170b104e3bebf347e26633f7a3b1c";
	
	/**
	 * 
	 * @param serverUrl
	 * @param appKey
	 * @param appSecret
	 */
	public static void serviceExecute(String serverUrl, String appKey, String appSecret){
		TaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
		ItemsGetRequest request = new ItemsGetRequest();
		request.setFields("num_iid,title,pict_url,small_images,"
				+ "reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
		request.setQ("Women");
		try {
			ItemsGetResponse response = client.execute(request);
			System.out.println(response.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
			System.out.println("A exception has occurred");
		}
	}
	
	
	/**
	 * 
	 * @param serverUrl
	 * @param appKey
	 * @param appSecret
	 */
	public static void getTimeOfTaobao(String serverUrl, String appKey, String appSecret){
		DefaultTaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
		TimeGetRequest request = new TimeGetRequest();
		TimeGetResponse response;
		try {
			response = client.execute(request);
			if (response.isSuccess()){
				System.out.println(response.getBody());
			}
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param serverUrl
	 * @param appKey
	 * @param appSecret
	 */
	public static void getAreaCode(String serverUrl, String appKey, String appSecret){
		TaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
		AreasGetRequest request = new AreasGetRequest();
		request.setFields("id,type,name");
		AreasGetResponse response;
		try {
			response = client.execute(request);
			if (response.isSuccess()){
				List<Area> areasList = response.getAreas();
				for(Area area : areasList){
					System.out.println(area.getName() +" | " + area.getZip() + " | " + area.getId());
				}
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param serverUrl
	 * @param appKey
	 * @param appSecret
	 */
	public static void uploadAppContent(String serverUrl, String appKey, String appSecret){
		TaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
		AlibabaBaichuanAppcontentUploadRequest request = new AlibabaBaichuanAppcontentUploadRequest();
		request.setParams("{\"Hello \":\"World\"}");
		request.setAppid("1");
		request.setBizid("1");
		request.setOperate("add");
		try {
			AlibabaBaichuanAppcontentUploadResponse response = client.execute(request);
			if (response.isSuccess()){
				System.out.println(response.getBody());
			}else{
				System.out.println("Upload failed");
				System.out.println(response.getBody());
			}
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param serverUrl
	 * @param appKey
	 * @param appSecret
	 */
	public static void searchATBItems(String serverUrl, String appKey, String appSecret){
		TaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
		AtbItemsGetRequest request = new AtbItemsGetRequest();
		request.setFields("open_iid,title,click_url,promotion_price");
//		request.setCid(123L);
		request.setKeyword("PS4");
		try {
			AtbItemsGetResponse response = client.execute(request);
			if (response.isSuccess()){
				System.out.println("Size : " + response.getTotalResults());
				List<AitaobaoItem> items = response.getItems();
				for (AitaobaoItem item : items){
					System.out.println("Title : " + item.getTitle() + " | URL : " + item.getClickUrl() + " | Price : " + item.getPromotionPrice());
				}
				System.out.println(response.getBody());
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
//		ServiceExecutor.serviceExecute(SERVER_URL, APP_KEY, APP_SECRET);
//		ServiceExecutor.uploadAppContent(SERVER_URL, APP_KEY, APP_SECRET);
//		ServiceExecutor.getAreaCode(SERVER_URL, APP_KEY, APP_SECRET);
		ServiceExecutor.searchATBItems(SERVER_URL, APP_KEY, APP_SECRET);
	}
}
