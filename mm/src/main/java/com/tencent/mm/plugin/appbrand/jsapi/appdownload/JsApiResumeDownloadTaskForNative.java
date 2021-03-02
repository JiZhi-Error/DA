package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiResumeDownloadTaskForNative extends d<s> {
    public static final int CTRL_INDEX = 660;
    public static final String NAME = "resumeDownloadTaskForNative";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45901);
        s sVar2 = sVar;
        AppBrandMainProcessService.a(new ResumeDownloadTask(this, sVar2, i2, jSONObject));
        d.n(sVar2);
        AppMethodBeat.o(45901);
    }

    static class ResumeDownloadTask extends MainProcessTask {
        public static final Parcelable.Creator<ResumeDownloadTask> CREATOR = new Parcelable.Creator<ResumeDownloadTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiResumeDownloadTaskForNative.ResumeDownloadTask.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ResumeDownloadTask[] newArray(int i2) {
                return new ResumeDownloadTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ResumeDownloadTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45893);
                ResumeDownloadTask resumeDownloadTask = new ResumeDownloadTask(parcel);
                AppMethodBeat.o(45893);
                return resumeDownloadTask;
            }
        };
        private int csv;
        private s kAr;
        private p lAi;
        private boolean lAq;
        private String lAr;
        private long lAs;
        private boolean lBG;
        private boolean lDa;

        public ResumeDownloadTask(p pVar, s sVar, int i2, JSONObject jSONObject) {
            AppMethodBeat.i(45894);
            this.lAi = pVar;
            this.kAr = sVar;
            this.csv = i2;
            this.lAs = jSONObject.optLong("downloadId");
            this.lDa = jSONObject.optBoolean("useDownloaderWidget", false);
            this.lBG = jSONObject.optBoolean("downloadInWifi", false);
            this.lAq = true;
            AppMethodBeat.o(45894);
        }

        public ResumeDownloadTask(Parcel parcel) {
            AppMethodBeat.i(45895);
            f(parcel);
            AppMethodBeat.o(45895);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String format;
            AppMethodBeat.i(45897);
            if (this.lAq) {
                if (Util.isNullOrNil(this.lAr)) {
                    format = "fail";
                } else {
                    format = String.format("fail:%s", this.lAr);
                }
                this.kAr.i(this.csv, this.lAi.h(format, null));
                AppMethodBeat.o(45897);
                return;
            }
            this.kAr.i(this.csv, this.lAi.h("ok", null));
            AppMethodBeat.o(45897);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            AppMethodBeat.i(45898);
            this.lAs = parcel.readLong();
            if (parcel.readByte() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.lBG = z;
            if (parcel.readInt() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.lAq = z2;
            this.lAr = parcel.readString();
            if (parcel.readInt() != 1) {
                z3 = false;
            }
            this.lDa = z3;
            AppMethodBeat.o(45898);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            byte b2;
            int i3;
            int i4 = 1;
            AppMethodBeat.i(45899);
            parcel.writeLong(this.lAs);
            if (this.lBG) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            parcel.writeByte(b2);
            if (this.lAq) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeString(this.lAr);
            if (!this.lDa) {
                i4 = 0;
            }
            parcel.writeInt(i4);
            AppMethodBeat.o(45899);
        }

        static {
            AppMethodBeat.i(45900);
            AppMethodBeat.o(45900);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            boolean z = false;
            AppMethodBeat.i(45896);
            Log.i("MicroMsg.JsApiResumeDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", Long.valueOf(this.lAs));
            if (this.lAs <= 0) {
                this.lAr = "downloadId invalid";
            } else if (this.lDa) {
                o.a(MMApplicationContext.getContext(), this.lAs, this.lBG, false, new o.a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiResumeDownloadTaskForNative.ResumeDownloadTask.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.downloader.model.o.a
                    public final void i(String str, JSONObject jSONObject) {
                        AppMethodBeat.i(45892);
                        if (Util.isNullOrNil(str)) {
                            ResumeDownloadTask.this.lAq = false;
                            AppMethodBeat.o(45892);
                            return;
                        }
                        ResumeDownloadTask.this.lAq = true;
                        AppMethodBeat.o(45892);
                    }
                });
                com.tencent.mm.modelstat.d.d(10, "JsApiResumeDownloadApp_resumeDownloadTask", hashCode());
            } else {
                a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(this.lAs);
                if (Cw != null) {
                    Cw.field_downloadInWifi = false;
                    Cw.field_fromDownloadApp = false;
                    Cw.field_showNotification = true;
                    com.tencent.mm.plugin.downloader.model.d.e(Cw);
                }
                if (!f.cBv().Cq(this.lAs)) {
                    z = true;
                }
                this.lAq = z;
            }
            bDU();
            AppMethodBeat.o(45896);
        }
    }
}
