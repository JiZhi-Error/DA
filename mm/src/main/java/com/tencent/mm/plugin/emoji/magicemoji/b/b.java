package com.tencent.mm.plugin.emoji.magicemoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.crash.ICrashReporter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.o;
import java.io.IOException;

/* access modifiers changed from: package-private */
public final class b {
    private static final String qYF = (com.tencent.mm.loader.j.b.aKA() + "cache/magic_emoji_crash");
    boolean qYG = false;
    int qYH;
    ICrashReporter.ICrashReportListener qYI = new ICrashReporter.ICrashReportListener() {
        /* class com.tencent.mm.plugin.emoji.magicemoji.b.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportListener
        public final void onCrashDumped(String str) {
            AppMethodBeat.i(199711);
            if (str.contains(") JSRuntimeME#") || str.contains(") ME.GLThread#")) {
                o oVar = new o(b.qYF);
                if (!oVar.exists()) {
                    try {
                        oVar.createNewFile();
                        AppMethodBeat.o(199711);
                        return;
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.MagicEmojiCrashMgr", e2, "dump magic emoji crash file failed", new Object[0]);
                    }
                }
                AppMethodBeat.o(199711);
                return;
            }
            AppMethodBeat.o(199711);
        }
    };

    static {
        AppMethodBeat.i(199714);
        AppMethodBeat.o(199714);
    }

    b() {
        AppMethodBeat.i(199712);
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("MagicEmojiCrashCheck");
        int i2 = singleMMKV.getInt("ClientVersion", -1);
        if (i2 == -1 || i2 == BuildInfo.CLIENT_VERSION_INT) {
            this.qYH = singleMMKV.getInt("CrashTimes", 0);
            o oVar = new o(qYF);
            if (oVar.exists()) {
                if (oVar.delete()) {
                    this.qYH++;
                    singleMMKV.putInt("ClientVersion", BuildInfo.CLIENT_VERSION_INT);
                    singleMMKV.putInt("CrashTimes", this.qYH);
                    h.INSTANCE.dN(1622, 5);
                    Log.i("MicroMsg.MagicEmojiCrashMgr", "crash found");
                    AppMethodBeat.o(199712);
                    return;
                }
                Log.i("MicroMsg.MagicEmojiCrashMgr", "crash found but delete failed: %s", qYF);
            }
            AppMethodBeat.o(199712);
            return;
        }
        this.qYH = 0;
        singleMMKV.putInt("ClientVersion", BuildInfo.CLIENT_VERSION_INT);
        singleMMKV.putInt("CrashTimes", 0);
        Log.i("MicroMsg.MagicEmojiCrashMgr", "crash reset: client version %d to %d", Integer.valueOf(i2), Integer.valueOf(BuildInfo.CLIENT_VERSION_INT));
        AppMethodBeat.o(199712);
    }

    /* access modifiers changed from: package-private */
    public final void cFA() {
        AppMethodBeat.i(199713);
        if (this.qYH > 0) {
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("MagicEmojiCrashCheck");
            singleMMKV.putInt("ClientVersion", BuildInfo.CLIENT_VERSION_INT);
            singleMMKV.putInt("CrashTimes", 0);
            this.qYH = 0;
        }
        AppMethodBeat.o(199713);
    }
}
