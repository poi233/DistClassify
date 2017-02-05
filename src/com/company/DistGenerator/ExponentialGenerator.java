package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Exponential;

/**
 * Created by puyihao on 17/1/30.
 * 指数分布
 */
public class ExponentialGenerator extends AbstractGenerator{

    @Override
    public void generate(double lambda){
        AbstractDistribution dist = new Exponential(lambda, this.getEngine());
        this.random(dist);
    }


}
