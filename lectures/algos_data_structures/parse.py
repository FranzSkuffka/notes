import re

OPERATORS = '|\+|\-|\*|\/'
NUMBERS = '\(?[0-9]\)?'

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
  rev = list(reversed(nested))
  least = None
  for index, part in enumerate(rev):
    if not(isinstance(part, list)) and ('*' in part or '/' in part):
      print(part)
      least = index
  for index, part in enumerate(rev):
    if not isinstance(part, list) and ('+' in part or '-' in part):
      print(part, type(part), not isinstance(part, list))
      least = index
  actual = len(nested) - least - 1
  print(actual)
  print(nested[0:actual], nested[actual], nested[actual + 1: len(nested)])
  return (nested[0:actual], nested[actual], nested[actual + 1: len(nested)])

def parse(s):
  nested = split(s)
  return build(nested)

print(parse('2*4*(3+(4-7)*8)-(1-6)'))
