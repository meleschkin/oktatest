package org.meleschkin.okta;

import com.okta.authn.sdk.AuthenticationStateHandler;
import com.okta.authn.sdk.client.AuthenticationClient;
import com.okta.authn.sdk.client.AuthenticationClients;
import com.okta.authn.sdk.resource.AuthenticationResponse;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;

@Log4j2
public class OktaSdkClient {
    public static void main(String[] args) {
        AuthenticationStateHandler ignoringStateHandler = new MyAuthenticationStateHandler();
        Configurator.initialize(new DefaultConfiguration());
        Configurator.setRootLevel(Level.INFO);
        try {
            AuthenticationClient client = AuthenticationClients.builder()
                    .setOrgUrl("https://hdi-partner.oktapreview.com")
                    .build();
            log.info(client.toString());
            AuthenticationResponse authenticationResponse = client.authenticate(
                    "117133_vp", "Okta4HUSKi!!".toCharArray(), null, ignoringStateHandler);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
