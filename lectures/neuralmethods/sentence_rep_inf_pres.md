# Sentence Rep
classic - word embeddings
sentences are richer
understandig of text requires sentence representations
problems:
- models not generic
- long training times

SkipThought
- encode sentence context
- robust model for multiple-tasks
- slow to train

FastSent
- denoising encoder


Problems
- unsupervised - low performance
- overfitting

INFERSENT
- generic sentence encoder
- 

GRU has less gates than LSTM / is simpler
LSTM
Hierarchical convNet

BiLSTM gives best results
AllNLI Corpus best training set

Questions
- Why does max pooling give better results
  - non-linearity?
  - hidden-vectors output by the lstm
  - which values are picked from the representation
  - what does it take from the word reprensation into the sentence representation
  - would it still outperform on different tasks
  - maybe the tasks are not chosen general enough?
  - increased size of the sentence vectors
  - BiGRU last assumes that the network can look beyond the sentence


Notes
- LaTeX presentation
- Citations below images
- 30 slides
- presents every part of the paper
- comparison of different methods
- duration: 20 minutes
