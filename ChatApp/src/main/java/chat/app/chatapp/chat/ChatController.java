package chat.app.chatapp.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("Chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMesseage (
            @Payload ChatMessage chatMessage
    ){
        return chatMessage;
    }

    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor

    ){
        headerAccessor.getSessionAttributes().put("username",chatMessage.getSender());
        return chatMessage;
    }


}
