package com.tencent.mm.plugin.backup.d;

import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b extends d {
    private static b oLl;
    private d oLm;
    private c oLn;
    private a oLo;
    private a oLp;
    String oLq = "tickit";
    private PowerManager.WakeLock wakeLock = null;

    public static b cfv() {
        AppMethodBeat.i(21292);
        if (oLl == null) {
            b bVar = new b();
            oLl = bVar;
            a((com.tencent.mm.plugin.backup.b.a) bVar);
        }
        b bVar2 = oLl;
        AppMethodBeat.o(21292);
        return bVar2;
    }

    @Override // com.tencent.mm.plugin.backup.b.a
    public final void ceH() {
        oLl = null;
    }

    @Override // com.tencent.mm.plugin.backup.b.d
    public final void o(Object... objArr) {
        AppMethodBeat.i(21293);
        final String str = (String) objArr[0];
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.backup.d.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(21289);
                c cfy = b.cfv().cfy();
                String str = str;
                Log.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", str);
                if (((l) g.af(l.class)).aTq().eiC()) {
                    bp.aVQ();
                }
                com.tencent.mm.plugin.backup.g.b.cgx();
                bg.azz().a(595, cfy.oLS);
                bg.azz().a(new e(str), 0);
                AppMethodBeat.o(21289);
            }
        });
        AppMethodBeat.o(21293);
    }

    public final a cfw() {
        AppMethodBeat.i(21294);
        if (this.oLp == null) {
            this.oLp = new a();
        }
        a aVar = this.oLp;
        AppMethodBeat.o(21294);
        return aVar;
    }

    public final d cfx() {
        AppMethodBeat.i(21295);
        if (this.oLm == null) {
            this.oLm = new d();
        }
        d dVar = this.oLm;
        AppMethodBeat.o(21295);
        return dVar;
    }

    public final c cfy() {
        AppMethodBeat.i(21296);
        if (this.oLn == null) {
            this.oLn = new c();
        }
        c cVar = this.oLn;
        AppMethodBeat.o(21296);
        return cVar;
    }

    public final a cfz() {
        AppMethodBeat.i(21297);
        if (this.oLo == null) {
            this.oLo = new a();
        }
        a aVar = this.oLo;
        AppMethodBeat.o(21297);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.backup.b.d
    public final void ceN() {
        AppMethodBeat.i(21298);
        Log.i("MicroMsg.BackupMoveModel", "startWakeLock");
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.backup.d.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(21290);
                try {
                    if (b.this.wakeLock == null) {
                        b.this.wakeLock = ((PowerManager) MMApplicationContext.getContext().getSystemService("power")).newWakeLock(26, "BackupMove Lock");
                    }
                    if (!b.this.wakeLock.isHeld()) {
                        b.this.wakeLock.acquire();
                    }
                    AppMethodBeat.o(21290);
                } catch (Throwable th) {
                    AppMethodBeat.o(21290);
                }
            }
        });
        AppMethodBeat.o(21298);
    }

    @Override // com.tencent.mm.plugin.backup.b.d
    public final void ceO() {
        AppMethodBeat.i(21299);
        Log.i("MicroMsg.BackupMoveModel", "stopWakeLock");
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.backup.d.b.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(21291);
                try {
                    if (b.this.wakeLock != null && b.this.wakeLock.isHeld()) {
                        b.this.wakeLock.release();
                    }
                    AppMethodBeat.o(21291);
                } catch (Throwable th) {
                    AppMethodBeat.o(21291);
                }
            }
        }, 15000);
        AppMethodBeat.o(21299);
    }
}
