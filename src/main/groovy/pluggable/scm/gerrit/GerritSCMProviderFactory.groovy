
package pluggable.scm.gerrit;

import pluggable.scm.SCMProvider;
import pluggable.scm.SCMProviderFactory;
import pluggable.scm.SCMProviderInfo;

/**
* The Gerrit SCM factory class is responsible for parsing the
* providers properties and instantiating a GerritSCMProvider.
*
* @author Robert Northard <robertnorthard@googlemail.com>
*/
@SCMProviderInfo(type="gerrit")
public class GerritSCMProviderFactory implements SCMProviderFactory {

  /**
  * A factory method which return an SCM Provider instantiated with the
  * the provided properties.
  *
  * @param scmProviderProperties - properties for the SCM provider.
  * @return SCMProvider configured from the provided SCM properties.
  **/
  public SCMProvider create(Properties scmProviderProperties){

    GerritSCMProvider scmProvider = null;

    String scmUrl = scmProviderProperties.getProperty("scm.url");
    String scmProtocol = scmProviderProperties.getProperty("scm.protocol");
    int scmPort = Integer.parseInt(scmProviderProperties.getProperty("scm.port"));

    String scmGerritProfile = scmProviderProperties.getProperty("scm.gerrit.server.profile");
    String scmGerritCloneUser = scmProviderProperties.getProperty("scm.gerrit.clone.user");

    scmProvider = new GerritSCMProvider(scmUrl, scmPort,GerritSCMProtocol.valueOf(scmProtocol.toUpperCase()), scmGerritProfile, scmGerritCloneUser);

    return scmProvider;
  }
}
