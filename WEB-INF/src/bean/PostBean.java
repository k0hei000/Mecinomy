package bean;

public class PostBean implements java.io.Serializable{
	private static final long serialVersionUID = 2137456818742159879L;

	private String matchingId;
	private String purpose;
	private String timeStart;
	private String timeEnd;
	private String userId;

	public PostBean() {
	}

	public PostBean(String purpose, String timeStart, String timeEnd, String userId) {
		super();
		this.purpose = purpose;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.userId = userId;
	}


	public String getMatchingId() {
		return matchingId;
	}
	public void setMatchingId(String matchingId) {
		this.matchingId = matchingId;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}



}
