<%@ page import="java.sql.*"%>
<%
    String userName = request.getParameter("userName");   
    String password = request.getParameter("password");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","");
    Statement st = con.createStatement();
    ResultSet rs;
    
    rs = st.executeQuery("select * from users where username='" + userName + "' and passwd='"+password+"'");
    
    if (rs.next()) {
        session.setAttribute("userid", rs.getInt("id"));
        session.setAttribute("userName", rs.getString("username"));
        session.setAttribute("password", rs.getString("passwd"));
        session.setAttribute("titulus", rs.getString("titulus"));
        response.sendRedirect("users.jsp");
    } else {
        out.println("Invalid password <a href='index.jsp'>try again</a>");
    }
%>