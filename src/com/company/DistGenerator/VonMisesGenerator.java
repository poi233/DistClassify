package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.VonMises;

/**
 * Created by puyihao on 17/1/31.
 * 冯.米塞斯分布
 */
public class VonMisesGenerator extends AbstractGenerator{
    @Override
    public void generate(double v) {
        AbstractDistribution dist = new VonMises(v,this.getEngine());
        this.random(dist);
    }
}
