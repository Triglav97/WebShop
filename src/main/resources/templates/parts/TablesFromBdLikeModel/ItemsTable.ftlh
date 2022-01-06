<table class="table table-dark table-striped">
    <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
        </tr>
    </thead>
    <#list Items as items>
        <tr>
            <th scope="col">${items.id}</th>
            <td>${items.name}</td>
        </tr>
    </#list>
</table>