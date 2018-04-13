<%-- 
    Document   : upload
    Created on : Apr 21, 2016, 11:40:23 AM
    Author     : shikhi1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="Upload" enctype="multipart/form-data" method="post">
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name="file" value=""  />
         <input type="submit" name="upload" value="submit" class="butt"  />
    
          </form>
        
        
        <%
            if(request.getAttribute("Images")!=null)

            {%>
            <img src ="images/<%=request.getAttribute("Images")%>"/>
         <%   }
    %>
   
    </body>
</html>
