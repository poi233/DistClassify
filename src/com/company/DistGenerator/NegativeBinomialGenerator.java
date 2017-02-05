package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.NegativeBinomial;

/**
 * Created by puyihao on 17/1/31.
 * 负二项分布
 */
public class NegativeBinomialGenerator extends AbstractGenerator{
    @Override
    public void generate(int r,double p) {
        AbstractDistribution dist = new NegativeBinomial(r,p,this.getEngine());
        this.random(dist);
    }
}
