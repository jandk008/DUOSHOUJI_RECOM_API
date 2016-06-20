package recommendation.items.api.service;


import java.util.List;

import javax.swing.RepaintManager;

import recommendation.items.api.client.JingdongAPIClient;
import recommendation.items.api.client.TaobaoAPIClient;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.AitaobaoItem;
import com.taobao.api.domain.AitaobaoItemDetail;
import com.taobao.api.domain.Area;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.ItemSearch;
import com.taobao.api.request.AlibabaBaichuanAppcontentUploadRequest;
import com.taobao.api.request.AreasGetRequest;
import com.taobao.api.request.AtbItemsDetailGetRequest;
import com.taobao.api.request.AtbItemsGetRequest;
import com.taobao.api.request.AtbItemsRelateGetRequest;
import com.taobao.api.request.ItemsGetRequest;
import com.taobao.api.request.TimeGetRequest;
import com.taobao.api.response.AlibabaBaichuanAppcontentUploadResponse;
import com.taobao.api.response.AreasGetResponse;
import com.taobao.api.response.AtbItemsDetailGetResponse;
import com.taobao.api.response.AtbItemsGetResponse;
import com.taobao.api.response.AtbItemsRelateGetResponse;
import com.taobao.api.response.ItemsGetResponse;
import com.taobao.api.response.TimeGetResponse;

public class SearchItemsService {
	
	/**
	 * 
	 * @param keywords
	 */
	public static void serviceExecute(String keywords){
		TaobaoAPIClient client = new TaobaoAPIClient();
		ItemSearch itemSearch = client.searchItems(keywords);
		if(itemSearch.getItems().size() == 0){
			return;
		}
		for (Item item : itemSearch.getItems()) {
			System.out.println(item.getNick()+ " | " + item.getTitle() + " | " + item.getDetailUrl());
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
				System.out.println(response.getTime());
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
	public static void searchATBItems(){
		AtbItemsGetRequest request = new AtbItemsGetRequest();
		request.setFields("open_iid,open_iid,title,promotion_price,commission");
		request.setKeyword("PS4");
		try {
			AtbItemsGetResponse response = TaobaoAPIClient.getClient().execute(request);
			if (response.isSuccess()){
//				System.out.println("Size : " + response.getTotalResults());
				List<AitaobaoItem> items = response.getItems();
				StringBuffer openiids = new StringBuffer();
				for (AitaobaoItem item : items){
					openiids.append(item.getOpenIid() + ",");
				}
				AtbItemsRelateGetRequest request2 = new AtbItemsRelateGetRequest();
				request2.setFields("title,click_url,commission");
				request2.setOpenIid(items.get(39).getOpenIid());
				request2.setRelateType(2l);
//				request2.setOpenIids(openiids.toString());
				AtbItemsRelateGetResponse response2 = TaobaoAPIClient
						.getClient().execute(request2);
//				List<AitaobaoItemDetail> aitaobaoItemDetails = response2
//						.getAtbItemDetails();
				List<AitaobaoItem> items2 = response2.getItems();
				for (AitaobaoItem aitaobaoItemDetail : items2) {
					if (!aitaobaoItemDetail.getClickUrl().equals("")){
						System.out.println(aitaobaoItemDetail.getTitle());
					}
//					System.out.println("Title "
//							+ aitaobaoItemDetail.getTitle() + " | "
//							+ aitaobaoItemDetail.getClickUrl() + " | " + aitaobaoItemDetail.getCommission());
				}
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
//		ServiceExecutor.serviceExecute(SERVER_URL, APP_KEY, APP_SECRET);
//		ServiceExecutor.uploadAppContent(SERVER_URL, APP_KEY, APP_SECRET);
//		ServiceExecutor.getAreaCode(SERVER_URL, APP_KEY, APP_SECRET);
//		ServiceExecutor.searchATBItems(SERVER_URL, APP_KEY, APP_SECRET);
		JingdongAPIClient client = new JingdongAPIClient();
		client.searchItems("PS4");
	}
}
