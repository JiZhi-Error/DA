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

public final class JsApiInstallDownloadTaskForNative extends d<f> {
    public static final int CTRL_INDEX = 658;
    public static final String NAME = "installDownloadTaskForNative";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45823);
        AppBrandMainProcessService.a(new InstallDownloadTask(this, fVar, i2, jSONObject));
        AppMethodBeat.o(45823);
    }

    static class InstallDownloadTask extends MainProcessTask {
        public static final Parcelable.Creator<InstallDownloadTask> CREATOR = new Parcelable.Creator<InstallDownloadTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTaskForNative.InstallDownloadTask.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ InstallDownloadTask[] newArray(int i2) {
                return new InstallDownloadTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ InstallDownloadTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45815);
                InstallDownloadTask installDownloadTask = new InstallDownloadTask(parcel);
                AppMethodBeat.o(45815);
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
            AppMethodBeat.i(45816);
            this.lAi = pVar;
            this.kSY = fVar;
            this.csv = i2;
            this.lAs = jSONObject.optLong("downloadId");
            this.mAppId = jSONObject.optString("appId");
            this.lAq = true;
            AppMethodBeat.o(45816);
        }

        public InstallDownloadTask(Parcel parcel) {
            AppMethodBeat.i(45817);
            f(parcel);
            AppMethodBeat.o(45817);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String format;
            AppMethodBeat.i(45819);
            if (this.lAq) {
                if (Util.isNullOrNil(this.lAr)) {
                    format = "fail";
                } else {
                    format = String.format("fail:%s", this.lAr);
                }
                this.kSY.i(this.csv, this.lAi.h(format, null));
                AppMethodBeat.o(45819);
                return;
            }
            this.kSY.i(this.csv, this.lAi.h("ok", null));
            AppMethodBeat.o(45819);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(45820);
            this.lAs = parcel.readLong();
            this.mAppId = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.lAq = z;
            this.lAr = parcel.readString();
            AppMethodBeat.o(45820);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45821);
            parcel.writeLong(this.lAs);
            parcel.writeString(this.mAppId);
            parcel.writeInt(this.lAq ? 1 : 0);
            parcel.writeString(this.lAr);
            AppMethodBeat.o(45821);
        }

        static {
            AppMethodBeat.i(45822);
            AppMethodBeat.o(45822);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45818);
            Log.i("MicroMsg.JsApiInstallDownloadTaskForNative", "doInstallDownloadTask, downloadId = %d", Long.valueOf(this.lAs));
            if (!Util.isNullOrNil(this.mAppId)) {
                a alb = com.tencent.mm.plugin.downloader.model.d.alb(this.mAppId);
                if (alb != null && alb.field_status == 3 && s.YS(alb.field_filePath)) {
                    com.tencent.mm.plugin.downloader.i.a.a(alb.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTaskForNative.InstallDownloadTask.AnonymousClass1 */

                        @Override // com.tencent.mm.pluginsdk.permission.a
                        public final void hk(boolean z) {
                            AppMethodBeat.i(45813);
                            InstallDownloadTask.this.lAq = !z;
                            AppMethodBeat.o(45813);
                        }
                    });
                }
            } else {
                a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(this.lAs);
                if (Cw != null && Cw.field_status == 3 && s.YS(Cw.field_filePath)) {
                    com.tencent.mm.plugin.downloader.i.a.a(Cw.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTaskForNative.InstallDownloadTask.AnonymousClass2 */

                        @Override // com.tencent.mm.pluginsdk.permission.a
                        public final void hk(boolean z) {
                            AppMethodBeat.i(45814);
                            InstallDownloadTask.this.lAq = !z;
                            AppMethodBeat.o(45814);
                        }
                    });
                }
            }
            bDU();
            AppMethodBeat.o(45818);
        }
    }
}
