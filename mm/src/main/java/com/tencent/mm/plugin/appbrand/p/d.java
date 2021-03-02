package com.tencent.mm.plugin.appbrand.p;

import android.arch.a.c.a;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public final class d implements DialogInterface {
    private DialogInterface.OnCancelListener XY;
    private MTimerHandler klF;
    private boolean mCanceled = false;
    private boolean mDismissed = false;
    public a<Context, k.a> ngL;
    k.a ngM;
    int ngN;

    public final void ab(final AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(147344);
        if (!MMHandlerThread.isMainThread()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.p.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(147342);
                    d.this.ab(appBrandRuntime);
                    AppMethodBeat.o(147342);
                }
            });
            AppMethodBeat.o(147344);
            return;
        }
        this.klF = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.appbrand.p.d.AnonymousClass2 */

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v26, types: [android.content.Context] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onTimerExpired() {
                /*
                // Method dump skipped, instructions count: 140
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.p.d.AnonymousClass2.onTimerExpired():boolean");
            }
        }, false);
        this.klF.startTimer(500);
        AppMethodBeat.o(147344);
    }

    public final d a(DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(147345);
        this.XY = onCancelListener;
        if (this.ngM != null) {
            this.ngM.setOnCancelListener(this.XY);
        }
        AppMethodBeat.o(147345);
        return this;
    }

    public final void cancel() {
        AppMethodBeat.i(147346);
        this.mCanceled = true;
        if (this.ngM != null) {
            this.ngM.cancel();
            AppMethodBeat.o(147346);
            return;
        }
        if (this.XY != null) {
            this.XY.onCancel(this);
        }
        AppMethodBeat.o(147346);
    }

    public final void dismiss() {
        AppMethodBeat.i(147347);
        this.mDismissed = true;
        if (this.ngM != null) {
            this.ngM.dismiss();
        }
        AppMethodBeat.o(147347);
    }
}
