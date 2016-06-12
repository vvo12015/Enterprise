package module01;

import java.util.*;

public class CreateResult {

    private HashMap<String, HashMap<String, Long[]>> resultCollections;


    public HashMap<String, HashMap<String, Long[]>> getResultCollections() {
        return resultCollections;
    }

    private void setResultCollections(HashMap<String, HashMap<String, Long[]>> resultCollections) {
        this.resultCollections = resultCollections;
    }

    public CreateResult() {

        Collection[] collections = {new ArrayList<Integer>(),
                new LinkedList<Integer>(),
                new HashSet<Integer>(),
                new TreeSet<Integer>()};

        String[] nameCollections = {"ArrayList", "LinkedList", "HashSet", "TreeSet"};

        resultCollections = new HashMap<>();

        for (int i = 0; i < 4; i++) {

            ComparatorListVsSet comparatorListVsSet = new ComparatorListVsSet(collections[i]);

            HashMap<String, Long[]> resultsOfMethods = new HashMap<>();

            for (int j = 0; j < Methods.values().length; j++) {
                resultsOfMethods.put(Methods.values()[j].toString(),
                        comparatorListVsSet.comparatorMethods(Methods.values()[i]));
            }

            resultCollections.put(nameCollections[i], resultsOfMethods);
        }
    }
}
