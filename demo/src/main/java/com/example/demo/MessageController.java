import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageController {
	private List<Message> messages;
	public MessageController() {
		messages = new ArrayList<>();
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void createMessage(int id, String title, String text, LocalDateTime time) {
		Message message = new Message(id, title, text, time);
		messages.add(message);
	}
	public Message getMessageById(int id) {
		for (Message message : messages) {
			if (message.getId() == id) {
				return message;
			}
		}
		return null;
	}
	public void updateMessage(int id, String title, String text, LocalDateTime time) {
		Message message = getMessageById(id);
		if (message != null) {
			message.setTitle(title);
			message.setText(text);
			message.setTime(time);
		}
	}
	public void deleteMessage(int id) {
		Message message = getMessageById(id);
		if (message != null) {
			messages.remove(message);
		}
	}
}
