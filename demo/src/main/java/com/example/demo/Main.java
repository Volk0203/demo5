import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
		MessageController messageController = new MessageController();
		LocalDateTime currentTime = LocalDateTime.now();
		messageController.createMessage(1, "Заголовок", "Текст сообщения", currentTime);
		System.out.println("Список сообщений:");
		for (Message message : messageController.getMessages()) {
			System.out.println("ID: " + message.getId());
			System.out.println("Заголовок " + message.getTitle());
			System.out.println("Сообщение " + message.getText());
			System.out.println("Время " + message.getTime());
		}
		messageController.updateMessage(1, "Новый заголовок", "Новый текст сообщения", LocalDateTime.now());
		messageController.deleteMessage(1);
	}
}
