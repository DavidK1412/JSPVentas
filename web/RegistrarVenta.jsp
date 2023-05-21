<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Venta</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-10 d-flex">
                                    <input type="text" name="codigocliente" value="${cDto.getIdentificacion()}" class="form-control" placeholder="Identificacion">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-info">
                                </div>
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="nombrescliente" value="${cDto.getNombres()}" class="form-control col-sm-6" placeholder="Nombre">
                                    <input type="text" name="apellidoscliente" value="${cDto.getApellidos()}" class="form-control col-sm-6" placeholder="Apellido">
                                </div>
                            </div>
                            <br>
                            <div class="form-group">
                                <label>Datos del Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-12 d-flex">
                                    <input type="text" name="codigoproducto" value="${pDto.getId()}" class="form-control" placeholder="ID Producto">
                                    <input type="submit" name="accion" value="BuscarProducto" class="btn btn-info">
                                </div>
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-12">
                                    <input type="text" name="nomproducto" value="${pDto.getNombre()}" class="form-control col-sm-6" placeholder="Nombre Producto">
                                </div>
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${pDto.getPrecio()}" class="form-control" placeholder="$0">
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" name="cant" value="1" class="form-control" placeholder="">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${pDto.getStock()}" class="form-control" placeholder="Stock">
                                </div>
                            </div>
                            <br>
                            <div class="form-group">
                                <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label>Nro.Serie </label>
                            <input type="text" name="NroSerie" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Nombre</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var = "list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIDProducto()}</td>
                                        <td>${list.getNombreProducto()}</td>
                                        <td>${list.getPrecioProducto()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td>
                                            <a href="#" class="btn btn-warning">Editar</a>
                                            <a href="#" class="btn btn-info">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-3 ml-auto">
                            <input type="text" name="txtTotal" class="form-control" value="${totalPagar}">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
                integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
                integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
        crossorigin="anonymous"></script>
    </body>
</html>