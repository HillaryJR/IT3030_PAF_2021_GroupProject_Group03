package authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userLogin {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gatget_badget_userservice?useSSL=false", "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String userLoginview(String username, String password,String type) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			// output = "<table border='1'><tr><th>User ID</th><th>User Name</th>" +"<th>Password</th>" +"<th> Gmail</th>" +"<th>Address</th>"+"<th>DOB</th>" + "<th>phone</th>" +"<th>description</th>" + "<th>profile Information</th></tr>";
			
			if (type.equals("consumer") || type.equals("Consumer")) {
				
				String query ="select userID,userName,password,email,address,dob,phone from consumer where userName= '"+username+"'AND password= '"+password+"' ";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				ResultSet rs = ((java.sql.Statement) preparedStmt).executeQuery(query);
				
				
				  while (rs.next()) {
					    String userID = Integer.toString(rs.getInt("userID"));
				        String UserName = rs.getString("userName");
				        String Password = rs.getString("password");
				        String Email = rs.getString("email");
				        String Address = rs.getString("address");
				        String Dob =rs.getString("dob");
				        String phone =rs.getString("phone");
				        
				       /* output += "<tr><td>" + userID + "</td>";
				   	 	output += "<td>" + UserName + "</td>";
				   	 	output += "<td>" + password + "</td>";
				   	 	output += "<td>" + Email + "</td>";
				   	 	output += "<td>" + Address + "</td>";
				   	 	output += "<td>" + Dob + "</td>";
				   	 	output += "<td>" + phone + "</td>";*/
				         
				        
				  
				        if((username.equals(UserName)) && (password.equals(Password))) {
				        	//output ="     Login Failed  !!";
				        	output ="     Login Successful  !!           You're logged as "   +username;
				        	/*output += "<br><br><table border='1'><tr><th>User ID</th><th>User Name</th>" +"<th>Password</th>" +"<th> Gmail</th>" +"<th>Address</th>"+"<th>DOB</th>" + "<th>phone</th></tr>";
				        	output += "<tr><td>" + userID + "</td>";
						   	output += "<td>" + UserName + "</td>";
						   	output += "<td>" + password + "</td>";
						   	output += "<td>" + Email + "</td>";
						   	output += "<td>" + Address + "</td>";
							output += "<td>" + Dob + "</td>";
						   	output += "<td>" + phone + "</td>";	*/
				        
				        }
			              else {
			                output ="      Login Failed...!!";
			              	} 
				  	}
				
				con.close();
				
			}
			if (type.equals("manufacturer") || type.equals("Manufacturer")) {
				
				String query ="select manufacturerID,userName,password,email,address,dob,phone,manufacturer.desc from manufacturer where userName= '"+username+"'AND password= '"+password+"' ";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				ResultSet rs = ((java.sql.Statement) preparedStmt).executeQuery(query);
				
				
				  while (rs.next()) {
					    String userID = Integer.toString(rs.getInt("manufacturerID"));
				        String UserName = rs.getString("userName");
				        String Password = rs.getString("password");
				        String Email = rs.getString("email");
				        String Address = rs.getString("address");
				        String Dob =rs.getString("dob");
				        String phone =rs.getString("phone");
				        String desc = rs.getString("desc");
				        
				  
				        if((username.equals(UserName)) && (password.equals(Password))) {
				        	//output ="     Login Failed  !!";
				        	output ="     Login Successful  !!           You're logged as "   +username;
				        	/*output += "<br><br><table border='1'><tr><th>User ID</th><th>User Name</th>" +"<th>Password</th>" +"<th> Gmail</th>" +"<th>Address</th>"+"<th>DOB</th>" + "<th>phone</th>" + "<th>description</th></tr>";
				        	output += "<tr><td>" + userID + "</td>";
						   	output += "<td>" + UserName + "</td>";
						   	output += "<td>" + password + "</td>";
						   	output += "<td>" + Email + "</td>";
						   	output += "<td>" + Address + "</td>";
							output += "<td>" + Dob + "</td>";
						   	output += "<td>" + phone + "</td>";	
							output += "<td>" + desc + "</td>";	*/
				        	}
			              else {
			                output ="      Login Failed...!!";
			            	 //output ="     Login Successful  !!           You're logged as"   +username;
			              	} 
				  	}
				
				con.close();
			}
			if (type.equals("researcher") || type.equals("Researcher")) {
				
				String query ="select researcherID,userName,password,email,address,dob,phone,profileInfo from researcher where userName= '"+username+"'AND password= '"+password+"' ";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				ResultSet rs = ((java.sql.Statement) preparedStmt).executeQuery(query);
				
				
				  while (rs.next()) {
					    String userID = Integer.toString(rs.getInt("researcherID"));
				        String UserName = rs.getString("userName");
				        String Password = rs.getString("password");
				        String Email = rs.getString("email");
				        String Address = rs.getString("address");
				        String Dob =rs.getString("dob");
				        String phone =rs.getString("phone");
				        String profileInfo = rs.getString("profileInfo");
				        
				  
				        if((username.equals(UserName)) && (password.equals(Password))) {
				        	//output ="     Login Failed  !!";
				        	output ="     Login Successful  !!           You're logged as "   +username;
				        /*	output += "<br><br><table border='1'><tr><th>User ID</th><th>User Name</th>" +"<th>Password</th>" +"<th> Gmail</th>" +"<th>Address</th>"+"<th>DOB</th>" + "<th>phone</th>" + "<th>profile Information</th></tr>";
				        	output += "<tr><td>" + userID + "</td>";
						   	output += "<td>" + UserName + "</td>";
						   	output += "<td>" + password + "</td>";
						   	output += "<td>" + Email + "</td>";
						   	output += "<td>" + Address + "</td>";
							output += "<td>" + Dob + "</td>";
						   	output += "<td>" + phone + "</td>";	
							output += "<td>" + profileInfo + "</td>";	*/
				        	}
			              else {
			                output ="      Login Failed...!!";
			            	 //output ="     Login Successful  !!           You're logged as"   +username;
			              	} 
				  	}
				
				con.close();
			}
			
		}catch (Exception e) {
			output = "Error while Logging.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
}