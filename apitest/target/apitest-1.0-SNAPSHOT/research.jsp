<html>
    <head>
        <jsp:include page="include.jsp"></jsp:include>
            <script>


                function getList(userlist) {
                    $.get("<%= request.getContextPath()%>" + "/api/getres", function (data) {
                        var html = '';

                        $.each(data, function (index, value) {
                            html += '<tr>\
                                <td><input type="text" id="research_name_' + value.research_id + '" value="' + value.research_name + '"/></td>\
                                <td><select id="leader_id_' + value.research_id + '" value="' + value.leader_id + '">' + userlist + '</select></td>\
                                <td><input type="text" id="fund_' + value.research_id + '" value="' + value.fund + '"/></td>\
                                <td><input type="checkbox" id="isPublic_' + value.research_id + '" ' + (value.isPublic ? 'checked' : '') + '/></td>\
                                <td><button onclick="modifyresearch(' + value.research_id + ')">Módosítás</button><button onclick="removeresearch(' + value.research_id + ')">Törlés</button></td>\
                                </tr>';
                        });
                        $("#researchlist").html(html);

                        $.each(data, function (index, value) {
                            $('#leader_id_' + value.research_id).val(value.leader_id);
                        });
                    });
                }

                function getUsers() {
                    $.get("<%= request.getContextPath()%>" + "/api/getusers", function (data) {
                        var userlist = '';

                        $.each(data, function (index, value) {
                            userlist += '<option value="' + value.id + '">' + value.username + '</option>';
                        });

                        getList(userlist);
                        $('#research_user').html(userlist);
                    });
                }


                getUsers();
                function modifyresearch(resid) {
                    var data = {
                        research_id: resid,
                        research_name: $('#research_name_' + resid).val(),
                        leader_id: $('#leader_id_' + resid).val(),
                        fund: $('#fund_' + resid).val(),
                        isPublic: $('#isPublic_' + resid).is(":checked")
                    };

                    jQuery.ajax({
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        'type': 'POST',
                        'url': '<%= request.getContextPath()%>/api/modifyres',
                        'data': JSON.stringify(data),
                        'dataType': 'json',
                        'success': function (data) {
                            getUsers();
                        }
                    });
                }

                function removeresearch(resid) {
                    var data = {
                        research_id: resid
                    };

                    jQuery.ajax({
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        'type': 'POST',
                        'url': '<%= request.getContextPath()%>/api/deleteres',
                        'data': JSON.stringify(data),
                        'dataType': 'json',
                        'success': function (data) {
                            getUsers();
                        }
                    });
                }

                function addresearch() {
                    var data = {
                        research_name: $('#research_name').val(),
                        leader_id: $('#research_user').val(),
                        fund: $('#research_fund').val(),
                        isPublic: $('#research_public').is(":checked")
                    };

                    jQuery.ajax({
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        'type': 'POST',
                        'url': '<%= request.getContextPath()%>/api/setres',
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
                            <td>Kutatas neve</td>
                            <td>Felelos</td>
                            <td>Penz</td>
                            <td>Publikus</td>
                            <td><td>
                        </tr>
                    </thead>

                    <tbody id="researchlist"></tbody>
                    <tfoot>
                    <td><input type="text" id="research_name"></td>
                    <td><select id="research_user"></select></td>
                    <td><input type="text" id="research_fund"></td>
                    <td><input type="checkbox" id="research_public"></td>
                    <td><button onclick="addresearch()">Hozzáad</button><td>                  
                        </tfoot>
                </table>
                
            </div>
        </div>
        <%
            }
        %>
    </body>
</html>
<script>
    $('#main-menu').find('li').removeClass('active-link');
    $($('#main-menu').find('li')[1]).addClass('active-link');
</script>