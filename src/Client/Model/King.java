package Client.Model;

import Client.dto.turn.TurnKing;

/**
 * This class has properties of the player's king.
 * Please do not change this class, it is a piece of the internal implementation
 * and you do not need to know anything about this class.
 */

public class King {
    private int hp;
    private int attack;
    private int range;
    private int playerId;
    private boolean isAlive;
    private Unit target;
    private Cell targetCell;
    private Cell center;

    public void update(TurnKing turnKing){
        this.setHp(turnKing.getHp());
        this.setAttack(this.attack);
        this.setRange(this.range);
        this.setPlayerId(this.playerId);
        this.setAlive(turnKing.isAlive());
        this.setCenter(this.center);
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Cell getCenter() {
        return center;
    }

    public void setCenter(Cell center) {
        this.center = center;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Unit getTarget() {
        return target;
    }

    public void setTarget(Unit target) {
        this.target = target;
    }

    public Cell getTargetCell() {
        return targetCell;
    }

    public void setTargetCell(Cell targetCell) {
        this.targetCell = targetCell;
    }

    public boolean isInKing(Cell cell){
        if(Math.abs(center.getCol() - cell.getCol()) <= 1 && Math.abs(center.getRow() - cell.getRow()) <= 1)
            return true;
        return false;
    }

    public int getDistance(Unit u){
        return getDistance(u.getCell());
    }

    public int getDistance(Cell cell) {
        int ans = Integer.MAX_VALUE;
        for(int i = center.getRow() - 1; i <= center.getRow() + 1; i++){
            for(int j = center.getCol() - 1; j <= center.getCol() + 1; j++){
                Cell c = new Cell(i, j);
                ans = Math.min(ans, c.getDistance(cell));
            }
        }
        return ans;
    }
}
