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
 * Servlet implementation class ServletContext1 获取全局配置参数
 * <p>
 * 2）通过servletContext对象获取到整个web应用的配置信息 String url =
 * this.getServletContext().getInitParameter("url"); String username =
 * this.getServletContext().getInitParameter("username"); String password =
 * this.getServletContext().getInitParameter("password");
 * </p>
 */
@WebServlet(urlPatterns="/ServletContext2",initParams = { @WebInitParam(name = "username", value = "张三"),
	/*	@WebInitParam(name = "age", value = "23")*/ })
public class ServletContext2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 拿到全局对象
		ServletContext sc = this.getServletContext();
		
		//获取配置信息，根据配置信息的name  获取value
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
