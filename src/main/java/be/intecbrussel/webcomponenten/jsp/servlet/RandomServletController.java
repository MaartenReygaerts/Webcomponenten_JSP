package be.intecbrussel.webcomponenten.jsp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/randomServlet")
public class RandomServletController extends HttpServlet {

    Random rand = new Random();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int number = rand.nextInt(3);

        if (number == 0){
            req.getRequestDispatcher("/WEB-INF/pages/helloworld.jsp").forward(req,resp);
        }else if(number == 1){
            req.getRequestDispatcher("/WEB-INF/pages/helloCalculator.jsp").forward(req,resp);
        }else if(number == 2){
            req.getRequestDispatcher("/WEB-INF/pages/helloSession.jsp").forward(req,resp);
        }

    }
}
