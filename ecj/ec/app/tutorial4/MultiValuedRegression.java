/*
  Copyright 2006 by Sean Luke
  Licensed under the Academic Free License version 3.0
  See the file "LICENSE" for more information
*/

package ec.app.tutorial4;

import ec.util.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ec.*;
import ec.gp.*;
import ec.gp.koza.*;
import ec.simple.*;

public class MultiValuedRegression extends GPProblem implements SimpleProblemForm {
	private static final long serialVersionUID = 1;

	public double currentX;


	public void setup(final EvolutionState state, final Parameter base) {
		super.setup(state, base);

		// verify our input is the right class (or subclasses from it)
		if (!(input instanceof DoubleData))
			state.output.fatal("GPData class must subclass from " + DoubleData.class, base.push(P_DATA), null);
	}

	public void evaluate(final EvolutionState state, final Individual ind, final int subpopulation,
			final int threadnum) {
		if (!ind.evaluated) // don't bother reevaluating
		{
			try {

				String fp = System.getProperty("user.dir") + "/ec/app/tutorial4/regression.txt";
				//String fp = "regression.txt"; //for deployment
				DoubleData input = (DoubleData) (this.input);

				int hits = 0;
				double sum = 0.0;
				double expectedResult;
				double result;

				Stream<String> stream = Files.lines(Paths.get(fp));
				ArrayList<String> list = (ArrayList<String>) stream.collect(Collectors.toList());
				stream.close();
				for (int i = 2; i < list.size(); i++) {
					currentX = Double.parseDouble(list.get(i).split("[ ]+")[1]);
					expectedResult = Double.parseDouble(list.get(i).split("[ ]+")[2]);


					((GPIndividual) ind).trees[0].child.eval(state, threadnum, input, stack, ((GPIndividual) ind),
							this);

					result = Math.pow((expectedResult - input.x), 2);
					if (result <= 0.01)
						hits++;
					sum += result;
				}

				sum = sum / (list.size() - 2);

				// the fitness better be KozaFitness!
				KozaFitness f = ((KozaFitness) ind.fitness);
				f.setStandardizedFitness(state, sum);
				f.hits = hits;
				ind.evaluated = true;

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
