<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%
        //request, response 그냥 사용 가능, jsp 는 어차피 서블릿으로 변경된다.
         MemberRepository memberRepository = MemberRepository.getInstance();
         List<Member> members = memberRepository.findAll();
%>

<html>
<head>
 <meta charset="UTF-8">
 <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
 <thead>
 <th>id</th>
 <th>username</th>
 <th>age</th>
 </thead>
 <tbody>
<%
 for (Member member : members) {
 out.write(" <tr>");
 out.write(" <td>" + member.getId() + "</td>");
 out.write(" <td>" + member.getUsername() + "</td>");
 out.write(" <td>" + member.getAge() + "</td>");
 out.write(" </tr>");
 }
%>
 </tbody>
</table>
</body>
</html>
