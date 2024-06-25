<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="logo2Url" value="/images/book_logo2.jpg" />
<layout:main>
    <h1>메인 페이지</h1>
    <img src="${logo2Url}" alt="<fmt:message key="로고2" />">
</layout:main>