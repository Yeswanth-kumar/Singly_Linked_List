public class Main {

	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<>();
		
		list.prepend("Hello");
		list.append("World");
		//list.search(28);
		list.contains("World");
		list.display();
	}
}
