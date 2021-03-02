package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public class h {
    private static volatile h JIn = null;
    private q JIo = null;

    private h() {
    }

    public static h gjO() {
        AppMethodBeat.i(30473);
        if (JIn == null) {
            synchronized (h.class) {
                try {
                    if (JIn == null) {
                        JIn = new h();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(30473);
                    throw th;
                }
            }
        }
        h hVar = JIn;
        AppMethodBeat.o(30473);
        return hVar;
    }

    public final q gjP() {
        AppMethodBeat.i(30474);
        if (this.JIo != null) {
            q qVar = this.JIo;
            AppMethodBeat.o(30474);
            return qVar;
        }
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERINFO_WENOTE_KEEP_TOP_DATA_STRING_SYNC, "");
        Log.d("WNNoteKeepTopManager", "getCurrentTopItem itemStr: %s", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(30474);
            return null;
        }
        byte[] decodeHexString = Util.decodeHexString(str);
        if (decodeHexString == null || decodeHexString.length <= 0) {
            AppMethodBeat.o(30474);
            return null;
        }
        this.JIo = cA(decodeHexString);
        Object[] objArr = new Object[1];
        objArr[0] = this.JIo != null ? this.JIo.gjG() : BuildConfig.COMMAND;
        Log.d("WNNoteKeepTopManager", "getCurrentTopItem item: %s", objArr);
        q qVar2 = this.JIo;
        AppMethodBeat.o(30474);
        return qVar2;
    }

    public final void c(q qVar) {
        AppMethodBeat.i(30475);
        this.JIo = qVar;
        byte[] d2 = d(this.JIo);
        String str = "";
        if (d2 != null && d2.length > 0) {
            str = Util.encodeHexString(d2);
        }
        Object[] objArr = new Object[1];
        objArr[0] = this.JIo != null ? this.JIo.gjG() : BuildConfig.COMMAND;
        Log.i("WNNoteKeepTopManager", "setCurrentTopItem item: %s", objArr);
        Log.i("WNNoteKeepTopManager", "setCurrentTopItem itemStr: %s", str);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_WENOTE_KEEP_TOP_DATA_STRING_SYNC, Util.nullAsNil(str));
        AppMethodBeat.o(30475);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f A[SYNTHETIC, Splitter:B:22:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054 A[Catch:{ Exception -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e A[SYNTHETIC, Splitter:B:32:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073 A[Catch:{ Exception -> 0x007a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.plugin.wenote.model.a.q cA(byte[] r11) {
        /*
        // Method dump skipped, instructions count: 147
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.h.cA(byte[]):com.tencent.mm.plugin.wenote.model.a.q");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f A[SYNTHETIC, Splitter:B:21:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054 A[Catch:{ Exception -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c A[SYNTHETIC, Splitter:B:30:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0071 A[Catch:{ Exception -> 0x0078 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] d(com.tencent.mm.plugin.wenote.model.a.q r11) {
        /*
        // Method dump skipped, instructions count: 146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.h.d(com.tencent.mm.plugin.wenote.model.a.q):byte[]");
    }
}
