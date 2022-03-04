**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#:      |  5  |
| -------------- | --- |
| Student Names: |  Nicholas Knapton   |
|                |  Jacob Artuso   |
|                |  Brian Kramer  |
|                |  Colin Christophe   |

# 1 Introduction

During our last lab we created tests for the Range and DataUtilities classes. This lab built on the last lab by requiring us to check coverage of these tests. With our new knowledge of how to cover more branches, conditions, and statement we created more tests to improve the code coverage. We were able to check our progress by using ECLEmma.  

# 2 Manual data-flow coverage calculations for X and Y methods
## DataUtilities.calculateColumnTotal()
### Data Flow Graph
![](media/calculateColumnTotalDFG.jpeg)

### Def-Use Sets and DU-Pairs
Defs:
        
         def(1) = {total, rowCount, r, data, column}
         def(3) = {n}
         def(4) = {total}
         def(5) = {r} |
      
Uses:

         use(1) = {data} 
         use(2) = {r, rowCount}
         use(3) = {n, data, r, column}
         use(4) = {total , n}
         use(5) = {r}
         use(6) = {total}

DU-Pairs:

        for total  (1, 4) (4, 4) (4, 6) (1, 6) 
        for data (1, 1) (1, 3)
        for column (1, 3)
        for r (1, 2) (5, 5) (5, 2)
        for n (3, 3) (3, 4)
        for rowCount (1, 2)

    
### Testcases and DU-Pairs Covered

| Test Cases | DU-Pairs covered | DU-Pairs not covered |
| ---------- | ---------------- | -------------------- | 
| calculateColumnTotalTest | for total  (1, 4) (4, 4) (4,6)<br/>for r (1, 2) (5, 5) (5, 2)<br/>for n (3, 3) (3, 4)<br/>for rowCount (1, 2)<br />for data (1, 1) (1, 3)</br>for column (1, 3) | for total (1, 6) | 
| calculateColumnTotalTestZero | for total  (1, 4) (4, 4) (4,6)<br/>for r (1, 2) (5, 5) (5, 2)<br/>for n (3, 3) (3, 4)<br/>for rowCount (1, 2)<br/>for data (1, 1) (1, 3)<br/>for column (1, 3) | for total (1, 6) | 
| calculateColumnTotalTestNegative | for total  (1, 4) (4, 4) (4,6)for r (1, 2) (5, 5) (5, 2)<br/>for n (3, 3) (3, 4)<br/>for rowCount (1, 2)<br/>for data (1, 1) (1, 3)<br/>for column (1, 3) | for total (1, 6) | 
| calculateColumnTotalTestNoRows | for total (1, 6) <br/>for r (1, 2)<br/>for data (1, 1) | for total  (1, 4) (4, 4) (4,6) <br/>for r  (5, 5) (5, 2)<br/>for n (3, 3) (3, 4)<br/>for rowCount (1, 2)<br/>for column (1, 3)<br/>for data (1, 3) |
| calculateColumnTotalTestOtherColumn | for total  (1, 4) (4, 4) (4,6)<br/>for r (1, 2) (5, 5) (5, 2)<br/>for n (3, 3) (3, 4)<br/>for rowCount (1, 2)<br/>for data (1, 1) (1, 3)<br/>for column (1, 3) | for total (1, 6) |
| calculateColumnTotalTestZeroTotal | for total  (1, 4) (4, 4) (4,6)<br/>for r (1, 2) (5, 5) (5, 2)<br/>for n (3, 3) (3, 4)<br/>for rowCount (1, 2)<br/>for data (1, 1) (1, 3)<br/>for column (1, 3) | for total (1, 6) | 

### DU-Pair Coverage
`
Du-pair coverage = Du-pairs covered/Total du-pairs = 13/13 * 100% = 100%
`

# 3 A detailed description of the testing strategy for the new unit test


Our testing strategy was to look through the functions an create du-pairs for each function. We then check to make sure our test cases would cover each du-pair. Further, we ensured that all branches were covered using white box testing. We expanded upon our previous tests as they were lacking in coverage. 

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

In DataUtilities...
- equalsTestNullFirst: ensured functionality was working in the equal method when the first inputted array in null. This increased both conditional and statement coverage.
- calculateColumnTotalTest: adding testing to the overloaded version of the calculateColumnTotal tests allow for the input of a valid row argument. This test increased statement coverage as we had not been testing this method before.
- calculateColumnTotalTestNull: ensured null value functionality working properly for the calculateColumnTotal overloaded method. This increased our condition coverage.\

In Range...
- ADD HERE COLIN AND NICK
# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

![](media/lineCount.png)\
![](media/lines.png)\

# 6 Pros and Cons of coverage tools used and Metrics you report

We used eclemma, it was very easy to integrate with eclipse. We had some trouble interpreting the different coverage terms used. We initially had issues with mocking but were able to resolve them. 

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Requirements-based testing is easier to plan/carry out than coverage-based testing. This is because you only have to know what the expected output is and not how the function being tested operates. However, this does mean that requirements-based testing may not test the function completely. This is where it is advantageous to use coverage-based testing since you will ensure that every possibly test type is used. 

# 8 A discussion on how the team work/effort was divided and managed

Team work was divided evenly in terms of writing the report, designing and writing the tests was done together on two computers for the sake of simplicity.

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

We faced some challenges when it came to properly importing files from assignment 2 and downloading ECLEmma. However, utilizing slides and other online resources we were able to properly use these resources. By using ECLEmma we were able to learn some interesting insights about testing coverage.

# 10 Comments/feedback on the lab itself

The lab was helpful for learning how to properly implement code coverage tools. It also taught how to use code coverage tools to improve current tests and create better tests for the future. 
