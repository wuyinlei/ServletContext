package one;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext2 演示ServletContext对象作为域对象使用
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
		 * <li>在serlvet中，可以使用如下语句来设置数据共享 ServletContext context
		 * =this.getServletContext();</li>
		 * <li>servletContext域对象context.setAttribute("data", "共享数据");
		 * 向域中存了一个data属性</li>
		 * </p>
		 * <p>
		 * <li在另一个servlet中，可以使用如下语句来获取域中的data属性 ServletContext context =
		 * this.getServletContext(); String value = (String)
		 * context.getAttribute("data"); //获取域中的data属性
		 * System.out.println(value);</li>
		 * </p>
		 */
		// 获取全局对象
		ServletContext sc = this.getServletContext();
		// 存储数据
		sc.setAttribute("name", "拜物教");
		System.out.println("数据存储完毕");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
