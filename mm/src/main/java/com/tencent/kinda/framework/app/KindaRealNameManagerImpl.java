package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KindaRealNameManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifySuccessUI;
import com.tencent.mm.plugin.wallet_core.id_verify.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;

public class KindaRealNameManagerImpl implements KindaRealNameManager {
    private final String KEY_PROCESS_ID = "process_id";
    private final String TAG = "KindaRealNameManagerImpl";

    @Override // com.tencent.kinda.gen.KindaRealNameManager
    public void startRealNameImpl(final VoidCallback voidCallback, final VoidCallback voidCallback2, ITransmitKvData iTransmitKvData) {
        AppMethodBeat.i(18504);
        Context context = KindaContext.get();
        if (!(context instanceof MMActivity)) {
            Log.e("KindaRealNameManagerImpl", "Fail to start KindaRealNameManagerImpl due to incompatible context(%s)", context.getClass().getName());
            AppMethodBeat.o(18504);
            return;
        }
        MMActivity mMActivity = (MMActivity) context;
        mMActivity.getIntent().putExtra("process_id", a.class.hashCode());
        Bundle bundle = new Bundle();
        bundle.putString("realname_verify_process_jump_activity", ".id_verify.SwitchRealnameVerifyModeUI");
        bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
        bundle.putInt("real_name_verify_mode", 0);
        bundle.putInt("entry_scene", 2);
        bundle.putBoolean("process_finish_stay_orgpage", false);
        bundle.putBoolean("is_from_new_cashier", true);
        bundle.putString("start_activity_class", mMActivity.getClass().getName());
        com.tencent.mm.wallet_core.a.a(mMActivity, a.class, bundle, (d.a) null);
        d by = com.tencent.mm.wallet_core.a.by(mMActivity);
        if (!(by instanceof a)) {
            Log.e("KindaRealNameManagerImpl", "Fail to get correct wallet process in KindaRealNameManagerImpl, expect RealNameVerifyProcess got %s", by.getClass().getName());
            AppMethodBeat.o(18504);
            return;
        }
        ((a) by).HQO = new a.AbstractC1914a() {
            /* class com.tencent.kinda.framework.app.KindaRealNameManagerImpl.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_core.id_verify.a.AbstractC1914a
            public void run(Activity activity) {
                AppMethodBeat.i(18503);
                if (activity instanceof WcPayRealnameVerifySuccessUI) {
                    voidCallback.call();
                    AppMethodBeat.o(18503);
                    return;
                }
                voidCallback2.call();
                AppMethodBeat.o(18503);
            }
        };
        AppMethodBeat.o(18504);
    }
}
