package configs;

import org.aeonbits.owner.Config;

public interface ProjectConfig extends Config {

  /**
   * Адреса сервисов
   */

  @Key("base.url")
  @DefaultValue("http://192.168.7.238/test")
  String getErpUrl();

  @Key("token.url")
  @DefaultValue("http://192.168.7.238/kc/realms/erp-integration2/protocol/openid-connect/token")
  String getTokenUrl();

  @Key("crypto.service.url")
  @DefaultValue("http://192.168.7.54:81/api/crypto/DetachedSign")
  String getCryptoServiceUrl();

  /**
   * База данных
   */

  @Key("database.url")
  @DefaultValue("jdbc:postgresql://192.168.7.220:5432/erp_db_dev")
  String getDatabaseUrl();

  @Key("database.login")
  @DefaultValue("sa")
  String getDatabaseLogin();

  @Key("database.password")
  @DefaultValue("sagfhjkzYES!")
  String getDatabasePassword();

  /**
   * Сертификаты
   */

  @Key("certificate.doctor")
  @DefaultValue("01db4d6981365cd00000d2d900050001")
  String getDoctorCertificateNumber();

  /**
   * Параметры для метода получения токена
   */

  @Key("client.id")
  @DefaultValue("e-Rp_Shebekino")
  String getClientId();

  @Key("client.secret")
  @DefaultValue("hLKQlWIP0zy2hip0TB6DlwIeVUajmBqG")
  String getClientSecret();

  @Key("grand.type")
  @DefaultValue("client_credentials")
  String getGrantType();

}
