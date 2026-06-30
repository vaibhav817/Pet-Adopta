package pet.project.PetAdopa.Service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
@Service

public class OllamaService {

    private final ChatClient chatClient;

    public OllamaService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String askPetQuestion(String question) {
        String prompt = 
            "You are a helpful pet care assistant " +
            "for Pet Adopa, an online pet store. " +
            "Answer this question helpfully and briefly: " 
            + question;
            
        return chatClient
                .prompt()
                .user(prompt)
                .call()
                .content();
    }
}

