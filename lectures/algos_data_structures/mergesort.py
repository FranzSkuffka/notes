def load_test_cases(path):
  return read_file("./test_files/" + path + ".txt")

""" Read a file by filename its contents """
def read_file(filename):
  with open(filename) as active_file:
    return [int(l.strip()) for l in active_file]

def mergesort(arr):
  __merge_sort(arr, 0, len(arr) - 1)

def __merge_sort(arr, idx, last):
  print(arr)

mergesort(load_test_cases("rand.dups.1000"))
print(load_test_cases("rand.dups.1000"))
# print(len(mergesort(load_test_cases("rand.dups.1000"))))
print(mergesort([2,3,6,1,15,2,34,5]))
