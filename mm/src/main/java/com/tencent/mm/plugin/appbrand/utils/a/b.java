package com.tencent.mm.plugin.appbrand.utils.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class b implements e {
    private final IntentFilter cnF = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    protected Context mContext;
    private final d ohQ = new d();
    Intent ohR = null;
    final e ohS = this;
    private a ohT;

    b() {
        AppMethodBeat.i(137931);
        AppMethodBeat.o(137931);
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.a.e
    public final synchronized void init(Context context) {
        AppMethodBeat.i(137932);
        this.ohR = null;
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.mContext = context;
        AppMethodBeat.o(137932);
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.a.e
    public final synchronized void release() {
        AppMethodBeat.i(137933);
        if (this.mContext != null) {
            if (this.ohT != null) {
                this.mContext.unregisterReceiver(this.ohT);
            }
            this.mContext = null;
        }
        AppMethodBeat.o(137933);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        if (r4 != 4) goto L_0x00b9;
     */
    @Override // com.tencent.mm.plugin.appbrand.utils.a.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.tencent.mm.plugin.appbrand.utils.a.c bZx() {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.utils.a.b.bZx():com.tencent.mm.plugin.appbrand.utils.a.c");
    }

    class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (b.this.ohS) {
                b.this.ohR = intent;
            }
        }
    }
}
