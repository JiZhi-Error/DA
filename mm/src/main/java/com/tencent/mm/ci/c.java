package com.tencent.mm.ci;

import android.os.Environment;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.concurrent.Executors;

public final class c {
    private static boolean OvW = false;
    public static a OvX = null;

    public static void akE(int i2) {
        final boolean z;
        final boolean z2;
        final boolean z3;
        final boolean z4;
        AppMethodBeat.i(145593);
        switch (i2) {
            case 1:
                z = false;
                z2 = true;
                z3 = false;
                z4 = true;
                break;
            case 2:
                z = false;
                z2 = true;
                z3 = true;
                z4 = true;
                break;
            case 3:
                z = false;
                z2 = false;
                z3 = false;
                z4 = true;
                break;
            case 4:
                z = true;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
            case 5:
                z = true;
                z2 = false;
                z3 = true;
                z4 = false;
                break;
            case 6:
                Log.i("MicroMsg.MemoryDumpOperation", "GC NOW.");
                System.gc();
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
            default:
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
        }
        Log.d("MicroMsg.MemoryDumpOperation", "hprof operate: dump:%b, checkWifi:%b, uploadSingal:%b,uploadAll:%b,", Boolean.valueOf(z4), Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z));
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            /* class com.tencent.mm.ci.c.AnonymousClass1 */

            public final void run() {
                String str;
                AppMethodBeat.i(145592);
                if (c.OvW) {
                    Log.w("MicroMsg.MemoryDumpOperation", "Hprof is mUploading");
                    AppMethodBeat.o(145592);
                    return;
                }
                if (z4) {
                    str = b.bb(true, false);
                } else {
                    str = null;
                }
                Process.setThreadPriority(10);
                boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
                if (!z3 || isWifi) {
                    if (!z2 || str == null) {
                        str = z ? b.OvV : null;
                    }
                    boolean unused = c.OvW = true;
                    c.Pn(str);
                    boolean unused2 = c.OvW = false;
                    AppMethodBeat.o(145592);
                    return;
                }
                Log.w("MicroMsg.MemoryDumpOperation", "Hprof no wifi");
                AppMethodBeat.o(145592);
            }
        });
        AppMethodBeat.o(145593);
    }

    static boolean apn() {
        AppMethodBeat.i(145594);
        try {
            if (!Environment.getExternalStorageState().equals("mounted") || MMApplicationContext.getContext().getExternalCacheDir() == null || !MMApplicationContext.getContext().getExternalCacheDir().canWrite()) {
                AppMethodBeat.o(145594);
                return false;
            }
            AppMethodBeat.o(145594);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(145594);
            return false;
        }
    }

    static /* synthetic */ void Pn(String str) {
        AppMethodBeat.i(145595);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.MemoryDumpOperation", "Hprof error uploadPath %s ", str);
            AppMethodBeat.o(145595);
        } else if (!apn()) {
            Log.e("MicroMsg.MemoryDumpOperation", "Hprof sdcard invalid.");
            AppMethodBeat.o(145595);
        } else {
            o oVar = new o(str);
            if (!oVar.exists()) {
                Log.e("MicroMsg.MemoryDumpOperation", "Hprof upload file is not exist");
                AppMethodBeat.o(145595);
                return;
            }
            String a2 = r.a(oVar, true, null);
            if (a2 != null) {
                o oVar2 = new o(a2);
                if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()) && oVar2.length() > 5242880) {
                    Log.i("MicroMsg.MemoryDumpOperation", "Hprof not wifi exceed max size, size " + oVar2.length());
                    AppMethodBeat.o(145595);
                    return;
                } else if (OvX == null) {
                    Log.e("MicroMsg.MemoryDumpOperation", "Hprof upload : no file upload impl set!");
                    AppMethodBeat.o(145595);
                    return;
                } else {
                    boolean aJP = OvX.aJP(a2);
                    Log.i("MicroMsg.MemoryDumpOperation", "Hprof upload : %b", Boolean.valueOf(aJP));
                    if (aJP) {
                        s.dy(b.OvV, true);
                    }
                }
            }
            AppMethodBeat.o(145595);
        }
    }
}
