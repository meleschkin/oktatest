package org.meleschkin.okta;

import com.okta.authn.sdk.AuthenticationStateHandler;
import com.okta.authn.sdk.resource.AuthenticationResponse;
import com.okta.authn.sdk.resource.User;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j2
public class MyAuthenticationStateHandler implements AuthenticationStateHandler {
    @Override
    public void handleUnauthenticated(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info("Status: " + authenticationResponse.getStatusString());

    }

    @Override
    public void handlePasswordWarning(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info("Status: " + authenticationResponse.getStatusString());

    }

    @Override
    public void handlePasswordExpired(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info("Status: " + authenticationResponse.getStatusString());

    }

    @Override
    public void handleRecovery(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info("Status: " + authenticationResponse.getStatusString());

    }

    @Override
    public void handleRecoveryChallenge(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info("Status: " + authenticationResponse.getStatusString());

    }

    @Override
    public void handlePasswordReset(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info("Status: " + authenticationResponse.getStatusString());

    }

    @Override
    public void handleLockedOut(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info("Status: " + authenticationResponse.getStatusString());

    }

    @Override
    public void handleMfaRequired(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info("Status: " + authenticationResponse.getStatusString());

    }

    @Override
    public void handleMfaEnroll(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info("Status: " + authenticationResponse.getStatusString());

    }

    @Override
    public void handleMfaEnrollActivate(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info("Status: " + authenticationResponse.getStatusString());

    }

    @Override
    public void handleMfaChallenge(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info("Status: " + authenticationResponse.getStatusString());

    }

    @Override
    public void handleSuccess(@NotNull AuthenticationResponse authenticationResponse) {
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

    }

    @Override
    public void handleUnknown(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info("Status: " + authenticationResponse.getStatusString());

    }
}
