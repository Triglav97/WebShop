<#import "parts/MainPart.ftlh" as MP>
<@MP.page>
    ${message!}
    <div>
        <form method="post" action="/registration">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div>
                <label for="validationName" class="form-label">Имя</label>
                <input type="text" class="form-control" id="validationName" placeholder="Имя" name="name" required>
                <div class="invalid-tooltip">
                    Укажите Имя.
                </div>
            </div>
            <div>
                <label for="validationPassword" class="form-label">Пароль</label>
                <input type="text" class="form-control" id="validationPassword" placeholder="Пароль" name="password" required>
                <div class="invalid-tooltip">
                    Укажите пароль.
                </div>
            </div>
            <div>
                <label for="validationCity" class="form-label">Телефон</label>
                <input type="text" class="form-control" id="validationCity" placeholder="89871234567" name="tel_num" required>
                <div class="invalid-tooltip">
                    Укажите действующий телефон.
                </div>
            </div>
            <div>
                <label for="validationAddress" class="form-label">Адрес</label>
                <input type="text" class="form-control" id="validationAddress" value="Москва" name="address" required>
                <div class="invalid-tooltip">
                    Укажите действующий адрес.
                </div>
            </div>
            <div>
                <button class="btn btn-primary" type="submit">Зарегистрироваться</button>
            </div>
        </form>
    </div>
</@MP.page>