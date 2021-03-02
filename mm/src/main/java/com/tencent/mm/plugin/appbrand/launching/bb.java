package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.a.d;
import com.tencent.mm.plugin.appbrand.launching.am;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.fcc;
import com.tencent.mm.protocal.protobuf.fds;
import com.tencent.mm.protocal.protobuf.fez;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.Callable;

public class bb extends aw<ap> {
    final String appId;
    final int appVersion;
    final AppBrandLaunchReferrer cys;
    final b cyz;
    final int ecU;
    final int enterScene;
    final int iOo;
    final AppBrandLaunchFromNotifyReferrer kHI;
    final String kHw;
    final QualitySession ldW;
    final String mRZ;
    private final String mRk;
    final ICommLibReader mWR;
    final String userName;

    @Override // com.tencent.mm.plugin.appbrand.launching.aa, com.tencent.mm.plugin.appbrand.launching.aw
    public final /* bridge */ /* synthetic */ boolean bNh() {
        AppMethodBeat.i(227110);
        boolean bNh = super.bNh();
        AppMethodBeat.o(227110);
        return bNh;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.aw
    public final /* bridge */ /* synthetic */ void hX(boolean z) {
        AppMethodBeat.i(180316);
        super.hX(z);
        AppMethodBeat.o(180316);
    }

    bb(String str, int i2, int i3, int i4, String str2, AppBrandLaunchReferrer appBrandLaunchReferrer, String str3, ICommLibReader iCommLibReader, QualitySession qualitySession, String str4, AppBrandLaunchFromNotifyReferrer appBrandLaunchFromNotifyReferrer, String str5, b bVar) {
        AppMethodBeat.i(227109);
        this.appId = str;
        this.iOo = i2;
        this.ecU = i3;
        this.enterScene = i4;
        this.kHw = str2;
        this.cys = appBrandLaunchReferrer;
        this.mRZ = str3;
        this.userName = str4;
        this.kHI = appBrandLaunchFromNotifyReferrer;
        this.mRk = str5;
        this.cyz = bVar;
        bd a2 = n.buL().a(str, i2, "version");
        this.appVersion = a2 == null ? 0 : a2.field_version;
        this.mWR = iCommLibReader;
        this.ldW = qualitySession;
        AppMethodBeat.o(227109);
    }

    /* access modifiers changed from: package-private */
    public void bsQ() {
    }

    public static boolean yl(int i2) {
        AppMethodBeat.i(47351);
        int[] iArr = AppBrandGlobalSystemConfig.bzP().lcT;
        if (iArr == null || !a.contains(iArr, i2)) {
            AppMethodBeat.o(47351);
            return false;
        }
        AppMethodBeat.o(47351);
        return true;
    }

    public static boolean b(ap apVar) {
        return (apVar == null || apVar.field_jsapiInfo == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.launching.aw
    public final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
    }

    @Override // java.util.concurrent.Callable
    public /* synthetic */ Object call() {
        int bvd;
        AppMethodBeat.i(47352);
        long nowMilliSecond = Util.nowMilliSecond();
        final ap apVar = new ap();
        apVar.field_appId = this.appId;
        final ao buD = n.buD();
        if (buD == null) {
            Log.e("MicroMsg.AppBrand.PrepareStepCheckLaunchInfo", "call() invalid storage, appId[%s]", this.appId);
            AppMethodBeat.o(47352);
            return null;
        }
        fcc fcc = new fcc();
        fcc.MjZ = this.iOo;
        fcc.KSa = this.appVersion;
        fcc.Scene = this.enterScene;
        fcc.MqE = this.kHw;
        fcc.MqD = 0;
        fcc.MqC = this.ecU;
        fez b2 = d.b(this.cys);
        fds c2 = d.c(this.cys);
        if (this.mWR == null) {
            bvd = -1;
        } else {
            bvd = this.mWR.bvd();
        }
        AnonymousClass1 r3 = new Callable<Boolean>() {
            /* class com.tencent.mm.plugin.appbrand.launching.bb.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Boolean call() {
                AppMethodBeat.i(227108);
                if (bb.yl(bb.this.enterScene)) {
                    Log.i("MicroMsg.AppBrand.PrepareStepCheckLaunchInfo", "checkIfNeedSyncLaunch, hit scene[%d] return true, appId[%s]", Integer.valueOf(bb.this.enterScene), bb.this.appId);
                    Boolean bool = Boolean.TRUE;
                    AppMethodBeat.o(227108);
                    return bool;
                }
                if (!buD.a(apVar, "appId")) {
                    Log.i("MicroMsg.AppBrand.PrepareStepCheckLaunchInfo", "checkIfNeedSyncLaunch, get NULL record, return true, appId[%s]", bb.this.appId);
                    Boolean bool2 = Boolean.TRUE;
                    AppMethodBeat.o(227108);
                    return bool2;
                } else if (!bb.b(apVar)) {
                    Log.i("MicroMsg.AppBrand.PrepareStepCheckLaunchInfo", "checkIfNeedSyncLaunch, get INVALID record, return true, appId[%s]", bb.this.appId);
                    Boolean bool3 = Boolean.TRUE;
                    AppMethodBeat.o(227108);
                    return bool3;
                } else {
                    int i2 = apVar.field_launchAction == null ? -1 : apVar.field_launchAction.KCD;
                    if (1 != i2) {
                        Log.i("MicroMsg.AppBrand.PrepareStepCheckLaunchInfo", "checkIfNeedSyncLaunch, cached infoLaunchAction[%d], return true, appId[%s]", Integer.valueOf(i2), bb.this.appId);
                        Boolean bool4 = Boolean.TRUE;
                        AppMethodBeat.o(227108);
                        return bool4;
                    }
                    Boolean bool5 = Boolean.FALSE;
                    AppMethodBeat.o(227108);
                    return bool5;
                }
            }
        };
        acc acc = new acc();
        acc.LmF = b.PRE_RENDER == this.cyz;
        acc.dUS = this.enterScene;
        if (((Boolean) r3.call()).booleanValue()) {
            bsQ();
            long nowMilliSecond2 = Util.nowMilliSecond();
            acc.LmG = 101;
            com.tencent.mm.plugin.appbrand.launching.a.b bVar = new com.tencent.mm.plugin.appbrand.launching.a.b(this.appId, true, fcc, b2, c2, this.mRZ, bvd, this.ldW, this.userName, this.kHI, this.mRk, acc);
            bVar.mXL = this;
            bVar.bNV();
            am.a(am.b.SYNC_LAUNCH, this.appId, this.appVersion, this.iOo, this.enterScene, Util.nowMilliSecond() - nowMilliSecond2, 0);
            c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessLaunchWxaApp_CGI, "", nowMilliSecond, Util.nowMilliSecond());
            ap apVar2 = bVar.mXK;
            AppMethodBeat.o(47352);
            return apVar2;
        }
        acc.LmG = 102;
        new com.tencent.mm.plugin.appbrand.launching.a.b(this.appId, false, fcc, b2, c2, this.mRZ, bvd, this.ldW, this.userName, this.kHI, this.mRk, acc).bNW();
        c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceSubProcessLaunchWxaApp_DB, "", nowMilliSecond, Util.nowMilliSecond());
        AppMethodBeat.o(47352);
        return apVar;
    }
}
