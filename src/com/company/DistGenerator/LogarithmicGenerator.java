package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Logarithmic;
import org.junit.Test;

/**
 * Created by puyihao on 17/1/31.
 * 对数分布
 */
public class LogarithmicGenerator extends AbstractGenerator {
    public LogarithmicGenerator() {
        this.setmDistInt(5);
    }

    @Override
    public void generate(double v) {
        AbstractDistribution dist = new Logarithmic(v, this.getEngine());
        this.random(dist);
    }

    @Test
    public void generateAll() {
        printStart();
        String[][] data = new String[100000][8];
        GenerateDriver gd = new GenerateDriver();
        gd.setmDistInt(this.getmDistInt());

        double para = 0;
        int i = 0;

        while (i < 10000) {
            this.generate(para);
            data[i] = gd.formatFeaturesArr(this.getAccArr());
            para+=0.0001;
            i++;
        }
        gd.saveDataToFile(data);
        printEnd(i);
    }
}
