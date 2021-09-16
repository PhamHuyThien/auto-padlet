package com.thiendz.tool.autopadlet.service;

import com.thiendz.tool.autopadlet.model.AccountClone;
import com.thiendz.tool.autopadlet.model.Post;
import com.thiendz.tool.autopadlet.model.RespType;
import com.thiendz.tool.autopadlet.util.JJson;
import com.thiendz.tool.autopadlet.util.JRequest;
import com.thiendz.tool.autopadlet.util.Utils;
import com.thiendz.tool.autopadlet.util.enums.RandomType;
import org.apache.http.entity.ContentType;

public class PadletReactionService {

    private static final String PADLET_POST_REACTION = "https://padlet.com/api/5/reactions";

    public static RespType<?> reaction(Post post) {
        RespType<AccountClone> respTypeAccount = PadletAccountService.cloneAccount();
        return reaction(respTypeAccount.getData(), post);
    }

    public static RespType<?> reaction(AccountClone accountClone, Post post) {
        RespType<?> respType = new RespType<>();
        if (accountClone == null) {
            respType.setCode(-1);
            respType.setMessage("AccountClone is null.");
            return respType;
        }
        respType = reactionPost(accountClone, post);
        return respType;
    }

    private static RespType<?> reactionPost(AccountClone accountClone, Post post) {
        final String SEND_BASE = "{\"wish_id\": %d,\"value\":1,\"reaction_type\":\"like\"}";
        RespType<?> respType = new RespType<>();
        JRequest jRequest = new JRequest(PADLET_POST_REACTION, JRequest.METHOD_POST)
                .header("cookie", accountClone.getCookie())
                .header("x-csrf-token", accountClone.getxCsrfToken())
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4576.82 Safari/537.36")
                .header("authorization", fakeAuthorization())
                .header("x-uid", fakeXUid())
                .send(String.format(SEND_BASE, post.getId()), ContentType.APPLICATION_JSON)
                .execute();
        JJson json = JJson.parse(jRequest.body());
        if (json.toObj() == null) {
            respType.setCode(-2);
            respType.setMessage("Response wrong format.");
            System.out.println(jRequest.body());
            return respType;
        }
        if (json.k("error").toStr() != null) {
            respType.setCode(-3);
            respType.setMessage(json.k("error").toStr());
            return respType;
        }
        if (json.k("data").toObj() != null) {
            respType.setCode(1);
            respType.setMessage("OK.");
        } else {
            respType.setCode(-4);
            respType.setMessage("Unknown error, " + json.toStr());
        }
        return respType;
    }

    public static String fakeAuthorization() {
        final String auth = Utils.randomCustom(64, "abcdef1234567890", "");
        return "Bearer " + auth;
    }

    public static String fakeXUid() {
        return Utils.randomCustom(30, "", "", RandomType.NUMBER);
    }
}
