package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.ChiSquare;

/**
 * Created by puyihao on 17/1/31.
 * 卡方分布
 */
public class ChiSquareGenerator extends AbstractGenerator {
    public ChiSquareGenerator() {
        this.setmDistInt(2);
    }

    @Override
    public void generate(double v) {
        AbstractDistribution dist = new ChiSquare(v, this.getEngine());
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
