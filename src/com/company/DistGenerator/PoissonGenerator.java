package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.PoissonSlow;

/**
 * Created by puyihao on 17/1/31.
 * 泊松分布
 */
public class PoissonGenerator extends AbstractGenerator {
    public PoissonGenerator() {
        this.setmDistInt(8);
    }

    @Override
    public void generate(double v) {
        AbstractDistribution dist = new PoissonSlow(v, this.getEngine());
        this.random(dist);
    }

    public void generateAll() {
        printStart();
        String[][] data = new String[10000][8];
        GenerateDriver gd = new GenerateDriver();
        gd.setmDistInt(this.getmDistInt());

        double para = 1;
        int i = 0;

        while (i < 10000) {
            this.generate(para);
            data[i] = gd.formatFeaturesArr(this.getAccArr());
            para++;
            i++;
        }
        gd.saveDataToFile(data);
        printEnd(i);
    }
}
