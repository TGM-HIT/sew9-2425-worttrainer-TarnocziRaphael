# Bilder-Wort-Ratespiel

## Übersicht

Dieses Java-Programm zeigt Bilder an, zu denen der Benutzer das richtige Wort erraten muss. Die Bilder und Wörter werden aus einer JSON-Datei geladen. Dank des **Strategy Patterns** lässt sich das Programm leicht erweitern, um auch andere Dateiformate (z.B. XML, CSV) zu unterstützen.

Zudem gibt es zwei Schaltflächen zum **Speichern** und **Laden** des Spielfortschritts. Am unteren Rand werden die **Spielstatistiken** wie Punkte und Versuche angezeigt.

## Installation und Setup

1. Repository klonen:
    ```bash
    git clone https://github.com/TGM-HIT/sew9-2425-worttrainer-TarnocziRaphael.git
    cd WortTrainer
    ```

2. Projekt mit einer Java-IDE oder der Kommandozeile kompilieren:
    ```bash
    javac -cp . Controller.java
    ```

3. Die JSON-Datei im richtigen Verzeichnis platzieren, z.B.:
    ```json
    {
      "total": 15,
      "correct": 5,
      "words": [
        {
          "url": "path/to/image1.png",
          "word": "Apfel"
        },
        {
          "url": "path/to/image2.png",
          "word": "Banane"
        }    
      ]  
    }
    ```
   Die Einträge "total" und "correct" sind hierbei optional und wenn diese nicht vorhanden sind, werden sie automatisch mit dem Wert 0 festgelegt.


4. Programm ausführen:
    ```bash
    java Controller
    ```

## Nutzung

- **Raten:** Ein Bild erscheint, und der Benutzer muss das passende Wort eingeben.
- **Speichern/Laden:** Spielstand speichern oder wiederherstellen.
- **Statistiken:** Punkte und Versuche unten angezeigt.

## Erweiterung

Dank des **Strategy Patterns** kann das Laden von Daten einfach auf andere Formate (z.B. XML, CSV) angepasst werden. Dazu einfach eine neue Klasse für das gewünschte Format implementieren, die das `StrategyStorage`-Interface umsetzt.

## Autor

- **Name:** Raphael Tarnoczi
- **Klasse:** 5AHIT
- **Datum:** 17. September 2024
