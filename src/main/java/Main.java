// inspired by http://inventwithpython.com/blog/2011/08/11/recursion-explained-with-the-flood-fill-algorithm-and-zombies-and-cats/
public class Main {
    final static String HUMAN = "😕";  // Human
    final static String ZOMBIE = "🤢";  // Zombie

    static void zombieAttack(String[][] map, int line, int column) {

        if (line < 0 || column < 0 || line >= map.length || column >= map[0].length) {
            return;  // base case: outside the "map"
        }

        if (!map[line][column].equals(HUMAN)) {
            return;  // base case: found non human (zombie or cat)
        }

        map[line][column] = ZOMBIE;

        showMap(map);

        zombieAttack(map, line, column - 1); // left
        zombieAttack(map, line, column + 1); // right
        zombieAttack(map, line - 1, column); // up
        zombieAttack(map, line + 1, column); // down
    }

    public static void main(String[] args) {
        String[][] map = new String[][] {
                { "😕","😕","😕","😕","😕","😕","😕"},
                { "😕","😕","😼","😼","😕","😕","😕"},
                { "😕","😼","😕","😕","😼","😕","😕"},
                { "😕","😼","😕","😕","😼","😕","😕"},
                { "😕","😕","😼","😼","😕","😕","😕"},
                { "😕","😕","😕","😕","😕","😕","😕"},
                { "😕","😕","😕","😕","😕","😕","😕"}
        };

        zombieAttack(map, 6, 6);  // start in the lower right corner
    }

    static void showMap(String[][] map) {

        Sleeper.pause(1);

        // several empty println's to clear the screen
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }

        for (int line = 0; line < map.length; line++) {
            for (int column = 0; column < map[line].length; column++) {
                System.out.print(map[line][column]);
            }
            System.out.println();
        }

    }
}