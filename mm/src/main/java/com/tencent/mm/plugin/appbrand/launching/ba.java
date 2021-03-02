package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.an;
import com.tencent.mm.plugin.appbrand.launching.w;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class ba extends aw<WxaPkgWrappingInfo> {
    private final String appId;
    private final int iOo;
    private final acc mSK;
    final w mWN;
    private final QualitySession mWO;
    private volatile boolean mWP = false;

    @Override // com.tencent.mm.plugin.appbrand.launching.aa, com.tencent.mm.plugin.appbrand.launching.aw
    public final /* bridge */ /* synthetic */ boolean bNh() {
        AppMethodBeat.i(227107);
        boolean bNh = super.bNh();
        AppMethodBeat.o(227107);
        return bNh;
    }

    @Override // java.util.concurrent.Callable
    public /* synthetic */ Object call() {
        AppMethodBeat.i(47349);
        WxaPkgWrappingInfo bCi = bCi();
        AppMethodBeat.o(47349);
        return bCi;
    }

    ba(String str, int i2, String str2, int i3, WxaAttributes.WxaVersionInfo wxaVersionInfo, boolean z, ICommLibReader iCommLibReader, QualitySession qualitySession, b bVar, boolean z2) {
        AppMethodBeat.i(227104);
        this.appId = str;
        this.iOo = i2;
        this.mWO = qualitySession;
        this.mSK = new acc();
        this.mSK.dUS = i3;
        this.mSK.LmF = b.PRE_RENDER == bVar;
        this.mSK.LmG = z2 ? 102 : 101;
        if (j.a.vP(i2)) {
            n.buL().a(str, wxaVersionInfo);
        }
        this.mWN = new ae(str, i2, z, str2, wxaVersionInfo, iCommLibReader, qualitySession, this.mSK) {
            /* class com.tencent.mm.plugin.appbrand.launching.ba.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.launching.ae
            public final void bNi() {
                AppMethodBeat.i(47334);
                super.bNi();
                ba.this.bNi();
                AppMethodBeat.o(47334);
            }

            @Override // com.tencent.mm.plugin.appbrand.launching.ae
            public final void onDownloadProgress(int i2) {
                AppMethodBeat.i(47336);
                super.onDownloadProgress(i2);
                ba.this.onDownloadProgress(i2);
                AppMethodBeat.o(47336);
            }
        };
        AppMethodBeat.o(227104);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.launching.aw
    public final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper";
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.aw
    public final void hX(boolean z) {
        AppMethodBeat.i(180313);
        super.hX(z);
        if (this.mWN instanceof w.a) {
            ((w.a) this.mWN).hX(z);
            AppMethodBeat.o(180313);
            return;
        }
        if (this.mWN instanceof aw) {
            ((aw) this.mWN).hX(z);
        }
        AppMethodBeat.o(180313);
    }

    public void bNi() {
        AppMethodBeat.i(227105);
        this.mWP = true;
        if (j.a.vP(this.iOo)) {
            aa.bvL();
        }
        AppMethodBeat.o(227105);
    }

    public void onDownloadProgress(int i2) {
    }

    public final WxaPkgWrappingInfo bCi() {
        boolean z;
        AppMethodBeat.i(227106);
        long nowMilliSecond = Util.nowMilliSecond();
        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) this.mWN.call();
        long nowMilliSecond2 = Util.nowMilliSecond();
        if (wxaPkgWrappingInfo != null) {
            if (this.mWP) {
                c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", nowMilliSecond, nowMilliSecond2);
            } else {
                c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", nowMilliSecond, nowMilliSecond2);
            }
        } else if (this.mWP) {
            c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_Download, "", "", nowMilliSecond, nowMilliSecond2);
        } else {
            c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessCodePkg_DB, "", "", nowMilliSecond, nowMilliSecond2);
        }
        try {
            String str = this.mWO.kEY;
            if (wxaPkgWrappingInfo != null) {
                z = true;
            } else {
                z = false;
            }
            an.b.b(str, z, nowMilliSecond2 - nowMilliSecond);
        } catch (Throwable th) {
            Log.e("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "call() reportUpdateResultAfterVersionFallbackIfNeed get exception %s", th);
        }
        AppMethodBeat.o(227106);
        return wxaPkgWrappingInfo;
    }
}
