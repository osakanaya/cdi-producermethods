package producermethods;

import java.util.logging.Logger;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;

public class CoderFactory {
	private static final Logger logger = Logger.getLogger(CoderFactory.class.getName());

	@Produces
	@Chosen
	public Coder getcoder(@New CoderImpl production, @New TestCoderImpl test, InjectionPoint injectionPoint) {
		Annotated annotated = injectionPoint.getAnnotated();
		CoderConfig config = annotated.getAnnotation(CoderConfig.class);
		CoderType type = config.type();
		
		switch(type) {
			case PRODUCTION:
				return production;
			case TEST:
				return test;
			default:
				return null;
		}
	}
	
	public void disposeCoder(@Disposes @Chosen Coder coder) {
		logger.info("Disposing coder - type: " + coder.getCoderType().toString());
	}
}
