<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
function check(){
    if(document.getElementById("writer").value==""){
        alert("이름을 입력하세요");
        return;
    }
    if(document.getElementById("title").value==""){
        alert("타이틀을 입력하세요");
        return;
    }
    if(document.getElementById("content").value==""){
        alert("내용을 입력하세요");
        return;
    }
    frm.submit();
}
</script>
</head>
<body>
<h1>Edit Employee</h1>
<form:form method="POST" action="/update" name="frm">
    <table >
        <tr>
            <td>PostId : </td>
            <td>${command.getSeq()}</td>
            <td><form:hidden  path="seq" /></td>
        </tr>
        <tr>
            <td>NickName : </td>
            <td><form:input path="writer"  /></td>
        </tr>
        <tr>
            <td>Title :</td>
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td>Content :</td>
            <td><form:input path="content" /></td>
        </tr>
        <tr>
            <td>cnt :</td>
            <td><form:hidden path="cnt" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="button" value="Edit Save" onclick="check()"></td>
        </tr>
    </table>
</form:form>
</body>