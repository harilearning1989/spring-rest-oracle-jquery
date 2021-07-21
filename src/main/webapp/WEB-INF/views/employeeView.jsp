<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div style="width: 100%;height:100%;background-color: lightblue;">
    <div sec:authorize="isAuthenticated()">
    	Welcome <b><sec:authentication property="principal.username" />
    	&nbsp;</br>
    	<sec:authentication property="principal.authorities" />
    </div>

    <form action="/logout" method="post">
    	<input type="submit" value="Logout" />
    </form>

    <div sec:authorize="hasAnyAuthority('CREATOR', 'ADMIN')">
    	<a href="new">Create New Employee</a>
    </div>

    <sec:authorize access="hasAuthority('CREATOR')">
        This content will only be visible to users who have
        the "supervisor" authority in their list of <tt>GrantedAuthority</tt>s.
    </sec:authorize>

    <sec:authorize access="isRememberMe()">
    	<h2># This user is login by "Remember Me Cookies".</h2>
    </sec:authorize>

    <sec:authorize access="isFullyAuthenticated()">
    	<h2># This user is login by username / password.</h2>
    </sec:authorize>

    <a href="/dataTableEmp">DataTableEmp</a>
    <a href="/ajaxMethods">AjaxMethods</a>

    <a href="/helloWorld">Hello World</a>
    <a href="/agGridHelloWorld">AgGridHelloWorld</a>
    <a href="/agGridServerData">AgGridServerData</a>

    <table border="2" width="70%" cellpadding="2">
    	<tr>
    		<th>First Name</th>
    		<th>Last Name</th>
    		<sec:authorize access="hasAnyAuthority('ADMIN','EDITOR')">
    		   <!-- <th sec:authorize="hasAnyAuthority('ADMIN', 'EDITOR')">Actions</th> -->
    		    <th>Actions</th>
    		</sec:authorize>
    	</tr>
    	<c:forEach var="emp" items="${listEmployee}">
    		<tr>
    			<td>${emp.firstName}</td>
    			<td>${emp.lastName}</td>
    			<sec:authorize access="hasAnyAuthority('ADMIN','EDITOR')">
                   <td><a href="/edit/${emp.empId}">Edit</a>
                        <sec:authorize access="hasAuthority('ADMIN')">
                            <a href="/delete/${emp.empId}">Delete</a>
                        </sec:authorize>
                   </td>
                </sec:authorize>
    		</tr>
    	</c:forEach>
    </table>
</div>
