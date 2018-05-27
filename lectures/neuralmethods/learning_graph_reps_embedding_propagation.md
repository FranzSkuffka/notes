# Learning Graph Representations with Embedding Progagation

## Motivation
Some information is better as graph than as text (unstructured).
Texts can also be represented as graphs

Graphs can be represented as one-hot but this is sparse
Words can more efficiently be represented as embeddings
- You shall know a word by a company it keeps
- You shall know a node by the neighbors it keeps

## Related Work - DeepWalk
- pick a node from a graph and then jump to n more random nodes
  - our node is now a sequence
  - with word2vec
  - number of edges is roughly a metaphor for word frequency
  - a node with more edges is more strongly connected to it's context
  - it is an approximation
### Word2Vec
Sequence of words w1, w2, w3, w4
|V| = 1000
w1 = one-hot -> |V| [0,..., 0, 1, 0, ..., 0]

Matrix = d x |V|
    
    |V|
         cut-out
  |      ||   |
  |      ||   |
  |      ||   |
d |      ||   |
  |      ||   |
  |      ||   |
  |      ||   |

This vector is fed into a NN with softmax normalization
d -> NN |V| 

Word2Vec is about predicting the words in context

## Embedding Propagation
Embedding propagation allows us to inherit the embeddings of a node from it's neighbors

Multimodal because it can also use more data like images
EP only uses direkt neighbors!!!
EP uses no transition probabilities
Calculation is different from the Word2Vec calculations

## Algo
Each word and labels from a node have their own embedding using the one-hot slice.
Only entities (labels, words...) of the same type are calculated together

Minimize the difference between the current and the 

(classed representation of neighboring nodes, rep of this node) -> gradient

Convnet representations of images can be used
composition function h_i(v)
- extract feature vectors from the node
composition function h~_i(v)
- extract feature vectors from the node

Must be differentiable and take variadic arguments
LSTM does not make much sense because order is irrelevant
min-pooling, max-pooling, concat are options

why is this formula not so good when we use max-pooling?
The loss function can lead to everything being the same

- same types of embeddings have the same length
  - only like this the gradient propagation works
- the representation of the starting node is also included

## EP-B
- composition function = average vector
- loss function = hinge loss
  - the distance of my context to myself must be lower than anyone to my context
## Formal Analysis
- Graph G = (V, E)
- k different label types
- lab_max = max number of labels per node
- deg_max = max number of neighbors
- T(n) complexity of g_i
- O(k|V|T(lab_max deg_max))

- k, lab_max, deg_max is constant
hinge loss is actually squared when 
## Results
- transductive vs inductive (inductive = training without test nodes)
  - for training sets without node attribs this is like zero-shot
## Closing notes


- why is sparsity bad

## Presentation styles
- asks questions about the paper
- explanations about the dataset
- things about the paper he liked and he did not like
