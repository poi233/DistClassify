package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Gamma;
import org.junit.Test;

/**
 * Created by puyihao on 17/1/31.
 * 伽马分布
 */
public class GammaGenerator extends AbstractGenerator {
    public GammaGenerator() {
        this.setmDistInt(4);
    }

    @Override
    public void generate(double alpha, double beta) {
        AbstractDistribution dist = new Gamma(alpha, beta, this.getEngine());
        this.random(dist);
    }

    @Test
    public void generateAll() {
        printStart();
        String[][] data = new String[10000][8];
        GenerateDriver gd = new GenerateDriver();
        gd.setmDistInt(this.getmDistInt());

        double alpha = 0;
        double beta = 0;
        int i = 0;

        while (i < 10000) {
            while (beta <= 100 && i < 10000) {
                data[i] = gd.formatFeaturesArr(this.getAccArr());
                i++;
                beta += 0.001;
            }
            beta = 0;
            alpha += 0.001;
        }
        gd.saveDataToFile(data);
        printEnd(i);
    }
}
