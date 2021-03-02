package com.tencent.mm.sdcard_migrate.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.MigrateResultCallback;

public final class a {
    public static void a(MigrateResultCallback migrateResultCallback, int i2) {
        AppMethodBeat.i(204697);
        if (migrateResultCallback != null) {
            try {
                if (migrateResultCallback.asBinder().isBinderAlive()) {
                    migrateResultCallback.ajH(i2);
                }
                AppMethodBeat.o(204697);
                return;
            } catch (Throwable th) {
                ExtStorageMigrateMonitor.gwK().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", th, "[-] Exception occurred.", new Object[0]);
            }
        }
        AppMethodBeat.o(204697);
    }

    public static void b(MigrateResultCallback migrateResultCallback, int i2) {
        AppMethodBeat.i(204698);
        if (migrateResultCallback != null) {
            try {
                if (migrateResultCallback.asBinder().isBinderAlive()) {
                    migrateResultCallback.ajI(i2);
                }
                AppMethodBeat.o(204698);
                return;
            } catch (Throwable th) {
                ExtStorageMigrateMonitor.gwK().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", th, "[-] Exception occurred.", new Object[0]);
            }
        }
        AppMethodBeat.o(204698);
    }

    public static void a(MigrateResultCallback migrateResultCallback, int i2, Throwable th) {
        AppMethodBeat.i(204699);
        if (migrateResultCallback != null) {
            try {
                if (migrateResultCallback.asBinder().isBinderAlive()) {
                    migrateResultCallback.b(i2, new ExtStorageMigrateException(th));
                }
                AppMethodBeat.o(204699);
                return;
            } catch (Throwable th2) {
                ExtStorageMigrateMonitor.gwK().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", th2, "[-] Exception occurred.", new Object[0]);
            }
        }
        AppMethodBeat.o(204699);
    }
}
