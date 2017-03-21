package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Zeta;

/**
 * Created by puyihao on 17/1/31.
 * Zeta分布
 */
public class ZetaGenerator extends AbstractGenerator {
    public ZetaGenerator() {
        this.setmDistInt(12);
    }

    @Override
    public void generate(double v, double v1) {
        AbstractDistribution dist = new Zeta(v, v1, this.getEngine());
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
