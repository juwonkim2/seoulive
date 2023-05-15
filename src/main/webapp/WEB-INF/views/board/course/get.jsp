
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
<%--    <jsp:include page="../../layout/header.jsp"/>--%>


    <div class="plan_page">
        <div class="plan_cover">
            <div class="cover_img"><img src="https://picsum.photos/id/1081/600/400"></div>
            <div class="cover_bottom">
                <div class="cover_bleft">
                    <div class="plan_title">제목 ${__BOARD__.TITLE}</div>
                    <div class="plan_datetheme">
                        <div class="plan_user">닉네임${__BOARD__.WRITER}</div>
                        <div class="plan_date">${__BOARD__.DURATION_START}-${__BOARD__.DURATION_END}</div>
                        <div class="clear"></div>
                    </div>
                </div>

                <div class="title_function">
                    <a href="#" id="copyBtn" class="url_setClipboard" title="" style="cursor:pointer;">
                        <i class="fas fa-share-nodes"></i>URL 복사
                    </a>
                    <a href="#" class="buddyBtn"><i class="fas fa-user"></i></a>팔로우
                    <button id="myButton"><a href="#"><i id="myIcon" class="fa-regular fa-heart"></i></a>
                    </button>
                </div>

                <div class="cover_bright">
                    <span>${__BOARD__.REVIEW}.</span>
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

            <div class="planpage_title">2020.02.06</div>
            <div class="planpage_daytitle">광화문</div>

            <div class="planpage_course1">
                <div class="planpage_couse1pic"><img src="/img/장미.jpg"></div>
                <div class="planpage_course1txt">여행지1</div>
                <div class="planpage_course1review">리뷰입니다</div>
            </div>

            <div class="planpage_course1">
                <div class="planpage_couse1pic"><img src="/img/장미.jpg"></div>
                <div class="planpage_course1txt">여행지1</div>
                <div class="planpage_course1review">리뷰입니다</div>
            </div>
            <div class="planpage_course1">
                <div class="planpage_couse1pic"><img src="/img/장미.jpg"></div>
                <div class="planpage_course1txt">여행지1</div>
                <div class="planpage_course1review">리뷰입니다</div>
            </div>
            <div class="planpage_course1">
                <div class="planpage_couse1pic"><img src="/img/장미.jpg"></div>
                <div class="planpage_course1txt">여행지1</div>
                <div class="planpage_course1review">리뷰입니다</div>
            </div>
        </div>
        <div class="wrap_planpage2">
            <!-- day 박스 -->
            <div class="planpage_day">
                <div class="planpage_daytxt">
                    Day2
                </div>
            </div>

            <div class="planpage_title">2020.04.06</div>
            <div class="planpage_daytitle">광화문</div>

            <div class="planpage_course1">
                <div class="planpage_couse1pic"><img src="/img/장미.jpg"></div>
                <div class="planpage_course1txt">여행지1</div>
                <div class="planpage_course1review">리뷰입니다</div>
            </div>

            <div class="planpage_course1">
                <div class="planpage_couse1pic"><img src="/img/장미.jpg"></div>
                <div class="planpage_course1txt">여행지1</div>
                <div class="planpage_course1review">리뷰입니다</div>
            </div>
            <div class="planpage_course1">
                <div class="planpage_couse1pic"><img src="/img/장미.jpg"></div>
                <div class="planpage_course1txt">여행지1</div>
                <div class="planpage_course1review">리뷰입니다</div>
            </div>
            <div class="planpage_course1">
                <div class="planpage_couse1pic"><img src="/img/장미.jpg"></div>
                <div class="planpage_course1txt">여행지1</div>
                <div class="planpage_course1review">리뷰입니다</div>
            </div>
        </div>
        <div class="wrap_planpage2">
            <!-- day 박스 -->
            <div class="planpage_day">
                <div class="planpage_daytxt">
                    Day3
                </div>
            </div>

            <div class="planpage_title">2020.05.06</div>
            <div class="planpage_daytitle">광화문</div>

            <div class="planpage_course1">
                <div class="planpage_couse1pic"><img src="/img/장미.jpg"></div>
                <div class="planpage_course1txt">여행지1</div>
                <div class="planpage_course1review">리뷰입니다</div>
            </div>

            <div class="planpage_course1">
                <div class="planpage_couse1pic"><img src="/img/장미.jpg"></div>
                <div class="planpage_course1txt">여행지1</div>
                <div class="planpage_course1review">리뷰입니다</div>
            </div>
            <div class="planpage_course1">
                <div class="planpage_couse1pic"><img src="/img/장미.jpg"></div>
                <div class="planpage_course1txt">여행지1</div>
                <div class="planpage_course1review">리뷰입니다</div>
            </div>
            <div class="planpage_course1">
                <div class="planpage_couse1pic"><img src="/img/장미.jpg"></div>
                <div class="planpage_course1txt">여행지1</div>
                <div class="planpage_course1review">리뷰입니다</div>
            </div>
        </div>


        <!-- 맵 -->
        <div class="map"><img src="/img/맵사진.PNG" alt="map"></div>

        <!-- 댓글 -->
        <div class="comm_page">
            <div class="comm">
                <div class="comm_list">댓글(개수)</div>
                <div class="comm_write">
                    <div class="comm_writecontent">댓글 작성</div>
                </div>
                <div class="comments">
                    <div class="comm_user_info">
                        <div class="comm_userpic"><a href="#"><img src="/img/로고.png"></a> </div>
                        <div class="comm_usercomminfo">

                            <div class="username">작성자</div>
                            <div class="comm_usercommtime">작성시간</div>
                            <div class="comm_usercommtxt">댓글 내용</div>
                        </div>
                    </div>

                    <div class="comments">
                        <div class="comm_user_info">
                            <div class="comm_userpic"><a href="#"><img src="/img/로고.png"></a> </div>
                            <div class="comm_usercomminfo">

                                <div class="username">작성자</div>
                                <div class="comm_usercommtime">작성시간</div>
                                <div class="comm_usercommtxt">댓글 내용</div>
                            </div>
                        </div>

                        <div class="comments">
                            <div class="comm_user_info">
                                <div class="comm_userpic"><a href="#"><img src="/img/로고.png"></a> </div>
                                <div class="comm_usercomminfo">

                                    <div class="username">작성자</div>
                                    <div class="comm_usercommtime">작성시간</div>
                                    <div class="comm_usercommtxt">댓글 내용</div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="../../layout/footer.jsp"/>
</body>
</html>
