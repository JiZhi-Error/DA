package com.tencent.soter.a.d;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.d;
import junit.framework.Assert;

@Deprecated
public final class a {
    public CancellationSignal NHn = null;

    public a() {
        AppMethodBeat.i(21);
        Assert.assertTrue(Build.VERSION.SDK_INT >= 16);
        hlF();
        AppMethodBeat.o(21);
    }

    @SuppressLint({"NewApi"})
    public final boolean DR(final boolean z) {
        AppMethodBeat.i(22);
        d.v("Soter.SoterFingerprintCanceller", "soter: publishing cancellation. should publish: %b", Boolean.valueOf(z));
        if (!this.NHn.isCanceled()) {
            if (Build.VERSION.SDK_INT < 23) {
                g.hlR().aj(new Runnable() {
                    /* class com.tencent.soter.a.d.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(18);
                        d.v("Soter.SoterFingerprintCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
                        a.this.NHn.cancel();
                        if (z) {
                            f.hlO().hlQ();
                        }
                        AppMethodBeat.o(18);
                    }
                });
            } else {
                g.hlR().aj(new Runnable() {
                    /* class com.tencent.soter.a.d.a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(19);
                        a.this.NHn.cancel();
                        AppMethodBeat.o(19);
                    }
                });
                g.hlR().m(new Runnable() {
                    /* class com.tencent.soter.a.d.a.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(20);
                        d.w("Soter.SoterFingerprintCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", 350L);
                        f.hlO().hlQ();
                        AppMethodBeat.o(20);
                    }
                }, 350);
            }
            AppMethodBeat.o(22);
            return true;
        }
        d.i("Soter.SoterFingerprintCanceller", "soter: cancellation signal already expired.", new Object[0]);
        AppMethodBeat.o(22);
        return false;
    }

    @SuppressLint({"NewApi"})
    public final void hlF() {
        AppMethodBeat.i(23);
        this.NHn = new CancellationSignal();
        AppMethodBeat.o(23);
    }
}
