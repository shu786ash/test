package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties p;

	public ReadConfig() throws Exception {

		FileInputStream file =
				new FileInputStream(
"src/main/resources/config.properties");

		p = new Properties();

		p.load(file);
	}

	public String getBrowser() {

		return p.getProperty("browser");
	}

	public String getUrl() {

		return p.getProperty("url");
	}

	public String getEmail() {

		return p.getProperty("email");
	}

	public String getPassword() {

		return p.getProperty("password");
	}
}
