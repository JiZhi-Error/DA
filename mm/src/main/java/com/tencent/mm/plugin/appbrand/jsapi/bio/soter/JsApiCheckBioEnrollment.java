package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiCheckBioEnrollment extends d {
    public static final int CTRL_INDEX = 344;
    public static final String NAME = "checkIsSoterEnrolledInDevice";
    private GetIsEnrolledTask lKm = null;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(106580);
        Log.i("MicroMsg.JsApiCheckBioEnrollment", "hy: subapp start do check is enrolled");
        this.lKm = new GetIsEnrolledTask(fVar, i2, a.ZB(jSONObject.optString("checkAuthMode")), this);
        this.lKm.bDJ();
        AppBrandMainProcessService.a(this.lKm);
        AppMethodBeat.o(106580);
    }

    static class GetIsEnrolledTask extends MainProcessTask {
        public static final Parcelable.Creator<GetIsEnrolledTask> CREATOR = new Parcelable.Creator<GetIsEnrolledTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment.GetIsEnrolledTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetIsEnrolledTask[] newArray(int i2) {
                return new GetIsEnrolledTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetIsEnrolledTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(106573);
                GetIsEnrolledTask getIsEnrolledTask = new GetIsEnrolledTask(parcel);
                AppMethodBeat.o(106573);
                return getIsEnrolledTask;
            }
        };
        private int csv = -1;
        private f kSY = null;
        private JsApiCheckBioEnrollment lKn;
        private int lKo = -1;
        private int lKp = -1;

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            boolean z = false;
            AppMethodBeat.i(106574);
            super.bjk();
            Log.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", Integer.valueOf(this.lKp));
            HashMap hashMap = new HashMap(2);
            if (this.lKp == 1) {
                z = true;
            }
            hashMap.put("isEnrolled", Boolean.valueOf(z));
            if (this.lKp == 0) {
                this.kSY.i(this.csv, this.lKn.n("ok", hashMap));
            } else if (this.lKp == -1) {
                this.kSY.i(this.csv, this.lKn.n("fail not support", hashMap));
            } else if (this.lKp == 1) {
                this.kSY.i(this.csv, this.lKn.n("ok", hashMap));
            } else {
                this.kSY.i(this.csv, this.lKn.n("fail unknown error", hashMap));
            }
            bDK();
            AppMethodBeat.o(106574);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(106575);
            jt jtVar = new jt();
            jtVar.dOE.dOG = this.lKo;
            EventCenter.instance.publish(jtVar);
            this.lKp = jtVar.dOF.dOH;
            Log.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", Integer.valueOf(this.lKp));
            bDU();
            AppMethodBeat.o(106575);
        }

        public GetIsEnrolledTask(f fVar, int i2, int i3, JsApiCheckBioEnrollment jsApiCheckBioEnrollment) {
            this.kSY = fVar;
            this.csv = i2;
            this.lKn = jsApiCheckBioEnrollment;
            this.lKo = i3;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(106576);
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.lKp);
            parcel.writeInt(this.lKo);
            AppMethodBeat.o(106576);
        }

        protected GetIsEnrolledTask(Parcel parcel) {
            AppMethodBeat.i(106577);
            f(parcel);
            AppMethodBeat.o(106577);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(106578);
            super.f(parcel);
            this.lKp = parcel.readInt();
            this.lKo = parcel.readInt();
            AppMethodBeat.o(106578);
        }

        static {
            AppMethodBeat.i(106579);
            AppMethodBeat.o(106579);
        }
    }
}
