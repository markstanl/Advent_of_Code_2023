
/**
 * Takes a string of different lines following the pattern: "Game 4: 1 green, 3 red, 6 blue; 3
 * green, 6 red; 3 green, 15 blue, 14 red" Breaks apart each game at the semicolon, such as "3
 * green, 6 red" it then makes sure the sum of the colors doesnt surpass 12 red, 13 green, 14 red it
 * does that for every semicolon game, and if all semi games pass, it adds the number of the game
 * (in this example 4) to the sum, and then prints the sum
 */
public class D02 {

  public static void main(String[] args) {
    // test values
    String values = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\r\n"
        + "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\r\n"
        + "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\r\n"
        + "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\r\n"
        + "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";

    int sum = 0; // the running sum

    String[] lines = allLines.split("\r\n"); // splits the entire string into an array of strings
    // representing the lines

    for (String line : lines) {
      sum += integerOfGame(line);
    }

    System.out.println(sum);

  }

  /**
   * returns the integer of the game. if the game is valid, returns the integer of the game if it is
   * invalid, returns 0
   * 
   * @param game the string line representing the game
   * @return the integer number of the game if the game is valid, 0 otherwise
   */
  private static int integerOfGame(String game) {
    // splits the game into an array, the index 0 is the game and number, the index 1 is the
    // multiple
    // semigames
    String[] tempLines = game.split(": ");

    // saves the game integer to the number
    int returnInt = Integer.parseInt(tempLines[0].substring(5));

    // makes a new game array filled with the semi games of the game
    String[] gameResets = tempLines[1].split(";");

    for (String games : gameResets) {
      // removes all whitespace
      games = games.replaceAll("\\s", "");
      // if the game is invalid, return 0
      if (!isSemiGameValid(games))
        return 0;
    }

    return returnInt;
  }

  /**
   * checks if the semi game (a round of a game split up by the semicolon) is valid
   * 
   * @param game the semigame being tested
   * @return if the game is valid returns true, false otherwise
   */
  private static boolean isSemiGameValid(String semigame) {

    String[] pulls = semigame.split(","); // splits the semi game into the individual pulls
    int[] intArray = new int[3]; // initializes a new array representing the sum of each color

    // red, green, blue
    for (String pull : pulls) {
      int[] tempArray = whichColor(pull);
      // adds the pull value to the slot of the array
      intArray[tempArray[0]] += tempArray[1];
    }

    return intArray[0] <= 12 && intArray[1] <= 13 && intArray[2] <= 14;// if any fail, returns false
  }

  /**
   * Checks which color the pull is
   * 
   * @param pull the string of the individual pull
   * @return a 2 value integer array, the first value represents color (red=0, green=1, blue=2) the
   *         second is the number in front of the pull
   */
  private static int[] whichColor(String pull) {
    // sets the string to a character array
    char[] charArray = pull.toCharArray();
    String num = ""; // represents the string value of the number
    char currentChar = charArray[0];
    int count = 0;

    while (Character.isDigit(currentChar)) {
      num += Character.toString(currentChar); // if the current character is a digit, concete it to
                                              // string
      count++; // adds to count to iterate through string
      currentChar = charArray[count]; // sets the currentchar to the next character
    }

    int newNum = Integer.parseInt(num); // sets the num string to a real integer

    // returns the integer array if the character is red, returns index 0, etc.
    if (currentChar == 'r') {
      return new int[] {0, newNum};
    }
    if (currentChar == 'g') {
      return new int[] {1, newNum};
    }
    if (currentChar == 'b') {
      return new int[] {2, newNum};
    }

    return new int[] {-1, -1};

  }


