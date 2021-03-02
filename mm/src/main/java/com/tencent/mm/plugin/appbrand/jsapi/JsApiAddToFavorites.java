package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.game.page.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import org.json.JSONObject;

public final class JsApiAddToFavorites extends d<c> {
    public static final int CTRL_INDEX = 800;
    public static final String NAME = "addToFavorites";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(226667);
        c cVar2 = cVar;
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("path");
        String optString3 = jSONObject.optString("imageUrl");
        final boolean optBoolean = jSONObject.optBoolean("disableForward", false);
        final int optInt = jSONObject.optInt("cardSubType", 0);
        final ag bsz = cVar2.bsz();
        final boolean c2 = e.b.c(cVar2.kEb.getOrientationHandler().btm());
        AnonymousClass1 r0 = new c.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.utils.c.a
            public final void Wz(String str) {
                int i2 = 0;
                AppMethodBeat.i(226651);
                Log.i("MicroMsg.JsApiAddToFavorites", "onLoad %s", str);
                AppBrandInitConfigWC bsC = bsz.getRuntime().bsC();
                int i3 = bsz.getRuntime().bsB().leb;
                IPCFavRequest iPCFavRequest = new IPCFavRequest();
                iPCFavRequest.username = bsC.username;
                iPCFavRequest.appId = bsC.appId;
                iPCFavRequest.dCx = optString2;
                iPCFavRequest.iconUrl = bsC.iconUrl;
                iPCFavRequest.lyD = str;
                iPCFavRequest.title = optString;
                iPCFavRequest.version = bsC.appVersion;
                iPCFavRequest.iOo = bsC.eix;
                if (bsz.yK(u.ShareAppMsg.ordinal()).neT || optBoolean) {
                    i2 = 1;
                }
                iPCFavRequest.lyE = i2;
                iPCFavRequest.leb = i3;
                iPCFavRequest.scene = bsC.cyA.scene;
                iPCFavRequest.eda = bsC.cys.eda;
                iPCFavRequest.subType = optInt;
                iPCFavRequest.lyF = c2;
                com.tencent.mm.plugin.appbrand.ipc.a.a(bsz.getContext(), iPCFavRequest, new AppBrandProxyUIProcessTask.b<AppBrandProxyUIProcessTask.ProcessResult>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
                    public final void a(AppBrandProxyUIProcessTask.ProcessResult processResult) {
                        AppMethodBeat.i(226650);
                        if (!(processResult instanceof IPCFavResult)) {
                            AppMethodBeat.o(226650);
                            return;
                        }
                        int i2 = ((IPCFavResult) processResult).ret;
                        if (i2 == 0) {
                            bsz.i(i2, JsApiAddToFavorites.this.h("ok", null));
                            AppMethodBeat.o(226650);
                            return;
                        }
                        bsz.i(i2, JsApiAddToFavorites.this.h(String.format("fail internal error:%d", Integer.valueOf(i2)), null));
                        AppMethodBeat.o(226650);
                    }
                });
                AppMethodBeat.o(226651);
            }
        };
        if (Util.isNullOrNil(optString3)) {
            Log.i("MicroMsg.JsApiAddToFavorites", "loadThumbFromSnapShot");
            o Wa = bsz.getFileSystem().Wa("addFavoriteSnapShot_" + System.currentTimeMillis());
            if (Wa == null) {
                Log.e("MicroMsg.JsApiAddToFavorites", "loadThumbFromSnapShot failed for allocTempFile");
                r0.Wz(null);
                AppMethodBeat.o(226667);
                return;
            }
            String z = aa.z(Wa.her());
            d dVar = (d) bsz.S(d.class);
            if (dVar != null) {
                try {
                    a(r0, bsz, dVar.MQ().getMagicBrush().cLA.h(dVar.MQ().getVirtualElementId(), -1, true), z);
                    AppMethodBeat.o(226667);
                } catch (NullPointerException e2) {
                    Log.printErrStackTrace("MicroMsg.JsApiAddToFavorites", e2, "hy: can not get snapshot!", new Object[0]);
                    r0.Wz("");
                    AppMethodBeat.o(226667);
                }
            } else {
                a(r0, bsz, bsz.bRB(), z);
                AppMethodBeat.o(226667);
            }
        } else {
            com.tencent.mm.plugin.appbrand.utils.c.a(bsz, optString3, null, r0);
            AppMethodBeat.o(226667);
        }
    }

    static final class a extends AppBrandProxyUIProcessTask {
        private a() {
        }

        static /* synthetic */ MMActivity a(a aVar) {
            AppMethodBeat.i(226665);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226665);
            return bDF;
        }

        static /* synthetic */ void a(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226664);
            aVar.b(processResult);
            AppMethodBeat.o(226664);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
            AppMethodBeat.i(226663);
            IPCFavRequest iPCFavRequest = (IPCFavRequest) processRequest;
            aml aml = new aml();
            aml.ajd(19);
            aml.bgu(iPCFavRequest.lyD);
            if (Util.isNullOrNil(iPCFavRequest.lyD)) {
                aml.At(true);
            }
            aml.bgt(iPCFavRequest.lyD);
            aml.bgf(iPCFavRequest.title);
            aml.bgg(iPCFavRequest.title);
            aml.bgs(b.ds(aml.toString(), 19));
            anh anh = new anh();
            anh.bhf(z.aTY());
            anh.MA(Util.nowMilliSecond());
            anh.ajm(iPCFavRequest.scene);
            amj amj = new amj();
            amj.appId = iPCFavRequest.appId;
            amj.iconUrl = iPCFavRequest.iconUrl;
            amj.dCx = iPCFavRequest.dCx;
            amj.dMe = iPCFavRequest.iOo;
            amj.version = iPCFavRequest.version;
            amj.username = iPCFavRequest.username;
            amj.lyE = iPCFavRequest.lyE;
            amj.leb = iPCFavRequest.leb;
            amj.eda = iPCFavRequest.eda;
            amj.subType = iPCFavRequest.subType;
            anb anb = new anb();
            anb.ppH.add(aml);
            anb.c(amj);
            anb.a(anh);
            cz czVar = new cz();
            anb.bhd(iPCFavRequest.title);
            czVar.dFZ.desc = iPCFavRequest.title;
            czVar.dFZ.title = iPCFavRequest.title;
            czVar.dFZ.dGb = anb;
            czVar.dFZ.type = 19;
            EventCenter.instance.publish(czVar);
            int i2 = czVar.dGa.ret;
            final IPCFavResult iPCFavResult = new IPCFavResult();
            iPCFavResult.ret = i2;
            Log.i("MicroMsg.JsApiAddToFavorites", "fav result:%d", Integer.valueOf(i2));
            com.tencent.mm.plugin.fav.ui.e.a(i2, bDF(), new a.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.a.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void onShow() {
                }

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void onHide() {
                    AppMethodBeat.i(226661);
                    a.a(a.this, iPCFavResult);
                    AppMethodBeat.o(226661);
                }

                @Override // com.tencent.mm.ui.widget.snackbar.a.c
                public final void bDY() {
                }
            }, null, new a.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.a.AnonymousClass2 */

                @Override // com.tencent.mm.ui.widget.snackbar.a.b
                public final void bDZ() {
                    AppMethodBeat.i(226662);
                    hb hbVar = new hb();
                    hbVar.dLm.type = 35;
                    hbVar.dLm.context = a.a(a.this);
                    EventCenter.instance.publish(hbVar);
                    AppMethodBeat.o(226662);
                }
            });
            AppMethodBeat.o(226663);
        }
    }

    static final class IPCFavRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
        public static final Parcelable.Creator<IPCFavRequest> CREATOR = new Parcelable.Creator<IPCFavRequest>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.IPCFavRequest.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IPCFavRequest[] newArray(int i2) {
                return new IPCFavRequest[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IPCFavRequest createFromParcel(Parcel parcel) {
                AppMethodBeat.i(226652);
                IPCFavRequest iPCFavRequest = new IPCFavRequest(parcel);
                AppMethodBeat.o(226652);
                return iPCFavRequest;
            }
        };
        String appId;
        String dCx;
        String eda;
        int iOo;
        String iconUrl;
        int leb;
        String lyD;
        int lyE;
        boolean lyF;
        int scene;
        int subType;
        String title;
        String username;
        int version;

        protected IPCFavRequest() {
        }

        protected IPCFavRequest(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(226653);
            this.username = parcel.readString();
            this.appId = parcel.readString();
            this.dCx = parcel.readString();
            this.iconUrl = parcel.readString();
            this.version = parcel.readInt();
            this.iOo = parcel.readInt();
            this.title = parcel.readString();
            this.lyD = parcel.readString();
            this.lyE = parcel.readInt();
            this.leb = parcel.readInt();
            this.scene = parcel.readInt();
            this.eda = parcel.readString();
            this.subType = parcel.readInt();
            this.lyF = parcel.readInt() != 1 ? false : z;
            AppMethodBeat.o(226653);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final boolean bDQ() {
            return this.lyF;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(226654);
            parcel.writeString(this.username);
            parcel.writeString(this.appId);
            parcel.writeString(this.dCx);
            parcel.writeString(this.iconUrl);
            parcel.writeInt(this.version);
            parcel.writeInt(this.iOo);
            parcel.writeString(this.title);
            parcel.writeString(this.lyD);
            parcel.writeInt(this.lyE);
            parcel.writeInt(this.leb);
            parcel.writeInt(this.scene);
            parcel.writeString(this.eda);
            parcel.writeInt(this.subType);
            parcel.writeInt(this.lyF ? 1 : 0);
            AppMethodBeat.o(226654);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final Class<? extends AppBrandProxyUIProcessTask> bCJ() {
            return a.class;
        }

        static {
            AppMethodBeat.i(226655);
            AppMethodBeat.o(226655);
        }
    }

    static final class IPCFavResult extends AppBrandProxyUIProcessTask.ProcessResult {
        public static final Parcelable.Creator<IPCFavResult> CREATOR = new Parcelable.Creator<IPCFavResult>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.IPCFavResult.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IPCFavResult[] newArray(int i2) {
                return new IPCFavResult[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IPCFavResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(226656);
                IPCFavResult iPCFavResult = new IPCFavResult(parcel);
                AppMethodBeat.o(226656);
                return iPCFavResult;
            }
        };
        int ret;

        protected IPCFavResult() {
        }

        protected IPCFavResult(Parcel parcel) {
            AppMethodBeat.i(226657);
            k(parcel);
            AppMethodBeat.o(226657);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult
        public final void k(Parcel parcel) {
            AppMethodBeat.i(226658);
            this.ret = parcel.readInt();
            AppMethodBeat.o(226658);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(226659);
            parcel.writeInt(this.ret);
            AppMethodBeat.o(226659);
        }

        static {
            AppMethodBeat.i(226660);
            AppMethodBeat.o(226660);
        }
    }

    private static void a(c.a aVar, ac acVar, Bitmap bitmap, String str) {
        AppMethodBeat.i(226666);
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
                    Log.i("MicroMsg.JsApiAddToFavorites", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", acVar.getAppId(), Integer.valueOf(acVar.hashCode()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    aVar.Wz(str);
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                        AppMethodBeat.o(226666);
                    }
                    AppMethodBeat.o(226666);
                    return;
                }
            } catch (Exception e2) {
                Log.w("MicroMsg.JsApiAddToFavorites", "save temp bitmap to file failed, . exception : %s", e2);
                aVar.Wz("");
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                    AppMethodBeat.o(226666);
                    return;
                }
            } catch (Throwable th) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                AppMethodBeat.o(226666);
                throw th;
            }
        }
        Log.w("MicroMsg.JsApiAddToFavorites", "snapshot can not be taken");
        aVar.Wz("");
        bitmap.recycle();
        AppMethodBeat.o(226666);
    }
}
