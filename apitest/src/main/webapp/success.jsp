<html>
    <head>
        <jsp:include page="include.jsp"></jsp:include>
        <script>
            $.get( "<%= request.getContextPath() %>"+"/api/getusers", function( data ) {
                var html='';
                        $.each(data, function( index, value ) {
                        
                            html+='<tr>\
                                    <td>'+value.username+'</td>\
                                    <td>'+value.titulus+'</td>\
                                    <td></td>\
                                   </tr>';
                        });
                        $("#userlist").html(html);
              });
            
        /*    $(document).ready(function(){
                
                $.get( "<%= request.getContextPath() %>"+"/api/getusers", function( data ) {
                    console.log(JSON.parse(data));
                });
              */  
                /*$.ajax({
                    url: "<%= request.getContextPath() %>/api/getusers",
                    success: function(data) {
                        var d = $("#userlist");
                        console.log(data);
                        console.log(JSON.parse(data));
                        var html='';
                        $.each(JSON.parse(data), function( index, value ) {
                        
                            html+='<tr>\
                                    <td>'+data.username+'</td>\
                                    <td>'+data.titulus+'</td>\
                                    <td></td>\
                                   </tr>';
                        });
                        d.html(html);
                        console.log(data);
                        console.log(html);
                    },
                    error: function(xhr, status, error) {
                        alert(error);
                    }
                });
            });    */       
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
                </table>
                
                
                <a href='logout.jsp'>Log out</a>
            </div>
        </div>
        
        <%
            }
        %>
    </body>
</html>