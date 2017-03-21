package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.NegativeBinomial;

/**
 * Created by puyihao on 17/1/31.
 * 负二项分布
 */
public class NegativeBinomialGenerator extends AbstractGenerator {
    public NegativeBinomialGenerator() {
        this.setmDistInt(6);
    }

    @Override
    public void generate(int r, double p) {
        AbstractDistribution dist = new NegativeBinomial(r, p, this.getEngine());
        this.random(dist);
    }

    public void generateAll() {
        printStart();
        String[][] data = new String[10000][8];
        GenerateDriver gd = new GenerateDriver();
        gd.setmDistInt(this.getmDistInt());

        double para = 1;
        int i = 0;

        while (para <= 10) {
            this.generate(para);
            data[i] = gd.formatFeaturesArr(this.getAccArr());
            para = para + 1;
            i = i + 1;
        }
        gd.saveDataToFile(data);
        printEnd(i);
    }
}
