import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;


public class authenticate extends HttpServlet {          

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

        
            String m_url = "jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
            String m_driverName = "oracle.jdbc.driver.OracleDriver";

            String m_userName = "rtwong";
            String m_password = "rtwong1234";

            String queryString;
            String l_login;
            String l_password;
            
            Statement stmt;
            Connection m_con;

            String actual_pass = null;
            String print_out = null;

            try {
                Class drvClass = Class.forName(m_driverName);
                DriverManager.registerDriver((Driver) drvClass.newInstance());
            } catch(Exception e) {
                System.err.print("ClassNotFoundException: ");
                System.err.println(e.getMessage());
            }
		
            l_login = request.getParameter("login");
	    l_password = request.getParameter("password");
            queryString = "select password from users u where u.user_name = '" + l_login + "'";
            try {
                m_con = DriverManager.getConnection(m_url, m_userName, m_password);
                stmt = m_con.createStatement();
                ResultSet rset = stmt.executeQuery(queryString);
                while(rset.next()) {
                    actual_pass = rset.getString(1);
                }
                if (actual_pass.equals(l_password)) {
                    print_out = "Accepted! " + actual_pass;
                } else {
                    print_out = "Denied. ";
                }
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			"Transitional//EN\">\n" +
			"<HTML>\n" +
			"<HEAD><TITLE>Temp Authentication Page</TITLE></HEAD>\n" +
			"<BODY>\n" +
			"<H1>" +
			print_out + 
			"</H1>\n" +
			"</BODY></HTML>");
            } catch(Exception e) {
                System.err.print("I'm adopted. ");
                System.err.println(e.getMessage());
            }




	}

}
