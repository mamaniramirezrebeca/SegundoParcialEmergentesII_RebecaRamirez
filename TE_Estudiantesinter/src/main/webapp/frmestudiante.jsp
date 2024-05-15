<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergente.modelo.Estudiante"%>
<%
    Estudiante estudiante = (Estudiante) request.getAttribute("estudiante");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>REGISTRO</h1>
        <form action="EstudiantesController"  method="post">
            <input type="hidden" name="id" value="${estudiante.id}"/>
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${estudiante.nombre}"/></td>
                </tr>

                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellido" value="${estudiante.apellido}"/></td>
                </tr>

                <tr>
                    <td>Seminario</td>
                    <td><input type="text" name="seminario" value="${estudiante.seminario}"/></td>
                </tr>

                <tr>
                    <td>Confirmado</td>
                    <td><input type="text" name="confirmado" value="${estudiante.confirmado}"/></td>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td><input type="text" name="fecha" value="${estudiante.fecha}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"/></td>
                </tr>
            </table>


        </form>


    </body>
</html>
