# Algorithms & Data Structures I 
sorting algorithms is the classic

Books don't go into the same depth as the lecture.

## Grading algorithms
what is good?
performance
efficiency
correctness

a range of techniques that overlap with theoretical computer science

## Computer algorithms
- finite - can be implemented using finit resources with a finite number of instructions
- terminable - must complete in a limited amount of time. Break-rules might make sense
- deterministic - same input same output
- 
- 
Properties
- deterministic - only one way to solve the problem, only one next step at any given time.
- determinable - same I, same O

## Session 2
Elegance is importantz!!
Turing Machine, Turing Hypothesis and determinacy
- correctness, complexity
- principles
- container

### Turing Machines
When is a computer a computer?
Formalisation
a write a into the current position
R one step R
L one step L
goto k
a?k:l If a in current position then k else l
Stop

Intuitively computable functions are Turing-computable functions.

## Correctness
### Complete induction
Expression about natural numbers

Theory
A(n)

a) Induction begin A(1)
b) Conclusion A(n) => A(n+1)

Example

A(n) = E(k = 1, n) k^2 = 1^2 + 2^2 + .. + n^2 = 1/6n(n+1)(2n+1)

a) A(1) = 1^2 = 1/6 * 1(1+1)(2*1+1) = 1
b) A(n+1) = E(k = 1, n + 1) k^2 = (E(k=1, n) n^2) + (n+1)^2 = 1/6n(n+1)(2n+1)(n+1)^2
   A(n) = 1/6 n(n+1A)(2n+1)
        = 1/6 (n+1)[n(2n+1) + (n+1)]
        = 1/6 (n+1)(n+2)(2n+3)

#### Division

```python
dividend = int(input('n='))
divisor = int(input('d='))

# precondition
assert dividend >= 0 ^ divisor > 0


result = 0
rest = dividend

while rest >= divisor:
  rest = rest - divisor
  result = result + 1

# postcondition
assert dividend == (result * divisor + rest) ^ rest >= 0 ^ rest < divisor

print('rest=', rest)
print('result=', result)
```

### Invariants
Loop invariant: INV     INV^~B <=> dividend == result * divisor + rest ^ 0 <= rest < divisor
Loop invariant: INV     INV <=> dividend == result * divisor + rest ^ 0 <= rest
```python
```

## Complexity
General Measure
Number of operations

- Best Case
- Average Case
- Worst Case

n Problem size
T(n) Computation Time

n           | 1 | 10 | 100
T(n) = n    | 1 | 10 | 100
T(n) = n^2  | 1 | 100 | 10000
T(n) = 2^n  | 1 | ~ 10^3 | ~ 10^30

## Principles
### Enumeration
Local alignment
Maximum-Subarry-Problem
Sequence of numbers
find subsequence with highest sum
[1, 2,5, -234, -23,4 34,345, 34, ,-3]

Algo I

```python
def maxSubArray(arr):
  maxSum = 0
  length = len(length)
  for l in range(length):
    for R in range (l, n):
      sum = 0
      for i in range(l, R):
        sum = sum + arr[i]
      if sum > maxSum:
        maxSum = sum
```

Algo II

```python
def maxSubArray(arr):
  maxSum = 0
  length = len(length)
  for l in range(length):
    sum = 0
    for R in range(l, n):
      sum = sum + arr[R]
      maxSum = sum
      if sum > maxSum:
        maxSum = sum
```

### Divide & Conquer
T(n) ~= log2 n

### Scanline
Iso Surfaces

o-o-o-o-o-o
| | | | | |
o-x-o-o-o-o
| | | | | |
o-x-x-x-o-o
| | | | | |
o-o-o-o-o-o

### Recursion

# Algos & Data Structures II

## Primitive data types
Algorithms
  -> Efficiency
    -> Complexity - A measure for Computation time / memory usage

Data Structures
  -> Efficient Access
  -> Operations
    -> Fast Algorithms

Abstract Data Types
  -> Specification, which kind of Data is managed
  -> Specification of Operations on the Data

Data Structures
  -> Implementation of the Abstract Data Types
  -> different runtimes

Data Types are defined by programming languagas

