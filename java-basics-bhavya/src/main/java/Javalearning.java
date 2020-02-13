
	import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader; 
	
public class Javalearning {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String userName = "";
	public static void main(String args[]) throws IOException{ 
		System.out.println("1.Register \n2.Login\nEnter Choice: ");
		String choice = br.readLine();
		System.out.println(choice);
		//boolean value = false;
		switch(choice)
		{
		case "1" : 
			registration();
			break;
		case "2":
			login();
			break;
		}
       
	}

	//		main(Args[]);
		
		  
	
		 public static void registration()
		 {
			 int flagger=0;
			 Scanner in = new Scanner(System.in);
	          System.out.print("Enter your name: ");  
			String name = in.nextLine();  
			
			 String str = "";
	         
	          try {
	        	  File file = new File("src/main/java/test.txt"); 
	        	  
	        	  BufferedReader br = new BufferedReader(new FileReader(file)); 
	        	  
	        	  String cred; 
	        	  
	        	  while ((cred = br.readLine()) != null) {
	        		str =  str + cred;
	        	  }	 

			} catch (Exception e) {
				// TODO: handle exception
			}
	          //in.close();
	          String credentials[] = str.split(";");
	          for(int i=0;i<credentials.length;i++) {
	        	  String cred[] = credentials[i].split(",");
	          if(name.equals(cred[0])){
	        	  flagger = 1;
	        	  break;
	          }}
	          if(flagger==1) {
	        	  System.out.println("User is already present." +"\n" + "To register with a different username, press 1."+"\n"+"To login, press 2"+"\n"+"Press 3 to exit");
	        	  int choice = in.nextInt();
	        	  
	        	  switch(choice)
	        	  {
	        	  case 1 :
	        		  registration();
	        		  break;
	        	  case 2 : 
	        		  login();
	        		  break;
	        	  case 3:
	        		  System.out.println("Visit again soon!");
	        		  break;
	        		  
	        		  default : 
	        			  System.out.println("Invalid choice");
	        			  break;
	        	  }
	          }
			
	          
	          else {
	        System.out.print("Enter your password: ");  
			String password = in.nextLine();         
	          //in.close();
	          try{  
	        	  String str1 = name+","+password+";";
	             FileWriter fw=new FileWriter("src/main/java/test.txt",true);    
	              fw.write(str1);
	              fw.close();    
	             }catch(Exception e){System.out.println(e);} 
	          System.out.println("Registration successful");}}
		 
		 
		 
		 public static boolean login()
		 {
			 
			 Scanner in = new Scanner(System.in);
			 System.out.print("Enter your name: ");  
				String name = in.nextLine();  
		          System.out.print("Enter your password: ");
		          String password = "";
		        	  password = in.nextLine();         
		          
		        
		          String str = "";
	         
	          try {
	        	  File file = new File("src/main/java/test.txt"); 
	        	  
	        	  BufferedReader br = new BufferedReader(new FileReader(file)); 
	        	  
	        	  String cred; 
	        	  
	        	  while ((cred = br.readLine()) != null) {
	        		str =  str + cred;
	        	  }
	        	 
	        	  
//	        	    
	        	 

			} catch (Exception e) {
				// TODO: handle exception
			}
	          int flag = 0;
	          String credentials[] = str.split(";");
	          for(int i =0;i<credentials.length;i++)
	        		  {
	        	 String credit[] = credentials[i].split(",");
	        	  if(name.equals(credit[0])  && password.equals(credit[1])) {
	        		  userName = name;
		        	  flag =1;
	        		  }}
	        	  
	         if (flag == 1 ) {
	        	  System.out.println("Login successful");
	        	  System.out.println("1.Save credentials \n2.Retrieve credentials ");
//	      		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	      		String select = in.nextLine();
	      		System.out.println(select);
	      		switch(select)
	      		{
	      		case "1":
	      			savecred(userName);
	      			break;
	      		case "2":
	      			retrievecred(userName);
	      			break;
	      		default:
	      			break;
	      			
	      		}
	        	  return true;
	          }
	          else
	          {
	        	  System.out.println("Login failed");
	        	  return false;
	          }
		 }
		 
		 public static void savecred (String user)
		 {
			 int flag = 0;
			 String credname = "";
			 String credpassword = "";
			 Scanner s = new Scanner(System.in);
			 System.out.println("Which platform do you want to save credentials for?");
			 String platform = s.nextLine();
		          String str = "";
	         
	          try {
	        	  File file = new File("src/main/java/savecred.txt"); 
	        	  
	        	  BufferedReader br = new BufferedReader(new FileReader(file)); 
	        	  
	        	  String cred; 
	        	  
	        	  while ((cred = br.readLine()) != null) {
	        		str =  str + cred;
	        	  }
	        	 

			} catch (Exception e) {
			}
	          String details = "";
	          String credentials[] = str.split(";");
	          for(int i =0; i< credentials.length; i++) {
	        	  String cred[] = credentials[i].split(",");
	        	  
	        	  if(platform.equals(cred[0])&& userName.equals(cred[3]))
	        	  {
	        		 flag = 1;
	        		 break;
	        	  }
	          }
	          if(flag==1)
	          {
	        	  System.out.println("You have already registered for this platform");
	          }
	          else 
	          {
			 System.out.println("Enter your username");
			 credname = s.nextLine();
			 System.out.println("Enter your password");
			 credpassword = s.nextLine();
			 
	          
			// s.close();

	          try{  
	        	  String str1 = platform+","+credname+","+credpassword+","+user+";";
	              FileWriter fw =new FileWriter("src/main/java/savecred.txt",true);    
	              BufferedWriter bw = new BufferedWriter(fw);
	              bw.write(str1);
	              bw.close();
	              fw.close();    
	             }catch(Exception e){
//	            	 System.out.println(e);
	            	 } System.out.println("Credentials stored successfully");} 
	          }

			 public static void retrievecred(String username)
			 {
				 int flag = 0;
				 Scanner input = new Scanner(System.in);
				 System.out.print("Which platform do you want to retrieve credentials for?");  
					String platform = input.nextLine();  
			         // input.close();
			          String str = "";
		         
		          try {
		        	  File file = new File("src/main/java/savecred.txt"); 
		        	  
		        	  BufferedReader br = new BufferedReader(new FileReader(file)); 
		        	  
		        	  String cred; 
		        	  
		        	  while ((cred = br.readLine()) != null) {
		        		str =  str + cred;
		        	  }
		        	 

				} catch (Exception e) {
				}
		          String details = "";
		          String credentials[] = str.split(";");
		          for(int i =0; i< credentials.length; i++) {
		        	  String cred[] = credentials[i].split(",");
		        	  
		        	  if(platform.equals(cred[0])&& username.equals(cred[3])) {
		        		  details = "username="+cred[1]+"\npassword="+cred[2];
		        		  flag = 1;
		        		  break;}
		        	 
		        	  }System.out.println(details);
		          if(flag!=1)
		          System.out.println("You do not have credentials stored for"+platform);
		          }

		          //System.out.println(credentials[0]+credentials[1]+credentials[2]);
		          
			 }
			 
			 
			 
		 
		 

	
	