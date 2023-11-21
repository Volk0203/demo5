public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }
    public ResponseEntity<?> addMessage(Message message) {
        User user = userRepository.findById(message.getUserId());
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        messageRepository.save(message);
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<?> deleteMessageById(Long messageId) {
        messageRepository.deleteById(messageId);
        return ResponseEntity.ok().build();
    }
    public List<Message> getMessagesByUserId(Long userId) {
        return messageRepository.findByUserId(userId);
    }
}
