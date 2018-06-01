import re

OPERATORS = '|\+|\-|\*|\/'
NUMBERS = '\(?[0-9]\)?'

OPERATOR_FNS = {
  '+': lambda x, y: x + y,
  '-': lambda x, y: x - y,
  '*': lambda x, y: x * y,
  '/': lambda x, y: x / y
}

class NodeNum:
    def __init__(self, value):
        v = int(value)
        self.value = v
    def eval(self):
        return self.value
class NodeOp:
    def __init__(self, value):
        self.value = value
        self.left = self.right = None
    def eval(self):
        return OPERATOR_FNS[self.value](self.left.eval(), self.right.eval())

def groupRest(restParts):
    opening = 0
    closing = 0
    for index, part in enumerate(restParts):
        if '(' in part:
            opening = opening + 1
        elif ')' in part:
            closing = closing + 1
        if opening == closing:
            innerWithBrackets = ' '.join(restParts[0: index + 1])
            inner = innerWithBrackets[1: len(innerWithBrackets) - 1]
            break
    res = [split(inner)] + split(' '.join(restParts[index + 1: len(restParts)]))
    return res

def group(parts):
    res = []
    for index, part in enumerate(parts):
        if '(' in part:
            res = res + groupRest(parts[index:len(parts)])
            break
        else:
            res.append(parts[index])
    return res

def split(s):
    """
    
    """
    parts = re.findall('(' + NUMBERS + OPERATORS + ')',s)
    res = group(parts)
    return res

def build(nested):
  # flattwen double-nested list
  if len(nested) == 1 and isinstance(nested, list) and isinstance(nested[0], list):
    nested = nested[0]
  rootOpPos = findRootOperatorPosition(nested)
  # if an operator was found, recurse
  if rootOpPos:
    root = NodeOp(nested[rootOpPos])
    root.left = build(nested[0:rootOpPos])
    root.right = build(nested[rootOpPos + 1: len(nested)])
    return root
  else:
    return NodeNum(nested[0])

def findRootOperatorPosition(nested):
  # we reverse the list because the leftmost operator has the highest precedence and we can't iterate from right to left
  rev = list(reversed(nested))
  # we first want the lesser-binding leftmost operators (+, -)
  # multiplication and division bind stronger, so we check their positions first and overwrite them with plus/minus positions if found
  leftMostLeastBindingOperatorPosition = None
  for index, part in enumerate(rev):
    if not(isinstance(part, list)) and ('*' in part or '/' in part):
      leftMostLeastBindingOperatorPosition = index
  for index, part in enumerate(rev):
    if not isinstance(part, list) and ('+' in part or '-' in part):
      leftMostLeastBindingOperatorPosition = index
  if leftMostLeastBindingOperatorPosition:
    # reverse index back
    return len(nested) - leftMostLeastBindingOperatorPosition - 1
  else:
    return None

def parse(s):
  print('parsing', s)
  nested = split(s)
  tree = build(nested)
  return tree

res = parse('2*4*(3+(4-7)*8)-(1-6)')
print(res, res.eval())
