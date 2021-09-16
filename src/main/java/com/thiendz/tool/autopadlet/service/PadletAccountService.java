
package com.thiendz.tool.autopadlet.service;

import com.thiendz.tool.autopadlet.model.AccountClone;
import com.thiendz.tool.autopadlet.model.RespType;
import com.thiendz.tool.autopadlet.util.JRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PadletAccountService {

    private static final String PADLET_URL = "https://padlet.com/features";
    
    public static RespType<AccountClone> cloneAccount() {
        RespType<AccountClone> respType = openPadlet();
        return respType;
    }
    
    private static RespType<AccountClone> openPadlet() {
        RespType<AccountClone> respType = new RespType<>();
        JRequest jRequest = new JRequest(PADLET_URL)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4576.82 Safari/537.36")
                .execute();
        if (jRequest.code() != 200) {
            respType.setCode(-1);
            respType.setMessage("Open Padlet error.");
            return respType;
        }
        String cookie = jRequest.header("Set-Cookie");
        if (cookie == null) {
            respType.setCode(-2);
            respType.setMessage("Cookie not found.");
            return respType;
        }
        String token = getCsrfToken(jRequest.body());
        if (token == null) {
            respType.setCode(-3);
            respType.setMessage("CSRF token not found.");
            return respType;
        }
        AccountClone accountClone = new AccountClone();
        accountClone.setCookie(cookie);
        accountClone.setxCsrfToken(token);
 
        respType.setCode(1);
        respType.setMessage("OK.");
        respType.setData(accountClone);
        
        return respType;
    }
    
    private static String getCsrfToken(String body) {
        final String REGEX_GET_CSRF = "name=\"csrf-token\" content=\"(.+?)\"";
        final String REGEX_REMOVE_REDUDANT_CHAIN = "(name=\"csrf-token\" content=)|\"";
        String token = null;
        Pattern p = Pattern.compile(REGEX_GET_CSRF);
        Matcher m = p.matcher(body);
        if (m.find()) {
            token = m.group().replaceAll(REGEX_REMOVE_REDUDANT_CHAIN, "");
        }
        return token;
    }
}
