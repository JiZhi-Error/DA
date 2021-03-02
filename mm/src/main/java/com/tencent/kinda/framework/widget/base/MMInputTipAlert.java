package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KInputTipAlert;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;

public class MMInputTipAlert implements KInputTipAlert {
    public String TAG = "MMInputTipAlert";

    @Override // com.tencent.kinda.gen.KInputTipAlert
    public void showInputAlertImpl(String str, String str2, String str3, final VoidStringCallback voidStringCallback, final VoidCallback voidCallback) {
        AppMethodBeat.i(18991);
        Log.i(this.TAG, "MMInputTipAlert");
        Context context = KindaContext.get();
        if (context == null) {
            Log.e(this.TAG, "MMInputTipAlert showInputAlertImpl() KindaContext.get() return null!");
            AppMethodBeat.o(18991);
            return;
        }
        a.a(context, str, str2, str3, 100, new h.b() {
            /* class com.tencent.kinda.framework.widget.base.MMInputTipAlert.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.h.b
            public boolean onFinish(CharSequence charSequence) {
                AppMethodBeat.i(18989);
                Log.i(MMInputTipAlert.this.TAG, "ok ".concat(String.valueOf(charSequence)));
                voidStringCallback.call(String.valueOf(charSequence));
                AppMethodBeat.o(18989);
                return false;
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.kinda.framework.widget.base.MMInputTipAlert.AnonymousClass2 */

            public void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(18990);
                Log.i(MMInputTipAlert.this.TAG, "cancel " + voidCallback);
                voidCallback.call();
                AppMethodBeat.o(18990);
            }
        });
        AppMethodBeat.o(18991);
    }
}
