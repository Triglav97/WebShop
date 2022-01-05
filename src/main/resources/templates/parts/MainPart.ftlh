<#macro page>
    <!DOCTYPE html>
    <html lang="ru" class="h-100">
        <head>
            <link rel="shortcut icon" href="/favicon.ico?v=1.1">
            <link rel="stylesheet" type="text/css" href="/css/style.css">
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

            <#--если нужна скорость, но косяки, разблочь кусок-->
           <#-- <script src="https://cdnjs.cloudflare.com/ajax/libs/turbolinks/5.2.0/turbolinks.js" integrity="sha512-G3jAqT2eM4MMkLMyQR5YBhvN5/Da3IG6kqgYqU9zlIH4+2a+GuMdLb5Kpxy6ItMdCfgaKlo2XFhI0dHtMJjoRw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
            <style>
                .turbolinks-progress-bar {
                    height: 2px;
                    background-color: navy;
                }
            </style>-->

            <title>WebShop</title>
        </head>

        <body class="d-flex h-100 my-bg-secondary bg-gradient">
            <div class="d-flex w-100 h-100 flex-column">
                <#include  "ConstructorMainPart/Header.ftlh">
                <main class="container-fluid h-100 mt-3 mb-3 px-3">
                    <#nested>
                </main>
                <#include "ConstructorMainPart/Footer.ftlh">
            </div>

            <!-- js bootstrap -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        </body>
    </html>
</#macro>