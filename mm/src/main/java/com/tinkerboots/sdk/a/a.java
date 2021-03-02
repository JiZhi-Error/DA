package com.tinkerboots.sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.a.a.b;
import com.tinkerboots.sdk.b.c;

public final class a {
    private static volatile a SKE;
    public b SKD;
    public final com.tinkerboots.sdk.a.b.a SKF = com.tinkerboots.sdk.a.b.a.hwa();
    public boolean cWq;
    public long ldB = 10800000;

    private a(b bVar) {
        AppMethodBeat.i(3432);
        this.SKD = bVar;
        AppMethodBeat.o(3432);
    }

    public static a a(b bVar) {
        AppMethodBeat.i(3433);
        if (SKE != null) {
            RuntimeException runtimeException = new RuntimeException("tinker server client is already init");
            AppMethodBeat.o(3433);
            throw runtimeException;
        }
        if (SKE == null) {
            synchronized (com.tinkerboots.sdk.a.b.a.class) {
                try {
                    if (SKE == null) {
                        SKE = new a(bVar);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(3433);
                    throw th;
                }
            }
        }
        a aVar = SKE;
        AppMethodBeat.o(3433);
        return aVar;
    }

    public final void om(String str, String str2) {
        AppMethodBeat.i(3434);
        this.SKF.on(str, str2);
        AppMethodBeat.o(3434);
    }

    public final void atl(int i2) {
        AppMethodBeat.i(3435);
        if (((long) i2) == -1) {
            hvZ();
            AppMethodBeat.o(3435);
        } else if (i2 < 0 || i2 > 24) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("hours must be between 0 and 24");
            AppMethodBeat.o(3435);
            throw tinkerRuntimeException;
        } else {
            this.ldB = ((long) i2) * 3600 * 1000;
            AppMethodBeat.o(3435);
        }
    }

    private static boolean hvZ() {
        AppMethodBeat.i(3436);
        ShareTinkerLog.v("Tinker.ServerClient", "Warning, disableFetchPatchUpdate", new Object[0]);
        boolean commit = c.getContext().getSharedPreferences("patch_server_config", 0).edit().putLong("fetch_patch_last_check", -1).commit();
        AppMethodBeat.o(3436);
        return commit;
    }
}
