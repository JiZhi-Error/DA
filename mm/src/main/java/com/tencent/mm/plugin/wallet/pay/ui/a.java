package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.h;

public final class a {
    AbstractC1904a HFX = null;
    private Context mContext;
    private Dialog tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.a$a  reason: collision with other inner class name */
    public interface AbstractC1904a {
        void d(boolean z, String str, String str2);
    }

    public a(Context context, AbstractC1904a aVar) {
        this.mContext = context;
        this.HFX = aVar;
    }

    public final void release() {
        this.HFX = null;
        this.mContext = null;
    }

    public final void b(boolean z, int i2, String str) {
        AppMethodBeat.i(69303);
        final jd jdVar = new jd();
        jdVar.dNN = null;
        jdVar.dNM.dNO = z;
        if (z && (this.tipDialog == null || (this.tipDialog != null && !this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            this.tipDialog = h.a(this.mContext, false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.wallet.pay.ui.a.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(69302);
                    a.this.closeTipDialog();
                    AppMethodBeat.o(69302);
                }
            });
        }
        jdVar.dNM.dNP = i2;
        jdVar.dNM.dNQ = str;
        jdVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(69301);
                Log.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
                jd.b bVar = jdVar.dNN;
                if (bVar != null && bVar.isSuccess) {
                    Log.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
                    a.this.closeTipDialog();
                    if (a.this.HFX != null) {
                        a.this.HFX.d(bVar.isSuccess, bVar.dNR, bVar.dNS);
                        AppMethodBeat.o(69301);
                        return;
                    }
                } else if (bVar == null || bVar.isSuccess) {
                    Log.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
                } else {
                    a.this.closeTipDialog();
                    if (a.this.HFX != null) {
                        a.this.HFX.d(bVar.isSuccess, bVar.dNR, bVar.dNS);
                    }
                    Log.e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
                    AppMethodBeat.o(69301);
                    return;
                }
                AppMethodBeat.o(69301);
            }
        };
        EventCenter.instance.asyncPublish(jdVar, Looper.getMainLooper());
        AppMethodBeat.o(69303);
    }

    public final void closeTipDialog() {
        AppMethodBeat.i(69304);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        AppMethodBeat.o(69304);
    }
}
