# 📚 StudyFlashCards

> **⚠️ Work in progress** — feel free to test it and report any bugs!

A simple Java Swing flashcard study app. Load your own question sets, pick a theme, and quiz yourself.

---

## 🚀 Running the App

### Requirements
- Java 23 or newer
- The `.jar` file (or build it yourself — see below)

### Run the JAR
```bash
java -jar StudyFlashCards.jar
```

> Make sure `GameData.json` and any image files are in the same directory as the JAR, or inside `res/`.

---

## 🔨 Building from Source

### Requirements
- Java 23+
- Maven

### Steps
```bash
git clone https://github.com/KyblikPlnejCeleru/StudyFlashCards.git
cd StudyFlashCards
mvn package
java -jar target/projectZaverecnyDzava-1.0-SNAPSHOT.jar
```

---

## 🃏 Custom Questions

Questions are loaded from a JSON file (`res/GameData.json`). You can also load your own file via the **"Upload questions"** button in the app.

Example format:
```json
{
  "card": [
    {
      "name": "Question 1",
      "imageName": "myimage.jpg",
      "question": {
        "q": "What is 2 + 2?",
        "answer": ["1", "2", "3", "4"],
        "rAnswerIndex": 3
      }
    }
  ]
}
```

- `answer` — array of 4 answer options
- `rAnswerIndex` — index of the correct answer (0-based)
- `imageName` — optional image shown with the question

---

## 🎨 Features

- Multiple choice flashcard quiz
- Light / Dark theme
- Load custom question sets from JSON
- Image support per card

---

## 🛠️ Tech Stack

- Java (Swing)
- Maven
- [Gson](https://github.com/google/gson) for JSON parsing

---

*Found a bug? Open an issue and I'll fix it ASAP 🙂*
