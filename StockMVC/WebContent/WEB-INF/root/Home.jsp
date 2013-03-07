<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome main page
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


</body>
</html>