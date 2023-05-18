<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Productos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
                crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
                crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del producto</label>
                            </div>
                            <br>
                            <!-- <div class="form-group">
                                <label>ID</label>
                                <input type="text" name="txtIDproducto" class="form-control" placeholder="ID">
                            </div>-->
                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" name="txtNombre" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Precio</label>
                                <input type="text" name="txtPrecio" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Stock</label>
                                <input type="text" name="txtStock" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Estado</label>
                                <input type="text" name="txtEstado" class="form-control">
                            </div>
                        </div>
                        <input type="submit" name="accion" value="Crear" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-warning">
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>Precio</th>
                                    <th>Stock</th>
                                    <th>Estado</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
