package com.company.DistGenerator;

import cern.colt.list.DoubleArrayList;
import cern.jet.random.AbstractDistribution;
import cern.jet.random.engine.MersenneTwister;
import cern.jet.random.engine.RandomEngine;
import hep.aida.bin.DynamicBin1D;

import java.util.Random;

/**
 * Created by puyihao on 17/1/30.
 * 随机数生成的抽象类
 */
abstract class AbstractGenerator {
    private DynamicBin1D bin;
    private RandomEngine engine;
    private int size = 1000000;//随机数生成数量
    private double noiseFactor = 1;
    private double mean;//平均值
    private double rms;//均方根值
    private double variance;//方差
    private double skew;//偏态
    private double kurtosis;//峰值
    private double quantile25, quantile50, quantile75;//分位点

    public void setNoiseFactor(double noiseFactor) {
        this.noiseFactor = noiseFactor;
    }

    public int getSize() {
        return size;
    }

    public void setFeatues() {
        this.mean = getBin().mean();
        this.rms = getBin().rms();
        this.variance = getBin().variance();
        this.skew = getBin().skew();
        this.kurtosis = getBin().kurtosis();
        this.quantile25 = getBin().quantile(0.25);
        this.quantile50 = getBin().quantile(0.5);
        this.quantile75 = getBin().quantile(0.75);
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 设置随机数生成引擎为MersenneTwister
     * @return
     */
    public RandomEngine getEngine() {
        if (engine == null)
            engine = new MersenneTwister();
        return engine;
    }

    public DynamicBin1D getBin() {
        if (bin == null)
            bin = new DynamicBin1D();
        return bin;
    }

    /**
     * 随机生成符合分布的size个数据
     * @param distribution 分布类型
     */
    public void random(AbstractDistribution distribution) {
        DoubleArrayList numbers = new DoubleArrayList(this.getSize());
        for (int i = 0; i < this.getSize(); i++) {
            if (Math.random() < 0.01)
                addNoise(numbers);
            else
                numbers.add(distribution.nextDouble());
        }
        this.getBin().addAllOf(numbers);
    }

    /**
     * 生成噪声
     * @param numbers 数据列表
     */
    public void addNoise(DoubleArrayList numbers) {
        Random random = new Random();
        numbers.add(random.nextGaussian() * noiseFactor);
    }

    public void print() {
        if (this.getBin() != null)
            System.out.println(this.getBin());
    }

    public void generate(double v) {
    }

    public void generate(double v, double v1) {
    }

    public void generate() {
    }

    public void generate(int v, double v1) {
    }
}
