package three;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext3 演示请求转发
 * 
 * <p>
 * 3）通过servletContext对象实现servlet转发
 * 由于servlet中的java数据不易设置样式，所以serlvet可以将java数据转发到JSP页面中进行处理
 * this.getServletContext().setAttribute("data","serlvet数据转发");
 * RequestDispatcher rd =
 * this.getServletContext().getRequestDispatcher("/viewdata.jsp");
 * rd.forward(request, response);
 * </P>
 */
@WebServlet("/ServletContext3")
public class ServletContext3 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 拿到全局对象
		ServletContext sc = this.getServletContext();

		request.setAttribute("name", "小白");

		// 拿到请求转发体
		RequestDispatcher rd = sc.getRequestDispatcher("/ServletContext4");

		// 转发过去
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
