package loginform1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


public class userlogin extends HttpServlet {
	/**
	 * 
	 */
	static ArrayList<mockusers> a1=new ArrayList<mockusers>(); 
	
	public void  init(ServletConfig config)throws ServletException
	{
		
		mockusers b1=new mockusers(101,"A","1");
		a1.add(b1);
		mockusers b2=new mockusers(102,"B","12");
		a1.add(b2);
		mockusers b3=new mockusers(103,"C","123");
		a1.add(b3);
		mockusers b4=new mockusers(104,"D","1234");
		a1.add(b4);
		mockusers b5=new mockusers(105,"E","12345");
		a1.add(b5);
		mockusers b6=new mockusers(106,"F","123456");
		a1.add(b6);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException 
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
	    mockusers usersData1 = new Gson().fromJson(body, mockusers.class);
	    System.out.println(usersData1);
	    if(usersData1==null) {
	    	String n=new Gson().toJson(a1);
	    	System.out.println(n);	    	
	    }
	    else {
	    //System.out.println(body);
	    mockusers usersData = new mockusers(0, "","");
	    PrintWriter out=response.getWriter();
	    //System.out.println(request.getParameter("id").trim());
	    usersData.id=Integer.parseInt(request.getParameter("id").trim());
		if(usersData!=null)
	    {
		for(mockusers d : a1)
			{
	    		if(d.getId()==usersData.id)
		        {
	    			usersData=d;
	    			System.out.println("Fetched");
	    			break;
		        }
		    }
				String n=new Gson().toJson(usersData);
				out.println(n);
//				String z=new Gson().toJson(a1);
//				out.println(z);
	    }
	    }
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
	    //System.out.println(usersData);
	    PrintWriter out=response.getWriter();
	    //System.out.println(usersData.getName());
	    int k=0;
	    if(usersData.getName().isEmpty()) 
		{
	    	//System.out.println();
	    	for(mockusers d : a1)
			{
	    		if((d.getId() == usersData.getId()) && (d.getPassword().equals(usersData.getPassword())))
		        {
		        k=1;
		        break;
		        }
		    }
		    if(k==1)
		    {
				System.out.println("Successful");
				String n=new Gson().toJson("Successfull");
				out.print(n);	
			}
			else
			{
				System.out.println("Unsuccessfull");
				String n=new Gson().toJson("Unsuccessfull");
				out.print(n);
			}
		}
		else
		{
		System.out.println("Added user");
	    System.out.println(usersData);
	    a1.add(usersData);
//		if(request.getParameter("id")!=null) {
//		
//		int id=Integer.parseInt(request.getParameter("id"));
//		String name=request.getParameter("name");
//		String password=request.getParameter("password");
		
//		mockusers b = new mockusers(id,name,password);
//		//JSONObject myJsonObject = new JSONObject();
//		System.out.println(b.id);
//		a1.add(b);
		String n=new Gson().toJson(a1);
		out.print(n);
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
	    mockusers usersData = new mockusers(0,"","");
	    usersData.id=Integer.parseInt(request.getParameter("id").trim());
	    PrintWriter out=response.getWriter();
		//JSONObject myJsonObject = new JSONObject();
	    for(mockusers d : a1)
		{
    		if(d.getId()==usersData.id)
	        {
    			a1.remove(d);
    			break;
	        }
	    }
		String n=new Gson().toJson("Deleted");
		System.out.println(a1);
		out.print(n);
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
	    int i=0;
	    for(mockusers d : a1)
		{
    		if(d.getId()==usersData.getId())
	        {
    			a1.set(i, usersData);
    			System.out.println("Successfully Updated");
    			break;
	        }
    		i++;
	    }
	    System.out.println(a1);
		PrintWriter out=response.getWriter();
		String n=new Gson().toJson(usersData);
		out.print(n);
//		}		
	}
	
}
