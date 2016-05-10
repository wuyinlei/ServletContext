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

	// �ڶ��ַ�ʽ��ȡp2��Դ�ļ������� ResourceBundle   ���ܻ�ȡweb�������Դ
	public void test21() {
		// ��ȡResourceBundle���� ���������ר������ȡproperties�ļ���
		ResourceBundle bundle = ResourceBundle.getBundle("four.p2");
		// ��ȡ�ļ��е�����
		System.out.println(bundle.getString("value"));

	}
	
	// �����ַ�ʽ��ȡp1��Դ�ļ�������   �������
			public void test31() {
				
				/**
				 * ��һ�֣�����    ServletContext5.class.getName();
				 * �ڶ��֣�����   this.getClass().getName();
				 * �����֣�Class.forName()   Class.forName("ServletContext5").getClassLoader();
				 */
				//��ȡ��������ķ�ʽ   Ĭ��·����src  ��Ӧweb·����classes
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
