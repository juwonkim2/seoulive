
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SEOULLIVE_get.jsp</title>

    <link rel="stylesheet" href="../../css/courseView.css">
    <link rel="stylesheet" href="../../../../resources/static/css/course/courseView.css">
    <link rel="stylesheet" href="../../../../resources/static/css/layout/layout.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/4b84ea08f3.js" crossorigin="anonymous"></script>

</head>
<body>

    <div>
        <h3>1. ${__BOARD__.SEQ}</h3>
        <h3>2. ${__BOARD__.WRITER}</h3>
        <h3>3. ${__BOARD__.TITLE}</h3>
        <h3>4. ${__BOARD__.REVIEW}</h3>
        <h3>5. ${__BOARD__.TOTAL}</h3>
        <h3>6. ${__BOARD__.WRITE_DATE}</h3>
        <h3>7. ${__BOARD__.MODIFY_DATE}</h3>
        <h3>8. ${__BOARD__.DURATION_START}</h3>
        <h3>9. ${__BOARD__.DURATION_END}</h3>
    </div>
    <hr>
    <div>
        <h3>1. ${__COURSETRAVELBOARD__.SEQ}</h3>
        <h3>2. ${__COURSETRAVELBOARD__.BOARD_SEQ}</h3>
        <h3>3. ${__COURSETRAVELBOARD__.TRAVEL_SEQ}</h3>
        <h3>4. ${__COURSETRAVELBOARD__.UPLOAD_SEQ}</h3>
        <h3>5. ${__COURSETRAVELBOARD__.LINK}</h3>
        <h3>6. ${__COURSETRAVELBOARD__.USER_REVIEW}</h3>
    </div>
    <hr>
    <div>
        <h3>1. ${__COMMENT__.SEQ}</h3>
        <h3>2. ${__COMMENT__.WRITER}</h3>
        <h3>3. ${__COMMENT__.CONTENT}</h3>
        <h3>4. ${__COMMENT__.WRITE_DATE}</h3>
        <h3>5. ${__COMMENT__.MODIFY_DATE}</h3>
        <h3>6. ${__COMMENT__.BOARD_NAME}</h3>
        <h3>7. ${__COMMENT__.POST_SEQ}</h3>
    </div>

</body>
</html>
