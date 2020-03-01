package action;
import dao.AccessSubmitDBAccess;
import dao.LinkClickSubmitDBAccess;

public class Show_HistorySearchAction {
	public void execute(String[] data) {
		if(data[0].equals("Link")) {
			//LinkClick数の更新
			LinkClickSubmitDBAccess LinkClickdao = new LinkClickSubmitDBAccess();
			String Link_colum = data[1];
			LinkClickdao.submitClickByLinkInf(Link_colum);
		}else {
			//Access数の更新
			AccessSubmitDBAccess Accessdao = new AccessSubmitDBAccess();
			Accessdao.submitAccessByAccessInf();
		}
	}

}
