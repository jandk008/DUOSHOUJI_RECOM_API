package recommendation.items.api.jd.domain;

import org.codehaus.jackson.annotate.JsonProperty;


public class JDResponseHead {
	
	@JsonProperty("Summary")
	JDResponseSummary summary;

	public JDResponseSummary getSummary() {
		return summary;
	}

	public void setSummary(JDResponseSummary summary) {
		this.summary = summary;
	}
	
}
