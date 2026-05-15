# 📚 StudyFlashCards

A simple Java desktop flashcard quiz app built with Swing.  
Load a question set, answer multiple-choice questions, and see how well you did!

---

## ✨ Features

- 🃏 **Multiple-choice quiz** — 4 answer options per card
- 🖼️ **Image per card** — each flashcard displays an image alongside the question
- 📂 **Custom question sets** — load your own JSON file via the Upload button
- 🌙 **Light / Dark theme** — toggle in Settings
- 📊 **End-of-game summary** — shows correct and wrong answer counts

---

## 🖥️ Windows

| Window | Description |
|---|---|
| **WelcomeScreen** | Main menu — Play, Settings, Upload questions |
| **GameScreen** | The quiz itself with cards, images and answer buttons |
| **SettingsScreen** | Toggle between light and dark theme |
| **Upload questions** | FileChooser where you can choose your own json |

---

## 🚀 Running the App

### Requirements
- Java 9 or newer
- Maven (only needed to build from source)

### Run the JAR
```bash
java -jar StudyFlashCards.jar
```

> Make sure `GameData.json` and image files are in the `res/` folder next to the JAR.

### Build from Source
```bash
git clone https://github.com/KyblikPlnejCeleru/StudyFlashCards.git
cd StudyFlashCards
mvn package
java -jar target/projectZaverecnyDzava-1.0-SNAPSHOT.jar
```

---

## 🎮 How to Use

1. Launch the app — the main menu appears
2. **Play** — starts the quiz using the built-in `GameData.json`
3. **Upload questions** — pick your own `.json` file to load a custom deck
4. **Settings** — switch between light and dark mode, then save
5. **During the quiz** — click one of the four answer buttons; green = correct, red = wrong
6. **After the last card** — a dialog shows your correct/wrong count, then returns to the menu

---

## 📝 JSON Format

Custom question sets must follow this format:

```json
{
  "card": [
    {
      "name": "Card name",
      "imagePath": "Absolute/Path/of/the/image",
      "question": {
        "q": "What is the question?",
        "answer": ["Option A", "Option B", "Option C", "Option D"],
        "rAnswerIndex": 0
      }
    }
  ]
}
```

| Field | Description |
|---|---|
| `name` | Card name |
| `imagePath` | Path to the image file (relative to working directory) |
| `q` | Question text |
| `answer` | Array of exactly 4 answer options |
| `rAnswerIndex` | Index of the correct answer (0–3) |

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java (Swing) | GUI and application logic |
| Maven | Dependency management and build |
| [Gson 2.13.2](https://github.com/google/gson) | JSON parsing |

---

## 📁 Project Structure

```
src/
├── Main.java               # Entry point
├── Brain/
│   ├── Game.java           # Tracks correct/wrong answer counts
│   ├── GameData.java       # Loads card data from JSON
│   └── ThemeManager.java   # Manages light/dark theme state
├── Properties/
│   ├── Card.java           # Card model (name, image, question)
│   ├── Question.java       # Question model (text, answers, correct index)
│   └── Player.java         # Player model
└── Windows/
    ├── WelcomeScreen.java  # Main menu window
    ├── GameScreen.java     # Quiz window
    ├── SettingsScreen.java # Settings window
    └── RoundedButton.java  # Custom rounded button component
res/
└── GameData.json           # Built-in question set (3 sample cards)
```

---

## 📄 License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.
