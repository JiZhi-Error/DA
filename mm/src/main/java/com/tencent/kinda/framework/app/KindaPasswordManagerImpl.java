package com.tencent.kinda.framework.app;

import android.content.Context;
import android.os.Bundle;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaPasswordManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pwd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;

public class KindaPasswordManagerImpl implements KindaPasswordManager {
    private final String KEY_PROCESS_ID = "process_id";
    private final String TAG = "KindaPasswordManagerImpl";

    @Override // com.tencent.kinda.gen.KindaPasswordManager
    public void startResetPasswordImpl(final VoidCallback voidCallback, final VoidCallback voidCallback2, boolean z) {
        AppMethodBeat.i(18459);
        final Context context = KindaContext.get();
        if (!(context instanceof MMActivity)) {
            if (context.getClass() != null) {
                Log.e("KindaPasswordManagerImpl", "Fail to start ResetPasswordImpl due to incompatible context(%s)", context.getClass().getName());
            }
            AppMethodBeat.o(18459);
            return;
        }
        MMActivity mMActivity = (MMActivity) context;
        mMActivity.getIntent().putExtra("process_id", a.class.hashCode());
        Bundle bundle = new Bundle();
        bundle.putBoolean("isFromKinda", true);
        bundle.putBoolean("isDomesticUser", z);
        com.tencent.mm.wallet_core.a.a(mMActivity, a.class, bundle, (d.a) null);
        d by = com.tencent.mm.wallet_core.a.by(mMActivity);
        if (!(by instanceof a)) {
            Log.e("KindaPasswordManagerImpl", "Fail to get correct wallet process in ResetPasswordImpl, expect ForgotPwdProcess got %s", by.getClass().getName());
            AppMethodBeat.o(18459);
            return;
        }
        ((a) by).HHO = new a.AbstractC1905a() {
            /* class com.tencent.kinda.framework.app.KindaPasswordManagerImpl.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet.pwd.a.AbstractC1905a
            public void run(int i2) {
                AppMethodBeat.i(18458);
                KindaContext.popToContext(context);
                if (i2 == 0) {
                    voidCallback.call();
                    AppMethodBeat.o(18458);
                    return;
                }
                voidCallback2.call();
                AppMethodBeat.o(18458);
            }
        };
        AppMethodBeat.o(18459);
    }
}
