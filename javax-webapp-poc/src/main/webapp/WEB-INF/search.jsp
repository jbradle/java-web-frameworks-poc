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
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
                <a href="frameworks?action=search" class="list-group-item active">Search</a>
            </div>
        </div>

        <div class="col-md-8">
            <div class="well">
                <form action="frameworks" method="get">
                    <input type="text" name="action" value="search" hidden/>
                    <label for="search">Framework Search</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="search" name="searchParam">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button>
                        </span>
                    </div>
                </form>
                <!-- /.input-group -->
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Docs</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${frameworks}" var="framework">
                    <tr>
                        <td><c:out value="${framework.name}"/></td>
                        <td><c:out value="${framework.category}"/></td>
                        <td>
                            <a href="${framework.documentationLink}">
                                <i class="fa fa-arrow-right fa-2x"></i>
                            </a>
                        </td>
                        <td>
                            <a href="frameworks?action=detail&id=${framework.id}" title="Detail">
                                <i class="fa fa-folder-open fa-2x"></i>
                            </a>
                            <a href="frameworks?action=edit&id=${framework.id}" title="Edit">
                                <i class="fa fa-edit fa-2x"></i>
                            </a>
                            <a href="frameworks?action=remove&id=${framework.id}" title="Remove">
                                <i class="fa fa-remove fa-2x"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
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
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.js"></script>

</body>

</html>
