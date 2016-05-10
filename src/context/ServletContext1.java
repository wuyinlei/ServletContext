package context;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext1
 * 
 * <li>�����ַ�ʽ��ȡServletContext����</li>
 * <li>1������ServletConfig�����ȡ</li>
 * <li>2������Servletʵ�������ȡ</li>
 * <li>3������request��������ȡ</li>
 * <p>
 * ServletConfig������ά����ServletContext��������ã�������Ա�ڱ�дservletʱ������ͨ��ServletConfig.
 * getServletContext�������ServletContext����
 * ����һ��WEBӦ���е�����Servlet����ͬһ��ServletContext����
 * ���Servlet����֮�����ͨ��ServletContext������ʵ��ͨѶ��ServletContext����ͨ��Ҳ����֮Ϊcontext�����
 * </P>
 * 
 */
@WebServlet("/ServletContext1")
public class ServletContext1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServletContext sc;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		// ��һ�ַ�ʽ
		// sc = config.getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �ڶ��ַ�ʽ
		// sc = this.getServletContext();

		// �����ַ�ʽ
		sc = request.getSession().getServletContext();
		// org.apache.catalina.core.ApplicationContextFacade@5bbca7c0
		System.out.println(sc);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
