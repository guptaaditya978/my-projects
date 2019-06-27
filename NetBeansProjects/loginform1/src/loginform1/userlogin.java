package loginform1;

import java.io.BufferedReader;
import java.util.Base64;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import java.sql.*;

public class userlogin extends HttpServlet {
	/**
	 * 
	 */
	HttpSession session;
	
//	public void  init(ServletConfig config)throws ServletException
//	{
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin", "root", "root");
//			Statement stmt = conn.createStatement();
//			String sqlStr = "select * from users";  
//			ResultSet rs = stmt.executeQuery(sqlStr); 
//			int id;
//			String str;
//			String username;
//			String password;
//			while(rs.next()){
//		         
//		         id  = rs.getInt("id");
//		         username = rs.getString("username");
//		         str=rs.getString("password");
//		         password= rs.getString("password");
//		         System.out.println(id+username+password);
//		         System.out.println();
//		         }
//			conn.close();
//		}
//		catch(Exception e)
//		{
//			System.out.println("database not connected");
//		}
//				
//	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException 
	{	
//		response.setContentType("text/html");
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException 
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
    	 System.out.println("session" + request.getSession(false)==null);
	    {
	    	
	    	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin", "root", "root");
				stmt = conn.createStatement();
				Base64.Encoder encoder = Base64.getEncoder();
				String str= encoder.encodeToString(usersData.password.getBytes());  
				System.out.println(str+ usersData.id);
				String sqlStr = "Select * from users WHERE id='"+usersData.id+"' && password='"+str+"'";  
				ResultSet rs = stmt.executeQuery(sqlStr);
				//System.out.println(rs.getRow());
				//System.out.println(rs.next());
				//System.out.println(rs.getInt("id"));
				
				if(rs.next())
				{
					session =request.getSession(true);  
			        int i=rs.getInt("id");
					session.setAttribute("logid", i);
			        usersData.id=rs.getInt("id");
			        //System.out.println(request.getSession(false)==null);
					System.out.println("Successful");
					String r=Integer.toString(rs.getInt("id"));
					//Cookie usercookie = new Cookie("id",r);
					//response.addCookie(usercookie);
					String n=new Gson().toJson("Successfull");
					out.print(n);	
				}
				else {
					System.out.println("Unsuccessfull");
					String n=new Gson().toJson("Unsuccessfull");
					out.print(n);	
				}
				System.out.println(session.getAttribute("logid"));
				System.out.println("session1" + request.getSession(false)==null);
				conn.close();	
			}
			catch(Exception e)
			{
				System.out.println("database not connected");
			}
		}
		
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response)throws IOException
	{
//		StringBuilder stringBuilder = new StringBuilder();
//	    BufferedReader bufferedReader = null;
//
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
	    mockusers usersData = new mockusers(0,"","","","","");
	    //usersData.id=Integer.parseInt(request.getParameter("id").trim());
	    PrintWriter out=response.getWriter();
		//JSONObject myJsonObject = new JSONObject();
	    if(request.getSession(false)!=null)
	    {
	    
	    try {
	    	int i=(int)request.getSession(false).getAttribute("logid");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin", "root", "root");
			Statement stmt = conn.createStatement();
			String sqlStr = "delete from users where id='"+i+"'";  
			stmt.executeUpdate(sqlStr); 
			System.out.println("Deleted Succesfully");
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("database not connected");
		}
	    }
		//String n=new Gson().toJson("Deleted");
		//System.out.println(a1);
		//out.print(n);
}
	
	public void doPut(HttpServletRequest request, HttpServletResponse response)throws IOException
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
	    //System.out.println(usersData);
	    //int index=
	    //if(a1.contains(usersData.id))
	    	//int index=a1.indexOf(usersData.id);
	    if(request.getSession(false)!=null)
	    {
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin", "root", "root");
			Statement stmt = conn.createStatement();
			Base64.Encoder encoder = Base64.getEncoder();
			String str= encoder.encodeToString((usersData.password).getBytes());  
			System.out.println(str);
			String sqlStr = "Update users set username='"+usersData.name+"', gender='"+usersData.gender+"', password='"+str+"', mobile='"+usersData.mobile+"', email='"+usersData.email+"'where id='"+usersData.id+"'";  
			stmt.executeUpdate(sqlStr); 
			System.out.println("Updated Succesfully");
			PrintWriter out=response.getWriter();
			String n=new Gson().toJson(usersData);
			out.print(n);
			conn.close();
	    }
		catch(Exception e)
		{
			System.out.println("database not connected");
		}
	    }
//		}		
	}
	
}
