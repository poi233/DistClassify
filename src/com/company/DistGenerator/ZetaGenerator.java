package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.Zeta;

/**
 * Created by puyihao on 17/1/31.
 * Zeta分布
 */
public class ZetaGenerator extends AbstractGenerator {
    @Override
    public void generate(double v, double v1) {
        AbstractDistribution dist = new Zeta(v,v1,this.getEngine());
        this.random(dist);
    }
}
