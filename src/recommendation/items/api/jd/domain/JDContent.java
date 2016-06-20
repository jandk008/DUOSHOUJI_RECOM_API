package recommendation.items.api.jd.domain;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * @author ziczhou
 *
 */
public class JDContent{
	
	@JsonProperty(value = "imageurl")
	String imageUrl;
	
	@JsonProperty(value = "warename")
	String wareName;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getWareName() {
		return wareName;
	}

	public void setWareName(String wareName) {
		this.wareName = wareName;
	}
	
	
}