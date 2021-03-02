package com.tencent.mm.plugin.freewifi.d;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class c extends q implements m {
    protected Activity activity;
    protected i callback;
    protected d rr;
    protected i wPq;

    /* access modifiers changed from: protected */
    public abstract void dNu();

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(final int i2, final int i3, final int i4, final String str, final s sVar, final byte[] bArr) {
        com.tencent.mm.plugin.freewifi.m.axP("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " returns [" + i3 + "," + i4 + "]");
        if (this.wPq != null) {
            this.wPq.onSceneEnd(i3, i4, str, this);
        }
        if ((this.activity == null || !this.activity.isFinishing()) && this.callback != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.freewifi.d.c.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(24847);
                    c.this.a(i2, i3, i4, str);
                    if (c.this.callback != null) {
                        c.this.callback.onSceneEnd(i3, i4, str, c.this);
                    }
                    AppMethodBeat.o(24847);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, int i4, String str) {
    }

    public final void c(i iVar) {
        this.callback = iVar;
        com.tencent.mm.plugin.freewifi.m.axP("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        bg.azz().a(this, 0);
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        this.wPq = iVar;
        return dispatch(gVar, this.rr, this);
    }

    public final c ap(Activity activity2) {
        this.activity = activity2;
        return this;
    }
}
