package node;
public class Stack {
	Node top;
	
	public Stack() {
		top = null;
	}
	
	public void push(String x) {
		Node n1 = new Node(x);
		n1.next = top;
		top = n1;
	}
	
	public String pop() {
		if(top == null) return null;
		String item = top.data;
		top = top.next;
		return item;
	}
	
	public String peek() {
		if(top == null) {
			System.out.println("There is no song in playlist!");
			return null;
		}
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void display() {
		Node temp = top;
		if(top == null) {
			System.out.println("There is no song in playlist!");
			return;
		}
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
