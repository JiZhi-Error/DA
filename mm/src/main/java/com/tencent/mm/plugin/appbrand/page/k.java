package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.game.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.bta;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public class k {
    private static final HashMap<AppBrandRuntime, k> nnT = new HashMap<>();
    private static final k nnV = new k() {
        /* class com.tencent.mm.plugin.appbrand.page.k.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.page.k
        public final String bQA() {
            return null;
        }

        @Override // com.tencent.mm.plugin.appbrand.page.k
        public final String bQB() {
            return "";
        }

        @Override // com.tencent.mm.plugin.appbrand.page.k
        public final String bQC() {
            return "";
        }

        @Override // com.tencent.mm.plugin.appbrand.page.k
        public final boolean bQD() {
            return false;
        }

        @Override // com.tencent.mm.plugin.appbrand.page.k
        public final void a(a aVar) {
        }

        @Override // com.tencent.mm.plugin.appbrand.page.k
        public final b yI(int i2) {
            return null;
        }

        @Override // com.tencent.mm.plugin.appbrand.page.k
        public final Runnable c(c cVar) {
            AppMethodBeat.i(47781);
            AnonymousClass1 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.k.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(47780);
                    AppMethodBeat.o(47780);
                }
            };
            AppMethodBeat.o(47781);
            return r0;
        }
    };
    private AppBrandRuntime kEc;
    private String nnU;

    public interface a {
        void ady(String str);
    }

    public static final class b {
        public String desc;
        public int nod;
        public int noe;
    }

    /* synthetic */ k() {
        this(null);
    }

    static {
        AppMethodBeat.i(47795);
        AppMethodBeat.o(47795);
    }

    public static k ad(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(47787);
        if (appBrandRuntime == null || appBrandRuntime.isDestroyed()) {
            k kVar = nnV;
            AppMethodBeat.o(47787);
            return kVar;
        }
        k kVar2 = nnT.get(appBrandRuntime);
        if (kVar2 == null) {
            kVar2 = new k(appBrandRuntime);
            nnT.put(appBrandRuntime, kVar2);
        }
        AppMethodBeat.o(47787);
        return kVar2;
    }

    private k(final AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(175027);
        this.kEc = appBrandRuntime;
        if (appBrandRuntime == null) {
            AppMethodBeat.o(175027);
            return;
        }
        appBrandRuntime.kAH.a(new c.a() {
            /* class com.tencent.mm.plugin.appbrand.page.k.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.a.c.a
            public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
                AppMethodBeat.i(175023);
                k.nnT.remove(appBrandRuntime);
                AppMethodBeat.o(175023);
            }
        });
        AppMethodBeat.o(175027);
    }

    public String bQA() {
        AppMethodBeat.i(47788);
        String str = this.kEc.OT().jyi;
        AppMethodBeat.o(47788);
        return str;
    }

    public String bQB() {
        AppMethodBeat.i(47789);
        String str = this.kEc.OT().brandName;
        AppMethodBeat.o(47789);
        return str;
    }

    public String bQC() {
        AppMethodBeat.i(47790);
        String vO = e.vO(this.kEc.OT().leE.kNW);
        AppMethodBeat.o(47790);
        return vO;
    }

    public boolean bQD() {
        AppMethodBeat.i(47791);
        if (this.kEc.OU().originalFlag == 1) {
            AppMethodBeat.o(47791);
            return true;
        }
        AppMethodBeat.o(47791);
        return false;
    }

    public void a(final a aVar) {
        AppMethodBeat.i(47792);
        if (!Util.isNullOrNil(this.nnU)) {
            aVar.ady(this.nnU);
            AppMethodBeat.o(47792);
            return;
        }
        bta bta = new bta();
        bta.username = ((AppBrandInitConfigLU) this.kEc.OU()).username;
        d.a aVar2 = new d.a();
        aVar2.funcId = 2921;
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
        aVar2.iLN = bta;
        aVar2.iLO = new btb();
        IPCRunCgi.a(aVar2.aXF(), new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.appbrand.page.k.AnonymousClass3 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                final String string;
                AppMethodBeat.i(175025);
                if (i2 != 0 || i3 != 0 || dVar == null || dVar.iLL.iLR == null || !(dVar.iLL.iLR instanceof btb)) {
                    string = MMApplicationContext.getContext().getString(R.string.a2c);
                    Log.e("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request fail");
                } else {
                    Log.i("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request success");
                    btb btb = (btb) dVar.iLL.iLR;
                    if (btb.LZE == null || btb.LZE.NyO == -1.0d) {
                        string = null;
                    } else if (btb.LZE.NyO == 0.0d) {
                        string = MMApplicationContext.getContext().getString(R.string.q3);
                    } else {
                        string = MMApplicationContext.getContext().getString(R.string.a38, String.valueOf(btb.LZE.NyO));
                    }
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.page.k.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(175024);
                        k.this.nnU = string;
                        aVar.ady(string);
                        AppMethodBeat.o(175024);
                    }
                });
                AppMethodBeat.o(175025);
            }
        });
        AppMethodBeat.o(47792);
    }

    public b yI(int i2) {
        AppMethodBeat.i(47793);
        if (i2 == a.b.NORMAL.ordinal()) {
            AppMethodBeat.o(47793);
            return null;
        }
        b bVar = new b();
        Context context = MMApplicationContext.getContext();
        if (i2 == a.b.LBS.ordinal()) {
            bVar.desc = context.getString(R.string.a26);
            bVar.noe = R.raw.appbrand_menu_header_lbs;
            bVar.nod = R.drawable.d4;
        } else if (i2 == a.b.VOICE.ordinal()) {
            bVar.desc = context.getString(R.string.a28);
            bVar.noe = R.raw.appbrand_menu_header_record_voice;
            bVar.nod = R.drawable.d5;
        } else {
            AppMethodBeat.o(47793);
            return null;
        }
        AppMethodBeat.o(47793);
        return bVar;
    }

    public Runnable c(final com.tencent.luggage.sdk.b.a.c cVar) {
        AppMethodBeat.i(47794);
        AnonymousClass4 r2 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.k.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(47785);
                AppMethodBeat.o(47785);
            }
        };
        final AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) this.kEc.OT();
        final AppBrandInitConfigLU appBrandInitConfigLU = (AppBrandInitConfigLU) this.kEc.OU();
        if (appBrandSysConfigLU == null || appBrandInitConfigLU == null) {
            AppMethodBeat.o(47794);
            return r2;
        }
        AnonymousClass5 r22 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.k.AnonymousClass5 */

            public final void run() {
                String str;
                AppMethodBeat.i(47786);
                String str2 = "";
                if (((com.tencent.luggage.sdk.d.d) k.this.kEc).ON().cyA != null) {
                    str2 = appBrandInitConfigLU.cym;
                }
                new com.tencent.mm.plugin.appbrand.game.e.b.b().a(cVar.NQ(), b.a.BeforeJumpToProfile, 0);
                AppBrandOpReportLogic.a.d(cVar);
                WxaExposedParams.a aVar = new WxaExposedParams.a();
                aVar.appId = appBrandSysConfigLU.appId;
                aVar.from = 3;
                if (cVar.nmX == null) {
                    str = "";
                } else {
                    str = cVar.lBI;
                }
                aVar.pageId = str;
                aVar.kNW = appBrandSysConfigLU.leE.kNW;
                aVar.pkgVersion = appBrandSysConfigLU.leE.pkgVersion;
                AppBrandProfileUI.a(cVar.getContext(), appBrandInitConfigLU.username, 3, str2, aVar.bAv(), null, ActivityStarterIpcDelegate.aJ(cVar.getContext()));
                i.a(cVar.getAppId(), cVar.lBI, 6, "", Util.nowSecond(), 1, 0);
                AppMethodBeat.o(47786);
            }
        };
        AppMethodBeat.o(47794);
        return r22;
    }
}
