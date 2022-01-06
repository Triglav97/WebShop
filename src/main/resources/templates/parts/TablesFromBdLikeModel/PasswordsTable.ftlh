<table class="table table-dark table-striped">
    <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Password</th>
        </tr>
    </thead>
    <#list Passwords as passwords>
        <tr>
            <th scope="col">${passwords.id}</th>
            <td>${passwords.pass}</td>
        </tr>
    </#list>
</table>