package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import org.json.JSONObject;

public final class JsApiInstallDownloadTask extends d<f> {
    public static final int CTRL_INDEX = 442;
    public static final String NAME = "installDownloadTask";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45812);
        AppBrandMainProcessService.a(new InstallDownloadTask(this, fVar, i2, jSONObject));
        AppMethodBeat.o(45812);
    }

    static class InstallDownloadTask extends MainProcessTask {
        public static final Parcelable.Creator<InstallDownloadTask> CREATOR = new Parcelable.Creator<InstallDownloadTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask.InstallDownloadTask.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ InstallDownloadTask[] newArray(int i2) {
                return new InstallDownloadTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ InstallDownloadTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45804);
                InstallDownloadTask installDownloadTask = new InstallDownloadTask(parcel);
                AppMethodBeat.o(45804);
                return installDownloadTask;
            }
        };
        private int csv;
        private f kSY;
        private p lAi;
        private boolean lAq;
        private String lAr;
        private long lAs;
        private String mAppId;

        public InstallDownloadTask(p pVar, f fVar, int i2, JSONObject jSONObject) {
            AppMethodBeat.i(45805);
            this.lAi = pVar;
            this.kSY = fVar;
            this.csv = i2;
            this.lAs = jSONObject.optLong("downloadId");
            this.mAppId = jSONObject.optString("appId");
            this.lAq = true;
            AppMethodBeat.o(45805);
        }

        public InstallDownloadTask(Parcel parcel) {
            AppMethodBeat.i(45806);
            f(parcel);
            AppMethodBeat.o(45806);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String format;
            AppMethodBeat.i(45808);
            if (this.lAq) {
                if (Util.isNullOrNil(this.lAr)) {
                    format = "fail";
                } else {
                    format = String.format("fail:%s", this.lAr);
                }
                this.kSY.i(this.csv, this.lAi.h(format, null));
                AppMethodBeat.o(45808);
                return;
            }
            this.kSY.i(this.csv, this.lAi.h("ok", null));
            AppMethodBeat.o(45808);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(45809);
            this.lAs = parcel.readLong();
            this.mAppId = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.lAq = z;
            this.lAr = parcel.readString();
            AppMethodBeat.o(45809);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45810);
            parcel.writeLong(this.lAs);
            parcel.writeString(this.mAppId);
            parcel.writeInt(this.lAq ? 1 : 0);
            parcel.writeString(this.lAr);
            AppMethodBeat.o(45810);
        }

        static {
            AppMethodBeat.i(45811);
            AppMethodBeat.o(45811);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45807);
            Log.i("MicroMsg.JsApiInstallDownloadTask", "doInstallDownloadTask, downloadId = %d", Long.valueOf(this.lAs));
            if (!Util.isNullOrNil(this.mAppId)) {
                a alb = com.tencent.mm.plugin.downloader.model.d.alb(this.mAppId);
                if (alb != null && alb.field_status == 3 && s.YS(alb.field_filePath)) {
                    com.tencent.mm.plugin.downloader.i.a.a(alb.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask.InstallDownloadTask.AnonymousClass1 */

                        @Override // com.tencent.mm.pluginsdk.permission.a
                        public final void hk(boolean z) {
                            AppMethodBeat.i(45802);
                            InstallDownloadTask.this.lAq = !z;
                            AppMethodBeat.o(45802);
                        }
                    });
                }
            } else {
                a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(this.lAs);
                if (Cw != null && Cw.field_status == 3 && s.YS(Cw.field_filePath)) {
                    com.tencent.mm.plugin.downloader.i.a.a(Cw.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask.InstallDownloadTask.AnonymousClass2 */

                        @Override // com.tencent.mm.pluginsdk.permission.a
                        public final void hk(boolean z) {
                            AppMethodBeat.i(45803);
                            InstallDownloadTask.this.lAq = !z;
                            AppMethodBeat.o(45803);
                        }
                    });
                }
            }
            bDU();
            AppMethodBeat.o(45807);
        }
    }
}
