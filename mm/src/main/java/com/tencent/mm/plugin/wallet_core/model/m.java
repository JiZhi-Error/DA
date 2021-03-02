package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class m {
    public int HYb;
    public String qwG;
    public boolean qxy;
    public int retCode;

    public static m a(boolean z, int i2, int i3, String str) {
        AppMethodBeat.i(70299);
        m mVar = new m();
        mVar.qxy = z;
        mVar.retCode = i2;
        mVar.HYb = i3;
        mVar.qwG = str;
        AppMethodBeat.o(70299);
        return mVar;
    }

    public static m jU(int i2, int i3) {
        AppMethodBeat.i(70300);
        m a2 = a(false, i2, i3, "");
        AppMethodBeat.o(70300);
        return a2;
    }

    public final void G(Context context, boolean z) {
        boolean z2;
        AppMethodBeat.i(70301);
        if (this.qxy) {
            if (context instanceof WalletBaseUI) {
                z2 = h.a((WalletBaseUI) context, null, 1000, this.retCode, this.qwG);
            } else {
                z2 = false;
            }
            if (!z2 && !Util.isNullOrNil(this.qwG)) {
                if (z) {
                    Toast.makeText(context, this.qwG, 1).show();
                    AppMethodBeat.o(70301);
                    return;
                }
                com.tencent.mm.ui.base.h.c(context, this.qwG, "", false);
            }
            AppMethodBeat.o(70301);
            return;
        }
        com.tencent.mm.ui.base.h.c(context, context.getString(R.string.ih4), "", false);
        AppMethodBeat.o(70301);
    }
}
