package modul01;

import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
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

    public void resultOut(PrintStream out){

        out.print("\t" + "Collections\\Methods" + "|");

        for (int i = 0; i < Methods.values().length; i++) {
            out.print("\t" + Methods.values()[i] + "|");
        }

        out.println();

        for (int i = 0; i < ComparatorListVsSet.COUNT_SIZES_OF_COLLECTIONS; i++) {

            for (Map.Entry<String, HashMap<String, Long[]>> entry: result.entrySet()) {
                out.print("\t" + entry.getKey() + "|");
                for (Map.Entry<String, Long[]> entryValue: entry.getValue().entrySet()){
                    out.print("\t" + entryValue.getValue()[i]);
                }
                out.println();
            }
            out.println();
            out.println();
        }

    }
}
