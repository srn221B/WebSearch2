package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Show_HistorySearchAction;


 @WebServlet("/Show_HistoryController")
public class Show_HistoryController extends HttpServlet {
	public Show_HistoryController(){
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String dao = request.getParameter("dao");
		String colum = request.getParameter("colum");
		//DB更新
		Show_HistorySearchAction action = new Show_HistorySearchAction();
		String[] data = {dao,colum};
		action.execute(data);
		String rdstr = "top.jsp";
		request.getRequestDispatcher(rdstr).forward(request, response);
	}
}