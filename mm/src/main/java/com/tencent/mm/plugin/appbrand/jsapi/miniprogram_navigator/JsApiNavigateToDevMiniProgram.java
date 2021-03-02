package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiNavigateToDevMiniProgram extends a {
    private static final int CTRL_INDEX = 351;
    private static final String NAME = "navigateToDevMiniProgram";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(d dVar, JSONObject jSONObject, final int i2) {
        boolean z;
        AppMethodBeat.i(46628);
        final d dVar2 = dVar;
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("downloadURL");
        String optString3 = jSONObject.optString("checkSumMd5");
        b a2 = b.a(jSONObject.optString("envVersion"), b.DEVELOP);
        String optString4 = jSONObject.optString("relativeURL");
        String optString5 = jSONObject.optString("extoptions");
        if (Util.isNullOrNil(optString)) {
            dVar2.i(i2, h("fail:appID is empty", null));
            AppMethodBeat.o(46628);
            return;
        }
        if (b.DEVELOP == a2 && !TextUtils.isEmpty(optString3)) {
            DevPkgInfo devPkgInfo = new DevPkgInfo();
            devPkgInfo.appId = optString;
            devPkgInfo.ecN = optString2;
            devPkgInfo.ecO = optString3;
            devPkgInfo.meX = optString5;
            try {
                z = h.a(MMApplicationContext.getPackageName(), devPkgInfo, a.class) != null;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.JsApiNavigateToDevMiniProgram", "invoke IPCFlushDevPkg, parcel:%s, exception:%s", devPkgInfo, e2);
                z = false;
            }
            if (!z) {
                dVar2.i(i2, h("fail save packageInfo failed", null));
                AppMethodBeat.o(46628);
                return;
            }
        }
        c.a aVar = new c.a();
        aVar.scene = jSONObject.optInt("scene", 0);
        aVar.dCw = jSONObject.optString("sceneNote");
        aVar.ecU = jSONObject.optInt("preScene", 0);
        aVar.ecV = jSONObject.optString("preSceneNote");
        m.mfl.a(dVar2, optString, a2.iOo, optString4, aVar, jSONObject, new c.AbstractC0681c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.AbstractC0681c
            public final void o(boolean z, String str) {
                String str2;
                AppMethodBeat.i(46622);
                if (z) {
                    str2 = "ok";
                } else {
                    str2 = "fail" + (TextUtils.isEmpty(str) ? "" : " ".concat(String.valueOf(str)));
                }
                dVar2.i(i2, JsApiNavigateToDevMiniProgram.this.h(str2, null));
                AppMethodBeat.o(46622);
            }
        });
        AppMethodBeat.o(46628);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.a
    public final c bGm() {
        return m.mfl;
    }

    static final class DevPkgInfo implements Parcelable {
        public static final Parcelable.Creator<DevPkgInfo> CREATOR = new Parcelable.Creator<DevPkgInfo>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram.DevPkgInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ DevPkgInfo[] newArray(int i2) {
                return new DevPkgInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DevPkgInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46623);
                DevPkgInfo devPkgInfo = new DevPkgInfo(parcel);
                AppMethodBeat.o(46623);
                return devPkgInfo;
            }
        };
        String appId;
        String ecN;
        String ecO;
        String meX;

        DevPkgInfo() {
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46624);
            parcel.writeString(this.appId);
            parcel.writeString(this.ecN);
            parcel.writeString(this.ecO);
            parcel.writeString(this.meX);
            AppMethodBeat.o(46624);
        }

        DevPkgInfo(Parcel parcel) {
            AppMethodBeat.i(46625);
            this.appId = parcel.readString();
            this.ecN = parcel.readString();
            this.ecO = parcel.readString();
            this.meX = parcel.readString();
            AppMethodBeat.o(46625);
        }

        public final String toString() {
            AppMethodBeat.i(226909);
            String str = "DevPkgInfo{appId='" + this.appId + '\'' + ", downloadURL='" + this.ecN + '\'' + ", checkSumMd5='" + this.ecO + '\'' + ", extoptions='" + this.meX + '\'' + '}';
            AppMethodBeat.o(226909);
            return str;
        }

        static {
            AppMethodBeat.i(46626);
            AppMethodBeat.o(46626);
        }
    }

    static final class a implements k<DevPkgInfo, IPCVoid> {
        a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCVoid invoke(DevPkgInfo devPkgInfo) {
            AppMethodBeat.i(46627);
            DevPkgInfo devPkgInfo2 = devPkgInfo;
            ((t) n.W(t.class)).A(devPkgInfo2.appId, 1, devPkgInfo2.meX);
            if (n.buL().a(devPkgInfo2.appId, 1, devPkgInfo2.ecN, devPkgInfo2.ecO, 0, Util.nowSecond() + 7200)) {
                com.tencent.mm.plugin.appbrand.task.h.bWb().cl(devPkgInfo2.appId, 1);
            }
            IPCVoid iPCVoid = IPCVoid.hnE;
            AppMethodBeat.o(46627);
            return iPCVoid;
        }
    }
}
