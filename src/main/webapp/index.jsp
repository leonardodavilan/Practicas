<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:p="http://primefaces.org/ui">
<h:head>
    <title>JSP - Hello World</title>
</h:head>

<h:body>
    <p:spinner />
    <h1><%= "Hello World!" %>
    </h1>
    <br/>
    <a href="hello-servlet">Hello Servlet</a>
</h:body>
</html>