## Abstract Data Types
- Arrays are the strictest: fixed size, fixed type
  - access by index
  - operations
    - create(n): Create array of size n
    - A.get(i): get element at pos i
    - A.set(i, val): set element at pos i to val
    - A.size(): length of array
  - operations on dynamic arrays
    - A.append(x): append x
    - A.deleteLast(): delete last el
- Tuples: fixed size, mixed type
  - access by index
- Lists: variable size, possibly variable type
  - element
    - key, data
    - next -> element
      - direct link
      - handle = indirect link
  - Linked list
  - access by iteration / other list methods

> Excourse: Von Neumann Architecture

Instruction Fetch
Instruction Decode _ Instruction Fetch
Execute            _ Instruction Decode
Memory             _ Execute
Write Back         _ Memory
                   _ Write Back

Superskalar Processor
- parallel processing

if-conditions are bad

> Computer Architecture
HDD
RAM 30ns
3rd-1st-level Cache - few cycles 32k memory
Register
Processors have multi-ghz frequency

using temporal and spacial locality is more performant

list / buffer overflow is critical in IT security

```python
class ListElement:
  def _init_(self, key=0, data=None, next=None, prev=None):
    self.key = key
    self.data = data
    self.next = next
    self.prev = prev

def find(key, first)
  current = first
  while current != None and current.key !=x:
    current = current.next

# length n ~ n Queries
# O(n)

def insertAfter(key, first, newElement): # single-link
  current = first
  # traverse until we hit the element or the end of the list
  while current != None and current.key != x:
    current = current.next
  if current != None and current.key == x:
    newElement.next = current.next
    current.next = newElement

def deleteAfter(key, first, newElement): # single-link
  # WIP- just a stub from insertAfter
  current = first
  # traverse until we hit the element or the end of the list
  while current != None and current.key != x:
    current = current.next
  if current != None and current.key == x:
    newElement.next = current.next
    current.next = newElement
```

A double linked list is more useful when I need to look back / have a delete operation.
Developing the delete Algorithm is easier with a double-link-list
It's a tradeoff between developer ergonomy, data structure size and algorithm efficiency
Usually, developer ergonomy has a greater weight.
Project costs for developer time vs computation time dictate this tradeoff factor

Runtime
List of length n
Query for key x ~n Operations
Insert O(i)
Delete O(i)
Append O(i)


Sentinel List
Like a linked list, but there is a nil element that points back to the first element

differences
- sentintel is replacement for None
- append and prepend require two more changes to the links
- append and prepend actually simplify the process because there is no special case for double-linked-lists

> A list is essentially a class that allows easy access to the elements linked together, starting at the first element


> ## Algos & Data Structures III

- Stack LIFO (n Elements)
  - create() = makes empty stack 
  - push(a) = prepend
  - x = pop() # mutates
  - y = peek()
- Queue FIFO (n Elements)
  - create() = makes empty queue 
  - push = append
  - pop = read first

- Heap / Priority Queue (manages set of key/value pairs)
  - insert(x, key)
  - getMin(key)
  - deleteMin(key)

- Dictionary / Map / Assoc Array (manages set of Elements with unique keys)
  - create(x, key) Create new dictionary
    - List : O(I)
    - Array: O(I)
    - SortedArray: O(I)
  - insert(x, key) = prepend # overwrites if key exists
    - List : O(I)
    - Array: O(I)
    - SortedArray: O(n)
  - find(key) # overwrites if key exists
    - List : O(n)
    - Array: O(n)
    - SortedArray: O(log n)
  - delete(key)
    - List : O(n)
    - Array: O(n)
    - SortedArray: O(n)
SortedArray allows divide and conquer
log n complexity is only when the key actually exists.


## Sorting
1/4 of all global computation time

Input:
- Sequence of n Elements, x_1, ..., x_n
- Order Relation (e.g. <=)
Output: by `<=` sorted sequence
forall i < j => xi <= xj

### Selection Sort
1. find smallest element
2. switch to first position
3. repeat

```
selectionSort(A):
  for i = 0 to len(A) - 2 do:
    # find min in A[i, ..., n-1]
    # swap A[i] mit min(A[i, ..., n-1])
```

