package com.jvlcode.jvlchat.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jvlcode.jvlchat.entity.Message;
import com.jvlcode.jvlchat.repository.MessageRepository;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // GET ALL MESSAGES
    @GetMapping
    public List<Message> getMessages() {

        return messageRepository.findAllByOrderByIdAsc();
    }


    // SAVE TEXT MESSAGE
    @PostMapping("/text")
    public ResponseEntity<?> saveText(
            @RequestParam String message,
            @RequestParam Integer uid) {

        Message newMessage = new Message();

        newMessage.setMessage(message);
        newMessage.setUid(uid);
        newMessage.setUrl(null);

        Message saved = messageRepository.save(newMessage);

        return ResponseEntity.ok(saved);
    }


    // SAVE AUDIO URL
    @PostMapping("/audio")
    public ResponseEntity<?> saveAudio(
            @RequestParam String url,
            @RequestParam Integer uid) {

        Message newMessage = new Message();

        newMessage.setUrl(url);
        newMessage.setUid(uid);
        newMessage.setMessage(null);

        Message saved = messageRepository.save(newMessage);

        return ResponseEntity.ok(saved);
    }


    // DELETE MESSAGE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(
            @PathVariable Integer id) {

        if (!messageRepository.existsById(id)) {

            return ResponseEntity
                    .notFound()
                    .build();
        }

        messageRepository.deleteById(id);

        return ResponseEntity.ok(
                "Message deleted successfully"
        );
    }
}