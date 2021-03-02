package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiCancelDownloadTask extends d<s> {
    public static final int CTRL_INDEX = 475;
    public static final String NAME = "cancelDownloadTask";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45779);
        s sVar2 = sVar;
        Log.d("MicroMsg.JsApiCancelDownloadTask", "invoke");
        JSONArray optJSONArray = jSONObject.optJSONArray("downloadIdArray");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            Log.e("MicroMsg.JsApiCancelDownloadTask", "doCancelDownloadTask fail, invalid downloadIdArray");
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(45779);
            return;
        }
        AppBrandMainProcessService.a(new CancelDownloadTask(optJSONArray, this, sVar2, i2));
        AppMethodBeat.o(45779);
    }

    static class CancelDownloadTask extends MainProcessTask {
        public static Parcelable.Creator<CancelDownloadTask> CREATOR = new Parcelable.Creator<CancelDownloadTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask.CancelDownloadTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ CancelDownloadTask[] newArray(int i2) {
                return new CancelDownloadTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CancelDownloadTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45771);
                CancelDownloadTask cancelDownloadTask = new CancelDownloadTask(parcel, (byte) 0);
                AppMethodBeat.o(45771);
                return cancelDownloadTask;
            }
        };
        private s kGT;
        private JSONArray lDd;
        private d lDe;
        private int lqe;

        /* synthetic */ CancelDownloadTask(Parcel parcel, byte b2) {
            this(parcel);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45772);
            if (this.lDd != null && this.lDd.length() > 0) {
                for (int i2 = 0; i2 < this.lDd.length(); i2++) {
                    long optLong = this.lDd.optLong(i2);
                    a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(optLong);
                    if (Cw == null || Cw.field_status != 3) {
                        f.cBv().Cn(optLong);
                    } else {
                        Log.i("MicroMsg.JsApiCancelDownloadTask", "canceldownloadtask, path: %s", Cw.field_filePath);
                        com.tencent.mm.vfs.s.deleteFile(Cw.field_filePath);
                        com.tencent.mm.plugin.downloader.model.d.alc(Cw.field_downloadUrl);
                    }
                }
            }
            bDU();
            AppMethodBeat.o(45772);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(45773);
            bDK();
            this.kGT.i(this.lqe, this.lDe.h("ok", null));
            AppMethodBeat.o(45773);
        }

        public CancelDownloadTask(JSONArray jSONArray, d dVar, s sVar, int i2) {
            AppMethodBeat.i(45774);
            bDJ();
            this.lDd = jSONArray;
            this.lDe = dVar;
            this.kGT = sVar;
            this.lqe = i2;
            AppMethodBeat.o(45774);
        }

        private CancelDownloadTask(Parcel parcel) {
            AppMethodBeat.i(45775);
            f(parcel);
            AppMethodBeat.o(45775);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(45776);
            String readString = parcel.readString();
            if (readString != null) {
                try {
                    this.lDd = new JSONArray(readString);
                    AppMethodBeat.o(45776);
                    return;
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiCancelDownloadTask", "parseFromParcel: " + e2.getMessage());
                }
            }
            AppMethodBeat.o(45776);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45777);
            parcel.writeString(this.lDd != null ? this.lDd.toString() : null);
            AppMethodBeat.o(45777);
        }

        static {
            AppMethodBeat.i(45778);
            AppMethodBeat.o(45778);
        }
    }
}
