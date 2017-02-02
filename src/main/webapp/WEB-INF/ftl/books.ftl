<html>
<#include "head.ftl"/>

<body>

<#include "navbar.ftl"/>    

<div id="content">
    
  <table class="table table-striped">
  	<tr>
  		<th>Title</th>  <th>Author</th> <th>ISBN</th>
  	</tr>
    <#list model["bookList"] as book>
  	<tr>
  		<td>${book.title}</td> <td>${book.author}</td> <td>${book.isbn}</td>
  	</tr>
    </#list>
  </table>

</div>  
</body>
</html>  