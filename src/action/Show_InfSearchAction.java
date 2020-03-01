package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessSearchDBAccess;
import dao.LinkClickSearchDBAccess;
import entity.Access;
import entity.Link_Click;

public class Show_InfSearchAction {

	/**
	 * リンク数リストを作成 Link_ClickListForDisplayで取得
	 * @param request
	 * @param response
	 * @return boolean
	 */
	public boolean LinkList(HttpServletRequest request, HttpServletResponse response , String year, String month, String day) {
		LinkClickSearchDBAccess Linkdao = new LinkClickSearchDBAccess();

		//Listを取得する
		List<Link_Click> list = Linkdao.list(year, month, day);

		//request.setAttribute(jspで参照するときの名前, 加工済みのリンク数リスト)
		request.setAttribute("Link_ClickListForDisplay",list);


		return true;

	}

	/**
	 * アクセス数リストを作成 AccessListForDisplayで取得
	 * @param request
	 * @param response
	 * @return boolean
	 */
	public boolean AccessList(HttpServletRequest request, HttpServletResponse response, String year, String month, String day) {
		AccessSearchDBAccess Accessdao = new AccessSearchDBAccess();

		//Listを取得する
		List<Access> list = Accessdao.list(year, month, day);

		//request.setAttribute(jspで参照するときの名前、加工済のアクセス数リスト）
		request.setAttribute("AccessListForDisplay", list);

		return true;

	}

}
