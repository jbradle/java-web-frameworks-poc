<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Java Web Framework POC</title>

    <!-- Bootstrap Core CSS -->
    <link href="node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="node_modules/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Custom CSS -->
    <link href="resources/css/logo-nav.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" style="background: #34302d" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <img src="resources/img/navbar-logo.jpg" alt="">
            </a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="frameworks">About</a>
                </li>
                <li>
                    <a href="frameworks?action=list">Example</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Java Web Framework POC</h1>

            <p>This page should include a description of the framework and summarize its benefits and cons.</p>

            <p>As proof of concept (POC) for individual frameworks were designed a simple project. This project is only
                a list
                of frameworks, in which it will be possible to perform the basic operations of these entities. Such as
                creating, editing, viewing and deleting detail. </p>

            <p>Since creating proof of concept across all layers of Web applications is not possible to summarize in one
                description, each description is divided into three groups. Each group constitutes one layer of a web
                application.</p>

            <p>
                There may be situations where the same frameworks will be used across multiple POC. For example
                in the service layer, which is in charge of mostly a business logic, such as calculations, communication
                with external services, analysis and transformation of data transmitted from the Web layer and saved
                on a data layer.
            </p>
            <ul class="list-group">
                <li class="list-group-item">
                    <h3 class="list-group-item-heading">Web Layer</h3>
                    <p class="list-group-item-text">
                        In this section will be described framework, which caters to the needs of the web layer.

                    </p>
                </li>
                <li class="list-group-item">
                    <h3 class="list-group-item-heading">Service Layer</h3>

                    <p class="list-group-item-text">
                        In this section will be described framework, which caters to the needs of the service layer.
                    </p>
                </li>
                <li class="list-group-item">
                    <h3 class="list-group-item-heading">Data Layer</h3>

                    <p class="list-group-item-text">
                        In this section will be described framework, which caters to the needs of the data layer.
                    </p>
                </li>
            </ul>

        </div>


        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; JBradle 2015</p>
                </div>
            </div>
        </footer>
    </div>
</div>
<!-- /.container -->

<!-- jQuery -->
<script src="node_modules/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>

</body>

</html>