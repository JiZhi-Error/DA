package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.luggage.sdk.e.c;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.launching.am;
import com.tencent.mm.plugin.appbrand.launching.d.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public final class bc extends aw<Pair<WxaAttributes, Boolean>> implements ak {
    String appId;
    private final AppBrandLaunchReferrer cys;
    private final b cyz;
    private final int enterScene;
    private final int iOo;
    private final AppBrandStatObject kEH;
    private String kEY;
    private AppBrandLaunchFromNotifyReferrer kHI;
    private final String kHw;
    private final String mRk;
    private boolean mWV;
    private boolean mWW;
    private WxaAttributes mWX;
    private final int mWY;
    boolean mWZ = false;
    private boolean mXa = false;
    private am.a mXb = am.a.NONE;
    private int mXc = -1;
    private aa.f mXd = null;
    String username;

    @Override // com.tencent.mm.plugin.appbrand.launching.ak
    public final /* synthetic */ Pair bNI() {
        AppMethodBeat.i(227115);
        Pair pair = (Pair) super.bNO();
        AppMethodBeat.o(227115);
        return pair;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ak
    public final long bNF() {
        return this.mWG;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ak
    public final long bNG() {
        return this.mWH;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ak
    public final long bNH() {
        return this.mWI;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ak
    public final String name() {
        return "PrepareStepGetWxaAttrs";
    }

    bc(String str, String str2, int i2, int i3, int i4, String str3, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, String str4, AppBrandLaunchFromNotifyReferrer appBrandLaunchFromNotifyReferrer, String str5, aa.f fVar, b bVar) {
        this.username = str;
        this.appId = str2;
        this.iOo = i2;
        this.mWY = i3;
        this.enterScene = i4;
        this.kHw = str3;
        this.kEH = appBrandStatObject;
        this.cys = appBrandLaunchReferrer;
        this.kEY = str4;
        this.kHI = appBrandLaunchFromNotifyReferrer;
        this.mRk = str5;
        this.cyz = bVar;
        this.mXd = fVar;
    }

    private WxaAttributes bNP() {
        AppMethodBeat.i(47354);
        if (!Util.isNullOrNil(this.username)) {
            WxaAttributes d2 = n.buC().d(this.username, new String[0]);
            AppMethodBeat.o(47354);
            return d2;
        }
        WxaAttributes e2 = n.buC().e(this.appId, new String[0]);
        AppMethodBeat.o(47354);
        return e2;
    }

    private static boolean j(WxaAttributes wxaAttributes) {
        AppMethodBeat.i(227114);
        if (wxaAttributes.bAn() == null || !wxaAttributes.bAn().NA()) {
            AppMethodBeat.o(227114);
            return false;
        }
        AppMethodBeat.o(227114);
        return true;
    }

    private static boolean k(WxaAttributes wxaAttributes) {
        AppMethodBeat.i(47355);
        if (Util.isNullOrNil(wxaAttributes.field_appId)) {
            Log.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid appID in contact(%s)", wxaAttributes.field_username);
            AppMethodBeat.o(47355);
            return true;
        } else if (wxaAttributes.bAp() == null) {
            Log.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL versionInfo(%s) in contact(%s)", wxaAttributes.field_versionInfo, wxaAttributes.field_username);
            AppMethodBeat.o(47355);
            return true;
        } else if (wxaAttributes.bAn() == null) {
            Log.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL appInfo(%s) in contact(%s)", wxaAttributes.field_appInfo, wxaAttributes.field_username);
            AppMethodBeat.o(47355);
            return true;
        } else if (wxaAttributes.bAp().cyu != 0 || !Util.isNullOrNil(wxaAttributes.bAp().lgS)) {
            AppMethodBeat.o(47355);
            return false;
        } else {
            Log.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid versionMD5 in contact(%s)", wxaAttributes.field_username);
            AppMethodBeat.o(47355);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.launching.aw
    public final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepGetWxaAttrs";
    }

    class a implements aa.f {
        private a() {
        }

        /* synthetic */ a(bc bcVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.config.aa.f
        public final void bAm() {
            boolean z;
            AppMethodBeat.i(175003);
            if (bc.this.mXd != null) {
                bc.this.mXd.bAm();
            }
            if (!j.a.vP(bc.this.iOo)) {
                AppMethodBeat.o(175003);
                return;
            }
            if (com.tencent.mm.plugin.appbrand.appcache.aa.bvK()) {
                com.tencent.mm.plugin.appbrand.appcache.aa.bvL();
            }
            int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_cgi_parallel, (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || !d.KyP) ? 1 : 0);
            Object[] objArr = new Object[3];
            objArr[0] = bc.this.username;
            objArr[1] = bc.this.appId;
            if (a2 == 1) {
                z = true;
            } else {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            Log.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "beforeSync: sync contact[username(%s) appId(%s)], process preload cgi, is open = [%b]", objArr);
            if (a2 == 1) {
                Log.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "beforeSync: sync contact[username(%s) appId(%s)], process preload cgi, is open = [%b]", bc.this.username, bc.this.appId, Boolean.TRUE);
                c cVar = c.cCC;
                c.a(new com.tencent.mm.plugin.appbrand.launching.d.c(), bc.this.kEY);
                c cVar2 = c.cCC;
                com.tencent.luggage.sdk.e.b dJ = c.dJ(bc.this.kEY);
                dJ.b(new com.tencent.mm.plugin.appbrand.launching.d.g(bc.this.username, bc.this.iOo, bc.this.enterScene, bc.this.kHw, bc.this.kEH, bc.this.cys, bc.this.appId, (bc.this.enterScene != 1162 || bc.this.kHI == null) ? null : bc.this.kHI.lek, bc.this.mRk));
                dJ.b(new f(bc.this.kHw, bc.this.username, bc.this.appId));
                com.tencent.mm.plugin.appbrand.launching.d.b.pl(0);
                com.tencent.mm.plugin.appbrand.keylogger.c.a(bc.this.appId, KSProcessWeAppLaunch.stepGetContact_CGI);
            }
            AppMethodBeat.o(175003);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x059d  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x05b6  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x05e3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013b  */
    @Override // java.util.concurrent.Callable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object call() {
        /*
        // Method dump skipped, instructions count: 1526
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.bc.call():java.lang.Object");
    }
}