  // all of the games
  private static String allLines =
      "Game 1: 2 blue, 4 green; 7 blue, 1 red, 14 green; 5 blue, 13 green, 1 red; 1 red, 7 blue, 11 green\r\n"
          + "Game 2: 6 blue, 3 green; 4 red, 1 green, 7 blue; 2 green\r\n"
          + "Game 3: 4 blue, 3 red; 2 blue, 4 red, 7 green; 1 blue, 6 red, 7 green; 5 green, 10 blue; 9 green, 1 blue, 6 red; 8 blue, 1 red, 12 green\r\n"
          + "Game 4: 15 blue, 4 green, 5 red; 2 red, 2 green, 5 blue; 3 green, 13 blue; 17 blue, 1 green, 5 red\r\n"
          + "Game 5: 11 green, 4 red, 3 blue; 8 blue, 6 green; 8 green, 2 red, 9 blue; 4 red, 16 blue; 8 blue, 10 red, 6 green; 9 blue, 3 red, 10 green\r\n"
          + "Game 6: 4 green, 9 red, 2 blue; 7 red, 2 green, 15 blue; 13 red, 2 green, 6 blue; 5 green, 7 blue, 6 red; 19 red, 15 blue, 4 green\r\n"
          + "Game 7: 12 blue, 5 red; 5 green, 6 blue; 5 red, 15 blue; 5 blue, 5 red, 5 green; 1 green, 11 blue, 2 red\r\n"
          + "Game 8: 6 red, 11 green; 5 red, 2 blue, 7 green; 7 red, 6 green\r\n"
          + "Game 9: 5 red, 1 blue, 11 green; 4 green, 1 blue; 8 green, 2 red; 1 green, 2 red, 2 blue; 3 green, 2 red\r\n"
          + "Game 10: 7 blue, 4 red, 11 green; 13 green, 1 red, 1 blue; 7 blue, 6 green\r\n"
          + "Game 11: 4 blue, 7 red, 2 green; 1 green, 14 red, 3 blue; 2 green, 5 red, 3 blue\r\n"
          + "Game 12: 6 green, 6 blue, 1 red; 1 green, 3 red, 2 blue; 2 blue, 6 red, 7 green\r\n"
          + "Game 13: 6 red, 10 green, 13 blue; 3 red, 12 green, 9 blue; 11 blue, 1 green; 4 red, 3 blue, 13 green; 12 green, 10 blue, 6 red; 13 blue, 3 green, 3 red\r\n"
          + "Game 14: 8 green, 1 blue, 17 red; 7 green, 11 blue, 19 red; 19 red, 9 blue, 2 green; 8 green, 20 red, 12 blue; 16 red, 3 green, 11 blue\r\n"
          + "Game 15: 3 red, 1 green, 5 blue; 9 blue, 4 green; 6 blue, 5 green, 9 red\r\n"
          + "Game 16: 13 blue, 1 red; 2 blue, 2 green; 1 green; 10 blue, 8 red; 4 red, 3 green, 9 blue\r\n"
          + "Game 17: 10 blue, 2 red; 3 green, 4 red; 6 blue, 1 red, 6 green; 5 green, 7 blue, 5 red\r\n"
          + "Game 18: 3 red, 1 green; 2 red, 5 blue; 5 blue, 2 red\r\n"
          + "Game 19: 7 green, 4 blue, 1 red; 1 green, 4 blue, 4 red; 6 blue, 8 green; 4 green, 2 blue, 1 red; 1 red, 1 blue, 2 green\r\n"
          + "Game 20: 13 green, 1 red, 1 blue; 12 green, 1 blue; 5 green, 1 blue, 2 red; 16 green, 3 red; 2 red, 9 green\r\n"
          + "Game 21: 8 red, 2 green, 2 blue; 5 red, 3 blue; 2 blue, 5 red, 2 green; 7 blue\r\n"
          + "Game 22: 9 red, 12 blue, 7 green; 7 red, 13 blue, 4 green; 9 blue, 13 red, 1 green; 3 blue, 4 red, 5 green\r\n"
          + "Game 23: 7 green, 12 red; 6 red, 7 green, 4 blue; 1 blue, 11 red, 5 green; 4 green, 2 blue, 6 red; 12 green, 6 red, 3 blue\r\n"
          + "Game 24: 11 red, 4 blue; 9 blue, 6 green, 17 red; 8 green, 2 red; 16 blue, 6 red, 2 green\r\n"
          + "Game 25: 7 red, 4 blue; 7 blue, 4 green; 10 blue, 4 red, 2 green; 6 green, 4 blue, 1 red; 10 blue, 2 red, 4 green\r\n"
          + "Game 26: 7 green, 8 red, 6 blue; 5 red, 3 green, 2 blue; 13 blue, 6 green, 5 red; 10 blue, 4 red, 8 green; 2 red, 2 blue, 1 green; 8 blue, 1 green, 4 red\r\n"
          + "Game 27: 7 green, 3 blue, 13 red; 1 green, 17 red, 1 blue; 16 red, 3 blue, 3 green; 5 green, 3 red, 5 blue; 13 red, 4 green, 8 blue; 6 blue, 2 green, 15 red\r\n"
          + "Game 28: 8 blue, 5 red, 18 green; 1 green, 6 red; 7 blue, 18 green, 5 red; 16 green, 3 red, 7 blue; 6 blue, 18 green; 8 blue, 8 green, 7 red\r\n"
          + "Game 29: 4 blue, 1 red; 6 blue, 1 red; 17 blue, 1 green\r\n"
          + "Game 30: 1 red, 2 green, 5 blue; 2 blue, 7 green, 6 red; 11 blue, 4 red, 2 green; 5 green, 6 blue, 4 red; 5 red, 8 blue, 7 green\r\n"
          + "Game 31: 10 green, 9 blue; 5 green, 9 blue, 1 red; 1 red, 8 blue\r\n"
          + "Game 32: 3 red, 5 green; 5 red, 5 blue, 14 green; 2 red, 2 green; 11 green, 3 red, 5 blue\r\n"
          + "Game 33: 7 blue, 10 green, 8 red; 18 blue, 15 green, 4 red; 6 red, 1 green; 18 blue, 8 red, 11 green\r\n"
          + "Game 34: 3 green; 2 red, 5 green; 5 blue, 3 green; 3 blue, 5 green, 1 red\r\n"
          + "Game 35: 1 blue, 5 green, 6 red; 3 green, 2 red, 3 blue; 4 red, 9 blue, 3 green; 1 green, 12 blue, 1 red\r\n"
          + "Game 36: 14 green, 3 blue, 16 red; 1 green, 2 red, 4 blue; 4 blue, 9 green, 18 red; 4 blue, 4 green, 14 red; 4 blue, 11 green\r\n"
          + "Game 37: 7 green, 2 blue, 3 red; 8 green, 9 red, 2 blue; 4 blue, 15 green, 18 red\r\n"
          + "Game 38: 11 red, 1 blue, 6 green; 6 green, 2 blue, 1 red; 6 blue, 17 red, 2 green; 17 red, 9 blue, 3 green; 7 red, 7 blue, 3 green; 3 green, 7 red, 7 blue\r\n"
          + "Game 39: 1 blue, 2 green; 1 blue, 2 green, 7 red; 1 blue, 4 red, 2 green; 1 blue, 12 red\r\n"
          + "Game 40: 1 blue, 4 red, 15 green; 12 green, 1 blue, 15 red; 15 red, 8 green\r\n"
          + "Game 41: 5 blue, 5 green, 1 red; 9 red, 8 green, 9 blue; 10 red, 10 blue, 4 green; 3 blue, 17 red, 3 green; 3 blue, 4 red, 2 green\r\n"
          + "Game 42: 2 blue, 10 red, 17 green; 6 red, 10 green, 10 blue; 3 blue, 6 green, 8 red; 9 green, 2 blue, 8 red; 13 green, 5 blue; 4 red, 18 green, 11 blue\r\n"
          + "Game 43: 8 red, 3 blue, 6 green; 2 red, 8 green, 10 blue; 5 blue, 9 red, 9 green; 1 green, 15 red, 8 blue\r\n"
          + "Game 44: 11 green, 19 red, 14 blue; 1 red, 19 green, 9 blue; 7 green, 8 red, 10 blue; 14 green, 8 blue, 15 red; 7 green, 3 red, 2 blue\r\n"
          + "Game 45: 4 green, 9 blue, 4 red; 7 blue, 13 green, 2 red; 12 green, 10 blue, 10 red\r\n"
          + "Game 46: 10 red, 2 green, 1 blue; 10 red, 10 green, 1 blue; 1 blue, 13 green; 1 blue, 2 green, 10 red; 1 blue, 7 red, 11 green; 10 red, 5 green\r\n"
          + "Game 47: 3 blue, 2 green, 12 red; 5 blue, 7 red; 5 green, 14 red; 12 red, 7 green, 5 blue\r\n"
          + "Game 48: 5 red, 1 blue, 3 green; 7 red, 8 green, 4 blue; 4 blue, 5 green, 17 red; 1 blue, 12 red\r\n"
          + "Game 49: 2 green, 7 red, 1 blue; 11 green, 5 red; 4 red, 1 blue, 1 green; 11 green, 1 blue, 7 red\r\n"
          + "Game 50: 10 red, 3 blue, 6 green; 1 blue, 5 red, 3 green; 6 blue, 11 red, 12 green; 10 green\r\n"
          + "Game 51: 18 blue, 1 green, 1 red; 15 blue; 13 blue, 11 green, 4 red; 8 red, 1 green, 18 blue; 10 green, 7 blue, 8 red\r\n"
          + "Game 52: 13 green, 15 blue; 6 blue, 4 red, 8 green; 6 red, 13 green, 11 blue; 2 red, 7 green, 13 blue; 12 green, 2 blue, 3 red; 6 red, 11 green, 1 blue\r\n"
          + "Game 53: 2 red, 2 green; 3 green, 1 blue, 1 red; 1 blue, 4 green, 7 red; 4 red, 1 blue; 4 red, 5 green, 2 blue\r\n"
          + "Game 54: 8 blue, 2 red, 5 green; 6 green, 2 blue, 3 red; 1 blue, 8 green, 4 red\r\n"
          + "Game 55: 6 green, 6 blue, 3 red; 13 green, 1 red; 2 blue, 1 red, 1 green; 14 green, 1 blue, 1 red; 1 blue, 2 red, 9 green; 9 green, 2 blue, 4 red\r\n"
          + "Game 56: 4 green, 6 blue, 1 red; 5 red, 3 blue; 6 red, 1 blue; 9 green, 5 blue, 7 red\r\n"
          + "Game 57: 5 red, 5 green, 8 blue; 11 red, 3 blue, 8 green; 7 green, 9 blue, 11 red; 3 green, 2 blue, 12 red\r\n"
          + "Game 58: 3 green, 3 red; 4 red, 1 green; 1 red, 6 green; 5 green; 5 red, 1 blue, 3 green; 3 red, 1 blue\r\n"
          + "Game 59: 2 green, 2 blue; 7 red, 18 green; 2 blue, 7 red, 16 green; 7 red, 10 green\r\n"
          + "Game 60: 3 blue, 4 red; 4 blue, 3 red, 3 green; 16 green\r\n"
          + "Game 61: 1 blue, 2 red, 8 green; 9 blue, 4 green, 12 red; 10 green, 2 red; 5 blue, 11 red, 1 green; 10 green, 3 blue, 8 red; 5 red, 2 green\r\n"
          + "Game 62: 15 red, 10 blue, 7 green; 4 blue, 9 red, 4 green; 4 red, 2 blue, 2 green; 11 green, 2 red; 8 blue, 2 green; 2 green, 8 red, 8 blue\r\n"
          + "Game 63: 2 green, 3 blue, 1 red; 7 blue, 5 red; 7 blue\r\n"
          + "Game 64: 3 green, 5 blue, 6 red; 9 green, 4 red; 13 red, 1 blue, 5 green; 4 blue, 13 red, 8 green\r\n"
          + "Game 65: 7 green, 1 blue; 1 red, 14 blue, 4 green; 8 blue, 6 red; 14 green, 4 red\r\n"
          + "Game 66: 6 red, 11 green, 7 blue; 1 blue, 6 red; 13 red, 7 blue, 3 green; 8 red, 6 blue, 15 green; 7 green, 6 blue, 4 red; 4 red, 1 blue, 20 green\r\n"
          + "Game 67: 4 blue, 9 green; 15 red, 16 green, 3 blue; 1 green, 14 red, 3 blue; 3 red, 2 blue, 3 green; 4 green, 3 blue, 12 red\r\n"
          + "Game 68: 5 green, 3 blue, 2 red; 4 green, 8 blue, 11 red; 6 red, 6 blue, 4 green; 8 red, 5 blue, 7 green; 6 blue, 6 green, 11 red; 2 blue, 3 green, 3 red\r\n"
          + "Game 69: 15 blue, 16 green, 5 red; 10 blue, 3 red, 13 green; 4 red, 5 blue, 2 green; 1 red; 11 green, 5 red, 15 blue\r\n"
          + "Game 70: 8 red, 9 blue, 12 green; 3 red, 2 blue, 14 green; 10 blue, 1 red, 18 green; 1 blue, 7 red, 16 green; 3 green, 4 red, 16 blue; 10 green, 6 red\r\n"
          + "Game 71: 12 blue, 7 red, 16 green; 2 red, 9 blue, 15 green; 1 red, 11 blue, 11 green; 15 red, 16 blue, 2 green\r\n"
          + "Game 72: 1 blue, 11 red, 6 green; 1 red, 2 blue, 5 green; 4 green, 2 red; 2 green, 12 red\r\n"
          + "Game 73: 1 blue, 1 red; 2 red, 4 blue, 2 green; 1 blue, 2 green, 10 red; 8 red\r\n"
          + "Game 74: 12 red, 1 green, 4 blue; 1 red, 5 blue, 1 green; 11 green, 16 red, 7 blue; 7 red, 1 blue, 1 green; 12 red, 11 green, 12 blue; 11 green, 6 red\r\n"
          + "Game 75: 12 green, 8 red, 3 blue; 7 red, 10 green; 1 green, 7 blue, 1 red\r\n"
          + "Game 76: 4 green, 1 red, 3 blue; 7 blue, 3 green, 3 red; 4 blue, 2 red, 3 green; 4 blue, 1 green\r\n"
          + "Game 77: 2 green, 12 blue, 10 red; 5 blue, 7 red; 2 red, 6 green; 1 blue, 2 red, 6 green\r\n"
          + "Game 78: 2 green, 4 blue, 4 red; 8 green, 10 red, 10 blue; 5 green, 8 blue, 10 red; 6 green, 2 red\r\n"
          + "Game 79: 3 green, 2 blue, 11 red; 8 red, 11 green, 1 blue; 1 blue, 16 red; 5 red, 7 green, 16 blue; 12 red, 7 green, 9 blue; 4 red, 20 blue, 12 green\r\n"
          + "Game 80: 3 red, 5 green; 2 blue, 4 green; 2 red, 12 green, 4 blue; 10 green, 1 blue, 1 red; 4 blue, 3 red\r\n"
          + "Game 81: 1 blue, 1 green, 1 red; 5 green, 3 red, 1 blue; 1 blue, 6 green; 1 green; 1 red, 5 green, 2 blue; 1 blue, 1 red, 3 green\r\n"
          + "Game 82: 7 green, 10 blue, 3 red; 10 green, 12 red, 12 blue; 18 red, 8 green, 14 blue; 3 red, 3 green, 10 blue; 3 red, 1 blue, 5 green; 1 green, 8 blue\r\n"
          + "Game 83: 9 red, 3 blue; 14 blue, 8 red, 3 green; 14 blue, 5 green, 4 red\r\n"
          + "Game 84: 2 blue, 3 red, 6 green; 11 green, 2 red, 1 blue; 17 green, 3 blue, 3 red; 1 red, 1 blue; 1 red, 2 blue, 19 green\r\n"
          + "Game 85: 3 green, 2 blue, 3 red; 4 red, 5 blue, 8 green; 15 green, 1 red, 9 blue; 12 green, 3 blue, 2 red\r\n"
          + "Game 86: 15 green, 7 red, 10 blue; 2 blue, 2 red, 1 green; 4 red, 1 green, 9 blue; 7 red, 14 blue, 5 green\r\n"
          + "Game 87: 1 green, 3 blue, 1 red; 2 blue, 1 green; 1 blue, 2 green, 1 red\r\n"
          + "Game 88: 2 green, 6 blue, 5 red; 5 blue, 2 red; 3 red, 13 blue; 9 blue, 10 red, 1 green\r\n"
          + "Game 89: 6 green, 10 red, 2 blue; 7 red, 1 blue, 8 green; 4 blue, 3 red, 5 green; 4 green, 4 blue, 10 red\r\n"
          + "Game 90: 8 red, 7 blue; 4 green, 3 red, 1 blue; 5 blue, 2 green\r\n"
          + "Game 91: 15 green, 14 red; 12 red, 16 green, 2 blue; 8 red, 10 green; 1 green, 6 red; 8 green, 12 red\r\n"
          + "Game 92: 4 blue, 4 green, 9 red; 1 blue, 17 green; 1 green; 15 green, 3 blue, 12 red; 11 red, 1 blue, 7 green; 7 blue, 13 red, 8 green\r\n"
          + "Game 93: 10 blue, 12 red; 10 blue, 11 green, 8 red; 1 blue, 11 green, 7 red; 10 blue, 15 red, 5 green; 11 red, 8 green, 9 blue; 10 green, 3 blue\r\n"
          + "Game 94: 1 blue, 2 red; 4 red, 1 green, 5 blue; 3 red, 2 green; 2 green, 2 blue; 1 red, 5 blue, 1 green; 4 blue, 1 red, 2 green\r\n"
          + "Game 95: 1 red, 1 blue, 3 green; 2 green, 6 blue; 1 green, 13 blue, 1 red; 3 green, 15 blue\r\n"
          + "Game 96: 16 blue, 7 green, 5 red; 5 green, 5 blue, 6 red; 3 green, 17 blue, 10 red; 13 blue, 2 red, 1 green\r\n"
          + "Game 97: 12 red; 1 blue, 6 red, 1 green; 9 red, 2 blue, 1 green; 1 green, 2 blue, 1 red; 15 red, 1 blue; 1 blue\r\n"
          + "Game 98: 11 red, 6 blue, 13 green; 4 blue, 2 red, 12 green; 2 blue, 8 green, 10 red\r\n"
          + "Game 99: 2 red, 1 blue; 4 green; 7 green, 1 blue, 1 red; 5 green, 2 red; 1 blue, 2 red, 9 green; 2 green, 3 red\r\n"
          + "Game 100: 7 red, 11 blue; 10 red, 5 blue, 1 green; 7 red, 1 green, 13 blue; 9 red; 9 red, 19 blue; 9 red, 9 blue\r\n";
}
