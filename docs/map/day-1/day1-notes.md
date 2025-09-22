## Künstliche Intelligenz (KI):
- Der Begriff „Künstliche Intelligenz” (KI) bezeichnet einen weit gefassten Bereich der Informatik. In diesem Bereich werden Systeme entwickelt, die Aufgaben ausführen können, für die normalerweise menschliche Intelligenz erforderlich ist, wie z. B. logisches Denken, Lernen und Problemlösen.

## Maschinelles Lernen (ML):
- Maschinelles Lernen ist ein Teilbereich der KI und ermöglicht es Computern, durch Erfahrungen und Daten zu lernen und ihre Leistung bei bestimmten Aufgaben zu verbessern, ohne dass sie für jedes Szenario explizit programmiert werden müssen.

## Große Sprachmodelle:
- LLMs sind eine spezielle Art von maschinellen Lernmodellen. Sie wurden mit riesigen Mengen an Textdaten trainiert, um menschenähnliche Sprache zu verstehen und zu generieren. Sie sind in der Lage, Aufgaben wie Konversation, Schreiben und Textanalyse auszuführen.

### Token:
- Tokens sind die grundlegenden Texteinheiten, die LLMs verarbeiten – die „atomaren Elemente“ der Sprache für das Modell. So wie eine Zeichenfolge durch Aufteilung anhand von Leer- oder Trennzeichen in Tokens zerlegt werden kann, zerlegen LLMs Text auf komplexere Weise in kleinere Einheiten.
  - Ein Token kann ein ganzes Wort („Hallo“), ein Wortteil („ing“), ein Satzzeichen (‚,‘) oder sogar ein Leerzeichen sein.
  - Die meisten modernen LLMs verwenden Algorithmen wie das Byte Pair Encoding (BPE), um aus häufig vorkommenden Zeichenfolgen Token zu erstellen.
  - Da verschiedene Modelle unterschiedliche Tokenizer verwenden, kann derselbe Text unterschiedlich aufgeteilt werden.
- Die Tokenisierung lässt sich mit der Analyse von Quellcode vergleichen. So wie ein Compiler Code in lexikalische Token (wie Schlüsselwörter, Bezeichner und Operatoren) zerlegt, zerlegt ein LLM natürliche Sprache in semantische Token.
  - Token-Limits legen die Größe des Kontextfensters fest. So hat beispielsweise GPT-4 ein Token-Limit von entweder 8.000 oder 32.000.
  - Die Kosten für eine API werden in der Regel pro Token berechnet.
  - Ein Token für englischen Text entspricht ungefähr vier Zeichen, dies variiert jedoch je nach Modell.

### Prompt:
- Ein Prompt ist der Eingabetext, der einem LLM bereitgestellt wird – im Wesentlichen der „Funktionsaufruf“ an das Modell. Dabei kann es sich um eine Anweisung, eine Frage oder den Kontext handeln, der dem Modell mitteilt, was es tun soll.
  - Einfache Abfragen: „Was ist Python?”
  - Anleitung: Schreibe eine Funktion, mit der sich eine Liste sortieren lässt.
  - Beispiele mit Aufnahmen: Bereitstellung von Eingabe-Ausgabe-Paaren zur Steuerung des Verhaltens.
  - Systemaufforderungen: Hintergrundanweisungen, die das Verhalten des Modells bestimmen.
- Prompts können als Funktionsparameter oder API-Anfragen betrachtet werden. Genauso wie API-Aufrufe mit bestimmten Parametern strukturiert sind, um die gewünschte Antwort zu erzeugen, sind auch Prompts so aufgebaut, dass sie die Ausgabe des LLMs beeinflussen.
  - Die Anweisungen müssen klar und konkret formuliert werden.
  - Bei Bedarf sollten Kontext und Beispiele angegeben werden.
  - Komplexe Anfragen sollten in strukturierten Formaten wie JSON oder Markdown eingegeben werden.
  - Eingabeaufforderungen sind ein wichtiger Bestandteil des Interface-Designs einer Anwendung.

### Completions
- Completions (Vervollständigungen) sind die Antworten, die das Modell als Reaktion auf Eingabeaufforderungen generiert – der „Rückgabewert“ eines LLM-Funktionsaufrufs. Das Modell nutzt sein Training, um die wahrscheinlichste Fortsetzung des Textes vorherzusagen und zu generieren.
  - Das Modell verarbeitet die Eingabeaufforderungstoken.
  - Es generiert Wahrscheinlichkeitsverteilungen über mögliche nächste Token.
  - Es wählt Token basierend auf diesen Wahrscheinlichkeiten aus (was durch die Temperatur beeinflusst wird).
  - Es fährt fort, bis eine Stoppbedingung erreicht ist oder das Token-Limit erreicht ist.
