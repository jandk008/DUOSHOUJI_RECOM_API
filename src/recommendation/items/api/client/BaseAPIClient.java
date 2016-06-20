package recommendation.items.api.client;

public abstract class BaseAPIClient {
	public abstract <T> T searchItems(String keyword);
	
}
