package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Show_InfSearchAction;
import dao.YearListDAO;

/**
 * Servlet implementation class Show_InfController
 */
@WebServlet("/Show_InfController")
public class Show_InfController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show_InfController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String year = request.getParameter("Year");
		String month = request.getParameter("Month");
		String day = request.getParameter("Day");
		System.out.println(year + "," + month + "," + day);

		Show_InfSearchAction show_inf = new Show_InfSearchAction();

		//Show_InfSearchAction AccessList と List_countを取得
		if(show_inf.AccessList(request, response, year, month, day) && show_inf.LinkList(request, response, year, month, day)) {
			//取得できた場合

			//存在年listをyearListForDisplayとして保存する。
			YearListDAO yearlist = new YearListDAO();
			List<String> list = yearlist.list();
			request.setAttribute("yearListForDisplay",list);

			//選択している年月日をselectListForDisplayとして保存する
			String[] select = new String[3];
			select[0] = year;
			select[1] = month;
			select[2] = day;
			request.setAttribute("selectListForDisplay", select);

			String rdstr = "show2.jsp";
			request.getRequestDispatcher(rdstr).forward(request, response);

		}else {
			System.out.println("取得失敗");
		}

	}

}
