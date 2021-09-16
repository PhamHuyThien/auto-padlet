
package com.thiendz.tool.autopadlet.service;

import com.thiendz.tool.autopadlet.model.AccountClone;
import com.thiendz.tool.autopadlet.model.Post;
import com.thiendz.tool.autopadlet.model.RespType;
import com.thiendz.tool.autopadlet.view.AutoPadletForm;

public class PadletCommentServiceImpl implements Runnable{
    private AccountClone accountClone;
    private Post post;
    private String text;

    public PadletCommentServiceImpl(Post post, String text) {
        this.post = post;
        this.text = text;
    }
    
    public PadletCommentServiceImpl(AccountClone accountClone, Post post, String text) {
        this.accountClone = accountClone;
        this.post = post;
        this.text = text;
    }

    @Override
    public void run() {
        if(accountClone == null){
            RespType<AccountClone> respTypeAccountClone = PadletAccountService.cloneAccount();
            accountClone = respTypeAccountClone.getData();
        }
        RespType<?> respTypeComment = PadletCommentService.comment(accountClone, post, text);
        AutoPadletForm.autoPadletForm.appendNotiComment(respTypeComment);
    }
    
}
