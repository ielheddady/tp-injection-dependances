package net.heddady.presentation;

import net.heddady.dao.DaoImpl;
import net.heddady.metier.MetierImpl;

public class presentation1 {
    public static void main(String[] args) {
        DaoImpl d = new DaoImpl();
        MetierImpl metier = new MetierImpl(d);
        //metier.setDao(d);//Injection des dépendances via le setter
        System.out.println("RES= "+metier.calcul());

    }
}
