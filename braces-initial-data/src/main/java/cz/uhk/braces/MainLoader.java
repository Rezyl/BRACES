package cz.uhk.braces;

import cz.uhk.braces.dataset.Loader;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: Lukas Rezner
 * Date: 27.2.16
 */
public class MainLoader {

	public static void load(String aSpringContext, String... aDatasets){
		//Boots up spring context and execute the loader
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(aSpringContext);
		try {
			ctx.getBean(Loader.class).load(aDatasets);
		} finally {
			ctx.close();
		}
	}
}
