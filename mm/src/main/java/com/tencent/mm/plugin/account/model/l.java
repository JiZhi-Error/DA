package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.sdk.platformtools.Log;

public class l implements i, k.a {
    @Override // com.tencent.mm.plugin.account.model.k.a
    public void E(Bundle bundle) {
        AppMethodBeat.i(127848);
        String string = bundle.getString("access_token");
        String string2 = bundle.getString("expires");
        Log.i("MicroMsg.RefreshTokenListener", "onComplete : newToken = " + string + ", expires = " + string2);
        if (string2 != null) {
            g.aAh().azQ().set(65832, string2);
        }
        g.aAh().azQ().set(65830, string);
        g.aAh().azQ().set(65831, Long.valueOf(System.currentTimeMillis()));
        g.azz().a(183, this);
        g.azz().a(new w(2, string), 0);
        AppMethodBeat.o(127848);
    }

    @Override // com.tencent.mm.plugin.account.model.k.a
    public void onError(int i2, String str) {
        AppMethodBeat.i(127849);
        Log.e("MicroMsg.RefreshTokenListener", "onError : errType = " + i2 + ", errMsg = " + str);
        AppMethodBeat.o(127849);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127850);
        if (qVar.getType() != 183) {
            AppMethodBeat.o(127850);
            return;
        }
        g.azz().b(183, this);
        if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.RefreshTokenListener", "update token success");
            AppMethodBeat.o(127850);
            return;
        }
        Log.e("MicroMsg.RefreshTokenListener", "update token fail");
        AppMethodBeat.o(127850);
    }
}
