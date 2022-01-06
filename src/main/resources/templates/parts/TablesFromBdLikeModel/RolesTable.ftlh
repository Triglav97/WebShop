<table class="table table-dark table-striped">
    <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Role</th>
        </tr>
    </thead>
    <#list Roles as roles>
        <tr>
            <th scope="col">${roles.id}</th>
            <td>${roles.role}</td>
        </tr>
    </#list>
</table>