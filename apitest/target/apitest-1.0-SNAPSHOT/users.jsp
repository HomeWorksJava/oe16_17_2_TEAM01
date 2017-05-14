<html>
    <head>
        <jsp:include page="include.jsp"></jsp:include>
            <script>
                $(document).ready(getUsers);

                function getUsers() {
                    $.get("<%= request.getContextPath()%>" + "/api/getusers", function (data) {
                        var html = '';

                        $("#userlist").html(html);

                        $.each(data, function (index, value) {

                            html += '<tr>\
                                            <td><input type="text" value="' + value.username + '" id="user' + value.id + '" /></td>\
                                            <td><input type="text" value="' + value.titulus + '" id="title' + value.id + '" /></td>\
                                            <td><input type="button" value="Módosítás" onclick="modifyUser(' + value.id + ');" />\
                                            <input type="button" value="Törlés" onclick="deleteUser(' + value.id + ');" /></td>\
                                        </tr>';
                        });

                        $("#userlist").html(html);
                    });
                }

                function deleteUser(id) {
                    // todo
                    var data = {
                        id: id
                    };

                    jQuery.ajax({
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        'type': 'POST',
                        'url': '<%= request.getContextPath()%>/api/deleteuser',
                        'data': JSON.stringify(data),
                        'dataType': 'json',
                        'success': function (data) {
                            getUsers();
                        }
                    });
                }

                function modifyUser(id) {
                    // todo
                    var data = {
                        id: id,
                        username: $("#user" + id).val(),
                        titulus: $("#title" + id).val(),
                    };

                    jQuery.ajax({
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        'type': 'POST',
                        'url': '<%= request.getContextPath()%>/api/modifyuser',
                        'data': JSON.stringify(data),
                        'dataType': 'json',
                        'success': function (data) {
                            getUsers();
                        }
                    });
                }

                function addUser() {
                    var data = {
                        username: $("#name").val(),
                        passwd: $("#pass").val(),
                        titulus: $("#title").val()
                    };

                    jQuery.ajax({
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        'type': 'POST',
                        'url': '<%= request.getContextPath()%>/api/adduser',
                        'data': JSON.stringify(data),
                        'dataType': 'json',
                        'success': function (data) {
                            getUsers();
                        }
                    });
                }
        </script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="page-wrapper" >
                <div id="page-inner">
                <%
                    if ((session.getAttribute("userName") == null) || (session.getAttribute("userName") == "")) {
                %>

                You are not logged in<br/>
                <a href="index.jsp">Please Login</a>
                <%
                } else {
                %>                
                <table>
                    <thead>
                        <tr>
                            <td>Felhasználónév</td>
                            <td>Titulus</td>
                            <td></td>                            
                        </tr>
                    </thead>
                    <tbody id="userlist">

                    </tbody>
                    <tfoot>
                    <td>Add new user</td>
                    <td>Name: <input type="text" id="name" /></td>
                    <td>Pass: <input type="text" id="pass" /></td>
                    <td>Title: <input type="text" id="title" /></td>
                    <td><input type="button" id="send" value="Hozzáad" onclick="addUser();" /></td>
                    </tfoot>
                </table>

                <div id="results"></div>

            </div>
        </div>

        <%
            }
        %>
    </body>
</html>
<script>
    $('#main-menu').find('li').removeClass('active-link');
    $($('#main-menu').find('li')[0]).addClass('active-link');
</script>