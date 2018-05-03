# Neural Networks - A. Frank

NNs can bring quick results

new thinking with regard to classic procedures for sorting etc.
architectures
methods
data

traing of embedded terms vs related phrases

new architectures that do not match with classic pipelines


- what are arguments for certains semantic terms

transfer learnings
traning labeller for semantic roles
> learned parameters get integrated into greate networks lateron



multi-task learning
training on more than one specialized data set to see if there are common abstractions
useful for problems where there is not enough data


> what are useful sub-tasks for my main-task

# Topic: discourse relations
Problem: get sentence relations
with or without _discourse connectors_ like 'but'
without > not enough data for related sentences
adding extra data (supplemented discourse connectors) do not necessarily improve learning performance

> adversarial training
discriminator tries to differentiate data relevance for the learner

# Interpretability
Often NNs don't use the same data points that we do.

New Law for Machine Learning
- software that comes to conclusions must give rationale
- 
models that work with attention lend themselves to visualisation
there are approaches that try to find out critical structures within the network for classification task
> is NN development neuroscience? overlap?
 
new approach: using more symbolic knowledge

## Problems
- sequence labelling
- structured prediction
- relation classification
- inference
- machine translation
- join modelling
- generation

## Solutions
- CNN
- RNN / LSTM / GRU (RNN)
- RecNNs (hierarchical tree structure)
- Relational (siamese)
- Seq2Seq Encoder / Decoder Model
- Graph NNs
- Multi-Source / Multi-Target
- Multi-Task Models
- Adversarial Models

it's often easier to stick to a common framework
RNNs and CNN have similar performance in sentiment analysis but RNNs are easier to integrate into larger systems

## Papers
- Style Transfer
- Adversarial Training for Discourse Relation
- Interpretability

## Presentation
- changes
- can we trust
- what are the tipps
- what is the context
- 
# Session II
Syntax & Semantic Role Labelling

Dependency Labelling -> Semantic Role Labelling

Structured Predictions is more than labeling entities

Dependency -> Transition based / Graph-based
Constituent -> CYK

Dependencies are similiar across languages -> generality

## Neural Networks
- classic Shift-reduce
- sequence-labeling
- graph-based or relatin based

Dependencies
1. bilexicas affinities [the -> dog]
2. dependency distance - usually the distance between head and dependent are usually low
3. intervening - words in-between
4. valency  ? 

english is generally an interesting field because it's ambiguous and not-so explicit

RNNs forget to quickly - so we get LSTMs
CNN are good for pattern recognition

bi-LSTM are nice for temporal data


two different variants of LSTM
- final concatenation
- in-place concatenation

highway lanes are useful for preventing forgetting

character-based-embeddings can use word-level features like endings to find out relations

Questions
- width of input is always limited to a window? - yes
- what are the two diffent types of lstms?
- highway connections vs LSTM
