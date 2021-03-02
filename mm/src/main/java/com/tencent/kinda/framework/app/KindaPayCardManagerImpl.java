package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaPayCardManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;

public class KindaPayCardManagerImpl implements KindaPayCardManager {
    @Override // com.tencent.kinda.gen.KindaPayCardManager
    public void addPayCardImpl(final VoidCallback voidCallback, final VoidCallback voidCallback2) {
        AppMethodBeat.i(18461);
        Context context = KindaContext.get();
        if (!(context instanceof MMActivity)) {
            Log.e("KindaPayCardManagerImpl", "Fail to start addPayCardImpl due to incompatible context(%s)", context.getClass().getName());
            AppMethodBeat.o(18461);
            return;
        }
        Activity activity = (Activity) context;
        activity.getIntent().putExtra("process_id", b.class.hashCode());
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("is_from_new_cashier", true);
        bundle.putString("start_activity_class", activity.getClass().getName());
        a.a(activity, b.class, bundle);
        d by = a.by(activity);
        if (!(by instanceof b)) {
            Log.e("KindaPayCardManagerImpl", "Fail to get correct wallet process in addPayCardImpl, expect BindCardProcess got %s", by.getClass().getName());
            AppMethodBeat.o(18461);
            return;
        }
        ((b) by).HPw = new b.a() {
            /* class com.tencent.kinda.framework.app.KindaPayCardManagerImpl.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_core.b.b.a
            public void run(int i2) {
                AppMethodBeat.i(18460);
                if (i2 == -1) {
                    voidCallback.call();
                    AppMethodBeat.o(18460);
                    return;
                }
                voidCallback2.call();
                AppMethodBeat.o(18460);
            }
        };
        AppMethodBeat.o(18461);
    }
}
