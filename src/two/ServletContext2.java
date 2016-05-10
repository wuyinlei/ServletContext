package two;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext1 ��ȡȫ�����ò���
 * <p>
 * 2��ͨ��servletContext�����ȡ������webӦ�õ�������Ϣ String url =
 * this.getServletContext().getInitParameter("url"); String username =
 * this.getServletContext().getInitParameter("username"); String password =
 * this.getServletContext().getInitParameter("password");
 * </p>
 */
@WebServlet(urlPatterns="/ServletContext2",initParams = { @WebInitParam(name = "username", value = "����"),
	/*	@WebInitParam(name = "age", value = "23")*/ })
public class ServletContext2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �õ�ȫ�ֶ���
		ServletContext sc = this.getServletContext();
		
		//��ȡ������Ϣ������������Ϣ��name  ��ȡvalue
		String name = sc.getInitParameter("username");
		//String age = sc.getInitParameter("age");
		System.out.println("username : " + name );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
