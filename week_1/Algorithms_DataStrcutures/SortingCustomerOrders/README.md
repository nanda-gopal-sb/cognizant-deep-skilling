## Sorting Customer Orders

Bubble Sort compares adjacent elements and swaps them until the list is ordered. It is simple but slow. Insertion Sort builds the sorted list one item at a time and works well for small or nearly sorted data. Quick Sort divides the list around a pivot and sorts the parts recursively. Merge Sort divides the list into halves, sorts each half, and merges them back together.

Bubble Sort has time complexity of O(n^2) in the average and worst cases. Quick Sort has average time complexity of O(n log n) and worst-case time complexity of O(n^2), although the worst case is uncommon with a good pivot choice.

Quick Sort is generally preferred over Bubble Sort because it is much faster on large datasets and performs far fewer swaps and comparisons in practice.
