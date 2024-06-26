<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:if test="${! empty script}">
    <script>
        ${script}
    </script>
</c:if>
<%--스크립트는 무조건 html 태그 안에서 실행->페이지가 나와야 실행 가능
스크립트를 속성형태로 사용하면 지정하는 대로 실행됨, setAttribute와 같이 사용--%>