<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.String"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hospital</title>
</head>
<body>

    <h1>Base de Datos Hospital</h1>

    <form action="SV_Recibe" method="POST">
        <input type="submit" value="Conectar" name="Conectar">
    </form>

    <br>

    <%
        // Mostrar mensaje de error si existe
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <h2 style="color: red;"><%= error %></h2>
    <%
        }

        // Mostrar tabla de pacientes si existen
        ArrayList<String[]> pacientes = (ArrayList<String[]>) request.getAttribute("pacientes");
        if (pacientes != null && !pacientes.isEmpty()) {
    %>
        <h2>Lista de Pacientes</h2>
        <table border="1" cellpadding="5" cellspacing="0">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Celular</th>
                    <th>Dirección</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (String[] paciente : pacientes) {
                %>
                    <tr>
                        <td><%= paciente[0] %></td>
                        <td><%= paciente[1] %></td>
                        <td><%= paciente[2] %></td>
                        <td><%= paciente[3] %></td>
                        <td><%= paciente[4] %></td>
                        <td><%= paciente[5] %></td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    <%
        }
    %>
</body>
</html>
