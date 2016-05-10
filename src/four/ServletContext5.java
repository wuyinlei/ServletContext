package four;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext5
 * <p>
 * 通过servletContext对象读取资源文件
 * 在实际开发中，用作资源文件的文件类型，通常是：xml、properties，而读取xml文件必然要进行xml文档的解析，
 * 所以以下例子只对properties文件进行读取(在一个web工程中，只要涉及到写地址，建议最好以/开头)
 * 在web工程中，我们一般来说，是不能采用传统方式读取配置文件的，因为相对的是jvm的启动目录(tomcat的bin目录)，
 * 所以我们要使用web绝对目录来获取配置文件的地址 读取资源文件的三种方式：
 * <p>
 * 第一种：使用ServletContext的getResourceAsStream方法：
 * <li>返回资源文件的读取字节流 InputStream in
 * =this.getServletContext().getResourceAsStream(
 * "/WEB-INF/classes/db.properties" );</li>Properties prop = new Properties();
 * prop.load(in); String url = prop.getProperty("url");
 * </p>
 * <p>
 * 第二种：使用ServletContext的getRealPath方法，获得文件的完整绝对路径path，再使用字节流读取path下的文件 String
 * path =
 * this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
 * String filename = path.substring(path.lastIndexOf("\\")+1);
 * //相比第一种方法的好处是：除了可以获取数据，还可以获取资源文件的名称 FileInputStream in = new
 * FileInputStream(path); Properties prop = new Properties(); prop.load(in);
 * String url = prop.getProperty("url");
 * </p>
 * 第三种：使用ServletContext的getResource方法，获得一个url对象，调用该类的openStream方法返回一个字节流，读取数据
 * URL url =
 * this.getServletContext().getResource("/WEB-INF/classes/db.properties");
 * InputStream in = url.openStream(); Properties prop = new Properties();
 * prop.load(in); String url1 = prop.getProperty("url");
 * </p>
 */
@WebServlet("/ServletContext5")
public class ServletContext5 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//test11();
		test21();
	}

	// 第一种方式获取p1资源文件的内容
	public void test11() {
		ServletContext sc = this.getServletContext();
		// 获取p1.properties这个文件的路径
		String path = sc.getRealPath("/WEB-INF/classes/p1.properties");
		System.out.println("路径： " + path);
		// 创建Properties对象
		Properties pro = new Properties();
		try {
			// 加载文件
			pro.load(new FileReader(path));
			// 读取p1中key的内容
			System.out.println(pro.getProperty("value"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 第二种方式获取p1资源文件的内容   ResourceBundle
	public void test21() {
		//拿取ResourceBundle对象    这个对象是专门来获取properties文件的
		ResourceBundle bundle =  ResourceBundle.getBundle("p1");
		//拿取文件中的内容
		System.out.println(bundle.getString("value"));

	}

}
