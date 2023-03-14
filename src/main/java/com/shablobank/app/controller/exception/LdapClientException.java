package com.shablobank.app.controller.exception;

/**
 * @author desireadje
 * @created 16/01/2023 - 10:07
 * @project spring-boot
 */
public class LdapClientException extends Exception {
    private String message;

    private LdapClientException(String message) {
        this.message = message;
    }

    public static LdapClientException create(String message) {
        return new LdapClientException(String.format("Ldap Server :: %s", message));
    }

    @Override
    public String getMessage() {
        return message;
    }
}
