package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Logarithmic;

/**
 * Created by puyihao on 17/1/31.
 * 对数分布
 */
public class LogarithmicGenerator extends AbstractGenerator {
    @Override
    public void generate(double v) {
        AbstractDistribution dist = new Logarithmic(v,this.getEngine());
        this.random(dist);
    }
}
