package entity;

import java.io.Serializable;

public class Access implements Serializable{
	private String Access_Hour;
	private String Access_Count;

	public Access() {
	}

	public Access(String Access_Hour,String Access_Count) {
		this.Access_Hour = Access_Hour;
		this.Access_Count = Access_Count;
	}

	public String getAccess_Hour() {
		return Access_Hour;
	}

	public void setAccess_Hour(String access_hour) {
		this.Access_Hour = access_hour;
	}

	public String getAccess_Count() {
		return Access_Count;
	}

	public void setAccess_Count(String access_count) {
		this.Access_Count = access_count;
	}
}
