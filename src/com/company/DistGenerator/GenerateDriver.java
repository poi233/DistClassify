package com.company.DistGenerator;
/**
 * Created by puyihao on 17/1/30.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.company.Util.Constant.*;

public class GenerateDriver {
    FileOutputStream outputStream;
    FileOutputStream testOutputStream;
    double mDistInt;                               // Dist 的label

    public GenerateDriver() {
        init();
    }

    public void init() {
        try {
            File f = new File(dir + File.separator + "train");
            if (f == null)
                f.createNewFile();
            outputStream = new FileOutputStream(dir + File.separator + "train", true);
            testOutputStream = new FileOutputStream(dir + File.separator + "test", true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getmDistInt() {
        return mDistInt;
    }

    public void setmDistInt(double mDistInt) {
        this.mDistInt = mDistInt;
    }

    public String[] formatFeaturesArr(double[] accArr) {
        String[] featuresArr = new String[8];
        double mean = accArr[0];
        featuresArr[0] = FUN_101_MEAN_CODE + ":" + mean;
        double rms = accArr[1];
        featuresArr[1] = FUN_102_RMS_CODE + ":" + rms;
        double var = accArr[2];
        featuresArr[2] = FUN_103_VARIANCE_CODE + ":" + var;
        double skew = accArr[3];
        featuresArr[3] = FUN_104_SKEW_CODE + ":" + skew;
        double kurtosis = accArr[4];
        featuresArr[4] = FUN_105_KURTOSIS_CODE + ":" + kurtosis;
        double quantile25 = accArr[5];
        featuresArr[5] = FUN_106_QUANTILE25_CODE + ":" + quantile25;
        double quantile50 = accArr[6];
        featuresArr[6] = FUN_107_QUANTILE50_CODE + ":" + quantile50;
        double quantile75 = accArr[7];
        featuresArr[7] = FUN_108_QUANTILE75_CODE + ":" + quantile75;
        return featuresArr;
    }

    public void saveDataToFile(String[][] data) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer testStringBuffer = new StringBuffer();
        for (String[] aData : data) {
            if (Math.random() > 0.01) {
                stringBuffer.append(getmDistInt());
                for (int j = 0; j < 8; j++) {
                    stringBuffer.append(" ").append(aData[j]);
                }
                stringBuffer.append("\n");
            } else {
                testStringBuffer.append(getmDistInt());
                for (int j = 0; j < 8; j++) {
                    testStringBuffer.append(" ").append(aData[j]);
                }
                testStringBuffer.append("\n");
            }
        }
        try {

            testOutputStream.write(testStringBuffer.toString().getBytes());
            outputStream.write(stringBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateMain() {
        BinomialGenerator bg = new BinomialGenerator();
        ChiSquareGenerator cg = new ChiSquareGenerator();
        ExponentialGenerator eg = new ExponentialGenerator();
        GammaGenerator gg = new GammaGenerator();
        LogarithmicGenerator lg = new LogarithmicGenerator();
        NegativeBinomialGenerator nbg = new NegativeBinomialGenerator();
        NormalGenerator ng = new NormalGenerator();
        PoissonGenerator pg = new PoissonGenerator();
        StudentTGenerator sg = new StudentTGenerator();
        UniformGenerator ug = new UniformGenerator();
        VonMisesGenerator vg = new VonMisesGenerator();
        ZetaGenerator zg = new ZetaGenerator();
        bg.generateAll();
        cg.generateAll();
        eg.generateAll();
        //gg.generateAll();
        //lg.generateAll();
        //nbg.generateAll();
        ng.generateAll();
        pg.generateAll();
        sg.generateAll();
        ug.generateAll();
        //vg.generateAll();
        //zg.generateAll();
    }
}
