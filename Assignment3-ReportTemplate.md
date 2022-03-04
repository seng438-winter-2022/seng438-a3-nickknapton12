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

## Range.combine()
### Data Flow Graph
![](media/combineDFG.jpeg)

### Def-Use Sets and DU-Pairs
Defs:
        
         def(1) = {range1,range2}
         def(6) = {l,u, new Range()}

      
Uses:

        use(2) = {range1} 
        use(3) = {range2}
        use(4) = {range2}
        use(5) = {range1}
        use(6) = {range1, range2, l , u, new Range()}


DU-Pairs:

        for range1 (1, 2) (1, 5) (1, 6)
        for range2 (1, 3) (1, 4) (1, 6)
        for l (6, 6)
        for u (6, 6)
        for new Range() (6, 6)


    
### Testcases and DU-Pairs Covered
Note the test cases below where done with parameterized testing so all the test cases below where the inputs as described by arg1, arg2, expected instead of a test name.

| Test Cases<br/>(arg 1, arg 2, expected) | DU-Pairs covered | DU-Pairs not covered |
| ---------- | ---------------- | -------------------- | 
| new Range(0,2), new Range(1,2), new Range(0,2) | for range1 (1, 2) (1, 6)<br/>for range2 (1, 4) (1, 6)<br/>for l (6, 6)<br/>for u (6, 6)<br/>for new Range() (6, 6) | for range1 (1, 5) <br/>for range2 (1, 3) |
| new Range(1,2), new Range(0,2), new Range(0,2) | for range1 (1, 2) (1, 6)<br/>for range2 (1, 4) (1, 6)<br/>for l (6, 6)<br/>for u (6, 6)<br/>for new Range() (6, 6) | for range1 (1, 5) <br/>for range2 (1, 3) |
| new Range(0,2), new Range(0,1), new Range(0,2) | for range1 (1, 2) (1, 6)<br/>for range2 (1, 4) (1, 6)<br/>for l (6, 6)<br/>for u (6, 6)<br/>for new Range() (6, 6) | for range1 (1, 5) <br/>for range2 (1, 3) |
| new Range(0,1), new Range(0,2), new Range(0,2) | for range1 (1, 2) (1, 6)<br/>for range2 (1, 4) (1, 6)<br/>for l (6, 6)<br/>for u (6, 6)<br/>for new Range() (6, 6) | for range1 (1, 5) <br/>for range2 (1, 3) |
| new Range(0,2), new Range(2,4), new Range(0,4) | for range1 (1, 2) (1, 6)<br/>for range2 (1, 4) (1, 6)<br/>for l (6, 6)<br/>for u (6, 6)<br/>for new Range() (6, 6) | for range1 (1, 5) <br/>for range2 (1, 3) |
| new Range(0,1), new Range(3,4), new Range(0,4) | for range1 (1, 2) (1, 6)<br/>for range2 (1, 4) (1, 6)<br/>for l (6, 6)<br/>for u (6, 6)<br/>for new Range() (6, 6) | for range1 (1, 5) <br/>for range2 (1, 3) |
| new Range(-1,0), new Range(0,1), new Range(-1,1) | for range1 (1, 2) (1, 6)<br/>for range2 (1, 4) (1, 6)<br/>for l (6, 6)<br/>for u (6, 6)<br/>for new Range() (6, 6) | for range1 (1, 5) <br/>for range2 (1, 3) |
| new Range(0,1), new Range(0,1), new Range(0,1) | for range1 (1, 2) (1, 6)<br/>for range2 (1, 4) (1, 6)<br/>for l (6, 6)<br/>for u (6, 6)<br/>for new Range() (6, 6) | for range1 (1, 5) <br/>for range2 (1, 3) | 
| new Range(0,1), null, new Range(0,1) | for range1 (1, 2) ( 1, 5)<br/>for range2 (1, 4) | for range1 (1, 6)<br/>for range2 (1,3) (1, 6)<br/>for l (6, 6)<br/>for u (6, 6)<br/>for new Range() (6, 6) |
| null, new Range(0,1), new Range(0,1) | for range1 (1, 2)<br/>for range2 (1, 3) | for range1 (1, 5) (1, 6)<br/>for range2 (1, 4) (1, 6)<br/>for l (6, 6)<br/>for u (6, 6)<br/>for new Range() (6, 6) | 
| null, null, null | for range1 (1, 2)<br/>for range2 (1, 3) | for range1 (1, 5) (1, 6)<br/>for range2 (1, 4) (1, 6)<br/>for l (6, 6)<br/>for u (6, 6)<br/>for new Range() (6, 6) |
| new Range(0,0), new Range(0,0), new Range(0,0) | for range1 (1, 2) (1, 6)<br/>for range2 (1, 4) (1, 6)<br/>for l (6, 6)<br/>for u (6, 6)<br/>for new Range() (6, 6) | for range1 (1, 5) <br/>for range2 (1, 3) |
| new Range(0,50000), new Range(-50000,0), new Range(-50000,50000) | for range1 (1, 2) (1, 6)<br/>for range2 (1, 4) (1, 6)<br/>for l (6, 6)<br/>for u (6, 6)<br/>for new Range() (6, 6) | for range1 (1, 5) <br/>for range2 (1, 3) |


### DU-Pair Coverage
`
Du-pair coverage = Du-pairs covered/Total du-pairs = 9/9 * 100% = 100%
`

# 3 A detailed description of the testing strategy for the new unit test


Our testing strategy was to look through the functions an create du-pairs for each function. We then check to make sure our test cases would cover each du-pair. Further, we ensured that all branches were covered using white box testing. We expanded upon our previous tests as they were lacking in coverage. 

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

In DataUtilities...
- equalsTestNullFirst: ensured functionality was working in the equal method when the first inputted array in null. This increased both conditional and statement coverage.
- calculateColumnTotalTest: adding testing to the overloaded version of the calculateColumnTotal tests allow for the input of a valid row argument. This test increased statement coverage as we had not been testing this method before.
- calculateColumnTotalTestNull: ensured null value functionality working properly for the calculateColumnTotal overloaded method. This increased our condition coverage.

In Range...
- RangeIntersectsDoubleTest: Tested to ensure that the intersect function worked when given two doubles and a range. This increase conditional, statement, and branch cover as this function was not tested in assignment 2.
-  RangeCombineIgnoringNaNTests: This tested the RangeCombineIgnoringNaN function which is a extension of the normal RangeCombine function. This testing increased code coverage by increase statement and conditional coverage that would not have been covered without the NaN version of the combine function.
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
