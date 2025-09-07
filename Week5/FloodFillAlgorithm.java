public class FloodFillAlgorithm {
    public static char[][] floodFill(char[][] image, int sr, int sc, char newColor) {
        int rows = image.length, cols = image[0].length;
        char originalColor = image[sr][sc];

        if (originalColor == newColor) return image;

        dfs(image, sr, sc, originalColor, newColor, rows, cols);
        return image;
    }

    private static void dfs(char[][] image, int r, int c, char originalColor, char newColor, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || image[r][c] != originalColor) return;

        image[r][c] = newColor;

        dfs(image, r+1, c, originalColor, newColor, rows, cols);
        dfs(image, r-1, c, originalColor, newColor, rows, cols);
        dfs(image, r, c+1, originalColor, newColor, rows, cols);
        dfs(image, r, c-1, originalColor, newColor, rows, cols);
    }

    public static void main(String[] args) {
        char[][] image = {
            {'B', 'B', 'W'},
            {'W', 'W', 'W'},
            {'W', 'W', 'W'},
            {'B', 'B', 'B'}
        };

        char[][] result = floodFill(image, 2, 2, 'G');

        for (char[] row : result) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
