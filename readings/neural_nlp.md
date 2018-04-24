# Goldberg - neural methods for NLP

- FFNNs can take fixed-length input or variable-length input when order is not relevant
- multi-layer perceptron for formerly linear models
> what is a linear model exactly
- convolutional NNs are good for extracting local patterns in data. Input-size is arbitrary
> what is the difference between a convolutional and perceptron architecture
- RNNs are good for sequential data
  - variable sequence input, fixed-size output
  - rarely used standalone, often fed into other network components
  - allow abandoning the markov assumption
> re-research markov assumption
- NLP problems are often structured. That means output is structured
- sequence to sequence = conditioned-generation models
- supervised data is rare, unsupervised is abundant

- MLPs (fully connected FFNNs) are drop-ins for linear learners. Problems include classification and more complex structure prediction problems
> what is beam-search?
