package Servlets;

import com.mycompany.hospital.ConexionBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Eraso
 */
@WebServlet(name = "SV_Recibe", urlPatterns = {"/SV_Recibe"})
public class SV_Recibe extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<String[]> pacientes = new ArrayList<>();

        try (Connection conn = ConexionBD.conectar()) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM pacientes");

                while (rs.next()) {
                    String[] paciente = new String[6];
                    paciente[0] = rs.getString("idPaciente");
                    paciente[1] = rs.getString("nombres");
                    paciente[2] = rs.getString("apellidos");
                    paciente[3] = rs.getString("fecha");
                    paciente[4] = rs.getString("celular");
                    paciente[5] = rs.getString("direccion");
                    pacientes.add(paciente);
                }

                request.setAttribute("pacientes", pacientes);
            }

        } catch (SQLException e) {
            request.setAttribute("error", "Error de conexión: " + e.getMessage());
        }

        // Redirige a index.jsp con los datos o con el error
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Muestra los pacientes o un error si no se puede conectar";
    }

}
