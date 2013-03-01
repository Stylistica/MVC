<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.*"  import="java.util.ArrayList"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello</title>
</head>
<body> 
Hello
<% out.println(request.getAttribute("ps"));
ArrayList styles = (ArrayList) request.getAttribute("s");
Iterator it = styles.iterator();
while(it.hasNext())
{
	  out.print("<br>User: " + it.next());
}  %>
</body>
</html>