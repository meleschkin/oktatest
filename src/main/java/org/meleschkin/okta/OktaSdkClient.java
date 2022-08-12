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

    public static final String AUTHENTICATION_OKTA_URL = "https://hdi-partner.oktapreview.com";
    public static final String USER = "117133_vp";
    public static final String PASSWORD = "Okta4HUSKi!!";
    public static final String SESSION_TOKEN = "SessionToken: ";

    public static void main(String[] args) {
        AuthenticationStateHandler ignoringStateHandler = new MyAuthenticationStateHandler();
        Configurator.initialize(new DefaultConfiguration());
        Configurator.setRootLevel(Level.INFO);
        try {
            AuthenticationClient client = AuthenticationClients.builder()
                    .setOrgUrl(AUTHENTICATION_OKTA_URL)
                    .build();

            log.info(client.toString());
            AuthenticationResponse authenticationResponse = client.authenticate(
                    USER, PASSWORD.toCharArray(), null, ignoringStateHandler);
            String sessionToken = authenticationResponse.getSessionToken();
            log.info(SESSION_TOKEN + sessionToken);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
