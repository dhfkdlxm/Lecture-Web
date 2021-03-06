package kr.ac.kopo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MethodServlet extends HttpServlet {

	// GET http://localhost:9999/Lecture-Web/method?id=aaa

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getMethod();

		// url을 가져오는 메소드~
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		String id = request.getParameter("id");

		// client 에게 응답
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();// 응답을 해주려면 IO가 필요하고, IO를위해서 response객체에 getWrite()를 얻어옴!
		out.println("<html>");
		out.println("		<head>");
		out.println("		  		<title>메소드 호출방식</title>");
		out.println("		</head>");
		out.println("		<body>");
		out.println("============================================<br>");
		out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;요 청 결 과<br>");
		out.println("파라미터(id)  : " + id + "<br>");
		out.println("요청 방식 :  " + method + "<br>");
		out.println("요청 uri :  " + uri + "<br>");
		out.println("============================================<br>");
		out.println("============================================<br>");
		out.println("		</body>");
		out.println("</html>");

		out.flush();
		out.close();

		/*
		 * System.out.println("사용자가 입력한 ID 는 : " + id); System.out.println("method : " +
		 * method); System.out.println("URL : " + url.toString());
		 * System.out.println("URI : " + uri);
		 */

	}

}
