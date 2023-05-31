<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
<script src="https://kit.fontawesome.com/4b84ea08f3.js" crossorigin="anonymous"></script>

<style src="/resources/static/css/layout/footer.css">

</style>

<!-- 퀵메뉴 시작 -->
<aside>
    <div class="quick_box">
        <p>QUICK LINK</p>
        <ul>
            <li class="aBtn">날씨</li>
            <li class="faqBtn aBtn">FAQ</li>
            <li class="top aBtn" onClick="javascript:window.scrollTo(0,0)"><i class="fas fa-caret-up"></i></li>
            <li class="bottom aBtn" onClick="javascript:window.scrollTo(0, document.body.scrollHeight)"><i class="fas fa-caret-down"></i></li>
        </ul>
    </div>

</aside>
<!-- 퀵메뉴 끝 -->

<!-- 푸터 시작 -->
<footer>
    <div class="footer_wrap">
        <div class="footer_box">
            <div class="logo_box">
                <a href="#a"><img src="${pageContext.request.contextPath}/resources/static/img/img-footer-logo.png"/></a>
            </div>
            <div>
                <ul>
                    <li><a href="#a">이용약관</a></li>
                    <li><a href="#a">개인정보처리방침</a></li>
                    <li><a href="#a">사이트맵</a></li>
                </ul>
                <p class="copyright">Copyright © seoulive. All Rights Reserved</p>
            </div>
        </div>
    </div>
</footer>
<script>
    $(function () {
        $('.faqBtn').on('click', function () {
            self.location.href = '/board/cs/faq/list';
        }); // .onclick
    }); // jq
</script>
<!-- 푸터 끝 -->