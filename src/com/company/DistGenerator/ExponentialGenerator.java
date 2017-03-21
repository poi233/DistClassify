package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Exponential;

/**
 * Created by puyihao on 17/1/30.
 * 指数分布
 */
public class ExponentialGenerator extends AbstractGenerator {
    public ExponentialGenerator() {
        this.setmDistInt(3);
    }

    @Override
    public void generate(double lambda) {
        AbstractDistribution dist = new Exponential(lambda, this.getEngine());
        this.random(dist);
    }

    public void generateAll() {
        printStart();
        String[][] data = new String[10000][8];
        GenerateDriver gd = new GenerateDriver();
        gd.setmDistInt(this.getmDistInt());

        double para = 0.01;
        int i = 0;

        while (i < 10000) {
            this.generate(para);
            data[i] = gd.formatFeaturesArr(this.getAccArr());
            para += 0.01;
            i++;
        }
        gd.saveDataToFile(data);
        printEnd(i);
    }


}
