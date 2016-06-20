package recommendation.items.api.jd.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import com.jd.open.api.sdk.domain.mall.http.IcoTagInfo;

/**
 * 
 * @author ziczhou
 *
 */
public class JDParagraph {
	
	@JsonProperty(value = "Content")
	JDContent content;

	@JsonProperty(value = "IcoTagInfo")
	IcoTagInfo icoTagInfo;
	
	String catid;
	String cid1;
	String cid2;
	String cod;
	String good;
	String ico;
	String shop_id;
	String wareid;
	
	public JDContent getContent() {
		return content;
	}
	public void setContent(JDContent content) {
		this.content = content;
	}
	public IcoTagInfo getIcoTagInfo() {
		return icoTagInfo;
	}
	public void setIcoTagInfo(IcoTagInfo icoTagInfo) {
		this.icoTagInfo = icoTagInfo;
	}
	public String getCatid() {
		return catid;
	}
	public void setCatid(String catid) {
		this.catid = catid;
	}
	public String getCid1() {
		return cid1;
	}
	public void setCid1(String cid1) {
		this.cid1 = cid1;
	}
	public String getCid2() {
		return cid2;
	}
	public void setCid2(String cid2) {
		this.cid2 = cid2;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getGood() {
		return good;
	}
	public void setGood(String good) {
		this.good = good;
	}
	public String getIco() {
		return ico;
	}
	public void setIco(String ico) {
		this.ico = ico;
	}
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getWareid() {
		return wareid;
	}
	public void setWareid(String wareid) {
		this.wareid = wareid;
	}
	
	@Override 
	public String toString(){
		return content.getImageUrl() + " | " + content.getWareName() + " | "
				+ (null != icoTagInfo ? icoTagInfo.getTagurl() : "null") + " | " + catid + " | " + cid1 + " | " + cid2
				+ " | " + cod + " | " + good + " | " + ico + " | " + shop_id + " | " + wareid;
	}
}

