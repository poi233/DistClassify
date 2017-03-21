package com.company.SVM.svm;

/**
 * Created by puyihao on 17/2/5.
 */

import com.company.DistGenerator.GenerateDriver;
import com.company.SVM.svmlib.svm_scale;
import com.company.SVM.svmlib.svm_train;
import com.company.SVM.svmlib.svm_predict;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static com.company.Util.Constant.*;
import static java.io.File.separator;

public class SVM {
    private static SVM svm;

    public static SVM getInstance() {
        if (svm != null) {
            return svm;
        } else {
            return new SVM();
        }
    }

    public void trainModel(String trainFile, String rangeFile, String scaleFile, String testScaleFile, String testFile, String modelFile, String result, String modelInfo, String predictInfo) {
        //createScaleFile(new String[]{"-l","-5","-u","5","-s", rangeFile, trainFile}, scaleFile);
        //createScaleFile(new String[]{"-l", "-5", "-u", "5", "-s", rangeFile, testFile}, testScaleFile);
        //createModelFile(new String[]{"-s", "0", "-t", "0", "-g", "0.5", "-c", "32", "-h", "0", scaleFile, modelFile}, modelInfo);
        createPredictFile(new String[]{scaleFile, modelFile, result}, predictInfo);
        /*createModelFile(new String[]{"-s", "0", "-t", "0","-h","0",trainFile, modelFile}, modelInfo);
        createPredictFile(new String[]{trainFile, modelFile, result}, predictInfo);*/
    }

    private static void createScaleFile(String[] args, String scalePath) {
        FileOutputStream fileOutputStream = null;
        PrintStream printStream = null;
        try {
            File file = new File(scalePath);
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            printStream = new PrintStream(fileOutputStream);
            // old stream
            PrintStream oldStream = System.out;
            System.setOut(printStream);//重新定义system.out
            svm_scale.main(args);//开始归一化
            System.setOut(oldStream);//回复syste.out
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (printStream != null) {
                    printStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createModelFile(String[] args, String outInfo) {
        FileOutputStream fileOutputStream = null;
        PrintStream printStream = null;
        try {
            File file = new File(outInfo);
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            printStream = new PrintStream(fileOutputStream);
            // old stream
            PrintStream oldStream = System.out;
            System.setOut(printStream);//重新定义system.out
            svm_train.main(args);//开始训练模型
            System.setOut(oldStream);//回复syste.out
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (printStream != null) {
                    printStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createPredictFile(String[] args, String outInfo) {
        FileOutputStream fileOutputStream = null;
        PrintStream printStream = null;
        try {
            File file = new File(outInfo);
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            printStream = new PrintStream(fileOutputStream);
            // old stream
            PrintStream oldStream = System.out;
            System.setOut(printStream);//重新定义system.out
            svm_predict.main(args);//开始测试精度
            System.setOut(oldStream);//回复syste.out
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (printStream != null) {
                    printStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] arg) {
        //GenerateDriver.generateMain();
        SVM.getInstance().trainModel(dir + separator + "train",
                dir + separator + range,
                dir + separator + scaleFileName,
                dir + separator + testScaleFileName,
                dir + separator + testFileName,
                dir + separator + modelFileName,
                dir + separator + train + separator + resultFileName,
                dir + separator + train + separator + modelInfo,
                dir + separator + train + separator + predictInfo);
    }

}
