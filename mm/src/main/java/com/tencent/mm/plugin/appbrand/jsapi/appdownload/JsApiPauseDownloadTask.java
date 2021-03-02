package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiPauseDownloadTask extends d<c> {
    public static final int CTRL_INDEX = 443;
    public static final String NAME = "pauseDownloadTask";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45858);
        AppBrandMainProcessService.a(new PauseDownloadTask(this, cVar, i2, jSONObject));
        AppMethodBeat.o(45858);
    }

    static class PauseDownloadTask extends MainProcessTask {
        public static final Parcelable.Creator<PauseDownloadTask> CREATOR = new Parcelable.Creator<PauseDownloadTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask.PauseDownloadTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PauseDownloadTask[] newArray(int i2) {
                return new PauseDownloadTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PauseDownloadTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45850);
                PauseDownloadTask pauseDownloadTask = new PauseDownloadTask(parcel);
                AppMethodBeat.o(45850);
                return pauseDownloadTask;
            }
        };
        private int csv;
        private s kAr;
        private p lAi;
        private boolean lAq;
        private String lAr;
        private long lAs;

        public PauseDownloadTask(p pVar, s sVar, int i2, JSONObject jSONObject) {
            AppMethodBeat.i(45851);
            this.lAi = pVar;
            this.kAr = sVar;
            this.csv = i2;
            this.lAs = jSONObject.optLong("downloadId");
            this.lAq = true;
            AppMethodBeat.o(45851);
        }

        public PauseDownloadTask(Parcel parcel) {
            AppMethodBeat.i(45852);
            f(parcel);
            AppMethodBeat.o(45852);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String format;
            AppMethodBeat.i(45854);
            if (this.lAq) {
                if (Util.isNullOrNil(this.lAr)) {
                    format = "fail";
                } else {
                    format = String.format("fail:%s", this.lAr);
                }
                this.kAr.i(this.csv, this.lAi.h(format, null));
                AppMethodBeat.o(45854);
                return;
            }
            this.kAr.i(this.csv, this.lAi.h("ok", null));
            AppMethodBeat.o(45854);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(45855);
            this.lAs = parcel.readLong();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.lAq = z;
            this.lAr = parcel.readString();
            AppMethodBeat.o(45855);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45856);
            parcel.writeLong(this.lAs);
            parcel.writeInt(this.lAq ? 1 : 0);
            parcel.writeString(this.lAr);
            AppMethodBeat.o(45856);
        }

        static {
            AppMethodBeat.i(45857);
            AppMethodBeat.o(45857);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            boolean z = true;
            AppMethodBeat.i(45853);
            Log.i("MicroMsg.JsApiPauseDownloadTask", "doPauseDownloadTask, downloadId = %d", Long.valueOf(this.lAs));
            if (this.lAs <= 0) {
                this.lAr = "downloadId invalid";
            } else {
                a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(this.lAs);
                if (Cw == null) {
                    this.lAr = "downloadId invalid";
                } else {
                    if (Cw.field_downloadInWifi) {
                        Cw.field_downloadInWifi = false;
                        com.tencent.mm.plugin.downloader.model.d.e(Cw);
                    }
                    if (f.cBv().Cp(this.lAs)) {
                        z = false;
                    }
                    this.lAq = z;
                }
            }
            bDU();
            AppMethodBeat.o(45853);
        }
    }
}
