<!DOCTYPE html>
<html>
<#include "head.ftl"/>

<body>

<#include "navbar.ftl"/>    

<div class="row">

<div id="content" class="col-sm-8">
  
    <table class="table table-striped table-hover">
  	<tr>
  		<th>Name</th>  <th>Phone</th> <th>Email</th>
  	</tr>
    <#list model["userList"] as user>
  	<tr>
  		<td><a data-user="${user.id}">${user.name}</a></td> <td>${user.phone}</td> <td>${user.email}</td>
  	</tr>
    </#list>
  </table>

</div>  

<div id="result" class="col-sm-4" >
</div>

</div>

</body>
</html>  