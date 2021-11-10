package be.ehb.thisappisintents.model;

import java.util.ArrayList;


public class PersoonDAO {
    //Singleton pattern
    private static final PersoonDAO ourInstance = new PersoonDAO();

    public static PersoonDAO getInstance() {
        return ourInstance;
    }

    private PersoonDAO() {

        personen.add( new Persoon("David",
                "tel:0492827218",
                "http://www.ehb.be") );
        personen.add( new Persoon("Joske Vermeulen",
                "tel:0492827218",
                "http://www.ehb.be") );
        personen.add(new Persoon("Amin",
                "tel:048951682",
                "http://www.google.be"));

    }

    //eigen waarden
    private final ArrayList<Persoon> personen = new ArrayList<>();

    public ArrayList<Persoon> getPersonen() {
        return personen;
    }
}
