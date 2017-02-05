package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Gamma;

/**
 * Created by puyihao on 17/1/31.
 * 伽马分布
 */
public class GammaGenerator extends AbstractGenerator {
    @Override
    public void generate(double alpha ,double beta) {
        AbstractDistribution dist = new Gamma(alpha,beta,this.getEngine());
        this.random(dist);
    }
}
