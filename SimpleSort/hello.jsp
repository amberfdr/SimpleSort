<%@taglib uri="/mytaglib" prefix="mm"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>helloapp</title>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8"/>
    </head>
    <body>
    <mm:hello/>:<b><%=request.getAttribute("USER")%></b>
    </body>
</html>