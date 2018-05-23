# Injecting logical background into embeddings for relation extraction
Relation extraction is part of information extraction

Recent New approaches:
- unifying canonical relations in a universal schema
- completing that schema using matrix factorization

Approach from the paper = matrix factorization + first-order logic formulae

Essentially, this is the content of logical foundations for computational linguistics

Goal: extend the class of formulae from such facts ( sth(a, b) ) to formulae like forall ( a b : sth(a, b) -> sthelse(a,b) )


QUESTIONS
- freebase schemas = graph. only nodes and links
- what are canonical relations
- logical embedding = entity-pair + relation
- how can those schemas be completed using matrix factorization
- what is distant supervision? - OK = "Distant supervision" is a learning scheme in which a classifier is learned given a weakly labeled training set (training data is labeled automatically based on heuristics / rules).
- what are first-order logic formulae OK = ground atoms
- what are surface patterns / surface-form relations
- what is ada-grad
- how does matrix factorization work for knowledge bases?
- negative atoms vs negative facts (first mention of adagrad)
- what are alignments
  - textual alignments mean that there are no entries for it in the knowledge base - there is direct evidence from the text
  - STILL DO SOME RESEARCH / what does this look like in freebase
 - is Table 2 labelled incorrectly?
- what is zero-shot learning - unseen classed used in the testing set

## The relation between matrix factorization and logic
matrix factorization requires facts
those facts are generated / completed from existing knowledge using first-order logic

## Comparison

- Pre - pre-factorization inference
- Joint - join-optimzation
- inf - pure logical inference
- post-factorization inference


Joint means that while doing the matirx factorization, we use logic formulae to extend existing facts from a sparse training matrix to low-rank logic embeddings


TODO
- take a look at AdaGrad, Freebase Relations
