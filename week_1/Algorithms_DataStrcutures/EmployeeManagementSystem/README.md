## Employee Management System

Arrays are stored in contiguous memory locations, which makes index-based access fast. Their main advantages are simple structure, constant-time access by index, and low overhead.

In this system, the employee records are stored in an array. Adding a new employee is O(1) when space is available, searching is O(n), traversing is O(n), and deleting is O(n) because elements must be shifted after removal.

Arrays are limited because they have fixed size and require shifting for insertions and deletions. They are best when the number of records is known in advance and fast direct access is more important than frequent resizing.
