<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="row">
            <div class="col-md-5">
                <h1>Example - Framework List</h1>
            </div>
        </div>
        <div class="col-md-3">
            <div class="list-group">
                <a href="frameworks?action=list" class="list-group-item">Framework List</a>
                <a href="frameworks?action=add" class="list-group-item">Add Framework</a>
                <a href="frameworks?action=search" class="list-group-item">Search</a>
            </div>
        </div>
        <div class="col-md-8">
            <div class="well">
                <h4>Add New Framework</h4>
                <form action="frameworks?action=edit&id=${framework.id}" method="post">
                    <div class="control-group form-group">
                        <div class="controls">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" id="name" name="name" value="${framework.name}">
                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label for="description">Description:</label>
                            <textarea class="form-control" rows="3" id="description" name="description">${framework.description}</textarea>
                            <div class="help-block"></div>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label for="docLink">Documentation Link:</label>
                            <input type="text" class="form-control" id="docLink" name="docLink" value="${framework.documentationLink}">
                            <div class="help-block"></div>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <label for="categorySelect">Category</label>
                        <select class="form-control" id="categorySelect" name="categorySelect">
                            <option>Web Layer</option>
                            <option>Service Layer</option>
                            <option>Data Layer</option>
                        </select>
                    </div>
                    <div id="success"></div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
                <!-- /.input-group -->
            </div>
        </div>
    </div>

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; JBradle 2015</p>
            </div>
        </div>
    </footer>
</div>
<!-- /.container -->

<!-- jQuery -->
<script src="node_modules/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>

</body>

</html>
