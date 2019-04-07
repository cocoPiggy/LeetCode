package piggyTest;

import java.io.Serializable;
import java.util.Map;

public class Configurations implements Serializable {

	private static final long serialVersionUID = -2783027620816755436L;
	
	public static final Configurations INSTANCE =ConfigurationFactory.create(Configurations.class);
	private Map<String,String> properties;
	private Map<String,String> hbaseOptions;
	
	public String getProperty(String key) {
		return this.properties.get(key);
	}
	
	public Map<String, String> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
	public Map<String, String> getHbaseOptions() {
		return hbaseOptions;
	}
	public void setHbaseOptions(Map<String, String> hbaseOptions) {
		this.hbaseOptions = hbaseOptions;
	}
	
	
}
