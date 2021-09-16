
package com.thiendz.tool.autopadlet.model;

import org.apache.http.HttpHost;

public class Proxy {

    private String host;
    private int port;
    private String user;
    private String pass;

    public Proxy() {
        super();
    }

    public Proxy(String host, int port, String user, String pass) {
        super();
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public HttpHost getHttpHost() {
        return new HttpHost(host, port);
    }

    @Override
    public String toString() {
        return "Proxy [host=" + host + ", port=" + port + ", user=" + user + ", pass=" + pass + "]";
    }

}
