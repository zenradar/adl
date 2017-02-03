<!DOCTYPE html>
<html>
<#include "head.ftl"/>

<body>

<#include "navbar.ftl"/>

<div class="row">

<div id="content" class="col-sm-8">
    <h2>Library Members</h2>
    <table class="table table-striped table-hover">
  	<tr>
  		<th>Name</th>  <th>Phone</th> <th>Email</th>
  	</tr>
    <#list model["userList"] as user>
  	<tr>
  		<td class="name-link">
        <a class="fetch-books" data-user="${user.id}">
          ${user.name}
        </a>
      </td>
      <td>${user.phone}</td>
      <td>${user.email}</td>
  	</tr>
    </#list>
  </table>

</div>

<div class="col-sm-4" >
  <h2>Member's Loans</h2>
  <div id="memberloans"></div>
</div>
</div>

</body>
</html>
