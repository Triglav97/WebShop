<#import "parts/MainPart.ftlh" as MP>
<@MP.page>
    <div> привет </div>

    <table>
        <#list Accounts as account>
            <tr>
                <td>${account.id}</td>
                <td>${account.telephone_num}</td>
                <td>${account.address}</td>
<#--                <td><#list account.cart_items as ac>${ac.name};</#list></td>-->
            </tr>
        </#list>
    </table>
    <hr>
    <table>
        <#list Items as items>
            <tr>
                <td>${items.id}</td>
                <td>${items.name}</td>
            </tr>
        </#list>
    </table>
    <hr>
    <table>
        <#list Passwords as passwords>
            <tr>
                <td>${passwords.id}</td>
                <td>${passwords.pass}</td>
            </tr>
        </#list>
    </table>
    <hr>
    <table>
        <#list Roles as roles>
            <tr>
                <td>${roles.id}</td>
                <td>${roles.role}</td>
                <td>${roles.account_id}</td>
            </tr>
        </#list>
    </table>
</@MP.page>