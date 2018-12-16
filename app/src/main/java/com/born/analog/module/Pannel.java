package com.born.analog.module;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * created by born on 2018/12/16.
 * 用户属性面板bean
 */
@Entity
public class Pannel {
    //气血
    private int HP;
    //防御
    private int defender;
    //力量
    private int power;
    //最小攻击力
    private int minAttack;
    //最大攻击力
    private int maxAttack;
    //最终伤害增加
    private int endAttack;
    //最终伤害减少
    private int endAttackT;
    //敏捷
    private int agility;
    //命中
    private int accurate;
    //闪避
    private int elude;
    //暴击率
    private int critP;
    //抗暴率
    private int TcritP;
    //暴击伤害
    private int cirt;
    //抗暴击
    private int Tcrit;
    //攻速
    private int gold;
    @Generated(hash = 1660137434)
    public Pannel(int HP, int defender, int power, int minAttack, int maxAttack,
            int endAttack, int endAttackT, int agility, int accurate, int elude,
            int critP, int TcritP, int cirt, int Tcrit, int gold) {
        this.HP = HP;
        this.defender = defender;
        this.power = power;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
        this.endAttack = endAttack;
        this.endAttackT = endAttackT;
        this.agility = agility;
        this.accurate = accurate;
        this.elude = elude;
        this.critP = critP;
        this.TcritP = TcritP;
        this.cirt = cirt;
        this.Tcrit = Tcrit;
        this.gold = gold;
    }
    @Generated(hash = 340137037)
    public Pannel() {
    }
    public int getHP() {
        return this.HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public int getDefender() {
        return this.defender;
    }
    public void setDefender(int defender) {
        this.defender = defender;
    }
    public int getPower() {
        return this.power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public int getMinAttack() {
        return this.minAttack;
    }
    public void setMinAttack(int minAttack) {
        this.minAttack = minAttack;
    }
    public int getMaxAttack() {
        return this.maxAttack;
    }
    public void setMaxAttack(int maxAttack) {
        this.maxAttack = maxAttack;
    }
    public int getEndAttack() {
        return this.endAttack;
    }
    public void setEndAttack(int endAttack) {
        this.endAttack = endAttack;
    }
    public int getEndAttackT() {
        return this.endAttackT;
    }
    public void setEndAttackT(int endAttackT) {
        this.endAttackT = endAttackT;
    }
    public int getAgility() {
        return this.agility;
    }
    public void setAgility(int agility) {
        this.agility = agility;
    }
    public int getAccurate() {
        return this.accurate;
    }
    public void setAccurate(int accurate) {
        this.accurate = accurate;
    }
    public int getElude() {
        return this.elude;
    }
    public void setElude(int elude) {
        this.elude = elude;
    }
    public int getCritP() {
        return this.critP;
    }
    public void setCritP(int critP) {
        this.critP = critP;
    }
    public int getTcritP() {
        return this.TcritP;
    }
    public void setTcritP(int TcritP) {
        this.TcritP = TcritP;
    }
    public int getCirt() {
        return this.cirt;
    }
    public void setCirt(int cirt) {
        this.cirt = cirt;
    }
    public int getTcrit() {
        return this.Tcrit;
    }
    public void setTcrit(int Tcrit) {
        this.Tcrit = Tcrit;
    }
    public int getGold() {
        return this.gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
}
