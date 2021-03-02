package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.finder.cgi.bt;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class JsApiGetFinderAccount extends d<s> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getFinderAccount";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(163954);
        GetFinderAccountTask getFinderAccountTask = new GetFinderAccountTask(sVar, i2);
        getFinderAccountTask.bDJ();
        AppBrandMainProcessService.a(getFinderAccountTask);
        AppMethodBeat.o(163954);
    }

    static class GetFinderAccountTask extends MainProcessTask implements i {
        public static final Parcelable.Creator<GetFinderAccountTask> CREATOR = new Parcelable.Creator<GetFinderAccountTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiGetFinderAccount.GetFinderAccountTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetFinderAccountTask[] newArray(int i2) {
                return new GetFinderAccountTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetFinderAccountTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(163946);
                GetFinderAccountTask getFinderAccountTask = new GetFinderAccountTask(parcel);
                AppMethodBeat.o(163946);
                return getFinderAccountTask;
            }
        };
        private s kGT;
        private String lVP;
        private int lqe;

        public GetFinderAccountTask(s sVar, int i2) {
            this.kGT = sVar;
            this.lqe = i2;
        }

        public GetFinderAccountTask(Parcel parcel) {
            AppMethodBeat.i(163947);
            f(parcel);
            AppMethodBeat.o(163947);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(163948);
            Log.i("MicroMsg.Finder.JsApiGetFinderAccount", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", this.kGT.getAppId(), this.lVP, Integer.valueOf(this.lqe), Boolean.valueOf(this.kGT.isRunning()));
            this.kGT.i(this.lqe, this.lVP);
            bDK();
            AppMethodBeat.o(163948);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(163949);
            bt btVar = new bt();
            g.azz().a(btVar.getType(), this);
            g.azz().a(btVar, 0);
            AppMethodBeat.o(163949);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(163950);
            this.lVP = parcel.readString();
            AppMethodBeat.o(163950);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(163951);
            parcel.writeString(this.lVP);
            AppMethodBeat.o(163951);
        }

        static {
            AppMethodBeat.i(163953);
            AppMethodBeat.o(163953);
        }

        @Override // com.tencent.mm.ak.i
        public void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(163952);
            g.azz().b(3930, this);
            JSONObject jSONObject = new JSONObject();
            if (i2 == 0 && i3 == 0) {
                try {
                    auc auc = ((bt) qVar).tvE;
                    if (!auc.LEN.isEmpty()) {
                        a.a(auc.LEN.get(0), jSONObject);
                        this.lVP = a.a("", 0, jSONObject);
                    } else {
                        this.lVP = a.a("not contact", -1, jSONObject);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Finder.JsApiGetFinderAccount", e2, "GetFinderAccountTask runInMainProcess", new Object[0]);
                    this.lVP = a.a(e2.getMessage(), -1, jSONObject);
                }
            } else if (i2 == 4) {
                this.lVP = a.a(str, i3, jSONObject);
            } else {
                this.lVP = a.a(str, -1, jSONObject);
            }
            bDU();
            AppMethodBeat.o(163952);
        }
    }
}
