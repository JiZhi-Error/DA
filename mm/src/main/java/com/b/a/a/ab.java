package com.b.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.b.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ab extends c {
    private static ab cnD;
    WifiManager chC;
    private final BroadcastReceiver cnE = new BroadcastReceiver() {
        /* class com.b.a.a.ab.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(87929);
            if (intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                ab abVar = ab.this;
                try {
                    List<ScanResult> scanResults = abVar.chC.getScanResults();
                    if (scanResults == null || scanResults.isEmpty()) {
                        Exception exc = new Exception("WifiScanMsg: null or empty scan result list");
                        AppMethodBeat.o(87929);
                        throw exc;
                    }
                    abVar.c(new a(scanResults));
                    AppMethodBeat.o(87929);
                    return;
                } catch (Exception e2) {
                }
            }
            AppMethodBeat.o(87929);
        }
    };
    private final IntentFilter cnF = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    private ac cnG;
    private long cnH = 10000;

    private ab() {
        AppMethodBeat.i(87930);
        AppMethodBeat.o(87930);
    }

    static ab JD() {
        AppMethodBeat.i(87931);
        if (cnD == null) {
            cnD = new ab();
        }
        ab abVar = cnD;
        AppMethodBeat.o(87931);
        return abVar;
    }

    private boolean isAvailable() {
        return this.chC != null;
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d, com.b.a.a.c
    public final synchronized void a(Handler handler, d.a aVar) {
        AppMethodBeat.i(87932);
        if (aVar == null) {
            aVar = new d.a(10000);
        }
        super.a(handler, aVar);
        AppMethodBeat.o(87932);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void au(Context context) {
        AppMethodBeat.i(87933);
        this.chC = (WifiManager) context.getSystemService("wifi");
        AppMethodBeat.o(87933);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void a(Context context, Handler handler, d.a aVar) {
        AppMethodBeat.i(87934);
        if (!isAvailable()) {
            AppMethodBeat.o(87934);
            return;
        }
        context.registerReceiver(this.cnE, this.cnF, null, handler);
        this.cnH = aVar.chx;
        WifiManager wifiManager = this.chC;
        if (handler == null) {
            handler = new Handler(context.getMainLooper());
        }
        this.cnG = new ac(wifiManager, handler);
        this.cnG.n(this.cnH, 0);
        AppMethodBeat.o(87934);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void av(Context context) {
        AppMethodBeat.i(87935);
        if (!isAvailable()) {
            AppMethodBeat.o(87935);
            return;
        }
        context.unregisterReceiver(this.cnE);
        this.cnG.stop();
        AppMethodBeat.o(87935);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void IV() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.c
    public final void IW() {
        AppMethodBeat.i(87936);
        if (!isAvailable() || !this.isRunning || this.cnH >= 90000) {
            AppMethodBeat.o(87936);
            return;
        }
        this.cnG.n(90000, 0);
        AppMethodBeat.o(87936);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.c
    public final void IX() {
        AppMethodBeat.i(87937);
        if (!isAvailable() || !this.isRunning || this.cnH >= 90000) {
            AppMethodBeat.o(87937);
            return;
        }
        this.cnG.n(this.cnH, 0);
        AppMethodBeat.o(87937);
    }

    static class a extends p {
        final List<ScanResult> cnJ;

        a(List<ScanResult> list) {
            super(101);
            this.cnJ = list;
        }
    }
}
