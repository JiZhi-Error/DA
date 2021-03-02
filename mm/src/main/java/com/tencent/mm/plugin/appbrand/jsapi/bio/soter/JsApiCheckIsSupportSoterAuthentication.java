package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiCheckIsSupportSoterAuthentication extends d {
    public static final int CTRL_INDEX = 276;
    public static final String NAME = "checkIsSupportSoterAuthentication";
    private GetIsSupportSoterTask lKq = null;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(106588);
        Log.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
        this.lKq = new GetIsSupportSoterTask(fVar, i2, this);
        this.lKq.bDJ();
        AppBrandMainProcessService.a(this.lKq);
        AppMethodBeat.o(106588);
    }

    static class GetIsSupportSoterTask extends MainProcessTask {
        public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR = new Parcelable.Creator<GetIsSupportSoterTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication.GetIsSupportSoterTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetIsSupportSoterTask[] newArray(int i2) {
                return new GetIsSupportSoterTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetIsSupportSoterTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(106581);
                GetIsSupportSoterTask getIsSupportSoterTask = new GetIsSupportSoterTask(parcel);
                AppMethodBeat.o(106581);
                return getIsSupportSoterTask;
            }
        };
        private int csv = -1;
        private f kSY = null;
        private JsApiCheckIsSupportSoterAuthentication lKr;
        private int lKs = 0;

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(106582);
            super.bjk();
            Log.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", Integer.valueOf(this.lKs));
            HashMap hashMap = new HashMap(2);
            hashMap.put("supportMode", a.wO(this.lKs));
            this.kSY.i(this.csv, this.lKr.n("ok", hashMap));
            bDK();
            AppMethodBeat.o(106582);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(106583);
            jv jvVar = new jv();
            EventCenter.instance.publish(jvVar);
            this.lKs = jvVar.dON.dOO;
            Log.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", Integer.valueOf(this.lKs));
            bDU();
            AppMethodBeat.o(106583);
        }

        public GetIsSupportSoterTask(f fVar, int i2, JsApiCheckIsSupportSoterAuthentication jsApiCheckIsSupportSoterAuthentication) {
            this.kSY = fVar;
            this.csv = i2;
            this.lKr = jsApiCheckIsSupportSoterAuthentication;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(106584);
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.lKs);
            AppMethodBeat.o(106584);
        }

        protected GetIsSupportSoterTask(Parcel parcel) {
            AppMethodBeat.i(106585);
            f(parcel);
            AppMethodBeat.o(106585);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(106586);
            super.f(parcel);
            this.lKs = parcel.readInt();
            AppMethodBeat.o(106586);
        }

        static {
            AppMethodBeat.i(106587);
            AppMethodBeat.o(106587);
        }
    }
}
