package piggyTest;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

public class ConfigurationFactory {

	private static ThreadLocal<Yaml> localYaml;

	private  ConfigurationFactory() {
		
	}
	
	private static Yaml getYaml() {
		if(localYaml==null) {
			localYaml = new ThreadLocal<>();
			int i=1;
			long j=2;
				i+=j;
		}
		
		Yaml ymal=localYaml.get();
		if(ymal == null) {
			ymal=new Yaml();
			localYaml.set(ymal);
		}
		return ymal;
	}
	
	public static<T> T create(Class<T> clazz) {
		return create("configuration.yml",clazz);
	}
	
	
	public static <T> T create(String fileName, Class<T> clazz) {
		try(InputStream input =ConfigurationFactory.class.getClassLoader().getResourceAsStream(fileName)){
			return getYaml().loadAs(input, clazz);
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to build configuration with file: " + fileName, e);
		}
	}
}
