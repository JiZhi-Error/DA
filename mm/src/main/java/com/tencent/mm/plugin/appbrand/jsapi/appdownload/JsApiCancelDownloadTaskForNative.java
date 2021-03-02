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

public final class JsApiCancelDownloadTaskForNative extends d<s> {
    public static final int CTRL_INDEX = 657;
    public static final String NAME = "cancelDownloadTaskForNative";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45788);
        s sVar2 = sVar;
        Log.d("MicroMsg.JsApiCancelDownloadTaskForNative", "invoke");
        JSONArray optJSONArray = jSONObject.optJSONArray("downloadIdArray");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            Log.e("MicroMsg.JsApiCancelDownloadTaskForNative", "doCancelDownloadTask fail, invalid downloadIdArray");
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(45788);
            return;
        }
        AppBrandMainProcessService.a(new CancelDownloadTask(optJSONArray, this, sVar2, i2));
        AppMethodBeat.o(45788);
    }

    static class CancelDownloadTask extends MainProcessTask {
        public static Parcelable.Creator<CancelDownloadTask> CREATOR = new Parcelable.Creator<CancelDownloadTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTaskForNative.CancelDownloadTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ CancelDownloadTask[] newArray(int i2) {
                return new CancelDownloadTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CancelDownloadTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45780);
                CancelDownloadTask cancelDownloadTask = new CancelDownloadTask(parcel, (byte) 0);
                AppMethodBeat.o(45780);
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
            AppMethodBeat.i(45781);
            if (this.lDd != null && this.lDd.length() > 0) {
                for (int i2 = 0; i2 < this.lDd.length(); i2++) {
                    long optLong = this.lDd.optLong(i2);
                    a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(optLong);
                    if (Cw == null || Cw.field_status != 3) {
                        f.cBv().Cn(optLong);
                    } else {
                        Log.i("MicroMsg.JsApiCancelDownloadTaskForNative", "canceldownloadtask, path: %s", Cw.field_filePath);
                        com.tencent.mm.vfs.s.deleteFile(Cw.field_filePath);
                        com.tencent.mm.plugin.downloader.model.d.alc(Cw.field_downloadUrl);
                    }
                }
            }
            bDU();
            AppMethodBeat.o(45781);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(45782);
            bDK();
            this.kGT.i(this.lqe, this.lDe.h("ok", null));
            AppMethodBeat.o(45782);
        }

        public CancelDownloadTask(JSONArray jSONArray, d dVar, s sVar, int i2) {
            AppMethodBeat.i(45783);
            bDJ();
            this.lDd = jSONArray;
            this.lDe = dVar;
            this.kGT = sVar;
            this.lqe = i2;
            AppMethodBeat.o(45783);
        }

        private CancelDownloadTask(Parcel parcel) {
            AppMethodBeat.i(45784);
            f(parcel);
            AppMethodBeat.o(45784);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(45785);
            String readString = parcel.readString();
            if (readString != null) {
                try {
                    this.lDd = new JSONArray(readString);
                    AppMethodBeat.o(45785);
                    return;
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiCancelDownloadTaskForNative", "parseFromParcel: " + e2.getMessage());
                }
            }
            AppMethodBeat.o(45785);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45786);
            parcel.writeString(this.lDd != null ? this.lDd.toString() : null);
            AppMethodBeat.o(45786);
        }

        static {
            AppMethodBeat.i(45787);
            AppMethodBeat.o(45787);
        }
    }
}
