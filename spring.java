import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChatServlet extends HttpServlet {
    private Chatbot chatbot;

    public ChatServlet() {
        chatbot = new Chatbot();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userInput = request.getParameter("userInput");
        String chatbotResponse = chatbot.generateResponse(userInput);

        // Save the chat to the database
        // For example: databaseConnector.saveChat(userInput, chatbotResponse);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("{\"response\": \"" + chatbotResponse + "\"}");
    }
}
