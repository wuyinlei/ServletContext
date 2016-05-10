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
 * <li>有三种方式获取ServletContext对象</li>
 * <li>1、采用ServletConfig对象获取</li>
 * <li>2、采用Servlet实例对象获取</li>
 * <li>3、采用request请求对象获取</li>
 * <p>
 * ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，可以通过ServletConfig.
 * getServletContext方法获得ServletContext对象。
 * 由于一个WEB应用中的所有Servlet共享同一个ServletContext对象，
 * 因此Servlet对象之间可以通过ServletContext对象来实现通讯。ServletContext对象通常也被称之为context域对象。
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
		// 第一种方式
		// sc = config.getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 第二种方式
		// sc = this.getServletContext();

		// 第三种方式
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
