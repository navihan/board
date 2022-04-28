<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Employee</h1>
    <table >
        <tr>
            <td>PostId : </td>
            <td>${command.getSeq()}</td>
        </tr>
        <tr>
            <td>NickName : </td>
            <td>${command.getWriter()}</td>
        </tr>
        <tr>
            <td>Title :</td>
            <td>${command.getTitle()}</td>
        </tr>
        <tr>
            <td>Content :</td>
            <td>${command.getContent()}</td>
        </tr>
        <tr>
            <td>cnt :</td>
            <td>${command.getCnt()}</td>
        </tr>
        <tr>
            <td> </td>
            <td><a href="/">리스트 돌아가기</a></td>
        </tr>
    </table>
