package net.heddady.metier;

import net.heddady.dao.IDao;

public class MetierImpl implements IMetier{
    private IDao dao; // Couplage faible

    /**
     * Pour injecter dans l'attribut dao
     * un objet de type Idao (d'une classe qui implémente l'interface IDao)
     * au moment de l'instantiation
     */
    public MetierImpl(IDao dao){
        this.dao = dao;
    }
    public MetierImpl(){
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 12 *Math.PI/2 *Math.cos(t);
        return res;
    }

    /**
     * Pour injecter dans l'attribut dao
     * un objet de type Idao (d'une classe qui implémente l'interface Idao
     * apres l'instantiation
     */
    public void  setDao(IDao dao){
        this.dao = dao;
    }
}
