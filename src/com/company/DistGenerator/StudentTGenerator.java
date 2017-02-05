package com.company.DistGenerator;

import cern.jet.random.AbstractDistribution;
import cern.jet.random.StudentT;

/**
 * Created by puyihao on 17/1/31.
 * T分布
 */
public class StudentTGenerator extends AbstractGenerator {
    @Override
    public void generate(double n) {
        AbstractDistribution dist = new StudentT(n,this.getEngine());
        this.random(dist);
    }
}
