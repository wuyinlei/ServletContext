package four;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletContext6")
public class ServletContext6 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		// test12();
		test21();
	}

	// 获取p2资源文件的内容
	public void test12() {
		ServletContext sc = this.getServletContext();
		// 获取p1.properties这个文件的路径
		String path = sc.getRealPath("/WEB-INF/classes/four/p2.properties");
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

	// 第二种方式获取p2资源文件的内容 ResourceBundle   不能获取web方面的资源
	public void test21() {
		// 拿取ResourceBundle对象 这个对象是专门来获取properties文件的
		ResourceBundle bundle = ResourceBundle.getBundle("four.p2");
		// 拿取文件中的内容
		System.out.println(bundle.getString("value"));

	}
	
	// 第三种方式获取p1资源文件的内容   类加载器
			public void test31() {
				
				/**
				 * 第一种：类名    ServletContext5.class.getName();
				 * 第二种：对象   this.getClass().getName();
				 * 第三种：Class.forName()   Class.forName("ServletContext5").getClassLoader();
				 */
				//获取类加载器的方式   默认路径是src  对应web路径是classes
				InputStream is = this.getClass().getClassLoader().getResourceAsStream("four/p1.properties");
				Properties prop = new Properties();
				try {
					prop.load(is);
				} catch (IOException e) {
					e.printStackTrace();
				}
				String value = prop.getProperty("value");
				System.out.println(value);
				

				
			}

}
