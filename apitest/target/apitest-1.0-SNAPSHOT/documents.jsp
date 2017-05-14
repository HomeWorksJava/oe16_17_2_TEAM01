<html>
    <head>
        <jsp:include page="include.jsp"></jsp:include>
            <script>

                $.get("<%= request.getContextPath()%>" + "/api/getusers", function (data) {
                    var html = '';

                    $.each(data, function (index, value) {
                        html += '<option value="' + value.id + '">' + value.username + '</option>';
                    });
                    $("#userlist").html(html);
                });

                function getList() {
                    // todo
                    var data = {
                        id: '<%=session.getAttribute("userid")%>'
                    };

                    jQuery.ajax({
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        'type': 'POST',
                        'url': '<%= request.getContextPath()%>/api/getdocs',
                        'data': JSON.stringify(data),
                        'dataType': 'json',
                        'success': function (data) {
                            console.log(data);
                            var html = '';

                            $.each(data, function (index, value) {
                                html += '<tr>\
                                                <td><a href="http://localhost:8080/apitest/resources/files/' + value.doc_name + '">' + value.doc_name + '</a></td>\
                                                <td>' + value.username + '</td>\
                                                <td><input type="button" value="Törlés" onclick="deleteDoc(' + value.doc_id + ',\'' + value.doc_name + '\');" /></td>\
                                            </tr>';
                            });
                            $("#documnetlist").html(html);
                        }
                    });
                }




                getList();

                function deleteDoc(docid, docname) {
                    var data = {
                        doc_id: docid,
                        doc_name: docname
                    };

                    jQuery.ajax({
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        'type': 'POST',
                        'url': '<%= request.getContextPath()%>/api/deletedoc',
                        'data': JSON.stringify(data),
                        'dataType': 'json',
                        'success': function (data) {
                            getList();
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
                            <td>Dokumentum</td>
                            <td>Tulajdonos</td>
                            <td></td>                            
                        </tr>
                    </thead>
                    <tbody id="documnetlist">
                    </tbody>
                </table>
                <hr>
                <form action="api/upload-file" method="post" enctype="multipart/form-data">
                    <p>
                        File name : <input type="text" name="fileName" />
                    </p>
                    <p>
                        Choose the file : <input type="file" name="selectedFile" />
                    </p>
                    <input type="hidden" name="owner" value="<%=session.getAttribute("userid")%>">
                    Publikus: <input type="checkbox" name="isPublic_doc"><br>
                    <input type="submit" value="Upload" />
                </form>

            </div>
        </div>
        <%
            }
        %>
    </body>
</html>
<script>
    $('#main-menu').find('li').removeClass('active-link');
    $($('#main-menu').find('li')[2]).addClass('active-link');
</script>