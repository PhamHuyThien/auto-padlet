
package com.thiendz.tool.autopadlet.service;

import com.thiendz.tool.autopadlet.model.AccountClone;
import com.thiendz.tool.autopadlet.model.Post;
import com.thiendz.tool.autopadlet.model.RespType;
import com.thiendz.tool.autopadlet.view.AutoPadletForm;


public class PadletReactionServiceImpl implements Runnable {
    
    private AccountClone accountClone;
    private Post post;

    public PadletReactionServiceImpl(Post post) {
        this.post = post;
    }

    public PadletReactionServiceImpl(AccountClone accountClone, Post post) {
        this.accountClone = accountClone;
        this.post = post;
    }

    @Override
    public void run() {
        if(accountClone == null){
            RespType<AccountClone> respTypeAccountClone = PadletAccountService.cloneAccount();
            accountClone = respTypeAccountClone.getData();
        }
        RespType<?> respTypeReaction = PadletReactionService.reaction(accountClone, post);
        AutoPadletForm.autoPadletForm.appendNotiReaction(respTypeReaction);
    }
    
}
