## Künstliche Intelligenz (KI):
- Der Begriff „Künstliche Intelligenz” (KI) bezeichnet einen weit gefassten Bereich der Informatik. In diesem Bereich werden Systeme entwickelt, die Aufgaben ausführen können, für die normalerweise menschliche Intelligenz erforderlich ist, wie z. B. logisches Denken, Lernen und Problemlösen.

## Maschinelles Lernen (ML):
- Maschinelles Lernen ist ein Teilbereich der KI und ermöglicht es Computern, durch Erfahrungen und Daten zu lernen und ihre Leistung bei bestimmten Aufgaben zu verbessern, ohne dass sie für jedes Szenario explizit programmiert werden müssen.

## Große Sprachmodelle:
- LLMs sind eine spezielle Art von maschinellen Lernmodellen. Sie wurden mit riesigen Mengen an Textdaten trainiert, um menschenähnliche Sprache zu verstehen und zu generieren. Sie sind in der Lage, Aufgaben wie Konversation, Schreiben und Textanalyse auszuführen.

### Token:
- Tokens sind die grundlegenden Texteinheiten, die LLMs verarbeiten – die „atomaren Elemente“ der Sprache für das Modell. So wie eine Zeichenfolge durch Aufteilung anhand von Leer- oder Trennzeichen in Tokens zerlegt werden kann, zerlegen LLMs Text auf komplexere Weise in kleinere Einheiten.
  - Ein Token kann ein ganzes Wort („Hallo“), ein Wortteil („ing“), ein Satzzeichen (‚, ‘) oder sogar ein Leerzeichen sein.
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

## Supervised Learning (Überwachtes Lernen)
- Bei dieser Art des maschinellen Lernens wird einem Programm durch das Zeigen von Beispielen mit den richtigen Antworten beigebracht.
- Es funktioniert genauso, als würde ein Lehrer oder Betreuer die Maschine anleiten. Man kann es sich wie das Trainieren einer Funktion vorstellen, bei dem sowohl die Eingabeparameter als auch die erwartete Ausgabe (Labels) bereitgestellt werden.
- Der Algorithmus lernt, Eingaben und Ausgaben zuzuordnen, indem er gekennzeichnete Beispiele analysiert.
- Wesentliche Merkmale:
  - Beschriftete Datensätze: Jeder Datenpunkt verfügt über Eingabeeigenschaften sowie eine bekannte Ausgabe bzw. ein bekanntes Ziel.
  - Trainingsprozess: Der Algorithmus passt seine Parameter iterativ an, um Vorhersagefehler zu minimieren.
  - Validierung: Die Genauigkeit lässt sich durch einen Vergleich der Vorhersagen mit den tatsächlichen Antworten ermitteln.
  - zwei Haupttypen:
    - Klassifizierung: Vorhersage von Kategorien (z. B. Identifizierung, ob eine E-Mail Spam ist oder nicht, Bilderkennung).
    - Regression: Vorhersage kontinuierlicher Werte (z. B. Aktien- oder Immobilienpreise).
- Übliche Algorithmen: Lineare/Logistische Regression, Entscheidungsbäume, random Forests, Support-Vektor-Maschinen und neuronale Netze.
- Analogie: Eine Funktion lernt aus einem Trainingsdatensatz. Sie nimmt eine Eingabe und eine erwartete Ausgabe entgegen - ***funktion (Eingabe, erwartete_Ausgabe)*** und gibt die Ausgabe für eine neue Eingabe aus - ***funktion (neue_Eingabe) > vorhergesagte Ausgabe***.
- Zu den praktischen Beispielen zählen Empfehlungssysteme, Betrugserkennung und medizinische Diagnosen.

