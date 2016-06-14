<%--
  Created by IntelliJ IDEA.
  User: mlhuang
  Date: 5/4/16
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>javascript test</title></head>
<script language="JavaScript">
    function checkIt() {
        var theForm;
        theForm = document.teachForm;
        if (theForm.name.value == "") {
            alert("name！");
            document.teachForm.name.focus();
            return false;
        }
        if (theForm.age.value == "") {
            alert("age！");
            document.teachForm.age.focus();
            return false;
        }
        if (theForm.name.value == "") {
            alert("note！");
            theForm.name.focus();
            return false;
        }
        theForm.submit();
    }
</script>
<body>
<center>
    <h1>个人信息登记表</h1>
    <hr>
    <form name="teachForm" action="/js" method="get">
        <table>
            <tr>
                <td><b>name</b></td>
                <td><input type="text" name="name" size="20"></td>
            </tr>
            <tr>
                <td><b>age</b></td>
                <td><input type="text" name="age" size="20"></td>
            </tr>
            <tr>
                <td><b>note</b></td>
                <td><input type="text" name="note" size="20"></td>
            </tr>
        </table>
        <p align="center">
            <input type="button" value="提交" name="Submit" onclick="checkIt()">
        </p>
    </form>
</center>
</body>

${name}
${note}
</html>
