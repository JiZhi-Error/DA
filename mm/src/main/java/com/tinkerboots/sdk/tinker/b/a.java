package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

public final class a extends com.tencent.tinker.lib.d.a {
    public a(Context context) {
        super(context);
    }

    @Override // com.tencent.tinker.lib.d.c, com.tencent.tinker.lib.d.a
    public final void a(File file, int i2, long j2) {
        AppMethodBeat.i(3443);
        super.a(file, i2, j2);
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            /* class com.tinkerboots.sdk.tinker.b.a.AnonymousClass1 */

            public final boolean queueIdle() {
                AppMethodBeat.i(3442);
                c.lp(a.this.context).hpj();
                AppMethodBeat.o(3442);
                return false;
            }
        });
        AppMethodBeat.o(3443);
    }

    @Override // com.tencent.tinker.lib.d.c, com.tencent.tinker.lib.d.a
    public final void a(Throwable th, int i2) {
        AppMethodBeat.i(3444);
        super.a(th, i2);
        AppMethodBeat.o(3444);
    }

    @Override // com.tencent.tinker.lib.d.c, com.tencent.tinker.lib.d.a
    public final void a(String str, String str2, File file, String str3) {
        AppMethodBeat.i(3445);
        super.a(str, str2, file, str3);
        AppMethodBeat.o(3445);
    }

    @Override // com.tencent.tinker.lib.d.c, com.tencent.tinker.lib.d.a
    public final void a(File file, int i2, boolean z) {
        AppMethodBeat.i(3446);
        super.a(file, i2, z);
        if (i2 == 1) {
            d dVar = com.tencent.tinker.lib.e.a.lk(this.context).SjZ;
            if (dVar.Ske != null && "00000000000000000000000000000000".equals(dVar.Ske)) {
                ShareTinkerLog.v("Tinker.ServerLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
                ShareTinkerInternals.killAllOtherProcess(this.context);
            }
        }
        AppMethodBeat.o(3446);
    }
}
