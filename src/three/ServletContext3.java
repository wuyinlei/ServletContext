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
 * Servlet implementation class ServletContext3 ��ʾ����ת��
 * 
 * <p>
 * 3��ͨ��servletContext����ʵ��servletת��
 * ����servlet�е�java���ݲ���������ʽ������serlvet���Խ�java����ת����JSPҳ���н��д���
 * this.getServletContext().setAttribute("data","serlvet����ת��");
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
		// �õ�ȫ�ֶ���
		ServletContext sc = this.getServletContext();

		request.setAttribute("name", "С��");

		// �õ�����ת����
		RequestDispatcher rd = sc.getRequestDispatcher("/ServletContext4");

		// ת����ȥ
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
