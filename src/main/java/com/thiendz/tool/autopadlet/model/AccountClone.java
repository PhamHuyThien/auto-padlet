
package com.thiendz.tool.autopadlet.model;

public class AccountClone {
    private String cookie;
    private String xCsrfToken;

    public AccountClone() {
    }

    public AccountClone(String cookie, String xCsrfToken) {
        this.cookie = cookie;
        this.xCsrfToken = xCsrfToken;
    }
    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getxCsrfToken() {
        return xCsrfToken;
    }

    public void setxCsrfToken(String xCsrfToken) {
        this.xCsrfToken = xCsrfToken;
    }

    @Override
    public String toString() {
        return "AccountClone{" + "cookie=" + cookie + ", xCsrfToken=" + xCsrfToken + '}';
    }

}
