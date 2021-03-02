package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.Looper;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class b extends d {
    private static b oOe;
    private a oLp;
    private c oOf;
    private e oOg;
    private d oOh;
    private a oOi;
    private PowerManager.WakeLock wakeLock = null;

    public static b cga() {
        AppMethodBeat.i(21549);
        if (oOe == null) {
            b bVar = new b();
            oOe = bVar;
            a((com.tencent.mm.plugin.backup.b.a) bVar);
        }
        b bVar2 = oOe;
        AppMethodBeat.o(21549);
        return bVar2;
    }

    @Override // com.tencent.mm.plugin.backup.b.a
    public final void ceH() {
        oOe = null;
    }

    @Override // com.tencent.mm.plugin.backup.b.d
    public final void o(Object... objArr) {
        AppMethodBeat.i(21550);
        ((Boolean) objArr[0]).booleanValue();
        new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.backup.backuppcmodel.c.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(21562);
                b.cga().cfw().stop();
                b.cga().ceO();
                b.cgt();
                b.cgv();
                AppMethodBeat.o(21562);
            }
        }, 100);
        AppMethodBeat.o(21550);
    }

    public final a cfw() {
        AppMethodBeat.i(21551);
        if (this.oLp == null) {
            this.oLp = new a();
        }
        a aVar = this.oLp;
        AppMethodBeat.o(21551);
        return aVar;
    }

    public final c cgb() {
        AppMethodBeat.i(21552);
        if (this.oOf == null) {
            this.oOf = new c();
        }
        c cVar = this.oOf;
        AppMethodBeat.o(21552);
        return cVar;
    }

    public final e cgc() {
        AppMethodBeat.i(21553);
        if (this.oOg == null) {
            this.oOg = new e();
        }
        e eVar = this.oOg;
        AppMethodBeat.o(21553);
        return eVar;
    }

    public final d cgd() {
        AppMethodBeat.i(21554);
        if (this.oOh == null) {
            this.oOh = new d();
        }
        d dVar = this.oOh;
        AppMethodBeat.o(21554);
        return dVar;
    }

    public final a cge() {
        AppMethodBeat.i(21555);
        if (this.oOi == null) {
            this.oOi = new a();
        }
        a aVar = this.oOi;
        AppMethodBeat.o(21555);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.backup.b.d
    public final void ceN() {
        AppMethodBeat.i(21556);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.backup.backuppcmodel.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(21547);
                try {
                    if (b.this.wakeLock == null) {
                        b.this.wakeLock = ((PowerManager) MMApplicationContext.getContext().getSystemService("power")).newWakeLock(26, "BackupPc Lock");
                    }
                    if (!b.this.wakeLock.isHeld()) {
                        b.this.wakeLock.acquire();
                    }
                    AppMethodBeat.o(21547);
                } catch (Throwable th) {
                    AppMethodBeat.o(21547);
                }
            }
        });
        AppMethodBeat.o(21556);
    }

    @Override // com.tencent.mm.plugin.backup.b.d
    public final void ceO() {
        AppMethodBeat.i(21557);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.backup.backuppcmodel.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(21548);
                try {
                    if (b.this.wakeLock != null && b.this.wakeLock.isHeld()) {
                        b.this.wakeLock.release();
                    }
                    AppMethodBeat.o(21548);
                } catch (Throwable th) {
                    AppMethodBeat.o(21548);
                }
            }
        });
        AppMethodBeat.o(21557);
    }
}
