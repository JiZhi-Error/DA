package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a extends g {
    private Bundle dQL;

    public a(MMActivity mMActivity, i iVar, Bundle bundle) {
        super(mMActivity, iVar);
        this.dQL = bundle;
    }

    @Override // com.tencent.mm.wallet_core.d.g
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(72142);
        if (qVar instanceof c) {
            c cVar = (c) qVar;
            if (!Util.isNullOrNil(cVar.token)) {
                Log.d("MicroMsg.CommonCheckPwdController", "hy: check pwd pass");
                this.dQL.putString("payu_reference", cVar.token);
                com.tencent.mm.wallet_core.a.l(this.activity, this.dQL);
            } else {
                Log.w("MicroMsg.CommonCheckPwdController", "hy: check pwd failed");
            }
        }
        AppMethodBeat.o(72142);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d.g
    public final boolean r(Object... objArr) {
        AppMethodBeat.i(72143);
        this.dQL.putString("key_pwd1", (String) objArr[0]);
        this.Ruz.b(new c(this.dQL.getString("key_pwd1")), true);
        AppMethodBeat.o(72143);
        return true;
    }
}
