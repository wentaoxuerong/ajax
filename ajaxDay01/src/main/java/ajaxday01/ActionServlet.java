/**
 * 
 */
package ajaxday01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author wentao
 */
public class ActionServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("servive(");
		String uri=req.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println(action);
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		if("/check".equals(action)) {
			String adminCode=req.getParameter("adminCode");
			System.out.println(adminCode);
			if("king".equals(adminCode)) {
				out.println("账号一存在");
			}else {
				out.println("账号可用");
			}
		}else if("/Random".equals(action)){
			Integer i= new Random().nextInt(10);
			out.println(i);
		}
		
	}

}
