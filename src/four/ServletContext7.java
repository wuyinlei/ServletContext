package four;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletContext7")
public class ServletContext7 extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		test13();
	}
	
	// 获取p3资源文件的内容
			public void test13() {
				ServletContext sc = this.getServletContext();
				// 获取p1.properties这个文件的路径
				String path = sc.getRealPath("/p3.properties");
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
		
		

}
