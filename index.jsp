<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<html>
    <head>
        <title>Index File</title>
    </head>
    <body>
        <%
        //HttpSession session = request.getSession(true);
        if (!request.isRequestedSessionIdValid()){
            out.print("Appropriate authorization required. adopted"); 
            return;
        }
        String auth = (String) session.getAttribute("class");
        %>
	<% 
        if(auth.equals("a")) {
        %>
        <a href="search.jsp">Search<br></a>
        <a href="analysis.jsp">Analysis<br></a>
        <a href="recordpage.jsp">Report Generation<br></a>
        <a href="usermanage.jsp">User Management<br></a>
        <form name="logout" method="POST" action= "logout">
        <input name= ".submit" type="submit" value="Logout"></td></tr>
        </form>
        <% 
        } 
        else if(auth.equals("r")) {
        %>
        <a href="search.jsp">Search<br></a>
        <a href="uploadrecord.jsp">Upload a Record<br></a>
        <a href="upload.jsp">Upload an Image<br></a>
        <form name="logout" method="POST" action= "logout">
        <input name= ".submit" type="submit" value="Logout"></td></tr>
        </form>
        <%            
        }
        else if(auth.equals("d") || auth.equals("p")) {
        %>
        <a href="search.jsp">Search<br></a>
        <form name="logout" method="POST" action= "logout">
        <input name= ".submit" type="submit" value="Logout"></td></tr>
        </form>
        <%            
        }
        else {
            out.print("Appropriate authorization required.");     
        }
        %>


    </body>
</html>        
