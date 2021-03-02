package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiResumeDownloadTask extends d<s> {
    public static final int CTRL_INDEX = 444;
    public static final String NAME = "resumeDownloadTask";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(107800);
        AppBrandMainProcessService.a(new ResumeDownloadTask(this, sVar, i2, jSONObject));
        AppMethodBeat.o(107800);
    }

    static class ResumeDownloadTask extends MainProcessTask {
        public static final Parcelable.Creator<ResumeDownloadTask> CREATOR = new Parcelable.Creator<ResumeDownloadTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask.ResumeDownloadTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ResumeDownloadTask[] newArray(int i2) {
                return new ResumeDownloadTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ResumeDownloadTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(107792);
                ResumeDownloadTask resumeDownloadTask = new ResumeDownloadTask(parcel);
                AppMethodBeat.o(107792);
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

        public ResumeDownloadTask(p pVar, s sVar, int i2, JSONObject jSONObject) {
            AppMethodBeat.i(107793);
            this.lAi = pVar;
            this.kAr = sVar;
            this.csv = i2;
            this.lAs = jSONObject.optLong("downloadId");
            this.lBG = jSONObject.optBoolean("downloadInWifi", false);
            this.lAq = true;
            AppMethodBeat.o(107793);
        }

        public ResumeDownloadTask(Parcel parcel) {
            AppMethodBeat.i(107794);
            f(parcel);
            AppMethodBeat.o(107794);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String format;
            AppMethodBeat.i(107796);
            if (this.lAq) {
                if (Util.isNullOrNil(this.lAr)) {
                    format = "fail";
                } else {
                    format = String.format("fail:%s", this.lAr);
                }
                this.kAr.i(this.csv, this.lAi.h(format, null));
                AppMethodBeat.o(107796);
                return;
            }
            this.kAr.i(this.csv, this.lAi.h("ok", null));
            AppMethodBeat.o(107796);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(107797);
            this.lAs = parcel.readLong();
            if (parcel.readByte() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.lBG = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.lAq = z2;
            this.lAr = parcel.readString();
            AppMethodBeat.o(107797);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            byte b2;
            int i3 = 1;
            AppMethodBeat.i(107798);
            parcel.writeLong(this.lAs);
            if (this.lBG) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            parcel.writeByte(b2);
            if (!this.lAq) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeString(this.lAr);
            AppMethodBeat.o(107798);
        }

        static {
            AppMethodBeat.i(107799);
            AppMethodBeat.o(107799);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            boolean z = true;
            AppMethodBeat.i(107795);
            Log.i("MicroMsg.JsApiResumeDownloadTask", "doQueryDownloadTask, downloadId = %d", Long.valueOf(this.lAs));
            if (this.lAs <= 0) {
                this.lAr = "downloadId invalid";
            } else {
                a Cw = d.Cw(this.lAs);
                if (!(Cw == null || Cw.field_downloadInWifi == this.lBG)) {
                    Cw.field_downloadInWifi = this.lBG;
                    d.e(Cw);
                }
                if (f.cBv().Cq(this.lAs)) {
                    z = false;
                }
                this.lAq = z;
            }
            bDU();
            AppMethodBeat.o(107795);
        }
    }
}
