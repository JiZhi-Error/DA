package com.tencent.soter.a.a;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.d;
import junit.framework.Assert;

public final class a {
    public CancellationSignal NHn = null;

    public a() {
        AppMethodBeat.i(11);
        Assert.assertTrue(Build.VERSION.SDK_INT >= 16);
        hlF();
        AppMethodBeat.o(11);
    }

    @SuppressLint({"NewApi"})
    public final boolean DP(final boolean z) {
        AppMethodBeat.i(12);
        d.v("Soter.SoterBiometricCanceller", "soter: publishing cancellation. should publish: %b", Boolean.valueOf(z));
        if (!this.NHn.isCanceled()) {
            if (Build.VERSION.SDK_INT < 23) {
                g.hlR().aj(new Runnable() {
                    /* class com.tencent.soter.a.a.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(8);
                        d.v("Soter.SoterBiometricCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
                        a.this.NHn.cancel();
                        if (z) {
                            f.hlO().hlQ();
                        }
                        AppMethodBeat.o(8);
                    }
                });
            } else {
                g.hlR().aj(new Runnable() {
                    /* class com.tencent.soter.a.a.a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(9);
                        a.this.NHn.cancel();
                        AppMethodBeat.o(9);
                    }
                });
                g.hlR().m(new Runnable() {
                    /* class com.tencent.soter.a.a.a.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(10);
                        d.w("Soter.SoterBiometricCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", 350L);
                        f.hlO().hlQ();
                        AppMethodBeat.o(10);
                    }
                }, 350);
            }
            AppMethodBeat.o(12);
            return true;
        }
        d.i("Soter.SoterBiometricCanceller", "soter: cancellation signal already expired.", new Object[0]);
        AppMethodBeat.o(12);
        return false;
    }

    @SuppressLint({"NewApi"})
    public final void hlF() {
        AppMethodBeat.i(13);
        this.NHn = new CancellationSignal();
        AppMethodBeat.o(13);
    }
}
