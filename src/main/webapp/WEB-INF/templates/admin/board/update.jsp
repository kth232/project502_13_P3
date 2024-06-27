<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="actionUrl" value="/admin/board/save" />
<layout:admin title="게시판 수정">
    <h1>게시판 수정</h1>
    <form name="frmSave" method="post" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
        <input type="hidden" name="mode" value="update"> <%--mode에 따라 등록인지 수정인지 구분함--%>
        <jsp:include page="_form.jsp" />
        <div class="button-group">
            <button type="reset">다시 입력</button>
            <button type="submit">수정하기</button>
        </div>
    </form>
</layout:admin>