<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>
	<ul class="pagination">
		<li <c:if test="${page.firstPage}">class="disabled"</c:if>><a
			href="?page.start=0" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<li <c:if test="${page.firstPage}">class="disabled"</c:if>><a
			href="?page.start=${page.start-page.count}" aria-label="Previous">
				<span aria-hidden="true">‹</span>
		</a></li>
		<c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
			<c:if  test="${-10<=page.count*status.count-page.start && page.count*status.count-page.start<=20}">
			<li
			<c:if test="${page.start/page.count == status.index}">class="disabled"</c:if>
			><a href="?page.start=${status.index*Page.count}" aria-label="Previous"
			<c:if test="${page.start/page.count == status.index}">class="current"</c:if>
			>
			 <span aria-hidden="true">
			 			${status.count }
			 </span>
			</a></li>
			</c:if>
		</c:forEach>
		<li <c:if test="${page.lastPage}">class="disabled"</c:if>><a
			href="?page.start=${page.start+page.count}" aria-label="Next"> <span
				aria-hidden="true">›</span>
		</a></li>
		<li <c:if test="${page.lastPage}">class="disabled"</c:if>><a
			href="?page.start=${page.last}" aria-label="Next"> <span
				aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
</nav>