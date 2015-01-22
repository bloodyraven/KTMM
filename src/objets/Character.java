package objets;

public class Character {

private int pv, atk, def, esq, lvl, pc;
	
	public Character() {
		pv=100;
		atk=5;
		def=0;
		esq=0;
		lvl=1;
		pc=0;
	}
	public Character(int pv, int atk, int def, int esq, int lvl, int pc) {
		this.pv=pv;
		this.atk=atk;
		this.def=def;
		this.esq=esq;
		this.lvl=lvl;
		this.pc=pc;
	}
	
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getEsq() {
		return esq;
	}
	public void setEsq(int esq) {
		this.esq = esq;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
}
