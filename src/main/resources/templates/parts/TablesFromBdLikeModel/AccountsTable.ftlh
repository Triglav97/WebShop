<table class="table table-dark table-striped">
    <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Telephone_num</th>
            <th scope="col">Address</th>
            <th scope="col">Roles</th>
        </tr>
    </thead>
    <#list Accounts as account>
        <tr>
            <th scope="col">${account.id}</th>
            <td >${account.name}</td>
            <td >${account.telephone_num}</td>
            <td>${account.address}</td>
            <td>${account.roles}</td>
        </tr>
    </#list>
</table>