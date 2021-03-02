package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import org.json.JSONObject;

public class b {
    public static final String iUq = (com.tencent.mm.loader.j.b.aKC() + "fonts/");
    public static final String iUr = (iUq + "temp/");
    public static final String iUs = (iUq + "WXkatonglemiao.ttf");
    public static final String iUt = (iUq + "WXxiari.ttf");
    private static b iUu;
    private String iUv = "emoji_font_meta.json";
    private boolean iUw = false;
    public IListener<bp> iUx = new IListener<bp>() {
        /* class com.tencent.mm.aq.b.AnonymousClass1 */

        {
            AppMethodBeat.i(161801);
            this.__eventId = bp.class.getName().hashCode();
            AppMethodBeat.o(161801);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(104511);
            final bp bpVar2 = bpVar;
            if (bpVar2.dEN.dEO == 57 && bpVar2.dEN.subType == 1) {
                Log.i("MicroMsg.FontResLogic", "download res finish, path: %s, fileVersion: %s, fileUpdated: %s", bpVar2.dEN.filePath, Integer.valueOf(bpVar2.dEN.dEP), Boolean.valueOf(bpVar2.dEN.dEQ));
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.aq.b.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(104510);
                        h.INSTANCE.n(933, 12, 1);
                        b.a(b.this, bpVar2.dEN.filePath, bpVar2.dEN.dEO, bpVar2.dEN.subType, bpVar2.dEN.dEP);
                        AppMethodBeat.o(104510);
                    }
                });
            }
            AppMethodBeat.o(104511);
            return false;
        }
    };

    public b() {
        AppMethodBeat.i(104512);
        AppMethodBeat.o(104512);
    }

    static /* synthetic */ void a(b bVar, String str, int i2, int i3, int i4) {
        AppMethodBeat.i(104518);
        bVar.f(str, i2, i3, i4);
        AppMethodBeat.o(104518);
    }

    static {
        AppMethodBeat.i(104519);
        AppMethodBeat.o(104519);
    }

    public static b bby() {
        AppMethodBeat.i(104513);
        synchronized (b.class) {
            try {
                if (iUu == null) {
                    iUu = new b();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(104513);
                throw th;
            }
        }
        b bVar = iUu;
        AppMethodBeat.o(104513);
        return bVar;
    }

    public final boolean bbz() {
        return this.iUw;
    }

    public static void bbA() {
        AppMethodBeat.i(104514);
        com.tencent.mm.pluginsdk.j.a.a.b.gnC();
        com.tencent.mm.pluginsdk.j.a.a.b.ahP(57);
        AppMethodBeat.o(104514);
    }

    public final boolean bbB() {
        AppMethodBeat.i(104515);
        if (!s.YS(iUs) || !s.YS(iUt)) {
            this.iUw = false;
        } else {
            Log.i("MicroMsg.FontResLogic", "font file exist");
            this.iUw = true;
        }
        boolean z = this.iUw;
        AppMethodBeat.o(104515);
        return z;
    }

    public static String[] bbC() {
        return new String[]{iUt, iUs};
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void f(java.lang.String r9, int r10, int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 417
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.aq.b.f(java.lang.String, int, int, int):void");
    }

    private static boolean b(JSONObject jSONObject, String str) {
        AppMethodBeat.i(104517);
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("md5");
        String str2 = iUr + optString;
        String md5 = com.tencent.mm.d.g.getMD5(str2);
        if (Util.isNullOrNil(md5) || !md5.equalsIgnoreCase(optString2)) {
            Log.e("MicroMsg.FontResLogic", "download %s not match! %s %s", optString, md5, optString2);
            AppMethodBeat.o(104517);
            return false;
        }
        if (!str.equalsIgnoreCase(str2)) {
            s.nx(str2, str);
        }
        AppMethodBeat.o(104517);
        return true;
    }
}
