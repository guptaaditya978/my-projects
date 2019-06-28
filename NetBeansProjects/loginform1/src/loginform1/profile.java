package loginform1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;


public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;    
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
		// TODO Auto-generated method stub
   		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
//		StringBuilder stringBuilder = new StringBuilder();
//	    BufferedReader bufferedReader = null;
//	    try {
//	        InputStream inputStream = request.getInputStream();
//	        if (inputStream != null) {
//	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//	            char[] charBuffer = new char[128];
//	            int bytesRead = -1;
//	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
//	                stringBuilder.append(charBuffer, 0, bytesRead);
//	            }
//	        } else {
//	            stringBuilder.append("");
//	        }
//	    } catch (IOException ex) {
//	        throw ex;
//	    } finally {
//	        if (bufferedReader != null) {
//	            try {
//	                bufferedReader.close();
//	            } catch (IOException ex) {
//	                throw ex;
//	            }
//	        }
//	    }
//
//	    String body = stringBuilder.toString();
//	    mockusers usersData1 = new Gson().fromJson(body, mockusers.class);
//	    System.out.println(usersData1);
//	    System.out.println(body);
	    mockusers usersData = new mockusers(0, "","","","","");
	    //System.out.println(request.getParameter("id").trim());
	    //usersData.id=Integer.parseInt(request.getParameter("id").trim());
	    
	    	session=request.getSession(false);
	    	
	    	System.out.println(session!=null);
	    	System.out.println((session.getAttribute("logid")));
	    	usersData.id=(int) session.getAttribute("logid");
	    	if(session!=null)
			{
				try 
				{
				Class.forName("com.mariadb.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/userlogin", "root", "root");
				Statement stmt = conn.createStatement();
				Base64.Decoder decoder = Base64.getDecoder(); 
				String sqlStr = "select * from users where id='"+usersData.id+"'";  
				ResultSet rs = stmt.executeQuery(sqlStr); 
				byte[] actualByte;
				while(rs.next())
				{  
			         usersData.id  = rs.getInt("id");
			         usersData.name = rs.getString("username");
			         usersData.gender = rs.getString("gender");
			         usersData.mobile = rs.getString("mobile");
			         usersData.email = rs.getString("email");
			         
			         actualByte= decoder.decode(rs.getString("password"));
			         String dstr= new String(actualByte);;
			         usersData.password=dstr;
			         System.out.println("Fetched from database");
			         String n=new Gson().toJson(usersData);
			         out.println(n);
			         System.out.println(n);
				}
				conn.close();
				}
				catch(Exception e)
				{
				System.out.println("database not connected");
				}
			}
			else
			{
				System.out.print("Session not present");
			}
			
	}
}


