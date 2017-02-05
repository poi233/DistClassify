package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Uniform;

/**
 * Created by puyihao on 17/1/31.
 * 均匀分布
 */
public class UniformGenerator extends AbstractGenerator {
    @Override
    public void generate() {
        AbstractDistribution dist = new Uniform(this.getEngine());
        this.random(dist);
    }
    @Override
    public void generate(double min,double max) {
        AbstractDistribution dist = new Uniform(min,max,this.getEngine());
        this.random(dist);
    }
}
