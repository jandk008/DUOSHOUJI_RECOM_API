package recommendation.items.api.client;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TimeGetRequest;
import com.taobao.api.response.TimeGetResponse;

public class Test {
	private static final String SERVER_URL = "http://gw.api.taobao.com/router/rest";
	private static final String APP_KEY = "23362952";
	private static final String APP_SECRET = "82c170b104e3bebf347e26633f7a3b1c";
	private static TaobaoClient client = new DefaultTaobaoClient(SERVER_URL, APP_KEY, APP_SECRET);
	
	public static void main(String[] args) {
		long timeStart = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					TaobaoClient client = new DefaultTaobaoClient(SERVER_URL, APP_KEY, APP_SECRET);
					TimeGetRequest request = new TimeGetRequest();
					TimeGetResponse response;
					try {
						response = client.execute(request);
						if (response.isSuccess()){
							System.out.println(response.getTime());
						}
					} catch (ApiException e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(System.currentTimeMillis() - timeStart);
	}
}
