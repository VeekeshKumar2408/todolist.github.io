<%@ include file="Common/header.jspf"%>
<body>
<%@ include file="Common/navigation.jspf"%>
<div class="container">
<h1>
Your Todos :
</h1>
<table class="table">
<thead>
    <tr>
        <th>description</th>
        <th>Target Date</th>
        <th>Is Done?</th>
        <th></th>
        <th></th>
    </tr>
 </thead>
<tbody>
    <c:forEach items="${todos}" var="todo">
    <tr>
        <td>${todo.description}</td>
        <td>${todo.targetDate}</td>
        <td>${todo.done}</td>
        <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
        <td><a href="update-todo?id=${todo.id}" class="btn btn-info">Update</a></td>
    </tr>
    </c:forEach>
</tbody>
</table>
<a href="add-todos" class="btn btn-secondary">
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
<path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2"/>
</svg>
Add Todo
</a>
</div>
<%@ include file="Common/footer.jspf"%>
