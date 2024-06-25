<%@ tag body-content="scriptless" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ attribute name="title" %>
<fmt:setBundle basename="messages.commons" />
<c:url var="cssUrl" value="/css/" />
<c:url var="jsUrl" value="/js/" />
<c:url var="homeUrl" value="/" />
<c:url var="searchUrl" value="/board/search" />
<c:url var="logoUrl" value="/images/book_logo1.jpg" />

<layout:common title="${title}">
    <jsp:attribute name="header">
        <section class="site-top">
        <nav>
            <div class="left">
                <a href="${homeUrl}">
                    <img src="${logoUrl}" alt="<fmt:message key='홈' />">
                </a>
            </div>
            <div class="layout-width inner">
                <a href="#">게시판</a>
                <a href="#">도감</a>
                <a href="<c:url value='/member/login' />">
                    <fmt:message key="로그인" />
                </a>
                <a href="<c:url value='/member/join' />">
                    <fmt:message key="회원가입" />
                </a>
            </div>
        </nav>
        </section>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <section class="layout-width inner">
            메인 레이아웃 하단 영역!
        </section>
    </jsp:attribute>
    <jsp:attribute name="commonCss">
        <link rel="stylesheet" type="text/css" href="${cssUrl}main.css">
    </jsp:attribute>
    <jsp:attribute name="commonJs">
        <script src="${jsUrl}main.js"></script>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</layout:common>