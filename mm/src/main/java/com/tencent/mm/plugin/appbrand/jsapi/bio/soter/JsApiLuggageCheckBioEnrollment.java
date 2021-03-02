package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiLuggageCheckBioEnrollment extends d {
    public static final int CTRL_INDEX = 344;
    public static final String NAME = "checkIsSoterEnrolledInDevice";
    private static Context lKu = null;
    private GetIsEnrolledTask lKt;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(159041);
        lKu = fVar.getContext();
        Log.i("MicroMsg.JsApiLuggageCheckBioEnrollment", "hy: subapp start do check is enrolled");
        this.lKt = new GetIsEnrolledTask(fVar, i2, d.ZB(jSONObject.optString("checkAuthMode")), this);
        this.lKt.bDJ();
        AppBrandMainProcessService.a(this.lKt);
        AppMethodBeat.o(159041);
    }

    static class GetIsEnrolledTask extends MainProcessTask {
        public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR = new Parcelable.Creator<GetIsEnrolledTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment.GetIsEnrolledTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetIsEnrolledTask[] newArray(int i2) {
                return new GetIsEnrolledTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetIsEnrolledTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(159034);
                GetIsEnrolledTask getIsEnrolledTask = new GetIsEnrolledTask(parcel);
                AppMethodBeat.o(159034);
                return getIsEnrolledTask;
            }
        };
        private int csv = -1;
        private f kSY = null;
        private int lKo = -1;
        private int lKp = -1;
        private JsApiLuggageCheckBioEnrollment lKv;

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            boolean z = false;
            AppMethodBeat.i(159035);
            super.bjk();
            Log.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", Integer.valueOf(this.lKp));
            HashMap hashMap = new HashMap(2);
            if (this.lKp == 1) {
                z = true;
            }
            hashMap.put("isEnrolled", Boolean.valueOf(z));
            if (this.lKp == 0) {
                this.kSY.i(this.csv, this.lKv.n("ok", hashMap));
            } else if (this.lKp == -1) {
                this.kSY.i(this.csv, this.lKv.n("fail not support", hashMap));
            } else if (this.lKp == 1) {
                this.kSY.i(this.csv, this.lKv.n("ok", hashMap));
            } else {
                this.kSY.i(this.csv, this.lKv.n("fail unknown error", hashMap));
            }
            bDK();
            AppMethodBeat.o(159035);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            int i2;
            AppMethodBeat.i(159036);
            Context context = JsApiLuggageCheckBioEnrollment.lKu;
            if (this.lKo != 1) {
                i2 = -1;
            } else if (a.ld(context)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.lKp = i2;
            Log.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", Integer.valueOf(this.lKp));
            bDU();
            AppMethodBeat.o(159036);
        }

        public GetIsEnrolledTask(f fVar, int i2, int i3, JsApiLuggageCheckBioEnrollment jsApiLuggageCheckBioEnrollment) {
            this.kSY = fVar;
            this.csv = i2;
            this.lKv = jsApiLuggageCheckBioEnrollment;
            this.lKo = i3;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(159037);
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.lKp);
            parcel.writeInt(this.lKo);
            AppMethodBeat.o(159037);
        }

        protected GetIsEnrolledTask(Parcel parcel) {
            AppMethodBeat.i(159038);
            f(parcel);
            AppMethodBeat.o(159038);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(159039);
            super.f(parcel);
            this.lKp = parcel.readInt();
            this.lKo = parcel.readInt();
            AppMethodBeat.o(159039);
        }

        static {
            AppMethodBeat.i(159040);
            AppMethodBeat.o(159040);
        }
    }
}
