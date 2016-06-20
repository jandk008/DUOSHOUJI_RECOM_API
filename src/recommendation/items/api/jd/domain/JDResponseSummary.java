package recommendation.items.api.jd.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class JDResponseSummary {
	
	@JsonProperty("ResultCount")
	int resultCount;

	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}
	
}
