package com.company;

public class Board {
    private Player[][] cells = new Player[3][3];
    private Player lastPlayedPlayer;

    public boolean move(Player player, int x, int y) {
        if (player.equals(lastPlayedPlayer)) {
            throw new IllegalArgumentException();
        }

        if (isWithinBounds(x, y)) {
            if (isCellUnoccupied(cells[x][y])) {
                cells[x][y] = player;
                lastPlayedPlayer = player;
                return true;
            } else {
                throw new ArrayStoreException();
            }
        } else
            return false;
    }

    private boolean isCellUnoccupied(Player player) {
        return player == null;
    }

    public Player playerAt(int x, int y) {
        if (isWithinBounds(x, y)) {
            return cells[x][y];
        } else
            throw new IllegalArgumentException();
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }
}
