package com.tencent.mm.pluginsdk.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ap;

public final class c {
    private static boolean[] KaK = new boolean[21];

    public static boolean goj() {
        AppMethodBeat.i(31175);
        g.aAi();
        if (!g.aAh().isSDCardAvailable()) {
            AppMethodBeat.o(31175);
            return true;
        }
        boolean bem = bem(b.aKJ());
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.pluginsdk.l.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(31174);
                c.access$000();
                AppMethodBeat.o(31174);
            }
        });
        AppMethodBeat.o(31175);
        return bem;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0141 A[SYNTHETIC, Splitter:B:49:0x0141] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0146 A[SYNTHETIC, Splitter:B:52:0x0146] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x016b A[SYNTHETIC, Splitter:B:62:0x016b] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0170 A[SYNTHETIC, Splitter:B:65:0x0170] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x019b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean bem(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 414
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.l.c.bem(java.lang.String):boolean");
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(31177);
        long currentTimeMillis = System.currentTimeMillis();
        if (!KaK[5] && !bem(b.aKO())) {
            h.INSTANCE.dN(951, 5);
            KaK[5] = true;
        }
        if (!KaK[7] && !bem(b.aKS())) {
            h.INSTANCE.dN(951, 7);
            KaK[7] = true;
        }
        if (!KaK[8] && !bem(b.aKQ())) {
            h.INSTANCE.dN(951, 8);
            KaK[8] = true;
        }
        if (!KaK[9]) {
            StringBuilder sb = new StringBuilder();
            g.aAi();
            if (!bem(sb.append(g.aAh().hqG).append("emoji/").toString())) {
                h.INSTANCE.dN(951, 9);
                KaK[9] = true;
            }
        }
        if (!KaK[10]) {
            StringBuilder sb2 = new StringBuilder();
            g.aAi();
            if (!bem(sb2.append(g.aAh().hqG).append("record/").toString())) {
                h.INSTANCE.dN(951, 10);
                KaK[10] = true;
            }
        }
        if (!KaK[11] && !bem(((com.tencent.mm.plugin.sns.b.c) g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath())) {
            h.INSTANCE.dN(951, 11);
            KaK[11] = true;
        }
        if (!KaK[12] && !bem(ap.aTc())) {
            h.INSTANCE.dN(951, 12);
            KaK[12] = true;
        }
        if (!KaK[13] && !bem(d.aSY())) {
            h.INSTANCE.dN(951, 13);
            KaK[13] = true;
        }
        if (!KaK[14] && !bem(d.aSZ())) {
            h.INSTANCE.dN(951, 14);
            KaK[14] = true;
        }
        if (!KaK[15]) {
            StringBuilder sb3 = new StringBuilder();
            g.aAi();
            if (!bem(sb3.append(g.aAh().hqG).append("video/").toString())) {
                h.INSTANCE.dN(951, 15);
                KaK[15] = true;
            }
        }
        if (!KaK[16] && !bem(s.bij())) {
            h.INSTANCE.dN(951, 16);
            KaK[16] = true;
        }
        if (!KaK[17] && !bem(s.aTa())) {
            h.INSTANCE.dN(951, 17);
            KaK[17] = true;
        }
        if (!KaK[18]) {
            StringBuilder sb4 = new StringBuilder();
            g.aAi();
            if (!bem(sb4.append(g.aAh().hqG).append("dbback/").toString())) {
                h.INSTANCE.dN(951, 18);
                KaK[18] = true;
            }
        }
        if (!KaK[19]) {
            StringBuilder sb5 = new StringBuilder();
            g.aAi();
            if (!bem(sb5.append(g.aAh().hqG).append("mailapp/").toString())) {
                h.INSTANCE.dN(951, 19);
                KaK[19] = true;
            }
        }
        if (!KaK[20]) {
            StringBuilder sb6 = new StringBuilder();
            g.aAi();
            if (!bem(sb6.append(g.aAh().hqG).append("openim/").toString())) {
                h.INSTANCE.dN(951, 20);
                KaK[20] = true;
            }
        }
        Log.d("MicroMsg.SdcardCheckUtil", "check time:" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(31177);
    }
}
