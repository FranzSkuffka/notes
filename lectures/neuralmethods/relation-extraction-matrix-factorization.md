# Relation Extraction with Matrix Factorization and Universal Schemas

## status-quo
  -  predefined, finite and fixed schuema for RE
    - born-in; employed-by
  - text is labelled and used for supervised training
    - time-consuming and difficult
  - distant-supervision
  	- alignment of DB with text = labelling
  	- requires large DB with the desired schema
  - OpenIE avoids need for existing datasets by using language itself as source for schema
  	- surface patterns between mentions serve as relations
  	- no supervision and very flexible
  	- not good at generalization
  	- textual diversity required for coverage not always available
  	- reasoning is inhibited by this lack of generalization
  - clustering of forms with similar sematnics helps with reasoning
  	- insufficient implicature
  - Freebase has no 'critized' nor 'scientist-at' relation

## Suggestion: Universal Schema
- union of all source schema
  - original input forms (like openIE)
  - reliations from structured 
  - probabilistically fill in inferred, unobserved relations
  - operation on struct- and non-struct data allows to reason about both in mutually-supporting ways
    - predicted surface-pattern relations support freebase relation prediction

## New method
unification in matrix
logistic function with natural parameter for a relation and a tuple
natural parameter is just the dot product of two vector representations
like generalized PCA

TODOS
- read collins
- read nickel et al for factorization

 QUESTIONS:
- what do freebase relations look like
  - surface form patterns
- what means "unlimited set of relations (due to surface forms)"
	- surface form = raw text / language, which is infinite
- why is labelling difficult
- exact definition of distant-supervision
  - some labelled training data
  - pool of unlabelled data
  - operator for labelling this unlabelled data; results expected to be noisy
  - 'bootstrapping'
- what is predicting source data?
- what is semantic equivalence
	- why is it illusive?
- what is penalty
  - quadratic penalty
- what is a latent feature vector
  - matrix-factorized (hidden) vector of input features
- what does the dot-product formula mean
- why can the neighborhood model not use synergies
- why does the neighborhood model not include any parameters from the tuple itself?
  - the tuple parameter is given because we use only observed facts
- what is stochastic gradient descent
