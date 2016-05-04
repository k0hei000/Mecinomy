package bean;

public class MatchingBean implements java.io.Serializable{

	private static final long serialVersionUID = -5922676543819145258L;

	private String goTime;
	private String purpose;
	private String matchingId;
	public String getGoTime() {
		return goTime;
	}
	public void setGoTime(String goTime) {
		this.goTime = goTime;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getMatchingId() {
		return matchingId;
	}
	public void setMatchingId(String matchingId) {
		this.matchingId = matchingId;
	}

	public MatchingBean(){

	}

	public MatchingBean(String goTime, String purpose, String matchingId) {
		super();
		this.goTime = goTime;
		this.purpose = purpose;
		this.matchingId = matchingId;
	}


}
