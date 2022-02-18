// inspired by http://inventwithpython.com/blog/2011/08/11/recursion-explained-with-the-flood-fill-algorithm-and-zombies-and-cats/
public class Main {
    final static String HUMAN = "😕";  // Human
    final static String ZOMBIE = "🤢";  // Zombie

    static void zombieAttack(String[][] map, int x, int y) {

        if (x < 0 || y < 0 || x >= map.length || y >= map.length) {
            return;  // base case: outside the "map"
        }

        if (!map[x][y].equals(HUMAN)) {
            return;  // base case: found non human (zombie or cat)
        }

        map[x][y] = ZOMBIE;

        showMap(map);

        zombieAttack(map, x - 1, y); // left
        zombieAttack(map, x + 1, y); // right
        zombieAttack(map, x, y - 1); // up
        zombieAttack(map, x, y + 1); // down
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

        zombieAttack(map, 6, 6);
    }

    static void showMap(String[][] map) {

        Sleeper.pause(1);

        // several empty println's to clear the screen
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }

        for (int line = 0; line < map.length; line++) {
            for (int column = 0; column < map.length; column++) {
                System.out.print(map[line][column]);
            }
            System.out.println();
        }

    }
}