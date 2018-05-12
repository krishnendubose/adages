<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Web Service Test with JSP and Servlet</h2>
<jsp:useBean id="cmdbService" type="cmdb.service.CMDBService" class="cmdb.service.CMDBService">
<% String method=request.getMethod();
cmdbService.setSctx(application);
cmdbService.populateDataFromFile();
if(!method.equals("GET")){
	response.sendError(response.SC_METHOD_NOT_ALLOWED,"Only Get is allowed");	
	
}
else{
	
	out.println(cmdbService.getDeploymentDetails(2));
}
%>
</jsp:useBean>
</body>
</html>