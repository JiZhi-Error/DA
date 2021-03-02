package com.tencent.kinda.framework.widget.base;

import android.widget.ImageView;
import com.tencent.kinda.gen.KAvatarImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Util;

public class MMKAvatarImageView extends MMKImageView implements KAvatarImageView {
    private String username;

    @Override // com.tencent.kinda.gen.KAvatarImageView
    public void setUsername(String str) {
        AppMethodBeat.i(18992);
        this.username = str;
        if (!Util.isNullOrNil(this.username)) {
            if (getCornerRadius() != 0.0f) {
                a.b.a((ImageView) getView(), this.username, getCornerRadius(), false);
            } else {
                a.b.c((ImageView) getView(), this.username);
            }
            notifyChanged();
        }
        AppMethodBeat.o(18992);
    }

    @Override // com.tencent.kinda.gen.KAvatarImageView
    public String getUsername() {
        return this.username;
    }
}
