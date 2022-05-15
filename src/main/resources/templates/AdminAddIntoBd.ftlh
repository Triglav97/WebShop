<#import "parts/MainPart.ftlh" as MP>
<@MP.page>
    <div> нужно добавить добавлялки в бд</div>
    <#--  если дотянутся руки до js в формы нужно будет добавить novalidate  -->
    <div>
        <form method="post" action="/admin/addAccount">
            <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
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
                <button class="btn btn-primary" type="submit" >Добавить</button>
            </div>
        </form>
        
        <hr>

        <form method="post" action="/admin/addRole">
            <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
            <div>
                <label for="validationRole" class="form-label">Роль</label>
                <input type="text" class="form-control" id="validationRole" placeholder="Роль" name="role" required>
                <div class="invalid-tooltip">
                    Укажите Роль.
                </div>
            </div>
            <div>
                <button class="btn btn-primary" type="submit" >Добавить</button>
            </div>
        </form>
        
        <hr>

        <form method="post" action="/admin/addCategory">
            <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
            <div>
                <label for="validationCategory" class="form-label">Категория</label>
                <input type="text" class="form-control" id="validationCategory" placeholder="Категория" name="сategory" required>
                <div class="invalid-tooltip">
                    Укажите Категорию.
                </div>
            </div>
            <div>
                <button class="btn btn-primary" type="submit" >Добавить</button>
            </div>
        </form>

        <hr>

        <form method="post" action="/admin/addCorp">
            <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
            <div>
                <label for="validationCorp" class="form-label">Фирма</label>
                <input type="text" class="form-control" id="validationCorp" placeholder="Фирма" name="corp" required>
                <div class="invalid-tooltip">
                    Укажите Фирму.
                </div>
            </div>
            <div>
                <button class="btn btn-primary" type="submit" >Добавить</button>
            </div>
        </form>

        <hr>

        <form method="post" action="/admin/addItem" enctype="multipart/form-data" modelAttribute="par">
            <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
            <div>
                <label for="validationItemName" class="form-label">Наименование товара</label>
                <input type="text" class="form-control" id="validationItemName" placeholder="Наименование товара" name="itemName" required>
                <div class="invalid-tooltip">
                    Укажите, наименование товара.
                </div>
            </div>
            <div>
                <label for="validationCategoryName" class="form-label">Категория товара</label>
                <select class="form-select" id="validationCategoryName" name="categoryName" required>
                    <option selected disabled value="">Выбрать...</option>
                    <#list Categories as category>
                        <option>${category.name}</option>
                    </#list>
                </select>
                <div class="invalid-tooltip">
                    Укажите, категорию товара.
                </div>
            </div>
            <div>
                <label for="validationCorpName" class="form-label">Фирма товара</label>
                <select class="form-select" id="validationCorpName" name="corpName" required>
                    <option selected disabled value="">Выбрать...</option>
                    <#list Corps as corp>
                        <option>${corp.name}</option>
                    </#list>
                </select>
                <div class="invalid-tooltip">
                    Укажите, фирму товара.
                </div>
            </div>
            <div>
                <label for="validationCorpName" class="form-label">Картинка товара</label>
                <input type="file" name="filePicture" required>
                <#--  <br /> 
                    Name: <input type="text" name="fileName" required>  -->
            </div>
            <div>
                <button class="btn btn-primary" type="submit">Добавить</button>
            </div>
        </form>
    </div>
</@MP.page>
