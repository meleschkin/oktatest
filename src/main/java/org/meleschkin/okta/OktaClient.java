package org.meleschkin.okta;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.pac4j.oidc.client.OidcClient;
import org.pac4j.oidc.config.OidcConfiguration;

@Log4j2
public class OktaClient {

    public static void main(String[] args) {
        Configurator.initialize(new DefaultConfiguration());
        Configurator.setRootLevel(Level.INFO);
        try {
            OidcConfiguration config = new OidcConfiguration();
            config.setClientId("0oa3vm5l1uVe8mwER0x7");
            config.setSecret("dZKkDrWvo4SNgVzcao2Irhso2XK_RMoEOpB4AwUk");
            config.setDiscoveryURI("https://hdi-partner.oktapreview.com");
            log.info(config.toString());
            OidcClient oidcClient = new OidcClient(config);
            log.info(oidcClient.toString());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
