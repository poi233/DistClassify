package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Binomial;

/**
 * Created by puyihao on 17/1/31.
 * 二项分布
 */
public class BinomialGenerator extends AbstractGenerator {
    @Override
    public void generate(int n, double p) {
        AbstractDistribution dist = new Binomial(n,p,this.getEngine());
        this.random(dist);
    }
}
