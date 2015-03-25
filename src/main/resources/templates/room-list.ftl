<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<ol class="breadcrumb">
    <li><a href="#">Home</a></li>
    <li class="active">Roomlist</li>
</ol>

<div class="container">

        <div class="row clearfix">
        <#list rooms as room>
            <div class="col-xs-6 col-md-4">
            <#if (room.getTaux() < 40)>
                <div class="panel panel-success">
            <#elseif (room.getTaux() >= 40 && room.getTaux() < 70)>
                <div class="panel panel-warning">
            <#elseif (room.getTaux() >= 70)>
                <div class="panel panel-danger">
            </#if>
                    <div class="panel-title text-center">
                        <h2>Room : ${room.getName()}</h2>
                    </div>
                    <div class="panel-body text-center">
                        <p>Capacity : ${room.getCapacity()}</p>
                    </div>
                </div>
            </div>
    </#list>
            </div>

    </div> <!-- /container -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>