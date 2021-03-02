package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiAddDownloadTaskStraight extends d<s> {
    public static final int CTRL_INDEX = 440;
    public static final String NAME = "addDownloadTaskStraight";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45770);
        s sVar2 = sVar;
        AppBrandMainProcessService.a(new AddDownloadTaskStraightTask(this, sVar2, i2, jSONObject));
        c.n(sVar2);
        AppMethodBeat.o(45770);
    }

    static class AddDownloadTaskStraightTask extends MainProcessTask {
        public static final Parcelable.Creator<AddDownloadTaskStraightTask> CREATOR = new Parcelable.Creator<AddDownloadTaskStraightTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight.AddDownloadTaskStraightTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AddDownloadTaskStraightTask[] newArray(int i2) {
                return new AddDownloadTaskStraightTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AddDownloadTaskStraightTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45762);
                AddDownloadTaskStraightTask addDownloadTaskStraightTask = new AddDownloadTaskStraightTask(parcel);
                AppMethodBeat.o(45762);
                return addDownloadTaskStraightTask;
            }
        };
        private int csv;
        private s kAr;
        private p lAi;
        private String lAj;
        private String lAk;
        private String lAl;
        private String lAm;
        private long lAn;
        private String lAo;
        private String lAp;
        private boolean lAq;
        private String lAr;
        private long lAs;
        private String mAppId;
        private String mPackageName;

        public AddDownloadTaskStraightTask(p pVar, s sVar, int i2, JSONObject jSONObject) {
            AppMethodBeat.i(45763);
            this.lAi = pVar;
            this.kAr = sVar;
            this.csv = i2;
            this.lAj = jSONObject.optString("taskName");
            this.lAk = jSONObject.optString("taskUrl");
            this.lAl = jSONObject.optString("fileMd5");
            this.lAm = jSONObject.optString("alternativeUrl");
            this.lAn = (long) jSONObject.optInt("taskSize", 0);
            this.lAo = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
            this.lAp = jSONObject.optString("fileType");
            this.mAppId = sVar.getAppId();
            this.mPackageName = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
            this.lAq = true;
            AppMethodBeat.o(45763);
        }

        public AddDownloadTaskStraightTask(Parcel parcel) {
            AppMethodBeat.i(45764);
            f(parcel);
            AppMethodBeat.o(45764);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String format;
            AppMethodBeat.i(45766);
            if (this.lAq) {
                if (Util.isNullOrNil(this.lAr)) {
                    format = "fail";
                } else {
                    format = String.format("fail:%s", this.lAr);
                }
                this.kAr.i(this.csv, this.lAi.h(format, null));
                AppMethodBeat.o(45766);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("downloadId", Long.valueOf(this.lAs));
            this.kAr.i(this.csv, this.lAi.n("ok", hashMap));
            AppMethodBeat.o(45766);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(45767);
            this.lAj = parcel.readString();
            this.lAk = parcel.readString();
            this.lAl = parcel.readString();
            this.lAm = parcel.readString();
            this.lAn = parcel.readLong();
            this.lAo = parcel.readString();
            this.lAp = parcel.readString();
            this.mAppId = parcel.readString();
            this.mPackageName = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.lAq = z;
            this.lAr = parcel.readString();
            this.lAs = parcel.readLong();
            AppMethodBeat.o(45767);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45768);
            parcel.writeString(this.lAj);
            parcel.writeString(this.lAk);
            parcel.writeString(this.lAl);
            parcel.writeString(this.lAm);
            parcel.writeLong(this.lAn);
            parcel.writeString(this.lAo);
            parcel.writeString(this.lAp);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.mPackageName);
            parcel.writeInt(this.lAq ? 1 : 0);
            parcel.writeString(this.lAr);
            parcel.writeLong(this.lAs);
            AppMethodBeat.o(45768);
        }

        static {
            AppMethodBeat.i(45769);
            AppMethodBeat.o(45769);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45765);
            g.aAi();
            if (!g.aAh().isSDCardAvailable()) {
                this.lAr = "fail_sdcard_not_ready";
            } else if (this.lAn > 0 && !e.yV(this.lAn)) {
                this.lAr = "fail_sdcard_has_not_enough_space";
            } else if (Util.isNullOrNil(this.lAk)) {
                this.lAr = "fail_invalid_url";
            } else {
                Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", this.lAk, this.lAl);
                g.a aVar = new g.a();
                aVar.alj(this.lAk);
                aVar.alk(this.lAm);
                aVar.setFileSize(this.lAn);
                aVar.all(this.lAj);
                aVar.setFileMD5(this.lAl);
                aVar.setAppId(this.mAppId);
                aVar.gm(this.mPackageName);
                aVar.kS(true);
                aVar.Fl(Util.getInt(this.lAp, 1));
                aVar.setScene(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE);
                aVar.Rv(this.lAo);
                long a2 = f.cBv().a(aVar.qIY);
                Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(a2)));
                if (a2 <= 0) {
                    Log.e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(a2)));
                    this.lAr = "";
                } else {
                    this.lAq = false;
                    this.lAs = a2;
                }
            }
            bDU();
            AppMethodBeat.o(45765);
        }
    }
}