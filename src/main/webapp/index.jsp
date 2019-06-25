<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%--&lt;%&ndash;<img src = "<%=basePath%>media">&ndash;%&gt;--%>
<%--&lt;%&ndash;<img src="http://localhost:8080/WebHdfs_war/orange">&ndash;%&gt;--%>
<%--<img src="<%= basePath%>media?fpath=backgroung.jpg">--%>

<%--<img src="<%= basePath%>background"/>--%>
<%--<img src="<%= basePath%>background.jpg">--%>

<img src="http://127.0.0.1:8080/media?media=/image/backgroung.jpg" >
<video width="960" height="720" controls>
  <source src="http://127.0.0.1:8080/media?media=/apple.mp4" type="video/mp4">
</video>
</body>
</html>