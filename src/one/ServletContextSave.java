package one;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext2 ��ʾServletContext������Ϊ�����ʹ��
 */
@WebServlet("/ServletContextSave")
public class ServletContextSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletContextSave() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * <p>
		 * <li>��serlvet�У�����ʹ������������������ݹ��� ServletContext context
		 * =this.getServletContext();</li>
		 * <li>servletContext�����context.setAttribute("data", "��������");
		 * �����д���һ��data����</li>
		 * </p>
		 * <p>
		 * <li����һ��servlet�У�����ʹ�������������ȡ���е�data���� ServletContext context =
		 * this.getServletContext(); String value = (String)
		 * context.getAttribute("data"); //��ȡ���е�data����
		 * System.out.println(value);</li>
		 * </p>
		 */
		// ��ȡȫ�ֶ���
		ServletContext sc = this.getServletContext();
		// �洢����
		sc.setAttribute("name", "�����");
		System.out.println("���ݴ洢���");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
