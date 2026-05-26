# 📚 StudyFlashCards

Jednoduchá desktopová aplikace pro učení pomocí kartiček. Načti sadu otázek, odpovídej na multiple-choice otázky a sleduj svůj výsledek!

---

## ✨ Funkce

- 🃏 **Multiple-choice kvíz** — 4 možnosti odpovědi na každé kartičce
- 🖼️ **Obrázek ke každé kartičce** — každá otázka může mít přiložený obrázek
- 📂 **Vlastní sady otázek** — nahraj si vlastní JSON soubor přes tlačítko Upload
- 🌙 **Světlý / Tmavý režim** — přepni v Nastavení
- 📊 **Výsledky po kvízu** — zobrazí počet správných a špatných odpovědí

---

## 🖥️ Okna aplikace

| Okno | Popis |
| --- | --- |
| **WelcomeScreen** | Hlavní menu — Hrát, Nastavení, Nahrát otázky |
| **GameScreen** | Samotný kvíz s kartičkami, obrázky a tlačítky odpovědí |
| **SettingsScreen** | Přepínání světlého a tmavého tématu |
| **Upload questions** | FileChooser pro výběr vlastního JSON souboru |

---

## 🚀 Spuštění

### Požadavky

- Java 9 nebo novější
- Maven (pouze pokud sestavuješ ze zdrojového kódu)

### Spuštění JAR souboru

```
java -jar StudyFlashCards.jar
```

> Ujisti se, že `GameData.json` a obrázky jsou ve složce `res/` vedle JAR souboru.

### Sestavení ze zdrojového kódu

```
git clone https://github.com/KyblikPlnejCeleru/StudyFlashCards.git
cd StudyFlashCards
mvn package
java -jar target/projectZaverecnyDzava-1.0-SNAPSHOT.jar
```

---

## 🎮 Jak hrát

1. Spusť aplikaci — zobrazí se hlavní menu
2. **Play** — spustí kvíz s vestavěným `GameData.json`
3. **Upload questions** — vyber vlastní `.json` soubor pro načtení vlastní sady
4. **Settings** — přepni světlý/tmavý režim a ulož
5. **Během kvízu** — klikni na jednu ze čtyř možností; zelená = správně, červená = špatně
6. **Po poslední kartičce** — dialog zobrazí počet správných/špatných odpovědí a vrátí tě do menu

---

## 📝 Tvorba vlastního JSON souboru

### Základní formát

```json
{
  "card": [
    {
      "name": "Název kartičky",
      "imagePath": "C:/Users/jmeno/Pictures/obrazek.png",
      "question": {
        "q": "Jaká je otázka?",
        "answer": ["Možnost A", "Možnost B", "Možnost C", "Možnost D"],
        "rAnswerIndex": 0
      }
    }
  ]
}
```

### Popis polí

| Pole | Popis |
| --- | --- |
| `name` | Název kartičky (zobrazuje se v hlavičce) |
| `imagePath` | Absolutní cesta k obrázku (viz níže) |
| `q` | Text otázky |
| `answer` | Pole přesně **4** možností odpovědí |
| `rAnswerIndex` | Index správné odpovědi — **0 = první, 1 = druhá, 2 = třetí, 3 = čtvrtá** |

---

### ⚠️ Na co si dát pozor

#### 1. Cesta k obrázku — lomítka
Na Windows **nepoužívej zpětná lomítka** `\` — JSON je bere jako escape znaky a hodí chybu. Vždy používej dopředná lomítka `/`:

```json
// ❌ ŠPATNĚ
"imagePath": "C:\Users\jmeno\Pictures\obrazek.png"

// ✅ SPRÁVNĚ
"imagePath": "C:/Users/jmeno/Pictures/obrazek.png"
```

#### 2. Počet odpovědí
Pole `answer` musí mít **vždy přesně 4 položky**. Méně nebo více způsobí chybné zobrazení tlačítek.

```json
// ❌ ŠPATNĚ
"answer": ["Ano", "Ne"]

// ✅ SPRÁVNĚ
"answer": ["Ano", "Ne", "Možná", "Nevím"]
```

#### 3. Index správné odpovědi
`rAnswerIndex` se počítá od **0**, ne od 1:

```json
"answer": ["Praha", "Brno", "Ostrava", "Plzeň"],
"rAnswerIndex": 0   // Správná odpověď je "Praha"
"rAnswerIndex": 2   // Správná odpověď je "Ostrava"
```

#### 4. Uvozovky a speciální znaky
Pokud potřebuješ v textu uvozovky, použij `\"`:

```json
"q": "Jak se řekne \"hello\" česky?"
```

#### 5. Závorky a čárky
JSON je přísný na strukturu. Každý objekt `{}` musí být správně uzavřen a mezi položkami v poli musí být čárka (ale **ne za poslední**):

```json
{
  "card": [
    { ... },
    { ... },
    { ... }
  ]
}
```

#### 6. Obrázek neexistuje
Pokud soubor na zadané cestě neexistuje, kartička se zobrazí bez obrázku (prázdná ikona). Zkontroluj, že cesta a název souboru jsou přesné včetně přípony (`.png`, `.jpg`...).

---

### 📄 Vzorový soubor s více kartičkami

```json
{
  "card": [
    {
      "name": "Matematika 1",
      "imagePath": "C:/Users/jmeno/Pictures/math.png",
      "question": {
        "q": "Kolik je 5 + 7?",
        "answer": ["10", "11", "12", "13"],
        "rAnswerIndex": 2
      }
    },
    {
      "name": "Geografie 1",
      "imagePath": "C:/Users/jmeno/Pictures/mapa.png",
      "question": {
        "q": "Jaké je hlavní město České republiky?",
        "answer": ["Brno", "Ostrava", "Praha", "Plzeň"],
        "rAnswerIndex": 2
      }
    }
  ]
}
```

> **Tip:** JSON soubor si můžeš ověřit online např. na [jsonlint.com](https://jsonlint.com) — vlož kód a řekne ti, jestli je validní.

---

## 🛠️ Technologie

| Technologie | Účel |
| --- | --- |
| Java (Swing) | GUI a aplikační logika |
| Maven | Správa závislostí a build |
| [Gson 2.13.2](https://github.com/google/gson) | Parsování JSON |

---

## 📁 Struktura projektu

```
src/
├── Main.java               # Vstupní bod aplikace
├── Brain/
│   ├── Game.java           # Sleduje počty správných/špatných odpovědí
│   ├── GameData.java       # Načítání dat karet z JSON
│   └── ThemeManager.java   # Správa světlého/tmavého tématu
├── Properties/
│   ├── Card.java           # Model kartičky (název, obrázek, otázka)
│   ├── Question.java       # Model otázky (text, odpovědi, správný index)
│   └── Player.java         # Model hráče
└── Windows/
    ├── WelcomeScreen.java  # Okno hlavního menu
    ├── GameScreen.java     # Okno kvízu
    ├── SettingsScreen.java # Okno nastavení
    └── RoundedButton.java  # Vlastní komponenta zakulaceného tlačítka
res/
└── GameData.json           # Vestavěná sada otázek (3 ukázkové kartičky)
```

---

## 👥 Autor

romek studios 

---

## 📄 Licence

Projekt je licencován pod MIT licencí — viz soubor [LICENSE](LICENSE).
