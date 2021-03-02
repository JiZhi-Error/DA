package com.tencent.kinda.framework.app;

import android.content.Context;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KRealNameService;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;

public class KindaRealNameServiceImpl implements KRealNameService {
    private static final String TAG = "MicroMsg.KindaRealNameServiceImpl";

    @Override // com.tencent.kinda.gen.KRealNameService
    public void checkRealnameLicenseImpl(int i2, final VoidCallback voidCallback, final VoidCallback voidCallback2, final VoidCallback voidCallback3, final VoidCallback voidCallback4) {
        MMActivity mMActivity;
        AppMethodBeat.i(18508);
        i iVar = new i(KindaContext.get(), null);
        new a.AbstractC1915a() {
            /* class com.tencent.kinda.framework.app.KindaRealNameServiceImpl.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_core.id_verify.util.a.AbstractC1915a
            public boolean run(int i2, int i3, String str, boolean z) {
                AppMethodBeat.i(18505);
                if (i2 != 0) {
                    Log.e(KindaRealNameServiceImpl.TAG, "WalletGetDisclaimerCallback resultCode=%d,errMsg=%s,errcode=%d", Integer.valueOf(i2), str, Integer.valueOf(i3));
                    voidCallback.call();
                } else if (z) {
                    voidCallback.call();
                } else {
                    voidCallback2.call();
                }
                AppMethodBeat.o(18505);
                return true;
            }

            public void onRequesting() {
                AppMethodBeat.i(18506);
                voidCallback3.call();
                AppMethodBeat.o(18506);
            }

            public void onResponsed() {
                AppMethodBeat.i(18507);
                voidCallback4.call();
                AppMethodBeat.o(18507);
            }
        };
        Context context = KindaContext.get();
        if (context instanceof MMActivity) {
            mMActivity = (MMActivity) context;
        } else {
            mMActivity = null;
        }
        t.fQC();
        t.b(mMActivity, iVar, 1);
        AppMethodBeat.o(18508);
    }
}
