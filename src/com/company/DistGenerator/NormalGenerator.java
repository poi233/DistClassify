package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Normal;
import org.junit.Test;

/**
 * Created by puyihao on 17/1/31.
 * 正态分布
 */
public class NormalGenerator extends AbstractGenerator {
    public NormalGenerator() {
        this.setmDistInt(7);
    }

    @Override
    public void generate(double mu, double sigma) {
        AbstractDistribution dist = new Normal(mu, sigma, this.getEngine());
        this.random(dist);
    }

    @Test
    public void generateAll() {
        printStart();
        String[][] data = new String[10000][8];
        GenerateDriver gd = new GenerateDriver();
        gd.setmDistInt(this.getmDistInt());

        double mu = 0;
        double sigma = 1;
        int i = 0;

        while (i < 10000) {
            while (sigma < 100 && i < 10000) {
                this.generate(mu, sigma);
                data[i] = gd.formatFeaturesArr(this.getAccArr());
                i++;
                sigma ++;
            }
            sigma = 1;
            mu += 0.2;
        }
        gd.saveDataToFile(data);
        printEnd(i);
    }
}
