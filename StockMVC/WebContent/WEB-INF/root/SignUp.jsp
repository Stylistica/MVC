<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="org.sqlite.*" %>
 
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
Root Pages<br/>
<a href="<%=request.getContextPath()%>/Error">Error</a>

<a href="<%=request.getContextPath()%>/AboutUs.do">about us</a>

<a href="<%=request.getContextPath()%>/SignUp.do">Sign Up</a>

<a href="<%=request.getContextPath()%>/Home.do">Home</a>
<br/>Analysis pages<br/>

<a href="<%=request.getContextPath()%>/analysis/Welcome.do">Analysis Home</a>

<a href="<%=request.getContextPath()%>/analysis/ML.do">Analysis ML</a>

<a href="<%=request.getContextPath()%>/analysis/TweetAnalysis.do">Analysis Tweet</a>
<br/>
Market<br/>
<a href="<%=request.getContextPath()%>/market/MarketTwitter.do">Market Tweet</a>
<a href="<%=request.getContextPath()%>/market/NewsFeed.do">News Feed</a>
<a href="<%=request.getContextPath()%>/market/ViewMarket.do">Market View</a>
<a href="<%=request.getContextPath()%>/market/Welcome.do">Market Home</a>
<br/>trading<br/>

<a href="<%=request.getContextPath()%>/trading/List.do">List</a>
<a href="<%=request.getContextPath()%>/trading/PortfolioAnalysis.do">Portfolio analysis</a>
<a href="<%=request.getContextPath()%>/trading/Trade.do">Trade</a>
<a href="<%=request.getContextPath()%>/trading/WelcomeTrading.do">Trade Home</a>
<table>
            <thead>
                <tr>
                    <th>Item No.</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
            <%
                Class.forName("org.sqlite.JDBC");
                Connection conn =
                		DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Avva\\git\\MVC\\StockMVC\\stock.db");
                PreparedStatement stat = conn.prepareStatement("select amount from user where userID= ?");
                stat.setInt(1,2);
                //stat.executeUpdate("create table person1 (id integer, name string)");
      	      	//stat.executeUpdate("insert into person values(1, 'leo1')");
      	      	//stat.executeUpdate("insert into person values(2, 'leo2')");
      	      
                ResultSet rs = stat.executeQuery();
 
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("amount") + "</td></tr>");
                }
 
                rs.close();
                conn.close();
               
            %>
            </tbody>
        </table>
   
</body>
</html>