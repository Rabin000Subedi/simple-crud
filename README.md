# Wildfire Burned Area Prediction in Nepal

## Overview
This project, developed for the **ITS66604 Machine Learning and Parallel Computing** course, predicts wildfire burned area (in hectares) in Nepal using the UCI Forest Fires dataset. It supports the Department of Forest and Soil Conservation (DoFSC) by providing a scalable machine learning pipeline to estimate fire impact. The pipeline uses **Linear Regression** and **Random Forest Regressor**, leveraging **Apache Spark** for parallel preprocessing and **Python multiprocessing** for efficient model training. Visualizations include a system architecture diagram, scatter plot, and correlation heatmap to analyze model performance and feature relationships.

## Dataset
- **Source**: UCI Forest Fires dataset (`forestfires.csv`, 517 records, 12 features: `X`, `Y`, `month`, `day`, `FFMC`, `DMC`, `DC`, `ISI`, `temp`, `RH`, `wind`, `rain`, `area`).
- **Relevance**: Meteorological features (`temp`, `RH`) align with Nepal’s dry season (March–May, ~40,000 hectares burned annually).
- **Access**: Download from [UCI Machine Learning Repository](https://archive.ics.uci.edu/ml/machine-learning-databases/forest-fires/forestfires.csv).

## Requirements
- **Environment**: Google Colab (Python 3.8+)
- **Libraries**:
  ```bash
  pip install pyspark seaborn matplotlib pandas numpy scikit-learn plantuml
