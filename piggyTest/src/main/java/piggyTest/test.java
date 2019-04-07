package piggyTest;

public class test {

	public static void main(String[] args) {

		String master =ConfigurationFactory.create(Configurations.class).getProperty("master");
		System.out.println(master);
	}

}
