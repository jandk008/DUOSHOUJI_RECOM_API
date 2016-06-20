package recommendation.items.api.jd.domain;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.jd.open.api.sdk.domain.mall.http.ObjA_Price;
import com.jd.open.api.sdk.domain.mall.http.ObjExtAttrCollection;


public class JDSearchResponse {
	
	String code;
	
	@JsonProperty(value = "Head")
	JDResponseHead head;
	
	@JsonProperty("ObjA_Price")
	List<ObjA_Price> objA_Prices;
	
	@JsonProperty("ObjExtAttrCollection")
	List<ObjExtAttrCollection> objExtAttrCollections;
	
	@JsonProperty("Paragraph")
	List<JDParagraph> paragraphs;
	
	
	public List<ObjExtAttrCollection> getObjExtAttrCollections() {
		return objExtAttrCollections;
	}
	public void setObjExtAttrCollections(
			List<ObjExtAttrCollection> objExtAttrCollections) {
		this.objExtAttrCollections = objExtAttrCollections;
	}
	public List<JDParagraph> getParagraphs() {
		return paragraphs;
	}
	public void setParagraphs(List<JDParagraph> paragraphs) {
		this.paragraphs = paragraphs;
	}
	public List<ObjA_Price> getObjA_Prices() {
		return objA_Prices;
	}
	public void setObjA_Prices(List<ObjA_Price> objA_Prices) {
		this.objA_Prices = objA_Prices;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public JDResponseHead getHead() {
		return this.head;
	}
	public void setHead(JDResponseHead head) {
		this.head = head;
	}
	
}
