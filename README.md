# Custom Sorter

Created by Armand Sarkezians


This sorter works in O(m) time, where m is the largest number in an array. It works well in specific use cases (numbers 1 .. 1000 all in an array but unsorted) and terrible in other use cases (arr = {1, 2, 100000000}). The code given shows a good use case for my sorter, and a comparison to mergeSort. If you change the custom `SIZE` parameter to a smaller number, like 10, my sorter will become wildly inefficient. Keeping SIZE at a larger number, like 100000000, will make the sorter work well.

If you have any tips / suggestions, please submit a pull request and I would gladly look them over. Thanks!

