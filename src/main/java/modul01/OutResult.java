package modul01;

import java.util.HashMap;
import java.util.Map;

public class OutResult {

    private HashMap<String, HashMap<String, Long[]>> result;

    public HashMap<String, HashMap<String, Long[]>> getResult() {
        return result;
    }

    public void setResult(HashMap<String, HashMap<String, Long[]>> result) {
        this.result = result;
    }

    public OutResult(HashMap<String, HashMap<String, Long[]>> result) {
        this.result = result;
    }

    public void consoleOut(){

        System.out.print("\t" + "Collections\\Methods" + "|");

        for (int i = 0; i < Methods.values().length; i++) {
            System.out.print("\t" + Methods.values()[i] + "|");
        }

        System.out.println();

        for (int i = 0; i < ComparatorListVsSet.COUNT_SIZES_OF_COLLECTIONS; i++) {

            for (Map.Entry<String, HashMap<String, Long[]>> entry: result.entrySet()) {
                System.out.print("\t" + entry.getKey() + "|");
                for (Map.Entry<String, Long[]> entryValue: entry.getValue().entrySet()){
                    System.out.print("\t" + entryValue.getValue()[i]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }

    }
}
