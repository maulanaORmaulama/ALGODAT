# 📊 Task 2 Report: Custom Generic Linked List Implementation

Welcome to the documentation for **Task 2**. This report provides a detailed breakdown of the custom generic Singly Linked List data structure implemented in Java, along with model entities (`Club` and `StarPlayer`) and an execution driver (`Main_2.java`).

---

## 📁 Directory Structure & File Summary

```text
task_2/
├── Club.java         # Domain entity representing a football club
├── StarPlayer.java   # Domain entity representing a professional football player
├── LinkedList.java   # Custom generic Linked List with automatic rank/position sync
└── Main_2.java       # Main entry point and execution report/demo
```

---

## 🔍 Detailed File Analysis

### 1. `LinkedList.java` — Core Custom Data Structure

* **Purpose**: Implements a generic Singly Linked List (`LinkedList<T>`) capable of storing any object type while automatically tracking node order and synchronizing positional/ranking attributes within domain models.
* **Key Components**:
  * **`Node<T>` Class**: An internal helper class holding element data (`T data`) and a pointer to the next node (`Node<T> next`).
  * **`tambahNode(T data)`**: Appends a new element to the end of the list, increments the list size, and assigns its sequential index position.
  * **`hapusNode(T data)`**: Searches for a target element and removes it by adjusting pointers. Upon removal, it triggers `updateAllPositions()` to re-index all remaining nodes so that ranks remain sequential ($1, 2, 3, \dots$).
  * **Position Synchronization Logic (`updatePosition` & `updateAllPositions`)**: Uses Java `instanceof` checks to dynamically update positions:
    * If `data` is an instance of `Club`, it calls `setPositionClub(position)`.
    * If `data` is an instance of `StarPlayer`, it calls `setRankPosition(position)`.
  * **`get(int index)`**: Traverses nodes sequentially up to the target index to return the element.
  * **`tampilkan()`**: Traverses and prints the visual node chain (e.g., `Node A -> Node B -> null`).

---

### 2. `Club.java` — Football Club Model

* **Purpose**: Represents a football club entity participating in a league table.
* **Fields**:
  * `String name`: The official club name.
  * `int positionClub`: The club's rank in the league standings (automatically updated by `LinkedList`).
* **Key Methods**:
  * **`Gacor()`**: Displays an informational message showing the club's current standing in the Premier League table.
  * **`toString()`**: Formats club instance information into a readable string format.

---

### 3. `StarPlayer.java` — Football Player Model

* **Purpose**: Represents a professional football player with statistical performance tracking.
* **Fields**:
  * `String name`: Player name.
  * `int squadNumber`: Shirt/jersey number.
  * `int goalAssist`: Total combined goals and assists ($G/A$).
  * `int trophies`: Total career trophies won.
  * `int rankPosition`: Current statistical ranking (automatically updated by `LinkedList`).
* **Key Methods**:
  * **`Gacor()`**: Prints a full statistical summary (Name, Squad Number, Rank, G/A, and Trophies).
  * **`toString()`**: Provides a structured string view of the player object.

---

### 4. `Main_2.java` — Driver & Verification Execution

* **Purpose**: Serves as the main execution file to demonstrate and test operations of the generic `LinkedList` using both `Club` and `StarPlayer` objects.
* **Execution Flow**:
  1. **Premier League Demonstration**:
     * Instantiates `LinkedList<Club>`.
     * Adds `Manchester United` and `Manchester City`.
     * Verifies automatic position assignments by invoking `Gacor()`.
  2. **Star Player Demonstration**:
     * Instantiates `LinkedList<StarPlayer>`.
     * Inserts players (`Bruno Fernandes`, `Erling Haaland`, `Bukayo Saka`).
     * Displays updated rankings for all players.
     * Deletes a player node (`Bruno Fernandes`) and demonstrates that rankings automatically shift up and stay coherent.

---

## ⚙️ How to Compile & Run

Make sure you are inside the project root directory or the `task_2` folder.

### 1️⃣ Compile All Files
```bash
javac task_2/*.java
# Or if working directly inside task_2 directory:
# javac *.java
```

### 2️⃣ Run the Demonstration
```bash
# Run Main_2 from the root directory
java task_2.Main_2

# Or if executing directly inside task_2 directory:
# java Main
```

---

## 🛠️ Requirements & System Info

* **Language**: Java 8 or higher
* **Paradigm**: Object-Oriented Programming (OOP) & Data Structures (Generics, Linked List)
* **Dependencies**: Standard Java Utility Libraries (No external dependencies required)
