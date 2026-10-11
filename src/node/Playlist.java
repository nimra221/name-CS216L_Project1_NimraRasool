package node;
public class Playlist{
	Node head;
	Node tail;
	Node current;
	
	Stack recentlyPlayed = new Stack();
	Stack deletedSongs = new Stack();
	Stack deletedPositions = new Stack();
	
	public void addSong(String name) {
		Node newNode = new Node(name);
		if(head == null) {
			head = tail = current = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		System.out.println("Song added successfully!");
	}
	
	public int getPosition(Node node) {
	    int position = 1;
	    Node temp = head;

	    while (temp != node) {
	        position++;
	        temp = temp.next;
	    }
	    return position;
	}
	
	public void deleteSong(String name) {
		if (head == null) {
			System.out.println("Playlist is empty!");
			return;
		}
		
		Node temp = head;
		while(temp != null) {
			if(temp.data.equalsIgnoreCase(name)) {
				break;
			}
			temp = temp.next;
		}
		if(temp == null) {
			System.out.println("Song not found!");
			return;
		}
		
		deletedSongs.push(temp.data);
		deletedPositions.push(String.valueOf(getPosition(temp)));
		
		//update previous node
		if(temp.prev != null) {
			temp.prev.next = temp.next;
		} else {
			head = temp.next;
		}
		
		//update next node
		if (temp.next != null) {
	        temp.next.prev = temp.prev;
	    } else {
	        tail = temp.prev;
	    }
		
		// Update current song if it was deleted
	    if (current == temp) {
	        if (temp.next != null) {
	            current = temp.next;
	        } else {
	            current = temp.prev;
	        }
	    }
	    
	    //disconnect removed node
	    temp.next = null;
	    temp.prev = null;
	    System.out.println("Song deleted successfully!");
	}
	
	public void undoDelete() {
		if (deletedSongs.isEmpty()) {
			System.out.println("No deletion to undo!");
			return;
		}
		String song = deletedSongs.pop();
	    int position = Integer.parseInt(deletedPositions.pop());

	    Node newNode = new Node(song);

	    if (head == null) {
	        head = newNode;
	        tail = newNode;
	    } else if (position == 1) {
	        newNode.next = head;
	        head.prev = newNode;
	        head = newNode;
	    } else {
	        Node temp = head;
	        int count = 1;

	        while (count < position - 1 && temp.next != null) {
	            temp = temp.next;
	            count++;
	        }
	        newNode.next = temp.next;
	        newNode.prev = temp;

	        if (temp.next != null) {
	            temp.next.prev = newNode;
	        } else {
	            tail = newNode;
	        }
	        temp.next = newNode;
	    }
	    System.out.println("Song restored successfully: " + song);
	}
	
	 public void displayPlaylist() {
	        if (head == null) {
	            System.out.println("Playlist is empty!");
	            return;
	        }
	        Node temp = head;
	        int count = 1;
	        System.out.println("\n--- MUSIC PLAYLIST ---");
	        while (temp != null) {
	            System.out.println(count + ". " + temp.data);
	            temp = temp.next;
	            count++;
	        }
	    }
	 
	public void searchSong(String name) {
		Node temp = head;
        while (temp != null) {
            if (temp.data.equalsIgnoreCase(name)) {
                System.out.println("Song found: " + temp.data);
                return;
            }
            temp = temp.next;
        }
            System.out.println("Song not found!");
	}
	
    public void sortPlaylist() {
        if (head == null || head.next == null) {
            System.out.println("Not enough songs to sort.");
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node temp = head;

            while (temp.next != null) {
                if (temp.data.compareToIgnoreCase(
                        temp.next.data) > 0) {
                    String swap = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = swap;

                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        System.out.println("Playlist sorted A-Z!");
        displayPlaylist();
    }
	
    public void playCurrent() {
        if (current == null) {
            System.out.println("Playlist is empty!");
            return;
        }
        System.out.println("Now playing: " + current.data);
        recentlyPlayed.push(current.data);
    }

    public void playNext() {
        if (current == null) {
            System.out.println("Playlist is empty!");
        } else if (current.next == null) {
            System.out.println("This is the last song!");
        } else {
            current = current.next;
            playCurrent();
        }
    }

    public void playPrevious() {
        if (current == null) {
            System.out.println("Playlist is empty!");
        } else if (current.prev == null) {
            System.out.println("This is the first song!");
        } else {
            current = current.prev;
            playCurrent();
        }
    }

    public void displayRecentlyPlayed() {
        System.out.println("\n--- RECENTLY PLAYED ---");
        recentlyPlayed.display();
    }

    public void showLastPlayed() {
        String song = recentlyPlayed.peek();

        if (song != null) {
            System.out.println("Last played: " + song);
        }
    }
}
