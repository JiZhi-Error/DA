package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.ens;
import com.tencent.mm.protocal.protobuf.ent;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class JsApiUploadWeRunData extends d {
    public static final int CTRL_INDEX = 323;
    public static final String NAME = "uploadWeRunData";
    private UploadMiniAppStepTask lCp;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45717);
        Log.d("MicroMsg.JsApiUploadWeRunData", "JsApiUploadWeRunData!");
        if (jSONObject == null) {
            fVar.i(i2, h("fail:data is null", null));
            Log.e("MicroMsg.JsApiUploadWeRunData", "data is null");
            AppMethodBeat.o(45717);
            return;
        }
        a(this, fVar, i2, jSONObject.optInt("step"), false);
        AppMethodBeat.o(45717);
    }

    public final void a(p pVar, f fVar, int i2, int i3, boolean z) {
        AppMethodBeat.i(45718);
        if (i3 <= 0) {
            fVar.i(i2, pVar.h("fail:step invalid", null));
            AppMethodBeat.o(45718);
            return;
        }
        this.lCp = new UploadMiniAppStepTask(pVar, fVar, i2, i3, z);
        this.lCp.bDJ();
        AppBrandMainProcessService.a(this.lCp);
        AppMethodBeat.o(45718);
    }

    /* access modifiers changed from: package-private */
    public static class UploadMiniAppStepTask extends MainProcessTask {
        public static final Parcelable.Creator<UploadMiniAppStepTask> CREATOR = new Parcelable.Creator<UploadMiniAppStepTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData.UploadMiniAppStepTask.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ UploadMiniAppStepTask[] newArray(int i2) {
                return new UploadMiniAppStepTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ UploadMiniAppStepTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45708);
                UploadMiniAppStepTask uploadMiniAppStepTask = new UploadMiniAppStepTask(parcel);
                AppMethodBeat.o(45708);
                return uploadMiniAppStepTask;
            }
        };
        private String appId;
        private boolean dGX;
        private p lAw;
        private f lAx;
        private int lCq;
        private boolean lCr;
        private int lqe;

        static /* synthetic */ boolean a(UploadMiniAppStepTask uploadMiniAppStepTask) {
            AppMethodBeat.i(45715);
            boolean bDU = uploadMiniAppStepTask.bDU();
            AppMethodBeat.o(45715);
            return bDU;
        }

        public UploadMiniAppStepTask(p pVar, f fVar, int i2, int i3, boolean z) {
            AppMethodBeat.i(45709);
            Log.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask");
            this.lAw = pVar;
            this.lAx = fVar;
            this.lqe = i2;
            this.lCq = i3;
            this.lCr = z;
            this.appId = fVar.getAppId();
            AppMethodBeat.o(45709);
        }

        public UploadMiniAppStepTask(Parcel parcel) {
            AppMethodBeat.i(45710);
            f(parcel);
            AppMethodBeat.o(45710);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45711);
            long aWy = cl.aWy();
            Log.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask currentTime %d", Long.valueOf(aWy / 1000));
            if (aWy == 0) {
                aWy = System.currentTimeMillis();
            }
            d.a aVar = new d.a();
            ens ens = new ens();
            aVar.iLN = ens;
            aVar.iLO = new ent();
            aVar.uri = "/cgi-bin/mmoc-bin/hardware/uploadminiappstep";
            aVar.funcId = 1949;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            ens.jfi = this.appId;
            ens.oUu = this.lCq;
            ens.NlA = this.lCr;
            ens.hil = (int) (aWy / 1000);
            aa.a(aVar.aXF(), new aa.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData.UploadMiniAppStepTask.AnonymousClass1 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                    AppMethodBeat.i(45707);
                    if (qVar.getType() != 1949) {
                        AppMethodBeat.o(45707);
                    } else {
                        if (i2 == 0 && i3 == 0) {
                            UploadMiniAppStepTask.this.dGX = true;
                            Log.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask ok.");
                        } else {
                            UploadMiniAppStepTask.this.dGX = false;
                            Log.i("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask fail: errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        }
                        UploadMiniAppStepTask.a(UploadMiniAppStepTask.this);
                        AppMethodBeat.o(45707);
                    }
                    return 0;
                }
            }, true);
            AppMethodBeat.o(45711);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(45712);
            if (this.dGX) {
                this.lAx.i(this.lqe, this.lAw.h("ok", null));
            } else {
                this.lAx.i(this.lqe, this.lAw.h("fail", null));
            }
            bDK();
            AppMethodBeat.o(45712);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(45713);
            this.lCq = parcel.readInt();
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.lCr = z;
            if (parcel.readByte() == 0) {
                z2 = false;
            }
            this.dGX = z2;
            this.appId = parcel.readString();
            AppMethodBeat.o(45713);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            byte b2;
            byte b3 = 1;
            AppMethodBeat.i(45714);
            parcel.writeInt(this.lCq);
            if (this.lCr) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            parcel.writeByte(b2);
            if (!this.dGX) {
                b3 = 0;
            }
            parcel.writeByte(b3);
            parcel.writeString(this.appId);
            AppMethodBeat.o(45714);
        }

        static {
            AppMethodBeat.i(45716);
            AppMethodBeat.o(45716);
        }
    }
}
