package demoservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {

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

        String text = request.getParameter("text");
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = getServletContext();  //Get input stream for reading data 

        try (PrintWriter out = response.getWriter()) {  //get output stream
            out.println("<!DOCTYPE html>"); //write to output stream
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Request DemoServlet</title>");
            out.println("</head>");
            out.println("<body>");

            if (text.isEmpty()) {
                out.println("<div>\n" +
"            <form action=\"DemoServlet\" method=\"GET\">\n" +
"                Enter something here:<br/>\n" +
"                <input type=\"text\" name=\"text\" size=\"20\" maxlength=\"256\">\n" +
"                <br/>\n" +
"                <br/>\n" +
"                <input type=\"submit\" value=\"Submit\">\n" +
"            </form> \n" +
"        </div>");
            } else {
                try {
                    int num = Integer.parseInt(text);
                    
                    out.println("<div>\n" + //coment this pnimtln to srtike out requery in page
"            <form action=\"DemoServlet\" method=\"GET\">\n" +
"                Enter something here:<br/>\n" +
"                <input type=\"text\" name=\"text\" size=\"20\" maxlength=\"256\">\n" +
"                <br/>\n" +
"                <br/>\n" +
"                <input type=\"submit\" value=\"Submit\">\n" +
"            </form> \n" +
"               </div>"+
"                <br/>\n" +
"                <br/>\n");
                    
                    out.println(num + 1);
                } catch (NumberFormatException ignored) {
                    out.println("<div>\n" + //coment this pnimtln to srtike out requery in page
"            <form action=\"DemoServlet\" method=\"GET\">\n" +
"                Enter something here:<br/>\n" +
"                <input type=\"text\" name=\"text\" size=\"20\" maxlength=\"256\">\n" +
"                <br/>\n" +
"                <br/>\n" +
"                <input type=\"submit\" value=\"Submit\">\n" +
"            </form> \n" +
"               </div>"+
"                <br/>\n" +
"                <br/>\n");
                                    
                    String[] words = text.split("\\s+");
                    out.println(text + "\ncontains " + words.length + " words.");
                }
            }
            out.println("</body>");
            out.println("</html>");
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
