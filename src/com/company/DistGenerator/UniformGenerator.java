package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Uniform;

/**
 * Created by puyihao on 17/1/31.
 * 均匀分布
 */
public class UniformGenerator extends AbstractGenerator {
    public UniformGenerator() {
        this.setmDistInt(10);
    }

    @Override
    public void generate() {
        AbstractDistribution dist = new Uniform(this.getEngine());
        this.random(dist);
    }

    @Override
    public void generate(double min, double max) {
        AbstractDistribution dist = new Uniform(min, max, this.getEngine());
        this.random(dist);
    }

    public void generateAll() {
        printStart();
        String[][] data = new String[10000][8];
        GenerateDriver gd = new GenerateDriver();
        gd.setmDistInt(this.getmDistInt());

        double min = -100;
        double max = 100;
        int i = 0;

        while (i < 10000) {
            while (max > min && i < 10000) {
                this.generate(min, max);
                data[i] = gd.formatFeaturesArr(this.getAccArr());
                max--;
                i++;
            }
            max = 100;
            min++;
        }
        gd.saveDataToFile(data);
        printEnd(i);
    }
}
