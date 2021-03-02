package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiCheckIsSupportFaceDetect extends d {
    public static final int CTRL_INDEX = 214;
    public static final String NAME = "checkIsSupportFacialRecognition";
    private GetIsSupportFaceTask lKf = null;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(106565);
        Log.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
        this.lKf = new GetIsSupportFaceTask(fVar, i2, this);
        this.lKf.bDJ();
        AppBrandMainProcessService.a(this.lKf);
        AppMethodBeat.o(106565);
    }

    static class GetIsSupportFaceTask extends MainProcessTask {
        public static final Parcelable.Creator<GetIsSupportFaceTask> CREATOR = new Parcelable.Creator<GetIsSupportFaceTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect.GetIsSupportFaceTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetIsSupportFaceTask[] newArray(int i2) {
                return new GetIsSupportFaceTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetIsSupportFaceTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(106558);
                GetIsSupportFaceTask getIsSupportFaceTask = new GetIsSupportFaceTask(parcel);
                AppMethodBeat.o(106558);
                return getIsSupportFaceTask;
            }
        };
        private int csv = -1;
        private boolean edB = false;
        private int errCode = -1;
        private String errMsg = "not returned";
        private f kSY = null;
        private JsApiCheckIsSupportFaceDetect lKg;
        private int lKh = -1;

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(106559);
            super.bjk();
            Log.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", Boolean.valueOf(this.edB), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.lKh));
            HashMap hashMap = new HashMap(3);
            hashMap.put("errCode", Integer.valueOf(this.errCode));
            hashMap.put("libVersionCode", Integer.valueOf(this.lKh));
            if (this.errCode == 0) {
                this.kSY.i(this.csv, this.lKg.n("ok", hashMap));
            } else {
                this.kSY.i(this.csv, this.lKg.n("fail " + this.errMsg, hashMap));
            }
            bDK();
            AppMethodBeat.o(106559);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(106560);
            ju juVar = new ju();
            EventCenter.instance.publish(juVar);
            this.edB = juVar.dOI.dOJ;
            this.errCode = juVar.dOI.dOK;
            this.errMsg = juVar.dOI.dOL;
            this.lKh = juVar.dOI.dOM;
            Log.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", Boolean.valueOf(this.edB), Integer.valueOf(this.errCode), this.errMsg, Integer.valueOf(this.lKh));
            bDU();
            AppMethodBeat.o(106560);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(106561);
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.edB ? (byte) 1 : 0);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.errMsg);
            parcel.writeInt(this.lKh);
            AppMethodBeat.o(106561);
        }

        public GetIsSupportFaceTask(f fVar, int i2, JsApiCheckIsSupportFaceDetect jsApiCheckIsSupportFaceDetect) {
            this.kSY = fVar;
            this.csv = i2;
            this.lKg = jsApiCheckIsSupportFaceDetect;
        }

        protected GetIsSupportFaceTask(Parcel parcel) {
            AppMethodBeat.i(106562);
            f(parcel);
            AppMethodBeat.o(106562);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(106563);
            super.f(parcel);
            this.edB = parcel.readByte() != 0;
            this.errCode = parcel.readInt();
            this.errMsg = parcel.readString();
            this.lKh = parcel.readInt();
            AppMethodBeat.o(106563);
        }

        static {
            AppMethodBeat.i(106564);
            AppMethodBeat.o(106564);
        }
    }
}
