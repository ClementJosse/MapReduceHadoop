package tn.bigdata.sales;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class SalesReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
    private DoubleWritable paiementTotal = new DoubleWritable();

    public void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {

        // Sommation du paiement de toutes les lignes qui ont le même magasin
        double sommeDesPaiement = 0.0;
        for (DoubleWritable paiement : values) {
            System.out.println("value: " + paiement.get());
            sommeDesPaiement += paiement.get();
        }
        System.out.println("--> Sum = " + sommeDesPaiement);

        // Ecriture de la paire (magasin, paiement total)
        paiementTotal.set(sommeDesPaiement);
        context.write(key, paiementTotal);
    }
}


