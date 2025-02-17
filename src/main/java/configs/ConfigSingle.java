package configs;

import org.aeonbits.owner.ConfigFactory;

/**
 * <h3>Инициализация конфига</h3>
 */

public class ConfigSingle {

  public static final ProjectConfig cfg;

  static {
    cfg = ConfigFactory.create(ProjectConfig.class);
  }

}
