package com.quhaodian.umall.data.app;

import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

public class OauthApp {

    public static void main(String[] args) {
        OAuthIssuerImpl oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
        try {
            String authorizationCode = oauthIssuerImpl.authorizationCode();
            System.out.println(authorizationCode);
            System.out.println(authorizationCode.length());
        } catch (OAuthSystemException e) {
            e.printStackTrace();
        }

    }
}
