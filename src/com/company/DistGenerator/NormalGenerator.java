package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Normal;

/**
 * Created by puyihao on 17/1/31.
 * 正态分布
 */
public class NormalGenerator extends AbstractGenerator {
    @Override
    public void generate(double mu, double sigma) {
        AbstractDistribution dist = new Normal(mu, sigma, this.getEngine());
        this.random(dist);
    }
}
