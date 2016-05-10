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

@WebServlet("/ServletContext6")
public class ServletContext6 extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		test12();
	}
	
	// ��ȡp2��Դ�ļ�������
		public void test12() {
			ServletContext sc = this.getServletContext();
			// ��ȡp1.properties����ļ���·��
			String path = sc.getRealPath("/WEB-INF/classes/four/p2.properties");
			System.out.println("·���� " + path);
			// ����Properties����
			Properties pro = new Properties();
			try {
				// �����ļ�
				pro.load(new FileReader(path));
				// ��ȡp1��key������
				System.out.println(pro.getProperty("value"));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	
	
	

}
