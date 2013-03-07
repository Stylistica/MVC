<% 
   response.setHeader("Cache-Control","no-store");
   response.setHeader("Pragma","no-cache"); 
   response.setDateHeader ("Expires", 0);  
   %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="org.sqlite.*" %>
<%@page import="model.DbConnection" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Sign Up<br/>
Enter details
<br/><br/><br/>
Root Pages -->
<a href="<%=request.getContextPath()%>/Error">Error</a>

<a href="<%=request.getContextPath()%>/AboutUs.do">about us</a>

<a href="<%=request.getContextPath()%>/SignUp.do">Sign Up</a>

<a href="<%=request.getContextPath()%>/Home.do">Home</a>
<br/>Analysis pages -->

<a href="<%=request.getContextPath()%>/analysis/Welcome.do">Analysis Home</a>

<a href="<%=request.getContextPath()%>/analysis/ML.do">Analysis ML</a>

<a href="<%=request.getContextPath()%>/analysis/TweetAnalysis.do">Analysis Tweet</a>
<br/>
Market -->
<a href="<%=request.getContextPath()%>/market/MarketTwitter.do">Market Tweet</a>
<a href="<%=request.getContextPath()%>/market/NewsFeed.do">News Feed</a>
<a href="<%=request.getContextPath()%>/market/ViewMarket.do">Market View</a>
<a href="<%=request.getContextPath()%>/market/Welcome.do">Market Home</a>
<br/>trading -->

<a href="<%=request.getContextPath()%>/trading/List.do">List</a>
<a href="<%=request.getContextPath()%>/trading/PortfolioAnalysis.do">Portfolio analysis</a>
<a href="<%=request.getContextPath()%>/trading/Trade.do">Trade</a>
<a href="<%=request.getContextPath()%>/trading/WelcomeTrading.do">Trade Home</a>

 <table>
        
   	  <script type="text/javascript">
         function validateLoginForm()
         {
         	var w=document.forms["LoginForm"]["LoginName"].value;
         	var x=document.forms["LoginForm"]["LoginPassword"].value;
         	if (w==null || w=="" || x==null ||x=="")
         	  {
         	  alert("Please fill-in all the Enteries");
         	  return false;
         	  }
         	else
				{
         		
         		alert(x);
				alert(w);return true;

				return true;
				}
         	
			}
         function validateSignUpForm()
         {

         	var a=document.forms["SignUpForm"]["Name"].value;
         	var b=document.forms["SignUpForm"]["Email"].value;
         	var c=document.forms["SignUpForm"]["LoginName"].value;
         	var d=document.forms["SignUpForm"]["Password"].value;
         	
         	if (a==null ||a==""|| b==null ||b==""|| c==null ||c==""|| d==null ||d=="" )
             	  {
         	  alert("Please fill-in all the Enteries");
         	  return false;
         	  }
         	else
				{
				alert(a);
				alert(b);
				alert(c);
				alert(d);
				}
         	
         
         }
         
         
         
      </script><br/>
Sign In PageLoginName

	<form id="LoginForm" name="LoginForm" method="post" onsubmit="return validateLoginForm()" action="SIP.do">
			LoginName: <input id="Email" name="Email" type="text" size="50" maxlength="50" /><br/>
            Password: <input  id="Password" name="Password" type="password" size="50" maxlength="50" /><br/>
			<input type="submit" value="submit" />
	</form>
Sign Up Page
	<form id="SignUpForm" name="SignUpForm" method="post" onsubmit="return validateSignUpForm()"action="SUP.do" >
            Name:<input  id="Name" name="Name" type="text" size="50" maxlength="50" /><br/>
            Email <input  id="Email" name="Email" type="text" size="50" maxlength="50" /><br/>
            Password<input  id="Password"name="Password" type="password" size="50" maxlength="50" /><br/>
			<input type="submit" value="submit" />
	</form>

</body>
</html>