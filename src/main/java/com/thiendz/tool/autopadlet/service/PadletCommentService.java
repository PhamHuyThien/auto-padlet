package com.thiendz.tool.autopadlet.service;

import com.thiendz.tool.autopadlet.model.AccountClone;
import com.thiendz.tool.autopadlet.model.Post;
import com.thiendz.tool.autopadlet.model.RespType;
import com.thiendz.tool.autopadlet.util.JJson;
import com.thiendz.tool.autopadlet.util.JRequest;
import org.apache.http.entity.ContentType;

public class PadletCommentService {

    private static final String URL_POST_COMMENT = "https://padlet.com/api/5/comments";

    public static RespType<?> comment(Post post, String text) {
        RespType<AccountClone> respTypeAccount = PadletAccountService.cloneAccount();
        return comment(respTypeAccount.getData(), post, text);
    }

    public static RespType<?> comment(AccountClone accountClone, Post post, String text) {
        RespType<?> respType = new RespType<>();
        if (accountClone == null) {
            respType.setCode(-1);
            respType.setMessage("AccountClone is null.");
            return respType;
        }
        respType = commentPost(accountClone, post, text);
        return respType;
    }

    private static RespType<?> commentPost(AccountClone accountClone, Post post, String text) {
        final String SEND_BASE = "{\"id\":\"new_1631781011113\",\"wish_id\": %d,\"body\":\"%s\",\"user\":{\"id\":1349804267,\"name\":null,\"short_name\":null,\"username\":null,\"avatar\":null,\"lang\":\"en\",\"status\":null,\"role\":null,\"email\":null,\"is_teacher\":null,\"bio\":null,\"tenant_id\":1,\"created_at\":\"2021-09-16T08:29:09.700Z\",\"updated_at\":\"2021-09-16T08:29:09.797Z\",\"registered_at\":\"2021-09-16T08:29:09.618Z\",\"paying\":false,\"quota\":{\"walls_used\":1,\"walls_limit\":3,\"actual_walls_limit\":5,\"can_make\":true,\"advertized_max_upload_megabytes\":25,\"max_upload_megabytes\":30},\"tenant_type\":\"native\"},\"user_id\":1349804267}";
        RespType<?> respTypeComment = new RespType<>();
        JRequest jRequest = new JRequest(URL_POST_COMMENT, JRequest.METHOD_POST)
                .header("cookie", accountClone.getCookie())
                .header("x-csrf-token", accountClone.getxCsrfToken())
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4576.82 Safari/537.36")
                .header("authorization", PadletReactionService.fakeAuthorization())
                .header("x-uid", PadletReactionService.fakeXUid())
                .send(String.format(SEND_BASE, post.getId(), text), ContentType.APPLICATION_JSON)
                .execute();
        JJson json = JJson.parse(jRequest.body());
        if (json.toObj() == null) {
            respTypeComment.setCode(-2);
            respTypeComment.setMessage("Response wrong format.");
            System.out.println(jRequest.body());
            return respTypeComment;
        }
        if (json.k("wish_id").toStr() != null) {
            respTypeComment.setCode(-3);
            respTypeComment.setMessage(json.k("wish_id").toStr());
            return respTypeComment;
        }
        if (json.k("data").toObj() != null) {
            respTypeComment.setCode(1);
            respTypeComment.setMessage("OK.");
        } else {
            respTypeComment.setCode(-4);
            respTypeComment.setMessage("Unknown error, " + json.toStr());
        }
        return respTypeComment;
    }

}
