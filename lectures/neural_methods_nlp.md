# Neural Networks - A. Frank

NNs can bring quick results

new thinking with regard to classical procedures for sorting etc.
architectures
methods
data


traing of embedded terms vs related phrases

new architectures that do not match with classical pipelines


- what are arguments for certains semantic terms

transfer learnings
traning labeller for semantic roles
> learned parameters get integrated into the network that lateron



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
