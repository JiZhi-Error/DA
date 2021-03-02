package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import org.json.JSONObject;

public final class JsApiWriteCommData extends d {
    public static final int CTRL_INDEX = 445;
    public static final String NAME = "writeCommData";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(139854);
        AppBrandMainProcessService.a(new WriteCommDataTask(this, fVar, i2, jSONObject));
        AppMethodBeat.o(139854);
    }

    static class WriteCommDataTask extends MainProcessTask {
        public static final Parcelable.Creator<WriteCommDataTask> CREATOR = new Parcelable.Creator<WriteCommDataTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData.WriteCommDataTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WriteCommDataTask[] newArray(int i2) {
                return new WriteCommDataTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WriteCommDataTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(139846);
                WriteCommDataTask writeCommDataTask = new WriteCommDataTask(parcel);
                AppMethodBeat.o(139846);
                return writeCommDataTask;
            }
        };
        private int csv;
        private f kSY;
        private p lAi;
        private boolean lAq;
        private String lAr;
        private String mData;
        private String mPackageName;

        public WriteCommDataTask(p pVar, f fVar, int i2, JSONObject jSONObject) {
            AppMethodBeat.i(139847);
            this.lAi = pVar;
            this.kSY = fVar;
            this.csv = i2;
            this.mPackageName = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
            this.mData = jSONObject.optString("data");
            this.lAq = true;
            AppMethodBeat.o(139847);
        }

        public WriteCommDataTask(Parcel parcel) {
            AppMethodBeat.i(139848);
            f(parcel);
            AppMethodBeat.o(139848);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String format;
            AppMethodBeat.i(139850);
            if (this.lAq) {
                if (Util.isNullOrNil(this.lAr)) {
                    format = "fail";
                } else {
                    format = String.format("fail:%s", this.lAr);
                }
                this.kSY.i(this.csv, this.lAi.h(format, null));
                AppMethodBeat.o(139850);
                return;
            }
            this.kSY.i(this.csv, this.lAi.h("ok", null));
            AppMethodBeat.o(139850);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(139851);
            this.mPackageName = parcel.readString();
            this.mData = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.lAq = z;
            this.lAr = parcel.readString();
            AppMethodBeat.o(139851);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(139852);
            parcel.writeString(this.mPackageName);
            parcel.writeString(this.mData);
            parcel.writeInt(this.lAq ? 1 : 0);
            parcel.writeString(this.lAr);
            AppMethodBeat.o(139852);
        }

        static {
            AppMethodBeat.i(139853);
            AppMethodBeat.o(139853);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            boolean z = false;
            AppMethodBeat.i(139849);
            if (Util.isNullOrNil(this.mPackageName)) {
                Log.e("MicroMsg.JsApiWriteCommData", "packageName nil");
            } else {
                if (!MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getPackageName() + "_comm_preferences", 0).edit().putString(this.mPackageName, this.mData).commit()) {
                    z = true;
                }
                this.lAq = z;
            }
            bDU();
            AppMethodBeat.o(139849);
        }
    }
}
