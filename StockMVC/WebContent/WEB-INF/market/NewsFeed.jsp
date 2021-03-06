<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="content-language" content="en"/>
<title>FeedEk jQuery RSS/ATOM Feed Plugin Demo | jQuery RSS/ATOM Parser Plugin FeedEk Demo</title>
<link href="${pageContext.request.contextPath}/css/FeedEk.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/FeedEk.js"></script>

<script type="text/javascript" >
    $(document).ready(function () {  
        $('#divRss').FeedEk({
            FeedUrl: 'http://feeds.finance.yahoo.com/rss/2.0/headline?s=TATASTEEL.NS&region=US&lang=en-US',
            MaxCount: 5
        });
		
        $('#divRss2').FeedEk({
            FeedUrl: 'http://feeds.finance.yahoo.com/rss/2.0/headline?s=INFY.NS&region=US&lang=en-US',
            MaxCount: 5,
			ShowDesc: true,
            ShowPubDate: false,
            DescCharacterLimit: 100
        });
		$('#divRss3').FeedEk({
            FeedUrl: 'http://rss.cnn.com/rss/edition.rss',
            MaxCount: 5,
			ShowDesc: false
        });
    });    

</script>
<style>
body{font-family:"Helvetica Neue",Helvetica,Arial,sans-serif; background-color:#efefef;font-size: 13px;line-height: 17px !important;}
.rssDiv{float:left; padding-right:35px;}
ul{width:300px !important}
</style>

</head>
<body>
<div>
<div class="rssDiv">
<p>Example<p/>
<div id="divRss"></div>
</div>
<div class="rssDiv">
<p>Example 2<p/>
<div id="divRss2"></div>
</div>
<div class="rssDiv">
<p>Example 3<p/>
<div id="divRss3"></div>
</div>
<div style="clear:both"></div>
</div>

Rss Links:
http://feeds.finance.yahoo.com/rss/2.0/headline?s=TATASTEEL.NS&region=US&lang=en-US<br/>
http://feeds.finance.yahoo.com/rss/2.0/headline?s=INFY.NS&region=US&lang=en-US<br/>
http://finance.yahoo.com/rssindex<br/>

</body>

</html>
