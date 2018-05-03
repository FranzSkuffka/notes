# dep parsing head section
get heads on a word level rather than expecting a tree as IO data structure
- advantage: little feature engineering
- post-processed using chu-liu-edmond algorithm
converts directed graph into undericted tree

# Beam search
https://www.youtube.com/watch?v=UXW6Cs82UKo
keep top n probabilities in a viterbi and continue with those.

# Softmax
softmax function : Vector -> Vector
"In probability theory, the output of the softmax function can be used to represent a categorical distribution – that is, a probability distribution over K different possible outcomes."
- https://en.wikipedia.org/wiki/Softmax_function


# Results
LAS = labeled attachment score
UAS = unlabeled "

projective = results in tree

Performance of non-neural parsers is better

generality through testing different languages

## Process
sentence is encoded as sequence of representation
- word embedding
- part-of-speech
- position

for each word in the sent we take a look at all other words in the sentence
we use the representations

Interesting question: what are the size of the features used for word embeddings

different sentence length may give different performance for different-order-parsers
