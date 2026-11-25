package net.heddady.metier;

public class MetierImpl implements IMetier{
    private IDao dao; // Couplage faible
    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 12 *Math.PI/2 *Math.cos(t);
        return res;
    }

    /**
     * Pour injecter dans l'attribut dao
     * un objet de type Idao (d'une classe qui implemente l'interface Idao
     */
    public void  setDao(Idao dao){
        this.dao = dao;
    }
}
