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
 * ͨ��servletContext�����ȡ��Դ�ļ�
 * ��ʵ�ʿ����У�������Դ�ļ����ļ����ͣ�ͨ���ǣ�xml��properties������ȡxml�ļ���ȻҪ����xml�ĵ��Ľ�����
 * ������������ֻ��properties�ļ����ж�ȡ(��һ��web�����У�ֻҪ�漰��д��ַ�����������/��ͷ)
 * ��web�����У�����һ����˵���ǲ��ܲ��ô�ͳ��ʽ��ȡ�����ļ��ģ���Ϊ��Ե���jvm������Ŀ¼(tomcat��binĿ¼)��
 * ��������Ҫʹ��web����Ŀ¼����ȡ�����ļ��ĵ�ַ ��ȡ��Դ�ļ������ַ�ʽ��
 * <p>
 * ��һ�֣�ʹ��ServletContext��getResourceAsStream������
 * <li>������Դ�ļ��Ķ�ȡ�ֽ��� InputStream in
 * =this.getServletContext().getResourceAsStream(
 * "/WEB-INF/classes/db.properties" );</li>Properties prop = new Properties();
 * prop.load(in); String url = prop.getProperty("url");
 * </p>
 * <p>
 * �ڶ��֣�ʹ��ServletContext��getRealPath����������ļ�����������·��path����ʹ���ֽ�����ȡpath�µ��ļ� String
 * path =
 * this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
 * String filename = path.substring(path.lastIndexOf("\\")+1);
 * //��ȵ�һ�ַ����ĺô��ǣ����˿��Ի�ȡ���ݣ������Ի�ȡ��Դ�ļ������� FileInputStream in = new
 * FileInputStream(path); Properties prop = new Properties(); prop.load(in);
 * String url = prop.getProperty("url");
 * </p>
 * �����֣�ʹ��ServletContext��getResource���������һ��url���󣬵��ø����openStream��������һ���ֽ�������ȡ����
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

	// ��һ�ַ�ʽ��ȡp1��Դ�ļ�������
	public void test11() {
		ServletContext sc = this.getServletContext();
		// ��ȡp1.properties����ļ���·��
		String path = sc.getRealPath("/WEB-INF/classes/p1.properties");
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

	// �ڶ��ַ�ʽ��ȡp1��Դ�ļ�������   ResourceBundle
	public void test21() {
		//��ȡResourceBundle����    ���������ר������ȡproperties�ļ���
		ResourceBundle bundle =  ResourceBundle.getBundle("p1");
		//��ȡ�ļ��е�����
		System.out.println(bundle.getString("value"));

	}

}
