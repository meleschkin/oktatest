package org.meleschkin.okta;

import com.okta.authn.sdk.AuthenticationStateHandler;
import com.okta.authn.sdk.client.AuthenticationClient;
import com.okta.authn.sdk.client.AuthenticationClients;
import com.okta.authn.sdk.resource.AuthenticationResponse;
import com.okta.authn.sdk.resource.User;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j2
public class OktaSdkClient {
    public static void main(String[] args) {
        AuthenticationStateHandler ignoringStateHandler = new AuthenticationStateHandler() {
            @Override
            public void handleUnauthenticated(@NotNull AuthenticationResponse authenticationResponse) {

            }

            @Override
            public void handlePasswordWarning(@NotNull AuthenticationResponse authenticationResponse) {

            }

            @Override
            public void handlePasswordExpired(@NotNull AuthenticationResponse authenticationResponse) {

            }

            @Override
            public void handleRecovery(@NotNull AuthenticationResponse authenticationResponse) {

            }

            @Override
            public void handleRecoveryChallenge(@NotNull AuthenticationResponse authenticationResponse) {

            }

            @Override
            public void handlePasswordReset(@NotNull AuthenticationResponse authenticationResponse) {

            }

            @Override
            public void handleLockedOut(@NotNull AuthenticationResponse authenticationResponse) {

            }

            @Override
            public void handleMfaRequired(@NotNull AuthenticationResponse authenticationResponse) {

            }

            @Override
            public void handleMfaEnroll(@NotNull AuthenticationResponse authenticationResponse) {

            }

            @Override
            public void handleMfaEnrollActivate(@NotNull AuthenticationResponse authenticationResponse) {

            }

            @Override
            public void handleMfaChallenge(@NotNull AuthenticationResponse authenticationResponse) {

            }

            @Override
            public void handleSuccess(@NotNull AuthenticationResponse authenticationResponse) {
                log.info("Jaaa!!!");
            }

            @Override
            public void handleUnknown(@NotNull AuthenticationResponse authenticationResponse) {

            }
        };

        Configurator.initialize(new DefaultConfiguration());
        Configurator.setRootLevel(Level.INFO);
        try {
            AuthenticationClient client = AuthenticationClients.builder()
                    .setOrgUrl("https://hdi-partner.oktapreview.com")
                    .build();
            log.info(client.toString());
            AuthenticationResponse authenticationResponse = client.authenticate(
                    "117133_vp", "Okta4HUSKi!!".toCharArray(), null, ignoringStateHandler);
            log.info(authenticationResponse.toString());
            log.info("Status: " + authenticationResponse.getStatusString());
            String sessionToken = authenticationResponse.getSessionToken();
            log.info("SessionToken: " + sessionToken);
            Date epiresAt = authenticationResponse.getExpiresAt();
            String pattern = "dd.MM.yyyy HH:mm:ss.SSS";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            log.info("ExpiresAt: " + simpleDateFormat.format(epiresAt));
            User user = authenticationResponse.getUser();
            log.info(user.toString());
            String login = user.getLogin();
            log.info("Login: " + login);
            String firstName = user.getFirstName();
            log.info("FirstName: " + firstName);
            String lastName = user.getLastName();
            log.info("LastName: " + lastName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