- Wie eine Funktion, die Eingabeparameter entgegennimmt (die Eingabeaufforderung) und eine Ausgabe zurückgibt (die Vervollständigung).
  - Vervollständigungen sind probabilistisch, nicht deterministisch.
  - Die Qualität hängt stark vom Prompt-Engineering ab.
  - Token-Limits gelten für die Eingabeaufforderung und die Vervollständigung zusammen.
  - Die Wahl zwischen Streaming und Batch-Vervollständigung beeinflusst die Benutzererfahrung.

### Temperature
- Die Temperatur ist ein Hyperparameter, mit dem sich die Zufälligkeit oder Kreativität der Modellausgabe steuern lässt. Sie ist eine wichtige Einstellung zur Feinabstimmung des Verhaltens von LLM-Vervollständigungen.
  - Niedrige Temperatur (0,0–0,3): – eher deterministische und vorhersehbare Ausgaben.
  - Mittlere Temperatur (0,4–0,7): Ein Gleichgewicht zwischen Konsistenz und Kreativität.
  - Hohe Temperatur (0,8–1,0+): Zufälligere und kreativere, aber möglicherweise weniger kohärente Ergebnisse.
- Die Temperatur skaliert die Logits (die Rohdaten des Modells), bevor die Softmax-Funktion angewendet wird, um die Wahrscheinlichkeiten zu ermitteln. Eine niedrigere Temperatur erhöht die Zuverlässigkeit des Modells bei seiner Top-Auswahl, während eine höhere Temperatur die Wahrscheinlichkeitsverteilung abflacht.
- Die Temperatur kann als "Zufallsgenerator" oder als Parameter für "Erkundung vs. Ausnutzung" in Algorithmen betrachtet werden. Eine niedrige Temperatur bedeutet, dass stets der offensichtlichste Weg eingeschlagen wird, während eine hohe Temperatur kontrollierte Zufälligkeit einführt.
  - Codegenerierung: Eine niedrige Temperatur (0,1–0,2) kann verwendet werden, um syntaktisch korrekten, zuverlässigeren Code zu generieren.
  - Kreatives Schreiben: Eine höhere Temperatur (0,7–0,9) kann verwendet werden, um vielfältigere und kreativere Ergebnisse zu erzielen.
  - Sachfragen: Eine niedrige Temperatur führt zu konsistenten, genauen Antworten.
  - Brainstorming: Eine höhere Temperatur kann verwendet werden, um vielfältige Ideen zu generieren.

## Supervised Learning
- This type of machine learning is like teaching a program by showing it examples with correct answers.
- It works like having a teacher or supervisor guiding the machine, and can be taught of as training a function where both input parameters and the expected output (labels) are provided.
- The algorithm learns to map inputs to outputs by analyzing these labeled examples.
- Key characteristics:
  - Labeled datasets: Each data point has both input features and a known output/target.
  - Training process: The algorithm iteratively adjusts its parameters to minimize prediction errors.
  - Validation: Accuracy can be measured by comparing predictions against known correct answers.
  - Two main types:
    - Classification: Predicting categories (e.g. spam vs. not spam, image recognition)
    - Regression: Predicting continuous values (e.g. stock prices, housing prices)
- Common algorithms: Linear/Logistic Regression, Decision Trees, Random Forest, Support Vector Machines, Neural Networks
- Analogy: Writing a function that learns from a training dataset ***function(input, expected_output)*** to later predict ***function(new_input) -> predicted output.***
- Practical examples: recommendation systems, fraud detection, medical diagnosis

## Unsupervised Learning
- This type of machine learning is like letting a program discover patterns in data without being told what to look for.
- Machine learning algorithms are used to analyze and cluster unlabeled data sets without human supervision.
- Unsupervised machine learning models are given unlabeled data and allowed to discover patterns and insights without any explicit guidance or instruction.
- Key characteristics:
  - Unlabeled data: Only input data without any target outputs can be provided.
  - Pattern discovery: The algorithm tries to make sense of data by extracting features and patterns on its own.
  - Self-learning: Algorithms find hidden patterns and data without any human intervention.
  - Exploration-focused: Discovering intrinsic structure or distribution of the data.
- Main techniques:
  - Clustering: Grouping similar data points (K-Means, Hierarchical Clustering, DBSCAN)
  - Association Rules: Finding relationships between data items (market basket analysis)
  - Dimensionality Reduction: Simplifying datasets while preserving essential information (PCS, t-SNE)
- Analogy: Giving a function only input data ***function(input_data)*** and letting it discover groups, patterns, or reduced representations without knowing what the "correct" answer should be.
- Practical examples: exploratory data analysis, anomaly detection, feature extraction, customer behavior analysis, data preprocessing