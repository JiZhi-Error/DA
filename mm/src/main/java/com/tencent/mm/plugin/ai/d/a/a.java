package com.tencent.mm.plugin.ai.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.ai.d.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashMap;

public final class a {
    public HashMap<String, Long> kwG;
    public b.a kwH;

    public a() {
        AppMethodBeat.i(238903);
        this.kwG = null;
        this.kwH = new b.a() {
            /* class com.tencent.mm.plugin.ai.d.a.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.ai.d.a.b.a
            public final void a(boolean z, String str, final String str2, boolean z2, final String str3) {
                AppMethodBeat.i(238902);
                Log.i("MicroMsg.AiDownloadLogic", "%s download ai model [%b] [%s] [%s]", a.this.info(), Boolean.valueOf(z), str, str2);
                if (z) {
                    h.INSTANCE.dN(1559, 3);
                } else {
                    h.INSTANCE.dN(1559, 4);
                }
                if (z && z2) {
                    com.tencent.f.h.RTc.b(new Runnable() {
                        /* class com.tencent.mm.plugin.ai.d.a.a.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(238901);
                            long currentTicks = Util.currentTicks();
                            boolean cg = c.cg(str3, str2);
                            Log.i("MicroMsg.AiDownloadLogic", "up zip [%b] unZipDir[%s] savePath[%s] cost[%d]", Boolean.valueOf(cg), str3, str2, Long.valueOf(Util.ticksToNow(currentTicks)));
                            if (cg) {
                                h.INSTANCE.dN(1559, 8);
                            } else {
                                h.INSTANCE.dN(1559, 9);
                            }
                            s.deleteFile(str2);
                            AppMethodBeat.o(238901);
                        }
                    }, "Ai_thread");
                }
                AppMethodBeat.o(238902);
            }
        };
        this.kwG = new HashMap<>();
        AppMethodBeat.o(238903);
    }

    public final String info() {
        AppMethodBeat.i(238904);
        String sb = new StringBuilder().append(hashCode()).toString();
        AppMethodBeat.o(238904);
        return sb;
    }

    public static int a(String str, String str2, String str3, PString pString) {
        boolean z;
        AppMethodBeat.i(238905);
        pString.value = "";
        String str4 = str3 + str2;
        if (!s.YS(str4)) {
            AppMethodBeat.o(238905);
            return -1;
        }
        if (str.equalsIgnoreCase(g.getMD5(str4))) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(238905);
            return -2;
        }
        pString.value = str4;
        AppMethodBeat.o(238905);
        return 0;
    }
}
