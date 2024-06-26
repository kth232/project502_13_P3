<%@ tag body-content="scriptless" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:if test="${!isLogin}">
    <%--로그인 상태가 아닐 때--%>
    <jsp:doBody />
</c:if>