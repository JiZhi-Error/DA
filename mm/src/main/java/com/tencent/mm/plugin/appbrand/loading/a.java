package com.tencent.mm.plugin.appbrand.loading;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.n;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class a {
    private static ServiceConnection mZP;
    public static final C0745a mZQ = new C0745a((byte) 0);
    private final Context ctx;
    private final AppBrandStatObject kEH;
    private final AppBrandInitConfigWC kID;
    private int mZL = -1;
    private final f mZM = g.ah(new b(this));
    private final Intent mZN;
    private final n mZO;

    static {
        AppMethodBeat.i(50818);
        AppMethodBeat.o(50818);
    }

    public final b bOq() {
        AppMethodBeat.i(175200);
        b bVar = (b) this.mZM.getValue();
        AppMethodBeat.o(175200);
        return bVar;
    }

    public a(Context context, Intent intent, AppBrandInitConfigWC appBrandInitConfigWC, n nVar, AppBrandStatObject appBrandStatObject) {
        p.h(context, "ctx");
        p.h(intent, "startAppBrandIntent");
        p.h(appBrandInitConfigWC, "cfg");
        p.h(nVar, "task");
        p.h(appBrandStatObject, "stat");
        AppMethodBeat.i(50817);
        this.ctx = context;
        this.mZN = intent;
        this.kID = appBrandInitConfigWC;
        this.mZO = nVar;
        this.kEH = appBrandStatObject;
        AppMethodBeat.o(50817);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.loading.a$a */
    public static final class C0745a {
        private C0745a() {
        }

        public /* synthetic */ C0745a(byte b2) {
            this();
        }
    }

    public final void bOr() {
        String str;
        AppMethodBeat.i(228822);
        this.mZL = c.mZY.a(new e(this.ctx, this.mZN, this.kID, this.kEH));
        Class bWy = this.mZO.bWy();
        StringBuilder sb = new StringBuilder("onNeedPreLoadingUI: triggerService = ");
        p.g(bWy, "processTriggerServiceClass");
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingLogic", sb.append(bWy.getCanonicalName()).toString());
        String canonicalName = bWy.getCanonicalName();
        if (canonicalName == null) {
            p.hyc();
        }
        p.g(canonicalName, "processTriggerServiceClass.canonicalName!!");
        ComponentName component = this.mZN.getComponent();
        if (component == null || (str = component.getClassName()) == null) {
            str = "";
        }
        Intent intent = new Intent(this.ctx, this.mZO.bWz());
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingLogic", "startPreLoadingActivity, ctx = " + this.ctx);
        intent.putExtra("MicroMsg.AppBrandPreLoadingLogic.name", this.kID.brandName);
        intent.putExtra("MicroMsg.AppBrandPreLoadingLogic.icon", this.kID.iconUrl);
        intent.putExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName", canonicalName);
        intent.putExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", this.mZL);
        intent.putExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName", str);
        intent.putExtra("MicroMsg.AppBrandPreLoadingLogic.splashFlavor", bOs());
        intent.putExtra("MicroMsg.AppBrandPreLoadingLogic.appId", this.kID.appId);
        intent.putExtra("MicroMsg.AppBrandPreLoadingLogic.scene", this.kEH.scene);
        intent.putExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo", this.kID.cyv);
        intent.addFlags(268435456);
        Context context = this.ctx;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic", "startPreLoadingActivity", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic", "startPreLoadingActivity", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (this.ctx instanceof Activity) {
            Activity activity = (Activity) this.ctx;
            switch (bOs()) {
                case 5:
                    ((ah) e.M(ah.class)).a(activity, this.kID);
                    break;
            }
        }
        d.b("MicroMsg.AppBrand.AppBrandPreLoadingLogic:startService:".concat(String.valueOf(canonicalName)), new c(this, canonicalName));
        this.kID.ldT = bWy.getCanonicalName();
        AppMethodBeat.o(228822);
    }

    private final int bOs() {
        if (this.mZO instanceof com.tencent.mm.plugin.appbrand.task.d) {
            return 4;
        }
        return 5;
    }

    public final boolean bOt() {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(50816);
        if (this.mZO.bWq() == com.tencent.mm.plugin.appbrand.task.g.WASERVICE && !this.kID.ldU) {
            Class bWy = this.mZO.bWy();
            p.g(bWy, "task.processTriggerServiceClass");
            String canonicalName = bWy.getCanonicalName();
            if (canonicalName == null || kotlin.n.n.aL(canonicalName)) {
                z = true;
            } else {
                z = false;
            }
            if (!z && !com.tencent.mm.plugin.appbrand.af.g.afU(this.kID.appId) && !com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.e(this.kID, this.kEH)) {
                if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_app_brand_pre_loading, !com.tencent.mm.protocal.d.KyP ? 1 : 0) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    MultiProcessMMKV VQ = com.tencent.mm.plugin.appbrand.app.f.kIs.VQ();
                    if (VQ != null) {
                        z3 = VQ.getBoolean("enable_pre_loading", true);
                    } else {
                        z3 = true;
                    }
                    if (!(!z3)) {
                        AppMethodBeat.o(50816);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(50816);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static final class b extends q implements kotlin.g.a.a<b> {
        final /* synthetic */ a mZR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.mZR = aVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ b invoke() {
            AppMethodBeat.i(175199);
            b bVar = new b(this.mZR.mZL, "MicroMsg.AppBrand.AppBrandPreLoadingLogic");
            AppMethodBeat.o(175199);
            return bVar;
        }
    }

    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a mZR;
        final /* synthetic */ String mZS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, String str) {
            super(0);
            this.mZR = aVar;
            this.mZS = str;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            b bOq;
            AppMethodBeat.i(177766);
            try {
                boolean bindService = this.mZR.ctx.bindService(new Intent(this.mZR.ctx, Class.forName(this.mZS)), this.mZR.bOq(), 65);
                Log.i("MicroMsg.AppBrand.AppBrandPreLoadingLogic", "startAppBrandProgress: bind " + this.mZS + " ret = " + bindService);
                C0745a aVar = a.mZQ;
                if (!bindService) {
                    bOq = null;
                } else {
                    bOq = this.mZR.bOq();
                }
                a.mZP = bOq;
            } catch (SecurityException e2) {
                Log.e("MicroMsg.AppBrand.AppBrandPreLoadingLogic", "startAppBrandProgress: ", e2);
                C0745a aVar2 = a.mZQ;
                a.mZP = null;
                c.mZY.yr(this.mZR.mZL);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(177766);
            return xVar;
        }
    }
}
