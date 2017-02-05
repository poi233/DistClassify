package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.ChiSquare;

/**
 * Created by puyihao on 17/1/31.
 * 卡方分布
 */
public class ChiSquareGenerator extends AbstractGenerator {
    @Override
    public void generate(double v) {
        AbstractDistribution dist = new ChiSquare(v,this.getEngine());
        this.random(dist);
    }
}
