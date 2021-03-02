package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.protocal.protobuf.cex;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiRefreshSession extends d {
    private static final int CTRL_INDEX = 118;
    private static final String NAME = "refreshSession";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45631);
        RefreshSessionTask refreshSessionTask = new RefreshSessionTask();
        l lVar = (l) fVar.av(l.class);
        if (lVar != null) {
            refreshSessionTask.iOo = lVar.leE.kNW;
        }
        String appId = fVar.getAppId();
        refreshSessionTask.lqf = this;
        refreshSessionTask.lAx = fVar;
        refreshSessionTask.lqe = i2;
        refreshSessionTask.appId = appId;
        AppBrandStatObject TS = a.TS(appId);
        if (TS != null) {
            refreshSessionTask.lBE = TS.scene;
        }
        refreshSessionTask.bDJ();
        AppBrandMainProcessService.a(refreshSessionTask);
        AppMethodBeat.o(45631);
    }

    public static class RefreshSessionTask extends MainProcessTask {
        public static final Parcelable.Creator<RefreshSessionTask> CREATOR = new Parcelable.Creator<RefreshSessionTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession.RefreshSessionTask.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ RefreshSessionTask[] newArray(int i2) {
                return new RefreshSessionTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RefreshSessionTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45620);
                RefreshSessionTask refreshSessionTask = new RefreshSessionTask(parcel);
                AppMethodBeat.o(45620);
                return refreshSessionTask;
            }
        };
        String appId;
        private String errorMsg;
        private int iOo;
        f lAx;
        private int lBB;
        private int lBC;
        private int lBD;
        int lBE;
        int lqe;
        p lqf;

        static /* synthetic */ boolean a(RefreshSessionTask refreshSessionTask) {
            AppMethodBeat.i(45626);
            boolean bDU = refreshSessionTask.bDU();
            AppMethodBeat.o(45626);
            return bDU;
        }

        static /* synthetic */ boolean b(RefreshSessionTask refreshSessionTask) {
            AppMethodBeat.i(45627);
            boolean bDU = refreshSessionTask.bDU();
            AppMethodBeat.o(45627);
            return bDU;
        }

        static /* synthetic */ boolean d(RefreshSessionTask refreshSessionTask) {
            AppMethodBeat.i(45628);
            boolean bDU = refreshSessionTask.bDU();
            AppMethodBeat.o(45628);
            return bDU;
        }

        static /* synthetic */ boolean e(RefreshSessionTask refreshSessionTask) {
            AppMethodBeat.i(45629);
            boolean bDU = refreshSessionTask.bDU();
            AppMethodBeat.o(45629);
            return bDU;
        }

        public RefreshSessionTask() {
        }

        public RefreshSessionTask(Parcel parcel) {
            AppMethodBeat.i(45621);
            f(parcel);
            AppMethodBeat.o(45621);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45622);
            bDJ();
            d.a aVar = new d.a();
            aVar.iLN = new cew();
            aVar.iLO = new cex();
            aVar.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
            aVar.funcId = 1196;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            cew cew = new cew();
            cew.jfi = this.appId;
            cew.MjZ = this.iOo;
            aVar.iLN = cew;
            if (this.lBE > 0) {
                cew.Mka = new fdg();
                cew.Mka.scene = this.lBE;
            }
            Log.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", this.appId, Integer.valueOf(this.iOo), Integer.valueOf(this.lBE));
            aa.a(aVar.aXF(), new aa.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession.RefreshSessionTask.AnonymousClass1 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                    AppMethodBeat.i(45619);
                    Log.d("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 && i3 == 0) {
                        cex cex = (cex) dVar.iLL.iLR;
                        if (cex == null || cex.Mkb == null) {
                            RefreshSessionTask.this.lBD = 0;
                            Log.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
                            RefreshSessionTask.b(RefreshSessionTask.this);
                        } else {
                            RefreshSessionTask.this.lBC = cex.Mkb.dIZ;
                            RefreshSessionTask.this.errorMsg = cex.Mkb.dJa;
                            if (RefreshSessionTask.this.lBC == 0) {
                                RefreshSessionTask.this.lBB = cex.Mku;
                                RefreshSessionTask.this.lBC = cex.Mkb.dIZ;
                                RefreshSessionTask.this.lBD = 1;
                                RefreshSessionTask.d(RefreshSessionTask.this);
                            } else {
                                RefreshSessionTask.this.lBC = cex.Mkb.dIZ;
                                RefreshSessionTask.this.lBD = 2;
                                Log.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", str);
                                RefreshSessionTask.e(RefreshSessionTask.this);
                            }
                        }
                        AppMethodBeat.o(45619);
                    } else {
                        RefreshSessionTask.this.lBD = 0;
                        RefreshSessionTask.this.errorMsg = "cgi fail";
                        RefreshSessionTask.a(RefreshSessionTask.this);
                        AppMethodBeat.o(45619);
                    }
                    return 0;
                }
            }, true);
            AppMethodBeat.o(45622);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String format;
            String format2;
            AppMethodBeat.i(45623);
            HashMap hashMap = new HashMap();
            switch (this.lBD) {
                case 1:
                    hashMap.put("expireIn", new StringBuilder().append(this.lBB).toString());
                    hashMap.put("errCode", new StringBuilder().append(this.lBC).toString());
                    this.lAx.i(this.lqe, this.lqf.n("ok", hashMap));
                    break;
                case 2:
                    if (Util.isNullOrNil(this.errorMsg)) {
                        format = "fail";
                    } else {
                        format = String.format("fail:%s", this.errorMsg);
                    }
                    hashMap.put("errCode", new StringBuilder().append(this.lBC).toString());
                    this.lAx.i(this.lqe, this.lqf.n(format, hashMap));
                    break;
                default:
                    if (Util.isNullOrNil(this.errorMsg)) {
                        format2 = "fail";
                    } else {
                        format2 = String.format("fail:%s", this.errorMsg);
                    }
                    hashMap.put("errCode", "-1");
                    this.lAx.i(this.lqe, this.lqf.n(format2, hashMap));
                    break;
            }
            bDK();
            AppMethodBeat.o(45623);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(45624);
            this.lBB = parcel.readInt();
            this.lBC = parcel.readInt();
            this.lBD = parcel.readInt();
            this.lqe = parcel.readInt();
            this.appId = parcel.readString();
            this.iOo = parcel.readInt();
            this.lBE = parcel.readInt();
            this.errorMsg = parcel.readString();
            AppMethodBeat.o(45624);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45625);
            parcel.writeInt(this.lBB);
            parcel.writeInt(this.lBC);
            parcel.writeInt(this.lBD);
            parcel.writeInt(this.lqe);
            parcel.writeString(this.appId);
            parcel.writeInt(this.iOo);
            parcel.writeInt(this.lBE);
            parcel.writeString(this.errorMsg);
            AppMethodBeat.o(45625);
        }

        static {
            AppMethodBeat.i(45630);
            AppMethodBeat.o(45630);
        }
    }
}
