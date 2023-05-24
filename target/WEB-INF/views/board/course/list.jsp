<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>list.jsp</title>

    <style>
        * {
            margin: 0 auto;
            padding: 0;
        }
        #wrapper {
            width: 1024px;

            font-family: D2Coding;
            font-size: 16px;
        }
        table {
            width: 100%;

            /* 경계선을 없앤다 */
            border-collapse: collapse;
            border: 1px ridge green;

            text-align: center;
        }

        th {
            padding: 10px;

            color: white;
            background-color: rgb(200, 141, 200);

            font-size: 18px;
        }

        td {
            padding: 3px;
        }

        caption {
            font-size: 18px;
            font-weight: bold;
        }

        td:nth-of-type(2) {
            text-align: left;
            padding-left: 5px ;
            width: 50%;
        }

        h1 {
            padding: 20px;
        }
        tr:hover {
            background-color: bisque;
        }

        #regBtn {
            width: 150px;
            height: 40px;
            margin-top: 10px;

            border: 0;


            font-size: 17px;
            font-weight: bold;

            color: white;
            background-color: rgb(244, 149, 149);

            cursor: pointer;
        }

    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js" ></script>
    <script>
        $(function () {
            $('#regBtn').click(function() {
                console.clear();

                location = "/board/register"

                console.log('Register Button Clicked ..')
            })

        }); //.jq

    </script>


</head>

<body>


<div id="wrapper">
    <table>
        <h3>${result}</h3>

        <button type="button" id="regBtn">REGISTER</button>

        <table border="1">
            <caption>tbl_board</caption>

        <thead>
        <tr>
            <th>bno</th>
            <th>title</th>
            <th>WRITER</th>
            <th>WRITE_DATE</th>
        </tr>
        </thead>
        <tbody>
        <!-- var = 임시 EL변수 -->
        <c:forEach var="boardVO" items="${__LIST__}">
            <tr>
                <td>${ boardVO.SEQ }</td>
                <!-- 상세조회는 get -->
                <td class="title"><a href="/board/course/get?seq=${ boardVO.SEQ }">${ boardVO.TITLE }</a></td>
                <td><a href="/board/course/get?seq=${ boardVO.SEQ }"> ${boardVO.WRITER} </a></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${boardVO.WRITE_DATE}" /> </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot></tfoot>
    </table>
    </table>
 </div>



</body>
</html>