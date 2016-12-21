package bitcamp.java89.ems2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java89.ems2.dao.impl.ManagerMysqlDao;
import bitcamp.java89.ems2.dao.impl.MemberMysqlDao;
import bitcamp.java89.ems2.dao.impl.StudentMysqlDao;
import bitcamp.java89.ems2.dao.impl.TeacherMysqlDao;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>애플리케이션 오류</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>오류 내용</h1>");
    //상세한 오류내용을 출력한다.
    Exception excetion = (Exception)request.getAttribute("error");
    if(excetion != null){
    out.printf("<pre>%s</pre>",excetion.getMessage());
    out.println("<pre>");
    excetion.printStackTrace(out);
    out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
      
  }
}