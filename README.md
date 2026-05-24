# 📚 StudyFlashCards

A simple Java desktop flashcard quiz app built with Swing.
Load a question set, answer multiple-choice questions, and see how well you did!

---

## ✨ Features

- 🃏 **Multiple-choice quiz** — 4 answer options per card
- 🖼️ **Image per card** — each flashcard displays an image alongside the question
- 📂 **Custom question sets** — load your own JSON file via the Upload button
- 🌙 **Light / Dark / Custom theme** — toggle in Settings, or pick your own background color
- 📊 **End-of-game summary** — shows correct and wrong answer counts

---

## 🖥️ Windows

| Window | Description |
|---|---|
| **WelcomeScreen** | Main menu — Play, Settings, Upload questions |
| **GameScreen** | The quiz itself with cards, images and answer buttons |
| **SettingsScreen** | Toggle between light, dark, or custom theme |
| **Upload questions** | FileChooser where you can choose your own json |

---

## 🚀 Getting Started

### Requirements
- Java 9 or newer

### Running a Release (JAR file)

1.  **Download the latest JAR** from the [Releases](https://github.com/KyblikPlnejCeleru/StudyFlashCards/releases) page.
2.  **Place the JAR** in a directory.
3.  **Ensure resources are present**: Create a `res/` folder in the **same directory** as the JAR. Place your `GameData.json` (or any custom JSON you want to use) and any image files referenced in your JSON within this `res/` folder.
4.  **Run the application** from your terminal:
    ```bash
    java -jar StudyFlashCards.jar
    ```

### Building from Source

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/KyblikPlnejCeleru/StudyFlashCards.git
    cd StudyFlashCards
    ```
2.  **Build the project** using Maven:
    ```bash
    mvn clean install
    ```
3.  **Run the application**:
    ```bash
    java -jar target/projectZaverecnyDzava-1.0-SNAPSHOT.jar
    ```
    (Note: The exact JAR name in `target/` might vary slightly based on your `pom.xml` configuration.)

---

## 🎮 How to Use

1.  Launch the app — the main menu appears.
2.  **Play** — starts the quiz using the built-in `GameData.json` (from the `res/` folder).
3.  **Upload questions** — opens a file dialog to pick your own `.json` file to load a custom deck.
4.  **Settings** — switch between light, dark, or a custom background color, then save your preference.
5.  **During the quiz** — click one of the four answer buttons; green indicates a correct answer, red indicates a wrong answer.
6.  **After the last card** — a dialog shows your correct/wrong count and success percentage, then returns to the main menu.

---

## 📝 JSON Format for Custom Questions

Custom question sets must follow this exact structure:

```json
{
  "card": [
    {
      "name": "Card name",
      "imagePath": "res/images/your_image.png",
      "question": {
        "q": "What is the question?",
        "answer": ["Option A", "Option B", "Option C", "Option D"],
        "rAnswerIndex": 0
      }
    }
  ]
}
```

| Field | Description | Example |
|---|---|---|
| `name` | A descriptive name for the card. | `"Capital of France"` |
| `imagePath` | **Relative path** to the image file from the application's working directory (e.g., `res/images/paris.png`). Ensure images are in the `res/` folder. | `"res/images/eiffel_tower.jpg"` |
| `q` | The actual question text. | `"Which city is known as the 'City of Love'?"` |
| `answer` | An array of exactly 4 string options for the multiple-choice question. | `["London", "Paris", "Rome", "Berlin"]` |
| `rAnswerIndex` | The 0-based index of the correct answer within the `answer` array. | `1` (for "Paris" in the example above) |

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java (Swing) | GUI and core application logic |
| Maven | Dependency management and build automation |
| [Gson 2.13.2](https://github.com/google/gson) | Efficient JSON serialization/deserialization |

---

## 📁 Project Structure

```
.
├── src/
│   ├── Main.java               # Application entry point
│   ├── Brain/
│   │   ├── Game.java           # Manages game statistics (correct/wrong answers)
│   │   ├── GameData.java       # Handles loading flashcard data from JSON files
│   │   └── ThemeManager.java   # Manages application themes (light, dark, custom)
│   ├── Properties/
│   │   ├── Card.java           # Data model for a single flashcard
│   │   └── Question.java       # Data model for a question with answers
│   └── Windows/
│       ├── WelcomeScreen.java  # Initial screen with main menu options
│       ├── GameScreen.java     # Main quiz interface for displaying cards
│       ├── SettingsScreen.java # Screen for theme configuration
│       └── RoundedButton.java  # Custom Swing button with rounded corners
├── res/
│   ├── GameData.json           # Default built-in question set
│   └── images/                 # Directory for card images (example)
├── pom.xml                     # Maven project configuration
├── README.md                   # Project documentation
└── LICENSE                     # License file
```

---

## 📄 License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.
