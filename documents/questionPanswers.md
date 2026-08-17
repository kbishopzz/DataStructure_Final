Warehouse Inventory & Order Priority System - Question Answers
---
Section 1: Binary Search Tree (BST)
1. Why does an inorder traversal of a BST return sorted results?

Inorder traversal basically walks the tree in the “natural” order the values are stored: left side first, then the current node, then the right side. Because the BST always keeps smaller values on the left and bigger ones on the right, following that pattern ends up giving you the values in sorted order without doing anything fancy.
“It recursively traverses the entire left subtree first… then the node… then the right subtree.”
---
2. What happens if you insert values in order (1, 2, 3, 4, 5)? How does this affect performance?

If you insert numbers in perfect ascending order, the tree doesn’t really branch — it just keeps growing to the right. You end up with something that looks more like a long stick than a tree. And because of that, every operation (searching, inserting, finding highest, etc.) takes longer since you have to walk through every node one by one.
“The tree structure degrades into a single linear chain… with no left children anywhere.”
---
3. Difference between average and worst‑case time complexity for a BST

In the average case, the tree is nicely balanced, so everything is pretty quick. In the worst case, the tree becomes that “stick” shape, and suddenly everything slows down because you’re basically doing a long list traversal.
“Worst case occurs when elements are inserted in already sorted order… the tree degrades into a single-line linked list.”
---
4. Where would you place duplicate priority values?

I’d put duplicates on the right side of the node. It keeps the logic simple, avoids weird special cases, and still keeps the tree behaving properly. Plus, when you do an inorder traversal, duplicates show up together in the order they were added, which feels natural.
“Duplicate priority values are placed in the right subtree.”
---
Section 2: Sorting Algorithm (Insertion Sort)

5. Explain how your sorting algorithm works using a small example.
Insertion Sort works kind of like organizing a hand of playing cards. You take one item at a time and slide it into the correct spot by shifting bigger items over. It’s simple, predictable, and easy to follow.
“It takes one item at a time… and shifts larger items to the right to insert the current item.”
---
6. What is the time complexity of your algorithm?

Insertion Sort is one of those algorithms that’s great when things are already mostly sorted, but not so great when they aren’t.
• Worst case: slow
• Average case: still slow
• Best case: fast if everything is already in order
“Worst-case… average-case… best-case…”
---
7. When does your sorting algorithm perform well?

It shines when the list is small or almost sorted already. In those situations, it’s quick, simple, and doesn’t waste time doing unnecessary work.
“For small lists… or nearly sorted data.”
---
8. Why is your sorting algorithm not ideal for very large datasets?

Once the dataset gets big, Insertion Sort starts to struggle. It has to do a lot of shifting and comparing, and that adds up fast. Bigger systems usually switch to more efficient algorithms that scale better.
“Insertion Sort is NOT ideal for very large datasets… better alternatives like MergeSort or QuickSort.”
---
Section 3: System Design & Database

9. Why might you choose to sort data in your application instead of the database?
Sometimes it’s better to sort things in the application layer because:
• You don’t overload the database with extra work
• You can use custom logic that SQL doesn’t handle well
• You might be working with in‑memory structures that make sorting faster or more flexible
“Offloading CPU-intensive sorting… custom business logic… in-memory structures.”
---
10. One advantage of using a BST in this system

A BST makes it really easy to grab the highest or lowest priority order without having to re-sort everything. You just walk to the far right or far left and you’re done.
“Finding the highest priority order takes fast lookup time without needing to re-sort.”
---
11. One limitation of your current design

Right now the BST isn’t balanced, which means it can turn into that “stick” shape if priorities come in sequentially. When that happens, everything slows down. A self-balancing tree would fix that.
“The current BST is an unbalanced Binary Search Tree… the tree degrades into a linear chain.”
---

Section 4: AI Usage & Development Assistance

• Where AI was used:
  - Troubleshooting and debugging the custom recursive Binary Search Tree (BST) insertion, traversal, and min/max lookup logic.
  - Reviewing the manual Insertion Sort algorithm implementation to ensure in-place shifting and stable sorting behavior without JDK utility dependencies.
  - Formulating comprehensive JUnit 5 unit test suites for `OrderBSTTest` and `ProductSorterTest`.
  - Assisting with generating the Postman API collection structure (`Warehouse_API.postman_collection.json`) and drafting comprehensive project documentation/README.

• When AI was used:
  - During the algorithm refinement phase (verifying edge cases such as duplicate priority handling in BST and empty/single-element lists in Insertion Sort).
  - During the test verification phase (confirming test coverage across tree traversals and sorting criteria).
  - During the final documentation and project packaging phase to verify complete rubric alignment against `SD_DSA_FINAL_SUMMER_2026.docx`.