## Unsupervised Learning (unüberwachtes Lernen)
- Bei dieser Art des maschinellen Lernens ist ein Programm in der Lage, Muster in Daten zu erkennen, ohne dass ihm vorgegeben wird, wonach es suchen soll.
- Algorithmen für maschinelles Lernen analysieren und gruppieren unbeschriftete Datensätze eigenständig und ohne menschliche Aufsicht.
- Unüberwachte maschinelle Lernmodelle werden mit unbeschrifteten Daten konfrontiert. Sie können dann selbstständig Muster und Erkenntnisse identifizieren, ohne dass sie explizite Anweisungen oder Vorgaben erhalten.
- Wesentliche Merkmale:
  - Unbeschriftete Daten: Es können nur Eingabedaten ohne Zielausgaben bereitgestellt werden.
  - Mustererkennung: Der Algorithmus interpretiert die Daten, indem er Merkmale und Muster unabhängig voneinander extrahiert.
  - Selbstlernend: Die Algorithmen finden, ohne menschliches Zutun versteckte Muster und Daten.
  - Erkundungsorientiert: Es findet eine Entdeckung der intrinsischen Struktur oder Verteilung der Daten statt.
- Haupttechniken:
  - Clustering: hier werden ähnliche Datenpunkte gruppiert. Es gibt verschiedene Verfahren, K-Means-Clustering, hierarchisches Clustering und DBSCAN.
  - Assoziationsregeln: Identifizierung von Beziehungen zwischen Datenelementen (z. B. Warenkorbanalyse).
  - Dimensionsreduktion: Vereinfachung von Datensätzen unter Beibehaltung wesentlicher Informationen (z. B. PCS und t-SNE).
- Analogie: Eine Funktion erhält Eingabedaten und muss daraus Gruppen, Muster oder reduzierte Darstellungen ableiten, ohne die „richtige” Antwort zu kennen.
- Zu den praktischen Beispielen zählen explorative Datenanalyse, Anomalieerkennung, Merkmalsextraktion, Kundenverhaltensanalyse und Datenvorverarbeitung.

### Neuronale Netze
- Rechenmodelle, die komplexe Muster erkennen können.
- Sie ahnen die Art und Weise nach, wie biologische Gehirne Informationen verarbeiten.
- Man kann sie sich als hoch entwickelte Funktionsapproximationen vorstellen, die aus miteinander verbundenen Verarbeitungseinheiten (Neuronen) bestehen, welche wiederum in Schichten organisiert sind.
- Jedes Neuron empfängt numerische Eingaben, wendet Gewichte (wie Koeffizienten) und Vorspannungen an und leitet das Ergebnis dann durch eine Aktivierungsfunktion weiter, die für Nichtlinearität sorgt.
- Das Netzwerk lernt, indem es diese Gewichte und Vorspannungen durch einen Trainingsprozess namens „Backpropagation” anpasst.
- Dabei vergleicht es seine Vorhersagen mit den richtigen Antworten und aktualisiert die Parameter iterativ, um Fehler zu minimieren.
- Im Gegensatz zur traditionellen Programmierung, bei der explizite Regeln geschrieben werden, entdecken neuronale Netze Regeln automatisch aus Daten.
- Während des Trainings werden Eingabe-Ausgabe-Beispiele vorgegeben und das Netzwerk lernt die zugrunde liegende Funktion, die Eingaben zu Ausgaben zuordnet.
- Dies macht sie für Aufgaben wie Bilderkennung, Verarbeitung natürlicher Sprache und Mustererkennung unglaublich leistungsfähig, bei denen das Schreiben expliziter Regeln unmöglich wäre.
- Der Begriff „neuronal” ist dabei nur inspirierend – im Wesentlichen handelt es sich um ausgefeilte mathematische Funktionen, die bei ausreichender Datenmenge und Rechenleistung jede komplexe Beziehung lernen können.


# Day 1 Completion Checklist

## AI Fundamentals ✓
- [x] Understand AI vs ML vs LLM differences
- [x] Know what tokens, prompts, completions are
- [x] Understand supervised vs unsupervised learning
- [x] Have basic neural network mental model

## Technical Implementation ✓
- [x] Created Spring Boot project with Spring AI
- [x] Configured OpenAI API integration
- [x] Built working /hello-ai endpoint
- [x] Added error handling and logging
- [x] Tested with multiple different prompts

## Working Endpoints
- http://localhost:8080/hello-ai
- http://localhost:8080/health

## What I Can Do Now
- Send text prompts to AI and get responses
- Handle AI API errors gracefully
- Log AI interactions for debugging