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

public final class JsApiAddDownloadTask extends d<s> {
    public static final int CTRL_INDEX = 474;
    public static final String NAME = "addDownloadTask";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45751);
        s sVar2 = sVar;
        AppBrandMainProcessService.a(new AddDownloadTask(this, sVar2, i2, jSONObject));
        c.n(sVar2);
        AppMethodBeat.o(45751);
    }

    static class AddDownloadTask extends MainProcessTask {
        public static final Parcelable.Creator<AddDownloadTask> CREATOR = new Parcelable.Creator<AddDownloadTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask.AddDownloadTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AddDownloadTask[] newArray(int i2) {
                return new AddDownloadTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AddDownloadTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45743);
                AddDownloadTask addDownloadTask = new AddDownloadTask(parcel);
                AppMethodBeat.o(45743);
                return addDownloadTask;
            }
        };
        private int csv;
        private s kAr;
        private p lAi;
        private String lAj;
        private String lAk;
        private String lAl;
        private long lAn;
        private String lAo;
        private String lAp;
        private boolean lAq;
        private String lAr;
        private long lAs;
        private boolean lBG;
        private boolean lCY;
        private int lCZ;
        private String mAppId;
        private String mPackageName;

        public AddDownloadTask(p pVar, s sVar, int i2, JSONObject jSONObject) {
            AppMethodBeat.i(45744);
            bDJ();
            this.lAi = pVar;
            this.kAr = sVar;
            this.csv = i2;
            this.lAj = jSONObject.optString("taskName");
            this.lAk = jSONObject.optString("taskUrl");
            this.lAl = jSONObject.optString("fileMd5");
            this.lAn = (long) jSONObject.optInt("taskSize", 0);
            this.lAo = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
            this.lAp = jSONObject.optString("fileType");
            this.mAppId = jSONObject.optString("appId");
            this.mPackageName = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
            this.lBG = jSONObject.optBoolean("downloadInWifi", false);
            this.lCY = jSONObject.optBoolean("showNotification", false);
            this.lCZ = jSONObject.optInt("downloaderType", 0);
            this.lAq = true;
            AppMethodBeat.o(45744);
        }

        public AddDownloadTask(Parcel parcel) {
            AppMethodBeat.i(45745);
            f(parcel);
            AppMethodBeat.o(45745);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String format;
            AppMethodBeat.i(45747);
            bDK();
            if (this.lAq) {
                if (Util.isNullOrNil(this.lAr)) {
                    format = "fail";
                } else {
                    format = String.format("fail:%s", this.lAr);
                }
                this.kAr.i(this.csv, this.lAi.h(format, null));
                AppMethodBeat.o(45747);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("downloadId", Long.valueOf(this.lAs));
            this.kAr.i(this.csv, this.lAi.n("ok", hashMap));
            AppMethodBeat.o(45747);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(45748);
            this.lAj = parcel.readString();
            this.lAk = parcel.readString();
            this.lAl = parcel.readString();
            this.lAn = parcel.readLong();
            this.lAo = parcel.readString();
            this.lAp = parcel.readString();
            this.mAppId = parcel.readString();
            this.mPackageName = parcel.readString();
            this.lBG = parcel.readByte() == 1;
            if (parcel.readByte() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.lCY = z;
            this.lCZ = parcel.readInt();
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.lAq = z2;
            this.lAr = parcel.readString();
            this.lAs = parcel.readLong();
            AppMethodBeat.o(45748);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            byte b2;
            int i3 = 1;
            AppMethodBeat.i(45749);
            parcel.writeString(this.lAj);
            parcel.writeString(this.lAk);
            parcel.writeString(this.lAl);
            parcel.writeLong(this.lAn);
            parcel.writeString(this.lAo);
            parcel.writeString(this.lAp);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.mPackageName);
            parcel.writeByte(this.lBG ? (byte) 1 : 0);
            if (this.lCY) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            parcel.writeByte(b2);
            parcel.writeInt(this.lCZ);
            if (!this.lAq) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeString(this.lAr);
            parcel.writeLong(this.lAs);
            AppMethodBeat.o(45749);
        }

        static {
            AppMethodBeat.i(45750);
            AppMethodBeat.o(45750);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            long a2;
            AppMethodBeat.i(45746);
            g.aAi();
            if (!g.aAh().isSDCardAvailable()) {
                this.lAr = "fail_sdcard_not_ready";
            } else if (this.lAn > 0 && !e.yV(this.lAn)) {
                this.lAr = "fail_sdcard_has_not_enough_space";
            } else if (Util.isNullOrNil(this.lAk)) {
                this.lAr = "fail_invalid_url";
            } else {
                Log.i("MicroMsg.JsApiAddDownloadTask", "runInMainProcess taskUrl:%s md5:%s", this.lAk, this.lAl);
                g.a aVar = new g.a();
                aVar.alj(this.lAk);
                aVar.setFileSize(this.lAn);
                aVar.all(this.lAj);
                aVar.setFileMD5(this.lAl);
                aVar.setAppId(this.mAppId);
                aVar.gm(this.mPackageName);
                aVar.kS(true);
                aVar.Fl(Util.getInt(this.lAp, 1));
                aVar.setScene(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE);
                aVar.Rv(this.lAo);
                aVar.kT(this.lCY);
                aVar.kV(this.lBG);
                aVar.kS(false);
                aVar.cBD();
                com.tencent.mm.plugin.downloader.model.g gVar = aVar.qIY;
                if (this.lCZ == 1) {
                    a2 = f.cBv().b(gVar);
                } else {
                    a2 = f.cBv().a(gVar);
                }
                Log.i("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(a2)));
                if (a2 <= 0) {
                    Log.e("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(a2)));
                    this.lAr = "";
                } else {
                    this.lAq = false;
                    this.lAs = a2;
                }
            }
            bDU();
            AppMethodBeat.o(45746);
        }
    }
}
