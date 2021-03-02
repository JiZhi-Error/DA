package com.tencent.mm.plugin.hp.c;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PeriodRecorder;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.util.concurrent.TimeUnit;

public final class a {
    private static final boolean[] ync = {false};
    private static final PeriodRecorder ynd = new PeriodRecorder("TinkerHealthStats", TimeUnit.DAYS.toMillis(1), true, true);
    private static final IListener<ps> yne = new IListener<ps>() {
        /* class com.tencent.mm.plugin.hp.c.a.AnonymousClass1 */

        {
            AppMethodBeat.i(196785);
            this.__eventId = ps.class.getName().hashCode();
            AppMethodBeat.o(196785);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ps psVar) {
            AppMethodBeat.i(196786);
            a.access$000();
            AppMethodBeat.o(196786);
            return true;
        }
    };

    static {
        AppMethodBeat.i(196792);
        AppMethodBeat.o(196792);
    }

    private static boolean isInstalled() {
        boolean z;
        synchronized (ync) {
            z = ync[0];
        }
        return z;
    }

    public static void dZf() {
        AppMethodBeat.i(196787);
        if (isInstalled()) {
            Log.w("MicroMsg.TinkerHealthStats", "[!] Already installed.");
            AppMethodBeat.o(196787);
            return;
        }
        EventCenter.instance.add(yne);
        synchronized (ync) {
            try {
                ync[0] = true;
            } catch (Throwable th) {
                AppMethodBeat.o(196787);
                throw th;
            }
        }
        Log.i("MicroMsg.TinkerHealthStats", "[+] install done.");
        AppMethodBeat.o(196787);
    }

    public static void m(Throwable th) {
        AppMethodBeat.i(196788);
        if (th == null) {
            AppMethodBeat.o(196788);
            return;
        }
        bB(7, android.util.Log.getStackTraceString(th));
        AppMethodBeat.o(196788);
    }

    private static boolean K(File file) {
        AppMethodBeat.i(196789);
        String[] strArr = {"arm", "arm64", "x86", "x86_64"};
        File parentFile = file.getParentFile();
        String replaceAll = file.getName().replaceAll("\\.dex|\\.apk|\\.jar|\\.zip", ShareConstants.ODEX_SUFFIX);
        for (int i2 = 0; i2 < 4; i2++) {
            if (new File(parentFile, "oat/" + strArr[i2] + FilePathGenerator.ANDROID_DIR_SEP + replaceAll).exists()) {
                AppMethodBeat.o(196789);
                return true;
            }
        }
        AppMethodBeat.o(196789);
        return false;
    }

    private static void bB(int i2, String str) {
        AppMethodBeat.i(196790);
        String format = String.format("%s,%s,%s", Integer.valueOf(i2), d.cQi, str.replace(",", "##"));
        e.INSTANCE.a(19725, format, true, true);
        Log.i("MicroMsg.TinkerHealthStats", "[+] kvReport, msg: %s", format);
        AppMethodBeat.o(196790);
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(196791);
        if (ynd.isExpired("rpt_oat_status")) {
            if (Build.VERSION.SDK_INT < 29) {
                Log.w("MicroMsg.TinkerHealthStats", "[!] Only report oat status on Android Q or above.");
                AppMethodBeat.o(196791);
                return;
            }
            ApplicationLike applicationLike = d.dks;
            if (!b.c(applicationLike)) {
                Log.i("MicroMsg.TinkerHealthStats", "[+] No patch was loaded, oat should be reguarded as generated.");
                bB(6, "OK|NOPATCH");
                e.INSTANCE.b(338, 240, TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, 1, true);
                AppMethodBeat.o(196791);
                return;
            } else if (applicationLike == null || applicationLike.getApplication() == null) {
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("tinkerApplication is null");
                AppMethodBeat.o(196791);
                throw tinkerRuntimeException;
            } else {
                if (K(new File(SharePatchFileUtil.getPatchDirectory(applicationLike.getApplication()), SharePatchFileUtil.getPatchVersionDirectory(b.d(applicationLike)) + "/dex/tinker_classN.apk"))) {
                    bB(6, "OK|PATCHED");
                    e.INSTANCE.b(338, 240, TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, 1, true);
                    AppMethodBeat.o(196791);
                    return;
                }
                bB(6, "MISSING");
                e.INSTANCE.b(338, 240, 242, 1, true);
            }
        }
        AppMethodBeat.o(196791);
    }
}
