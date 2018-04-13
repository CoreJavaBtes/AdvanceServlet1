package pkg;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

public String name;
Connection con;        
 Statement st;
 ResultSet rs; 
 PreparedStatement pst;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  try (PrintWriter out = response.getWriter()) {
		         
		        try
		        {
		        	out.print("hello");
		            
		        String UPLOAD_DIRECTORY = "D://Sipika Data backup/Drive E/EclipseExamples/SampleUploadDownloadPic/WebContent/images";
		        response.setContentType("text/html;charset=UTF-8");      
		            if(ServletFileUpload.isMultipartContent(request)){
		            	out.print("hello1111");
		                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		            	out.print("hello2222");
		                for(FileItem item : multiparts){
		                    if(!item.isFormField()){
				            	out.print("hell03333");
		                        name = new File(item.getName()).getName();
		                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
		                        String fp1=UPLOAD_DIRECTORY.replace("\\" ,"/");
		 		               	fp1=fp1+"/"+name;
		 		               	System.out.println("1111111111");
		 		              
		                        out.print(name);
		                        System.out.print("my file::"+name);
		                         request.setAttribute("Images", name);
		                RequestDispatcher req = request.getRequestDispatcher("/upload.jsp");
		                
		                req.include(request, response); 
		                    }
		                }
		               
		                
		            }
		              /*  Class.forName("com.mysql.jdbc.Driver");
		           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/morph_hub","root","root"); 
		               String fp1=UPLOAD_DIRECTORY.replace("\\" ,"/");
		               fp1=fp1+"/"+name;
		               System.out.println("1111111111");
		               st=con.createStatement();
		               try {
		               //String query = "cat "+fp1+"|awk '{print $1,$2,$3,$4,$5,$6,$7,$8,$9,$10,$11,$12,$13}'>new_file.txt";
		               //st.executeUpdate(query);
		               System.out.println("1111111111");               
		               String query1 = "LOAD DATA INFILE '"+fp1+"'  INTO TABLE register"; //(rid,batch_code, @dummy, column3, @dummy,column4, @dummy,column5, @dummy,column6, @dummy,column7, @dummy,column8, @dummy,column9, @dummy,column10, @dummy,column11, @dummy,column12, @dummy,column13)
		               st.executeUpdate(query1);
		               }
		               catch( Exception e){System.out.println(e);}
		               System.out.println("1111111111");
		               request.setAttribute("message", "File Uploaded Successfully");
		               request.setAttribute("filename", name);
		               
		               RequestDispatcher rd  = request.getRequestDispatcher("home.jsp");
		               rd.forward(request, response);
		            } catch (Exception ex) {
		               request.setAttribute("message", "File Upload Failed due to " + ex);
		            }          
		         
		        }else{
		           out.println("fail");
		        }*/
		             
		        }
		            catch(Exception e){
		            	
		            	System.out.println(e);
		        
		        } finally {    
		                
		            
		            out.close();
		        }
		         
		        }
		    
		  

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
