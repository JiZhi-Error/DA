package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.g.a.na;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.cha;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class OpenBusinessViewUtil {

    public interface a {
        void ak(int i2, String str);

        void ds(String str, String str2);
    }

    public static void a(int i2, String str, String str2, String str3, String str4, final a aVar) {
        AppMethodBeat.i(46305);
        cha cha = new cha();
        cha.source = i2;
        cha.Mmi = str;
        cha.Mmj = str3;
        cha.Mmk = str4;
        cha.query = str2;
        d.a aVar2 = new d.a();
        aVar2.funcId = 1268;
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxabusiness/launchbizwxaapp";
        aVar2.iLN = cha;
        aVar2.iLO = new chb();
        IPCRunCgi.a(aVar2.aXF(), new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.AnonymousClass1 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                AppMethodBeat.i(46299);
                if (i2 != 0 || i3 != 0 || dVar == null || dVar.iLL.iLR == null || !(dVar.iLL.iLR instanceof chb)) {
                    Log.e("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request fail");
                    if (aVar != null) {
                        aVar.ak(i3, str);
                    }
                    AppMethodBeat.o(46299);
                    return;
                }
                chb chb = (chb) dVar.iLL.iLR;
                Log.i("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request success, appId:%s, path:%s", chb.dNI, chb.Mml);
                if (aVar != null) {
                    aVar.ds(chb.dNI, chb.Mml);
                }
                AppMethodBeat.o(46299);
            }
        });
        AppMethodBeat.o(46305);
    }

    public static void z(q qVar) {
        AppMethodBeat.i(174786);
        AppBrandLaunchReferrer appBrandLaunchReferrer = qVar.bsC().cys;
        if (appBrandLaunchReferrer == null || Util.isNullOrNil(appBrandLaunchReferrer.businessType)) {
            Log.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, referrer businessType is null");
            AppMethodBeat.o(174786);
            return;
        }
        String str = qVar.mAppId;
        p.Un(str).kCZ = appBrandLaunchReferrer.leo;
        p.Un(str).kCY = appBrandLaunchReferrer.businessType;
        p.Un(str).kDa = false;
        p.Un(str).kDc = false;
        p.Un(str).kDb = false;
        Log.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, app:%s, businessType:%s, launchScene:%s", str, appBrandLaunchReferrer.businessType, Integer.valueOf(appBrandLaunchReferrer.leo));
        AppMethodBeat.o(174786);
    }

    public static void A(q qVar) {
        AppMethodBeat.i(174787);
        if (qVar == null) {
            AppMethodBeat.o(174787);
            return;
        }
        int i2 = p.Um(qVar.mAppId).kCZ;
        String str = p.Um(qVar.mAppId).kCY;
        Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, appId:%s, businessType:%s, launchScene:%s", qVar.mAppId, str, Integer.valueOf(i2));
        if (!Util.isNullOrNil(str)) {
            if (i2 == 2) {
                if (!p.Um(qVar.mAppId).kDa) {
                    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to H5, businessType:%s", str);
                    B(str, null, -3);
                }
                AppMethodBeat.o(174787);
                return;
            } else if (i2 == 4) {
                if (!p.Um(qVar.mAppId).kDc) {
                    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to Application, businessType:%s", str);
                    if (qVar.bsC().cys != null && !Util.isNullOrNil(qVar.bsC().cys.appId)) {
                        A(qVar.bsC().cys.appId, str, -2);
                    }
                }
                AppMethodBeat.o(174787);
                return;
            } else if (i2 == 1 && !p.Um(qVar.mAppId).kDb) {
                Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to MiniProgram, businessType:%s", str);
                x(str, f.CANCEL.errCode, null);
            }
        }
        AppMethodBeat.o(174787);
    }

    public static void A(String str, String str2, int i2) {
        AppMethodBeat.i(46308);
        Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackApplication, appId:%s, businessType:%s, errCode:%d", str, str2, Integer.valueOf(i2));
        AppBrandMainProcessService.a(new JsApiNavigateBackApplication.NavigateBackAppTask(str, Util.nullAs((String) null, "{}"), str2, i2));
        AppMethodBeat.o(46308);
    }

    public static void x(String str, int i2, String str2) {
        AppMethodBeat.i(46309);
        Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackMiniProgram, businessType:%s, errCode:%d", str, Integer.valueOf(i2));
        y(str, i2, str2);
        AppMethodBeat.o(46309);
    }

    private static void y(String str, int i2, String str2) {
        AppMethodBeat.i(46310);
        na naVar = new na();
        naVar.dSK.errCode = i2;
        naVar.dSK.businessType = str;
        naVar.dSK.dSJ = str2;
        EventCenter.instance.publish(naVar);
        AppMethodBeat.o(46310);
    }

    public static void B(String str, String str2, int i2) {
        AppMethodBeat.i(46311);
        Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackH5, businessType:%s, errCode:%d", str, Integer.valueOf(i2));
        if (MMApplicationContext.isMMProcess()) {
            C(str, str2, i2);
            AppMethodBeat.o(46311);
            return;
        }
        AppBrandMainProcessService.a(new NavigateBackH5Task(str, str2, i2));
        AppMethodBeat.o(46311);
    }

    public static void C(String str, String str2, int i2) {
        AppMethodBeat.i(46312);
        mz mzVar = new mz();
        mzVar.dSI.businessType = str;
        mzVar.dSI.errCode = i2;
        mzVar.dSI.dSJ = str2;
        EventCenter.instance.publish(mzVar);
        AppMethodBeat.o(46312);
    }

    public static final class NavigateBackH5Task extends MainProcessTask {
        public static final Parcelable.Creator<NavigateBackH5Task> CREATOR = new Parcelable.Creator<NavigateBackH5Task>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.NavigateBackH5Task.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ NavigateBackH5Task[] newArray(int i2) {
                return new NavigateBackH5Task[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ NavigateBackH5Task createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46300);
                NavigateBackH5Task navigateBackH5Task = new NavigateBackH5Task();
                navigateBackH5Task.f(parcel);
                AppMethodBeat.o(46300);
                return navigateBackH5Task;
            }
        };
        public String businessType;
        public int errCode;
        public String extra;

        public NavigateBackH5Task() {
        }

        public NavigateBackH5Task(String str, String str2, int i2) {
            this.businessType = str;
            this.extra = str2;
            this.errCode = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(46301);
            OpenBusinessViewUtil.C(this.businessType, this.extra, this.errCode);
            AppMethodBeat.o(46301);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46302);
            parcel.writeString(this.businessType);
            parcel.writeString(this.extra);
            parcel.writeInt(this.errCode);
            AppMethodBeat.o(46302);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(46303);
            this.businessType = parcel.readString();
            this.extra = parcel.readString();
            this.errCode = parcel.readInt();
            AppMethodBeat.o(46303);
        }

        static {
            AppMethodBeat.i(46304);
            AppMethodBeat.o(46304);
        }
    }
}
