<%--<%@page pageEncoding="utf-8" contentType="text/html; ISO-8859-1" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="css/pagestudent.css">
<ul style="width: 1200px;text-decoration: none">
    <li><a href="liststudentsbypage.jsp?page=1">首页</a></li>
    <%
        if (currentPage!=1){
    %> <li><a href="liststudentsbypage.jsp?page=<%=currentPage-1%>">上一页</a></li>
    <%
        }
    %>
   <%
       if (currentPage!=pageutil.getMaxPage()){
   %>
    <li><a href="liststudentsbypage.jsp?page=<%=currentPage+1%>">下一页</a></li>
    <%
        }
   %>

    <li><a href="liststudentsbypage.jsp?page=<%=pageutil.getMaxPage()%>">尾页</a></li>
    <li style="width:200px">
        <form action="liststudentsbypage.jsp" method="post">
            跳转到<select name="page" id="selectPage">
                <option>请选择</option>
        </select>
<%--            <input type="text" name="jumptopage" size="2">页--%>
            <input type="submit" value="跳转" name="submit">
        </form>

    </li>
</ul>
<script>
    function insertPage(element,maxPge){
        for (i=1;i<maxPge;i++){
            element.options.add(new Option(i,i))
        }
    }
    insertPage(document.getElementById("selectPage"),"<%=pageutil.getMaxPage()%>")
</script>

<%
    int pageSize2=5;
    for (int i=1;i<pageSize2;i++){
%>
<a href="liststudentsbypage.jsp?page=<%=i%>"><%=i%></a>
<%
    }
%>