<#import "parts/MainPart.ftlh" as MP>
<@MP.page>
    <div>
        <form method="post" action="/login">
            <#include "/parts/LogReg/NamePass.ftlh">
            <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
            <div>
                <button class="btn btn-primary" type="submit" >Войти</button>
            </div>
        </form>
        <a href="/registration">Зарегистрироваться</a>
    </div>
</@MP.page>