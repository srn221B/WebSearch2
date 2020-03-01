package entity;

import java.io.Serializable;

public class Link_Click implements Serializable{

	private String Link_Colum;
	private String Link_Count;

	public Link_Click() {};

	public Link_Click(String Link_Colum,String Link_Count) {
		super();
		this.Link_Colum = Link_Colum;
		this.Link_Count = Link_Count;
	}

	public String getLink_Colum() {
		return Link_Colum;
	}

	public void setLink_Colum(String link_colum) {
		this.Link_Colum = link_colum;
	}

	public String getLink_Count() {
		return Link_Count;
	}

	public void setLink_Count(String link_count) {
		this.Link_Count = link_count;
	}
}