```python
def selectionSort(alist):
  for i in range(len(alist) - 1):
    least = i
    for k in range(i + 1, len(alist) -1):
      if alist[k] < alist[least]
        least = k
    tmp = alist[least]
    alist[least] = alist[i]
    alist[i] = tmp
```

```python
import time

start = time.time()
# ...
run_time = (time.time() - start_time) * 1000
```
Will result in `f(n) = a + bn + cn^2`

Each loop gives us one exponent - or - one factor with n

## Algo / Data Structures III
- Bubble sort: O(n^2) - two loops where the higher number below a window of two is moved to the second position
- Quick sort: split (best at median). Indices L / R are increased / decreased until they exceed median. Then switch.

## III Complexity
O(g(n)) = { f| elof c > 0, n_0 > 0 forall n >= n0: f(n) <= g(n)}
f(n) elof O(g(n)) falls es konstanten c>0, n_0 < 0 gibt, sodass f(n) <= c g(n) für alle n >= n_0.

omega(g(n)) = { f | exists c > 0, n_0 > 0  forall n >= n_0: f(n) >= c g(n)}
Funktion f(n) elof omega(g(n)) falls es konstancen c >0, n0 <0 gibt, sodass f(n) >= (g(n) für alle n <=n)
f(n) elof O(g(n))
f(n) wächst asymptotisch nicht schneller als g(n)
f(n) elof omega(g(n))
f(n) wächst asymptotosch mindestens so schnell wie g(n)


f(n) = O(g(n))

Beispiel
SelectionSort
c'n^2 <= T(n) <= c n^2
T(n) elof O(n^2); T(n) elof omega(n^2)
T(n) elof theta (n^2)

f(n) = 10n^3
g(n) = n^3 / 1000

10n^3 <= c * n^3 / 1000
10n^3 <= c' * n^3 / 1000

f(n) elof theta(g(n))
f(n) = e ^n; g(n) = n100

f(n) elof omega(g(n))

f(n) = n/log_2n; g(n) = n^1/2
f(n) elof omega(g(n))

f(n) = n^1/256 g(n) = 10logn

f(n) = log10n; g(n) = log2n


Algos / Datastructures IV
Can we get better

Lower bar
Counting Sort

Every program uses n comparisons
n comparisons can be use

T = Depth
2^T leaves
Depth correlates with the number of comparison operations

T elof omega(n log n)


## Counting Sort

Sort int[] of length n

A[i] = x

für alle i elof {0, 1 n-1} A[i] elof {0, k}


Pseudocode
O = Ordnung
```python
# k = unique elements
# n = array length
counts = new int[k + 1] # O(1)
for i = 0 to k:  # O(k)
  counts[i] = 0
for i = 0 to n - 1 # O(n)
  counts[A[i]]++
i = 0
for j = 0 to k:           # Sum(k)(j=0) counts[j] // sum of all = n elements
  for l = 0 to counts[j]:
    A[i] = j
    i++
# O(k + n) Total complexity
```

lower bound = O(n)
upper bound = O(2n) <- k = n


## Radix sort
Generalized count sort
Write xi = ai,0 + ai,1 m + ai,2m^2 + ai,3m^3 + ai,k m ^k

m = 10
1573 = 3 * 10^0, + 7 * 10^ + 5*10^2 + 1*10*3

Algorithmus
1. Sortwith counting sort from ai,0
2. sort with count sort from a:1

O(m + n)        O(n) pro counting sort
m << n (viel kleiner)

x_max : größter zahlenwert

k = [log_m x_max]

Total complexity O(k + n) = O(n log_m x_max) = O(n log_2 xmax / log_2 m)

# SUMMARY
- Selection Sort, Insertion Sort, Bubble Sort worst case theta(n^2)
- morge sort worst case theta(n log n)
- Quicksort worst case O(n^2) average case O(n log n)
- radix sort worst case O(n log n)
- lower bar f comparison-based algorithms = omega(n log n)

## Master Theorem
T(n) = a * T(n/b) + f(n)
- n / b = size of each subproblem
- a = number of subproblem in the recursion
- f(n) = size of work tb done outside the recursion
