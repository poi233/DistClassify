package com.company;

import cern.jet.random.AbstractDistribution;
import com.company.DistGenerator.ChiSquareGenerator;
import com.company.DistGenerator.ExponentialGenerator;
import com.company.DistGenerator.PoissonGenerator;
import com.company.DistGenerator.UniformGenerator;

/**
 * Created by puyihao on 17/1/30.
 */
public class GenerateDriver {

    public void doGenerate(){
    }

    public static void main(String[] arg){
        ExponentialGenerator dist = new ExponentialGenerator();
//        PoissonGenerator dist = new PoissonGenerator();
//        UniformGenerator dist = new UniformGenerator();
//        ChiSquareGenerator dist = new ChiSquareGenerator();

 //       dist.generate(10.0);
  //      dist.generate(30);
        dist.generate(10);

        dist.print();
    }
}
