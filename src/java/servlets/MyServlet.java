/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Author;
import entity.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.AuthorFacade;
import session.BookFacade;

/**
 *
 * @author user
 */
@WebServlet(name = "MyServlet", urlPatterns = {
    "/addAuthor",
    "/createAuthor",
    "/addBook",
    "/createBook",
    "/listBooks"
})
public class MyServlet extends HttpServlet {
    @EJB private AuthorFacade authorFacade;
    @EJB private BookFacade bookFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        switch (path){
            case "/addAuthor":
                
                request.getRequestDispatcher("/WEB-INF/addAuthor.jsp").forward(request, response);
                break;
            case "/createAuthor":
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String birthYear = request.getParameter("birthYear");
                if ("".equals(firstName)
                        || lastName.isEmpty()
                        || birthYear.isEmpty()) {
                    request.setAttribute("firstName", firstName);
                    request.setAttribute("lastName", lastName);
                    request.setAttribute("birthYear", birthYear);
                    request.setAttribute("info", "Year of birth with numbers");
                request.getRequestDispatcher("addAuthor.jsp").forward(request, response);
                break;
                    
                }
                Author author = new Author();
                author.setFirstName(firstName);
                author.setLastName(lastName);
                author.setBirthYear(Integer.parseInt(birthYear));
                authorFacade.create(author);
                request.getRequestDispatcher("addAuthor.jsp").forward(request, response);
                break;
            case "/addBook":
                
                
                break;
            case "/createBook":
                
                
                break;
            case "listBooks":
                
                
                break;
        }
        List<Book> books = bookFacade.findAll();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/listBooks.jsp").forward(request, response);
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
