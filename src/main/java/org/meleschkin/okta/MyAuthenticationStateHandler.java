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

    public static final String STATUS = "Status: ";
    public static final String FIRST_NAME = "FirstName: ";
    public static final String LAST_NAME = "LastName: ";
    public static final String LOGIN = "Login: ";
    public static final String EXPIRES_AT = "ExpiresAt: ";
    public static final String DATE_FORMAT = "dd.MM.yyyy HH:mm:ss.SSS";
    public static final String SESSION_TOKEN = "SessionToken: ";

    @Override
    public void handleUnauthenticated(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info(STATUS + authenticationResponse.getStatusString());

    }

    @Override
    public void handlePasswordWarning(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info(STATUS + authenticationResponse.getStatusString());

    }

    @Override
    public void handlePasswordExpired(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info(STATUS + authenticationResponse.getStatusString());

    }

    @Override
    public void handleRecovery(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info(STATUS + authenticationResponse.getStatusString());

    }

    @Override
    public void handleRecoveryChallenge(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info(STATUS + authenticationResponse.getStatusString());

    }

    @Override
    public void handlePasswordReset(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info(STATUS + authenticationResponse.getStatusString());

    }

    @Override
    public void handleLockedOut(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info(STATUS + authenticationResponse.getStatusString());

    }

    @Override
    public void handleMfaRequired(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info(STATUS + authenticationResponse.getStatusString());

    }

    @Override
    public void handleMfaEnroll(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info(STATUS + authenticationResponse.getStatusString());

    }

    @Override
    public void handleMfaEnrollActivate(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info(STATUS + authenticationResponse.getStatusString());

    }

    @Override
    public void handleMfaChallenge(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info(STATUS + authenticationResponse.getStatusString());

    }

    @Override
    public void handleSuccess(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info(STATUS + authenticationResponse.getStatusString());
        String sessionToken = authenticationResponse.getSessionToken();
        log.info(SESSION_TOKEN + sessionToken);
        Date expiresAt = authenticationResponse.getExpiresAt();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        log.info(EXPIRES_AT + simpleDateFormat.format(expiresAt));
        User user = authenticationResponse.getUser();
        log.info(user.toString());
        String login = user.getLogin();
        log.info(LOGIN + login);
        String firstName = user.getFirstName();
        log.info(FIRST_NAME + firstName);
        String lastName = user.getLastName();
        log.info(LAST_NAME + lastName);

    }

    @Override
    public void handleUnknown(@NotNull AuthenticationResponse authenticationResponse) {
        log.info(authenticationResponse.toString());
        log.info(STATUS + authenticationResponse.getStatusString());

    }
}
