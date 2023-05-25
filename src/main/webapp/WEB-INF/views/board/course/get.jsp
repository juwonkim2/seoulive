<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course_View</title>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/course/courseView.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout/layout.css">


    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/courseComm.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/889f069cfd.js" crossorigin="anonymous"></script>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js" ></script>

    <script>
        $(function () {
            $('.boardList').click(function() {
                console.clear();

                location = "/board/course/list"

                console.log('List Button Clicked ..')
            });

            

            $(document).ready(function() {
                var operForm = $('#operForm');

                console.log("========");
                console.log("JS TEST");

                var seqValue = 0; // seqValue 변수를 값과 함께 초기화
                var InputContent = ""; // InputContent 변수를 빈 문자열로 초기화

                var seqValue = '<c:out value="${__BOARD__.seq}"/>';

                var commWriter = $(".username");
                var commTime = $(".comm_usercommtime");
                var commContent = $(".comm_usercommtxt");


                var Commregitbtn = $(".comm_rigitbutton"); //등록 버튼

                Commregitbtn.on("click", function (e) {
                    var InputContent = {
                        content: commContent.val(),
                        writer: commWriter.val(),
                        seq:seqValue
                    }; //ajax로 전달할 InputContent 객체 선언 및 할당


                })

                commService.add(InputContent, function(result) {
                        alert("RESULT: "+ result);
                    });

            });

            //댓글 목록 보이기
            commService.getList({
                seq: seqValue,
                page:1
            }, function (list) {
                for(var i=0, len=list.length || 0; i< len; i++) {
                    console.log(list[i])
                }
            })




            // }); //ready
        }); //.jq

    </script>




</head>
<body>
    <jsp:include page="../../../../resources/layout/header.jsp" />


<div class="plan_page">
    <div class="plan_cover">
        <div class="cover_img"><img src="https://picsum.photos/id/1081/600/400"></div>
        <div class="cover_bottom">
            <div class="cover_bleft">
                <div class="plan_title">${__BOARD__.TITLE}</div>
                <div class="plan_datetheme">
                    <div class="plan_user">${__BOARD__.WRITER}</div>
                    <div class="plan_date">${__BOARD__.DURATION_START}-${__BOARD__.DURATION_END}</div>
                    <div class="clear"></div>
                </div>
            </div>

            <div class="title_function">
                <div class="url_setClipboard">
                    <a href="#" id="copyBtn" title="" style="cursor:pointer;">
                        <i class="fas fa-share-nodes"></i>URL 복사
                    </a>
                </div>
                <div class="buddyBtn">
                    <a href="#"><i class="fas fa-user"></i></a>팔로우
                </div>
                <button id="myButton">
                    <a href="#"><i id="myIcon" class="fa-regular fa-heart"></i></a>
                </button>
            </div>


            <div class="cover_bright">
                <span>${__BOARD__.REVIEW}</span>
            </div>
        </div>
    </div>


    <div class="plan_mnu_box">
        <div class="plan_mnu">일정표</div>
        <div class="plan_mnu_line"></div>
        <div class="plan_mnu">댓글</div>
    </div>
    <div class="wrap_planpage1">

        <!-- day 박스 -->
        <div class="planpage_day">
            <div class="planpage_daytxt">
                Day1
            </div>
        </div>



        <div class="planpage_title">${__BOARD__.DURATION_START}</div>
        <div class="planpage_daytitle"></div>

        <div class="planpage_course1">
            <c:forEach var="courseTravelVO" items = "${__COURSETRAVELBOARD__}">
<%--                <div class="planpage_couse1pic"><img src="${courseTravelVO.LINK}"></div>--%>

                <div class="planpage_course1txt">
                        ${courseTravelVO.SEQ}
                </div>
                <div class="planpage_course1review">${courseTravelVO.USER_REVIEW}</div>
            </c:forEach>

        </div>

        <!-- 맵 -->
        <div class="map">
            <%--            <img src="/img/맵사진.PNG" alt="map">--%>
            <h3>map</h3>
        </div>


        <!-- 댓글 -->
        <div class="comm_page">
            <div class="comm">
                <div class="comm_list">댓글(${__COMMENT_LIST__.size()})</div>
                <div class="comm_write">
	                <form action="/board/course/comm_write" method="post">
	                    <div class="comm_writecontent">
	                        <input type="text" name="content" placeholder="댓글을 입력해주세요." 
	                               size="20" style= "width: 960px; height: 100px;">
	                        <input type="hidden" name="seq" value="${__BOARD__.seq}">
	                        <input type="submit" class="comm_regbutton" value="등록"
	                               style="width:50px; height:50px; background: #49539E; border:none " >
	                    </div>
	                </form>
                
                </div>
                <div class="comments">
	                <c:forEach var="commVO" items = "${__COMMENT_LIST__}">
	                    <div class="comm_user_info">
	                        <div class="comm_userpic"><a href="#"><img src="/img/로고.png"></a> </div>
	                        <div class="comm_usercomminfo">
	
	                            <div class="comm_username">${commVO.writer}</div>
	                            <div class="comm_usercommtime">${commVO.write_date}</div>
	                            <div class="comm_usercommtxt">${commVO.content}</div>
	                        </div>
	                    </div>
					</c:forEach>
				</div>


                    <form id='operForm' action="/board/course/modify" method="get">
                        <input type="hidden" id="seq" name="seq"
                               value="${__BOARD__.seq}">
                    </form>


                    <div class="getContainer">
                        <div class="boardList"><button type="button" class="boardList">list</button></div>
                        <div class="viewModify"><button type="button" class="viewModify">modify</button></div>
                    </div>





    <jsp:include page="../../../../resources/layout/footer.jsp" />
</body>
</html>