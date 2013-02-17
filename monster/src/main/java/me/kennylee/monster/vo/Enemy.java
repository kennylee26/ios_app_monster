package me.kennylee.monster.vo;

public class Enemy {
	private int round;
	private boolean isEgg;
	private int num;
	private int coin;
	private int gotExp;
	private int hp;
	private int coolDown;
	private int gotCoin;
	private int maxCool;
	private int baseCoin;
	private int baseExp;
	private int defend;
	private int attack;

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public boolean isEgg() {
		return isEgg;
	}

	public void setEgg(boolean isEgg) {
		this.isEgg = isEgg;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getGotExp() {
		return gotExp;
	}

	public void setGotExp(int gotExp) {
		this.gotExp = gotExp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getCoolDown() {
		return coolDown;
	}

	public void setCoolDown(int coolDown) {
		this.coolDown = coolDown;
	}

	public int getGotCoin() {
		return gotCoin;
	}

	public void setGotCoin(int gotCoin) {
		this.gotCoin = gotCoin;
	}

	public int getMaxCool() {
		return maxCool;
	}

	public void setMaxCool(int maxCool) {
		this.maxCool = maxCool;
	}

	public int getBaseCoin() {
		return baseCoin;
	}

	public void setBaseCoin(int baseCoin) {
		this.baseCoin = baseCoin;
	}

	public int getBaseExp() {
		return baseExp;
	}

	public void setBaseExp(int baseExp) {
		this.baseExp = baseExp;
	}

	public int getDefend() {
		return defend;
	}

	public void setDefend(int defend) {
		this.defend = defend;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public String toString() {
		return "Enemy [round=" + round + ", isEgg=" + isEgg + ", num=" + num
				+ ", coin=" + coin + ", gotExp=" + gotExp + ", hp=" + hp
				+ ", coolDown=" + coolDown + ", gotCoin=" + gotCoin
				+ ", maxCool=" + maxCool + ", baseCoin=" + baseCoin
				+ ", baseExp=" + baseExp + ", defend=" + defend + ", attack="
				+ attack + "]";
	}

}
