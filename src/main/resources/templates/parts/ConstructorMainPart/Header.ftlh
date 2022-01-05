<header class="mb-auto">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">WebShop</a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown"
                    aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                <ul class="nav navbar-nav me-auto">
                    <#include "NavbarDropdown.ftlh">
                    <li class="nav-item"><a class="nav-link" href="/test/checkAll">вывести всю бд</a></li>

                    <li class="nav-item"><a class="nav-link" href="/admin/add/AdminAddIntoBd">добавлялки в бд(админ)</a></li>
                </ul>
                <ul class="nav navbar-nav me-0">
                    <li class="nav-item nav-link">login</li>
                </ul>
            </div>
        </div>
    </nav>
</header>