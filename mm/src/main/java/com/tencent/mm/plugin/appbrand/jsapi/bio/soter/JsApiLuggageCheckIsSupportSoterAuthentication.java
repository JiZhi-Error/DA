package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

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

public final class JsApiLuggageCheckIsSupportSoterAuthentication extends d {
    public static final int CTRL_INDEX = 276;
    public static final String NAME = "checkIsSupportSoterAuthentication";
    private GetIsSupportSoterTask lKw;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(159049);
        Log.i("MicroMsg.JsApiLuggageCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
        this.lKw = new GetIsSupportSoterTask(fVar, i2, this);
        this.lKw.bDJ();
        AppBrandMainProcessService.a(this.lKw);
        AppMethodBeat.o(159049);
    }

    static class GetIsSupportSoterTask extends MainProcessTask {
        public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR = new Parcelable.Creator<GetIsSupportSoterTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckIsSupportSoterAuthentication.GetIsSupportSoterTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetIsSupportSoterTask[] newArray(int i2) {
                return new GetIsSupportSoterTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetIsSupportSoterTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(159042);
                GetIsSupportSoterTask getIsSupportSoterTask = new GetIsSupportSoterTask(parcel);
                AppMethodBeat.o(159042);
                return getIsSupportSoterTask;
            }
        };
        private int csv = -1;
        private f kSY = null;
        private JsApiLuggageCheckIsSupportSoterAuthentication lKx;
        private String lKy = "";

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(159043);
            super.bjk();
            Log.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. verifyRemoteStr: %s", this.lKy);
            HashMap hashMap = new HashMap(2);
            hashMap.put("verifyRemote", this.lKy);
            hashMap.put("nativeSupport", Boolean.valueOf(a.hlj()));
            Log.i("MicroMsg.GetIsSupportSoterTask", "hy: nativeSupport:" + a.hlj());
            this.kSY.i(this.csv, this.lKx.n("ok", hashMap));
            bDK();
            AppMethodBeat.o(159043);
        }

        public GetIsSupportSoterTask(f fVar, int i2, JsApiLuggageCheckIsSupportSoterAuthentication jsApiLuggageCheckIsSupportSoterAuthentication) {
            this.kSY = fVar;
            this.csv = i2;
            this.lKx = jsApiLuggageCheckIsSupportSoterAuthentication;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(159045);
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.lKy);
            AppMethodBeat.o(159045);
        }

        protected GetIsSupportSoterTask(Parcel parcel) {
            AppMethodBeat.i(159046);
            f(parcel);
            AppMethodBeat.o(159046);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(159047);
            super.f(parcel);
            this.lKy = parcel.readString();
            AppMethodBeat.o(159047);
        }

        static {
            AppMethodBeat.i(159048);
            AppMethodBeat.o(159048);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(159044);
            this.lKy = a.hlp();
            Log.i("MicroMsg.GetIsSupportSoterTask", "hy: verifyRemoteStr: %s", this.lKy);
            bDU();
            AppMethodBeat.o(159044);
        }
    }
}
