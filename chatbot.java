import java.util.HashMap;
import java.util.Map;

public class Chatbot {
    private Map<String, String> responses;

    public Chatbot() {
        responses = new HashMap<>();
        responses.put("hello", "Hi there!");
        responses.put("how are you", "I'm good, thank you!");
        responses.put("what's your name", "I'm an AI chatbot.");
    }

    public String generateResponse(String userInput) {
        String response = responses.get(userInput.toLowerCase());
        return response != null ? response : "I'm sorry, I don't understand.";
    }
}
