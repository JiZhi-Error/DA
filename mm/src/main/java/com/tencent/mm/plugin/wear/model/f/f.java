package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.eyp;
import com.tencent.mm.protocal.protobuf.eyq;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class f extends c {
    private String nickname;
    private int type;
    private String username;

    public f(String str, String str2, int i2) {
        this.username = str;
        this.nickname = str2;
        this.type = i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.f.c
    public final void send() {
        AppMethodBeat.i(30126);
        com.tencent.mm.plugin.wear.model.f aWj = a.fVK().aWj(this.username);
        eyq eyq = new eyq();
        if (this.type == 1) {
            eyp eyp = new eyp();
            eyp.xNF = aWj.id;
            eyp.UserName = this.username;
            eyp.oUJ = this.nickname;
            eyp.iAc = MMApplicationContext.getContext().getString(R.string.fg2);
            Bitmap a2 = c.a(this.username, false, -1, null);
            if (a2 != null) {
                eyp.Nvo = new b(h.aF(a2));
            }
            eyq.oTA.add(eyp);
        }
        try {
            a.fVQ();
            r.a(20006, eyq.toByteArray(), true);
            AppMethodBeat.o(30126);
        } catch (IOException e2) {
            AppMethodBeat.o(30126);
        }
    }

    @Override // com.tencent.mm.plugin.wear.model.f.d
    public final String getName() {
        return "WearFriendCreateTask";
    }
}
