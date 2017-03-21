package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Binomial;

/**
 * Created by puyihao on 17/1/31.
 * 二项分布
 */
public class BinomialGenerator extends AbstractGenerator {
    public BinomialGenerator() {
        this.setmDistInt(1);
    }

    @Override
    public void generate(int n, double p) {
        AbstractDistribution dist = new Binomial(n, p, this.getEngine());
        this.random(dist);
    }

    public void generateAll() {
        printStart();
        String[][] data = new String[10000][8];
        GenerateDriver gd = new GenerateDriver();
        gd.setmDistInt(this.getmDistInt());

        int n = 1;
        double p = 0.01;
        int i = 0;

        while (p <= 1 && i < 10000) {
            while (n <= 1000 && i < 10000) {
                this.generate(n, p);
                data[i] = gd.formatFeaturesArr(this.getAccArr());
                n++;
                i++;
            }
            n = 1;
            p += 0.01;
        }
        gd.saveDataToFile(data);
        printEnd(i);
    }
}
