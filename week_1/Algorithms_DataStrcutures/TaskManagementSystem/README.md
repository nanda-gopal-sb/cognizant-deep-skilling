## Task Management System

A singly linked list stores each node with data and a reference to the next node. A doubly linked list stores both next and previous references, which makes backward traversal easier but uses more memory.

This system uses a singly linked list to manage tasks. Adding a task at the end is O(1) with a tail reference, searching is O(n), traversing is O(n), and deleting is O(n).

Linked lists are useful when the data size changes often because they grow dynamically and do not require shifting elements like arrays do.
