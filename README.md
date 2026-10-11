Project Titile: 
 Music Playlist Manager

 Description : 
A menu-driven Java application that manages a music playlist using a doubly linked list. Users can add, delete, search, sort, and play songs, undo deletions, and view recently played songs.

 Data Structures Used : 
- Doubly Linked List : Stores songs and supports forward/backward navigation.
-Stack : Stores recently played songs and deleted songs.
-Stack : Stores deleted song positions so songs can be restored to their original positions.

Features: 
- Add and display songs
- Delete a song and undo the deletion
- Search for a song
- Sort songs alphabetically (A–Z)
- Play the current, next, or previous song
- Display recently played songs
- Show the last played song

 Time Complexity

Let n be the number of songs in the playlist and r be the number of recently played entries.

| Operation | Time Complexity |

| Add song | O(1) |
| Display playlist | O(n) |
| Search song | O(n) |
| Delete song | O(n) |
| Undo deletion | O(n) |
| Sort playlist (bubble sort) | O(n²) |
| Play current song / move next or previous | O(1) |
| Display recently played | O(r) |
| Show last played song | O(1) |

 GitHub Repository
Repository link  : https://github.com/nimra221/name-CS216L_Project1_NimraRasool.git
=======
# name-CS216L_Project1_NimraRasool
A Java-based Music Playlist Manager that uses a doubly linked list and stacks to manage songs. It supports adding, deleting, searching, sorting, playing next and previous songs, undoing deletions, and tracking recently played songs.
>>>>>>> 2fbadb0611a1a55c9dfb97df6f2acd07a3e92512
