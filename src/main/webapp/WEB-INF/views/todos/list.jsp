<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<title>할일관리</title>
</head>
<body>
	<div class="container">
		<div class="mt-2 mb-2">
			<h4># 금주에는 이런걸 해보시는게 어떨까요?</h4>
			<ul class="list-group">
				<c:forEach var="q" items="${quests }">
					<li class="list-group-item d-flex justify-content-between" 
						onclick="location.href='/todos/addQuest?questId=${q.id}'"
					><span>${q.description }</span>
						<span class="badge bg-danger" data-bs-toggle="tooltip"
						data-bs-placement="top" title="참여중인 사용자들">${q.joinCnt }</span></li>
				</c:forEach>
			</ul>
		</div>
		<div class="mt-5 mb-2">
			<c:choose>
				<c:when test="${empty todos }">
					<h4># 당신이 등록한 일들이 없습니다. 추가해보시겠어요?</h4>
				</c:when>
				<c:otherwise>
					<h4># 당신이 등록한 일들입니다. 잊으시진 않으셨죠?</h4>
				</c:otherwise>
			</c:choose>

		</div>
		<div class="mb-1 text-end">
			<a href="/todos/create" class="text-warning">할 일을 추가합니다</a>
		</div>
		<ul class="list-group">
			<c:forEach var="obj" items="${todos }">
				<li class="list-group-item">
					<div class="d-flex justify-content-between align-items-center"
						onclick="location.href='/todos/update?todoId=${obj.id }'">
						<div>
							<span
								class="${!empty obj.done ? 'text-decoration-line-through':'' }">${obj.description }</span>
						</div>
						<div>
							<small class="text-success">~ <fmt:formatDate
									value="${obj.targetDate }" /></small> <a
								href="/todos/delete?todoId=${obj.id }"
								class="btn btn-outline-danger btn-sm">X</a>
						</div>
					</div>
				</li>

			</c:forEach>
		</ul>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
	<script>
		var tooltipTriggerList = [].slice.call(document
				.querySelectorAll('[data-bs-toggle="tooltip"]'))
		var tooltipList = tooltipTriggerList.map(function(tooltipTriggerEl) {
			return new bootstrap.Tooltip(tooltipTriggerEl)
		})
	</script>
</body>
</html>


