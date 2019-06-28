package loginform1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import loginform1.mockusers;

public class signup extends HttpServlet {
	HttpSession session;
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		session=request.getSession(false);
		//String n=(String)session.getAttribute("id");
		System.out.println(session==null);
	   if(session!=null) {
			try {
				request.getSession(false).invalidate(); 
				System.out.println("logout ho gaya");
			}
			catch(Exception e)
			{
				System.out.println("nhi hua logout");
			}
		
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StringBuilder stringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = null;

	    try {
	        InputStream inputStream = request.getInputStream();
	        if (inputStream != null) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
	        } else {
	            stringBuilder.append("");
	        }
	    } catch (IOException ex) {
	        throw ex;
	    } finally {
	        if (bufferedReader != null) {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {
	                throw ex;
	            }
	        }
	    }

	    String body = stringBuilder.toString();
	    mockusers usersData = new Gson().fromJson(body, mockusers.class);
	    System.out.println(usersData);
	    PrintWriter out=response.getWriter();
	    //System.out.println(usersData.getName());
	    Connection conn= null;
    	Statement stmt = null;
    	 System.out.println(request.getSession(false)==null);
	    if(request.getSession(false)==null)
	    {
			try {
				Class.forName("com.mariadb.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/userlogin","root","root");
				stmt = conn.createStatement();
				Base64.Encoder encoder = Base64.getEncoder();
				String str= encoder.encodeToString(usersData.password.getBytes());  
				String sqlStr = "insert into users(id,username,gender,password,mobile,email)values('"+usersData.id+"','"+usersData.name+"','"+usersData.gender+"','"+str+"','"+usersData.mobile+"','"+usersData.email+"')";
				stmt.executeUpdate(sqlStr);
				System.out.println("Suscessfully added");
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}

}
