/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UsuarioService;
import util.Util;

/**
 *
 * @author Administrador
 */
@WebServlet(name = "usuario", urlPatterns = {"/*"})
public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    HttpServletRequest _REQUEST;
    HttpServletResponse _RESPONSE;
    Util util = new Util();
    UsuarioService service = new UsuarioService();

    private void pesquisar_usuario() {
        Usuario filtro = new Usuario();
        try {
            util.RequestToObject(_REQUEST, filtro);
            util.Response200Json(_RESPONSE, service.getUsuarios(filtro));
//        retornar(200, service.getUsuarios().toString());
        } catch (IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alterar_usuario() {
        try {

            Usuario u = new Usuario();

            util.RequestToObject(_REQUEST, u);
            if( service.alterar(u)){
                util.ResponseMsg(_RESPONSE, 200, "Usuário gravado");
            }else {
                util.ResponseMsg(_RESPONSE, 500, "Usuário não gravado");
            }
            
           

//        retornar(200, service.getUsuarios().toString());
        } catch (IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void add_usuario() {
        try {

            Usuario u = new Usuario();

            util.RequestToObject(_REQUEST, u);
            Long id = service.add(u);
            if (id != null && id > 0) {
                util.Response200Json(_RESPONSE, u);
            } else {
                util.ResponseMsg(_RESPONSE, 500, "Usuário não gravado");
            }

//        retornar(200, service.getUsuarios().toString());
        } catch (IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8");
        _REQUEST = request;
        _RESPONSE = response;
        /* TODO output your page here. You may use following sample code. */

        String acao = request.getPathInfo();
        String metodo = request.getMethod();
        if (metodo.equals("POST") && acao.equals("/pesquisar")) {

            pesquisar_usuario();

        }
        if (metodo.equals("POST") && acao.equals("/add")) {

            add_usuario();

        }
        if (metodo.equals("POST") && acao.equals("/alterar")) {

            alterar_usuario();

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
