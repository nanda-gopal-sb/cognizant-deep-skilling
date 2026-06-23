## Library Management System

Linear search checks each book one by one. Binary search repeatedly halves the sorted list, so it is much faster for large ordered datasets.

This system stores books in a class with bookId, title, and author. Linear search is used to find a book by title in an unsorted array, and binary search is used when the array is already sorted by title.

Linear search has O(n) time complexity in the average and worst cases. Binary search has O(log n) time complexity in the average and worst cases, but it only works on sorted data.

Use linear search for small or changing lists. Use binary search for large, sorted book collections where fast lookup matters.
