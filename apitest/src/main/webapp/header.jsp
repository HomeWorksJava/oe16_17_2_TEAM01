<% 
    if ((session.getAttribute("userName") == null) || (session.getAttribute("userName") == "")) {
%>
You're not logged in!
<%
    } else {
%>
  Welcome 
<%=session.getAttribute("userName")%>|
<a href='logout.jsp'>Log out</a>
<!-- page content goes here -->
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li>
                <a href="users.jsp">FELHASZN�L�K</a>
            </li>
            <li>
                <a href="research.jsp">KUTAT�S</a>
            </li>
            <li>
                <a href="documents.jsp">DOKUMENTUMOK</a>
            </li>
        </ul>
    </div>

</nav>

<%
    }
%>