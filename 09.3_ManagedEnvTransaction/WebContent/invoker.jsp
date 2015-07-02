<%@ page import="emp.*"%>
<%

new EmpCreateRecords().create();
out.println("hi"+"<br>");

new EmpFetchRecords().fetch();
out.println("ha"+"<br>");

new EmpFetchRecords().fetch();
out.println("ba"+"<br>");
//new EmpUpdateDelete().updateDelete();
%>