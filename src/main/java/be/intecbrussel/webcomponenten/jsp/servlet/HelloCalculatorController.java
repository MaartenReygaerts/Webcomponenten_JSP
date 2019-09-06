package be.intecbrussel.webcomponenten.jsp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/calculator")
public class HelloCalculatorController extends HttpServlet {

    private final String RESULT = "CalculatorServlet.result";
    private final String NUMBER = "number";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();
        Object resultAttribute = session.getAttribute(RESULT);

        int result = 0;
        if (resultAttribute != null){
            result = (Integer) resultAttribute;
        }
        String message = "";
        Object messageAttribute = req.getAttribute("message");
        if (messageAttribute != null){
            message = (String) messageAttribute;
        }
        session.setAttribute("result",result);
        session.setAttribute("message",message);
        req.getRequestDispatcher("/WEB-INF/pages/helloCalculator.jsp").forward(req,resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result = 0;
        String operation = req.getParameter("operation");
        String message = "";
        HttpSession session = req.getSession();
        Object resultAttribute = session.getAttribute(RESULT);

        if (resultAttribute != null){
            result = (Integer) resultAttribute;
        }
        String numberParameter = req.getParameter(NUMBER);
        if (numberParameter !=null){
            try{
                switch (operation) {
                    case "+":
                        result += Integer.parseInt(numberParameter);
                        break;
                    case "-":
                        result -= Integer.parseInt(numberParameter);
                        break;
                    case "*":
                        result = result * Integer.parseInt(numberParameter);
                        break;
                    case "/":
                        result = result / Integer.parseInt(numberParameter);
                        break;
                    case "CE":
                        result = 0;
                        break;
                }

            }catch (NumberFormatException ex){
                message = "Invalid number";
            }
        }
        req.setAttribute("message",message);
        session.setAttribute(RESULT,result);
        doGet(req,resp);
    }
}
