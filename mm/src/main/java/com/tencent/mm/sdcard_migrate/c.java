package com.tencent.mm.sdcard_migrate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CancellationSignal;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.g;

@SuppressLint({"NewApi"})
public final class c implements a {
    static {
        AppMethodBeat.i(204634);
        b.a(new c(), "//extmig");
        AppMethodBeat.o(204634);
    }

    public static void init() {
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(final Context context, String[] strArr, String str) {
        boolean z = false;
        AppMethodBeat.i(204633);
        if (strArr == null || strArr.length < 2) {
            AppMethodBeat.o(204633);
            return false;
        }
        String str2 = strArr[1];
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -7490165:
                if (str2.equals("maintain")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3551:
                if (str2.equals("on")) {
                    c2 = 2;
                    break;
                }
                break;
            case 108404047:
                if (str2.equals("reset")) {
                    c2 = 3;
                    break;
                }
                break;
            case 109757538:
                if (str2.equals("start")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (strArr.length >= 3 && strArr[2] != null && strArr[2].equalsIgnoreCase("fcp")) {
                    z = true;
                }
                ExtStorageMigrateConfig.a aVar = new ExtStorageMigrateConfig.a(ExtStorageMigrateConfig.NGK);
                aVar.NGN = z;
                ExtStorageMigrateRoutine.startMigration(context, aVar.gwJ(), new ExtStorageMigrateTestCommand$1(this, context));
                AppMethodBeat.o(204633);
                return true;
            case 1:
                new CancellationSignal();
                h.RTc.ba(new Runnable() {
                    /* class com.tencent.mm.sdcard_migrate.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(204632);
                        try {
                            g.hYQ().aQ(0, 0);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.sdcard_migrate.c.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(204630);
                                    Toast.makeText(context, "Done.", 1).show();
                                    AppMethodBeat.o(204630);
                                }
                            });
                            AppMethodBeat.o(204632);
                        } catch (Throwable th) {
                            Log.printErrStackTrace("MicroMsg.ExtStorageMigrateTestCommand", th, "[-] Error happened.", new Object[0]);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.sdcard_migrate.c.AnonymousClass1.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(204631);
                                    Toast.makeText(context, "Error happened.", 1).show();
                                    AppMethodBeat.o(204631);
                                }
                            });
                            AppMethodBeat.o(204632);
                        }
                    }
                });
                AppMethodBeat.o(204633);
                return true;
            case 2:
                MultiProcessMMKV.getMMKV("extmig_switch_storage").encode("is_routine_enabled", true);
                Toast.makeText(context, "Switch on done.", 1).show();
                AppMethodBeat.o(204633);
                return true;
            case 3:
                MultiProcessMMKV.getMMKV("extmig_status_memo_storage").clear().commit();
                MultiProcessMMKV.getMMKV("extmig_switch_storage").clear().commit();
                Toast.makeText(context, "Reset done.", 1).show();
                AppMethodBeat.o(204633);
                return true;
            default:
                AppMethodBeat.o(204633);
                return false;
        }
    }
}
