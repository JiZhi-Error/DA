package com.tencent.mm.game.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.game.report.c.c;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;

/* access modifiers changed from: package-private */
public final class e {
    private static LinkedList<b> hhn = new LinkedList<>();
    private static boolean hho;
    private static String hhp = "log_id";
    private static String hhq = "log_ext";

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(108258);
        axe();
        AppMethodBeat.o(108258);
    }

    static {
        AppMethodBeat.i(108259);
        AppMethodBeat.o(108259);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(108255);
        if (MMApplicationContext.isMMProcess()) {
            b(bVar);
            AppMethodBeat.o(108255);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(hhp, bVar.hhs);
        bundle.putString(hhq, bVar.hht);
        h.a(MainProcessIPCService.dkO, bundle, a.class, null);
        AppMethodBeat.o(108255);
    }

    private static synchronized void b(b bVar) {
        synchronized (e.class) {
            AppMethodBeat.i(108256);
            if (!g.aAf().azp() || com.tencent.mm.kernel.a.azj()) {
                Log.w("MicroMsg.ReportService", "report, account not ready");
                AppMethodBeat.o(108256);
            } else if (bVar == null) {
                AppMethodBeat.o(108256);
            } else {
                hhn.add(bVar);
                axe();
                AppMethodBeat.o(108256);
            }
        }
    }

    private static synchronized void axe() {
        synchronized (e.class) {
            AppMethodBeat.i(108257);
            if (hho) {
                Log.i("MicroMsg.ReportService", "tryDoScene isBusy");
                AppMethodBeat.o(108257);
            } else if (Util.isNullOrNil(hhn)) {
                Log.i("MicroMsg.ReportService", "waitingList is null");
                AppMethodBeat.o(108257);
            } else {
                b remove = hhn.remove(0);
                if (remove != null) {
                    hho = true;
                    d.a aVar = new d.a();
                    aVar.uri = "/cgi-bin/micromsg-bin/gamereportkv";
                    aVar.funcId = v2helper.EMethodPcMicLevel;
                    aVar.iLP = 0;
                    aVar.respCmdId = 0;
                    c cVar = new c();
                    cVar.hid = com.tencent.mm.protocal.d.KyJ;
                    cVar.hie = com.tencent.mm.protocal.d.KyI;
                    cVar.hif = com.tencent.mm.protocal.d.KyL;
                    cVar.hig = com.tencent.mm.protocal.d.KyM;
                    cVar.hih = LocaleUtil.getApplicationLanguage();
                    cVar.hii = remove.hhs;
                    cVar.hij = remove.hht;
                    aVar.iLN = cVar;
                    aVar.iLO = new com.tencent.mm.game.report.c.d();
                    aa.a(aVar.aXF(), new aa.a() {
                        /* class com.tencent.mm.game.report.e.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.aa.a
                        public final int a(int i2, int i3, String str, d dVar, q qVar) {
                            AppMethodBeat.i(108253);
                            Log.i("MicroMsg.ReportService", "tryDoScene, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                            boolean unused = e.hho = false;
                            e.access$100();
                            AppMethodBeat.o(108253);
                            return 0;
                        }
                    });
                    AppMethodBeat.o(108257);
                } else {
                    axe();
                    AppMethodBeat.o(108257);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(108254);
            Bundle bundle2 = bundle;
            e.a(new b(bundle2.getInt(e.hhp), bundle2.getString(e.hhq)));
            dVar.bn(null);
            AppMethodBeat.o(108254);
        }
    }
}
