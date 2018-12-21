package com.born.analog;

import android.content.Context;

import com.born.analog.module.Affix;

import java.util.ArrayList;
import java.util.List;

/**
 * created by born on 2018/12/10.
 */
public class AnaLog {
    public static List<Affix> AffixList = new ArrayList<>();
    public static List<Affix> Affix_Weapon = new ArrayList<>();
    public static List<Affix> Affix_Armour = new ArrayList<>();
    public static List<Affix> Affix_Hand = new ArrayList<>();
    public static List<Affix> Affix_Shoes = new ArrayList<>();
    public static List<Affix> Affix_Necklace = new ArrayList<>();

    public static void init(Context context){

        initAffix();

    }

    private static void initAffix(){

        AffixList.clear();
        Affix_Weapon.clear();
        Affix_Armour.clear();
        Affix_Hand.clear();
        Affix_Shoes.clear();


        Affix min_max_a = getAffix();
        min_max_a.setTag(AnaLogTag.MIN_MAX_A);
        min_max_a.setDescribe("攻击力 ");
        AffixList.add(min_max_a);

        Affix power = getAffix();
        power.setName("力量");
        power.setType(Affix.TYPE_NORMAL);
        power.setMinSpace(10);
        power.setMaxSpace(15);
        power.setPro(500);
        power.setMaxPro(5);
        power.setTag(AnaLogTag.POWER);
        power.setDescribe("力量 +");
        AffixList.add(power);
        Affix_Weapon.add(power);
        Affix_Hand.add(power);
        Affix_Necklace.add(power);

        Affix minAttack = getAffix();
        minAttack.setName("最小攻击力增加");
        minAttack.setType(Affix.TYPE_NORMAL);
        minAttack.setMinSpace(150);
        minAttack.setMaxSpace(250);
        minAttack.setPro(400);
        minAttack.setMaxPro(4);
        minAttack.setTag(AnaLogTag.MIN_A);
        minAttack.setDescribe("最小攻击力 +");
        AffixList.add(minAttack);
        Affix_Weapon.add(minAttack);
        Affix_Necklace.add(minAttack);

        Affix minAttackP=getAffix();
        minAttackP.setName("最小攻击力提升");
        minAttackP.setType(Affix.TYPE_PERCENT);
        minAttackP.setMinSpace(5);
        minAttackP.setMaxSpace(10);
        minAttackP.setPro(300);
        minAttackP.setMaxPro(3);
        minAttackP.setTag(AnaLogTag.MIN_A_P);
        minAttackP.setDescribe("最小攻击力 +");
        AffixList.add(minAttackP);
        Affix_Weapon.add(minAttackP);


        Affix maxAttack = getAffix();
        maxAttack.setName("最大攻击力增加");
        maxAttack.setType(Affix.TYPE_NORMAL);
        maxAttack.setMinSpace(150);
        maxAttack.setMaxSpace(250);
        maxAttack.setTag(AnaLogTag.MAX_A);
        maxAttack.setDescribe("最大攻击力 +");
        AffixList.add(maxAttack);
        Affix_Weapon.add(maxAttack);

        Affix maxAttackP=getAffix();
        maxAttackP.setName("最大攻击力提升");
        maxAttackP.setType(Affix.TYPE_PERCENT);
        maxAttackP.setMinSpace(5);
        maxAttackP.setMaxSpace(10);
        maxAttackP.setPro(3);
        maxAttackP.setMaxPro(30);
        maxAttackP.setTag(AnaLogTag.MAX_A_P);
        maxAttackP.setDescribe("最大攻击力 +");
        AffixList.add(maxAttackP);
        Affix_Weapon.add(maxAttackP);

        Affix endAttack = getAffix();
        endAttack.setName("最终伤害增加");
        endAttack.setType(Affix.TYPE_NORMAL);
        endAttack.setMinSpace(30);
        endAttack.setMaxSpace(50);
        endAttack.setPro(700);
        endAttack.setMaxPro(7);
        endAttack.setTag(AnaLogTag.END_A);
        endAttack.setDescribe("造成的最终伤害 +");
        AffixList.add(endAttack);
        Affix_Weapon.add(endAttack);
        Affix_Hand.add(endAttack);
        Affix_Necklace.add(endAttack);

        Affix defender = getAffix();
        defender.setName("防御");
        defender.setType(Affix.TYPE_NORMAL);
        defender.setMinSpace(150);
        defender.setMaxSpace(250);
        defender.setPro(400);
        defender.setMaxPro(4);
        defender.setTag(AnaLogTag.DEF);
        defender.setDescribe("防御 +");
        AffixList.add(defender);
        Affix_Armour.add(defender);
        Affix_Hand.add(defender);
        Affix_Shoes.add(defender);

        Affix endDef = getAffix();
        endDef.setName("最终伤害减少");
        endDef.setType(Affix.TYPE_NORMAL);
        endDef.setMinSpace(30);
        endDef.setMaxSpace(50);
        endDef.setPro(700);
        endDef.setMaxPro(7);
        endDef.setTag(AnaLogTag.END_T);
        endDef.setDescribe("受到的最终伤害 -");
        AffixList.add(endDef);
        Affix_Armour.add(endDef);
        Affix_Hand.add(endDef);
        Affix_Shoes.add(endDef);

        Affix endDefP=getAffix();
        endDefP.setName("最终免伤");
        endDefP.setType(Affix.TYPE_PERCENT);
        endDefP.setMinSpace(5);
        endDefP.setMaxSpace(10);
        endDefP.setPro(1);
        endDefP.setPro(10);
        endDefP.setTag(AnaLogTag.END_T_P);
        endDefP.setDescribe("最终免伤 +");
        AffixList.add(endDefP);
        Affix_Armour.add(endDefP);
        Affix_Hand.add(endDefP);
        Affix_Shoes.add(endDefP);

        Affix agility = getAffix();
        agility.setName("敏捷");
        agility.setType(Affix.TYPE_NORMAL);
        agility.setMinSpace(10);
        agility.setMaxSpace(15);
        agility.setPro(500);
        agility.setMaxPro(5);
        agility.setTag(AnaLogTag.AGI);
        agility.setDescribe("敏捷 +");
        AffixList.add(agility);
        Affix_Weapon.add(agility);
        Affix_Armour.add(agility);
        Affix_Hand.add(agility);
        Affix_Shoes.add(agility);
        Affix_Necklace.add(agility);

        Affix accurate = getAffix();
        accurate.setName("精准");
        accurate.setType(Affix.TYPE_NORMAL);
        accurate.setMinSpace(30);
        accurate.setMaxSpace(50);
        accurate.setPro(600);
        accurate.setMaxPro(6);
        accurate.setTag(AnaLogTag.ACC);
        accurate.setDescribe("精准 +");
        AffixList.add(accurate);
        Affix_Weapon.add(accurate);
        Affix_Hand.add(accurate);

        Affix elude = getAffix();
        elude.setName("闪避");
        elude.setType(Affix.TYPE_NORMAL);
        elude.setMinSpace(30);
        elude.setMaxSpace(50);
        elude.setPro(600);
        elude.setMaxPro(6);
        elude.setTag(AnaLogTag.ELU);
        elude.setDescribe("闪避 +");
        AffixList.add(elude);
        Affix_Armour.add(elude);
        Affix_Shoes.add(elude);

        Affix critP = getAffix();
        critP.setName("暴击率");
        critP.setType(Affix.TYPE_PERCENT);
        critP.setMinSpace(5);
        critP.setMaxSpace(10);
        critP.setPro(90);
        critP.setMaxPro(3);
        critP.setTag(AnaLogTag.CRIT_P);
        critP.setDescribe("暴击率 +");
        AffixList.add(critP);
        Affix_Weapon.add(critP);
        Affix_Necklace.add(critP);

        Affix TcritP = getAffix();
        TcritP.setName("抗暴率");
        TcritP.setType(Affix.TYPE_PERCENT);
        TcritP.setMinSpace(5);
        TcritP.setMaxSpace(10);
        TcritP.setPro(90);
        TcritP.setMaxPro(3);
        TcritP.setTag(AnaLogTag.T_CRIT_P);
        TcritP.setDescribe("抗暴率 +");
        AffixList.add(TcritP);
        Affix_Armour.add(TcritP);
        Affix_Hand.add(TcritP);
        Affix_Shoes.add(TcritP);

        Affix crit = getAffix();
        crit.setName("暴击伤害增加");
        crit.setType(Affix.TYPE_NORMAL);
        crit.setMinSpace(150);
        crit.setMaxSpace(250);
        crit.setPro(400);
        crit.setMaxPro(4);
        crit.setTag(AnaLogTag.CRIT);
        crit.setDescribe("暴击伤害 +");
        AffixList.add(crit);
        Affix_Weapon.add(crit);
        Affix_Necklace.add(crit);

        Affix Tcrit = getAffix();
        Tcrit.setName("暴击伤害减少");
        Tcrit.setType(Affix.TYPE_NORMAL);
        Tcrit.setMinSpace(150);
        Tcrit.setMaxSpace(250);
        Tcrit.setPro(400);
        Tcrit.setMaxPro(4);
        Tcrit.setTag(AnaLogTag.CRIT_T);
        Tcrit.setDescribe("受到的暴击伤害 -");
        AffixList.add(Tcrit);
        Affix_Armour.add(Tcrit);
        Affix_Hand.add(Tcrit);
        Affix_Shoes.add(Tcrit);

        Affix critAttackP = getAffix();
        critAttackP.setName("暴击伤害提升");
        critAttackP.setType(Affix.TYPE_PERCENT);
        critAttackP.setMinSpace(5);
        critAttackP.setMaxSpace(10);
        critAttackP.setPro(60);
        critAttackP.setMaxPro(3);
        critAttackP.setTag(AnaLogTag.CRIT_P);
        critAttackP.setDescribe("暴击伤害 +");
        AffixList.add(critAttackP);
        Affix_Weapon.add(critAttackP);
        Affix_Necklace.add(critAttackP);

        Affix critDefP = getAffix();
        critDefP.setName("暴击伤害减免");
        critDefP.setType(Affix.TYPE_PERCENT);
        critDefP.setMinSpace(5);
        critDefP.setMaxSpace(10);
        critDefP.setPro(60);
        critDefP.setMaxPro(3);
        critDefP.setTag(AnaLogTag.CRIT_T_P);
        critDefP.setDescribe("受到的暴击伤害 -");
        AffixList.add(critDefP);
        Affix_Armour.add(critDefP);
        Affix_Hand.add(critDefP);
        Affix_Shoes.add(critDefP);

        Affix blood = getAffix();
        blood.setName("气血");
        blood.setType(Affix.TYPE_NORMAL);
        blood.setMinSpace(150);
        blood.setMaxSpace(250);
        blood.setPro(400);
        blood.setMaxPro(4);
        blood.setTag(AnaLogTag.BLOOD);
        blood.setDescribe("气血上限 +");
        AffixList.add(blood);
        Affix_Armour.add(blood);
        Affix_Hand.add(blood);
        Affix_Shoes.add(blood);

        Affix speed = getAffix();
        speed.setType(Affix.TYPE_FINAL);
        speed.setName("攻速");
        speed.setSpace(10);
        speed.setPro(3);
        speed.setMaxPro(30);
        speed.setTag(AnaLogTag.SPEED);
        speed.setDescribe("攻击速度 +10%");
        AffixList.add(speed);
        Affix_Weapon.add(speed);

        Affix gold = getAffix();
        gold.setType(Affix.TYPE_FINAL);
        gold.setName("天赐");
        gold.setSpace(50);
        gold.setPro(3);
        gold.setMaxPro(3);
        gold.setTag(AnaLogTag.GOLD);
        gold.setDescribe("基础属性 +50%");
        AffixList.add(gold);
        Affix_Weapon.add(gold);
        Affix_Armour.add(gold);
        Affix_Hand.add(gold);
        Affix_Shoes.add(gold);
    }

    private static Affix getAffix(){
        return new Affix();
    }

}
