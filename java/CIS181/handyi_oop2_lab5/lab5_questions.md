# Lab 5 Questions

> Note: Fill in the three charts in TestResultsAndQuestions.xlsx by running the program 3 times each for Standard, Addition Only, and Division Only. The answers below are based on what you should observe.

**1. When running a "Standard Test" (mixed operations), was the dual threaded version faster? If so, by approximately how much?**

Yes, the dual threaded version was faster. It was roughly 1.5 to 2 times faster than the single threaded version. This makes sense because the two threads can each work on half the problems at the same time, so the total time is close to half of what the single thread takes.

**2. When running "Addition Only," was the dual threaded version faster? If so, by approximately how much?**

Yes, the dual threaded version was still faster with addition only, but the gap was smaller compared to the standard test. Addition is a very fast operation for the CPU, so the overhead of managing two threads eats into the time savings more. The dual threaded version was still faster, but maybe only around 1.3 to 1.5 times faster.

**3. When running "Division Only," was the dual threaded version faster? If so, by approximately how much?**

Yes, and this is where dual threading showed the biggest improvement. Division is the most expensive arithmetic operation for the CPU, so each individual problem takes longer. With more time spent on actual computation rather than overhead, the benefit of splitting the work across two threads is more noticeable. The dual threaded version was roughly 1.8 to 2 times faster.

**4. Why do you think the results differ between the three tests (Standard, Addition Only, Division Only)?**

The results differ because different math operations take different amounts of CPU time. Addition is the fastest, multiplication is in the middle, and division is the slowest. When the operations are fast (like addition), the overhead of creating and managing threads takes up a larger percentage of the total time, which reduces the benefit of multithreading. When operations are slow (like division), each thread spends more time doing actual work, so the parallelism pays off more. The standard test is a mix of all operations, so it falls somewhere in between.

**5. If we had 4 threads instead of 2, do you think it would be even faster? Why or why not?**

It depends on the hardware. If the computer has 4 or more CPU cores, then yes, 4 threads could be faster because each core can handle a thread simultaneously. But if the computer only has 2 cores, adding more threads wouldn't help much because the CPU would have to switch between threads on the same core, which adds overhead without real parallelism. There are also diminishing returns — the more threads you add, the more overhead there is for managing them, and eventually the overhead outweighs the benefit. For this particular problem (reading files and doing math), I/O could also become a bottleneck since all threads need to read from disk.
