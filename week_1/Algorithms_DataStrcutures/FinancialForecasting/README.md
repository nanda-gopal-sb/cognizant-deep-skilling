## Financial Forecasting

Recursion is a technique where a method calls itself to solve a smaller version of the same problem until it reaches a base case. It is useful when the problem naturally repeats in smaller steps.

This solution predicts future value by applying each growth rate recursively. The recursive method takes the current value and moves through the growth-rate list one step at a time.

The time complexity is O(n), where n is the number of growth-rate entries. The space complexity is O(n) because each recursive call uses stack space.

To optimize the solution, you can convert it to an iterative loop or use tail recursion when supported. That avoids deep recursion and reduces stack overhead.
