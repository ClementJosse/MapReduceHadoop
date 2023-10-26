package tn.bigdata.sales;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class SalesMapper extends Mapper<Object, Text, Text, DoubleWritable> {
    private Text word = new Text();

    public void map(Object key, Text value, Mapper.Context context) throws IOException, InterruptedException {

        String[] parts = value.toString().split("\t"); // Séparation de la ligne en plusieurs parties avec les tabulations
        double cost = Double.parseDouble(parts[4]); // Récupération et transformation du paiement String en Double
        word.set(parts[2]); // Récupération du nom du magasin
        context.write(word, new DoubleWritable(cost)); // Ecriture de la paire (magasin, paiement)

    }
}
