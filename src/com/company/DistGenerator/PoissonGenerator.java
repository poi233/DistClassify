package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Exponential;
import cern.jet.random.PoissonSlow;

/**
 * Created by puyihao on 17/1/31.
 * 泊松分布
 */
public class PoissonGenerator extends AbstractGenerator{

    @Override
    public void generate(double v){
        AbstractDistribution dist = new PoissonSlow(v, this.getEngine());
        this.random(dist);
    }
}
