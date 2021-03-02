package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.Context;
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
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader_app.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiAddDownloadTaskForNative extends d<s> {
    public static final int CTRL_INDEX = 655;
    public static final String NAME = "addDownloadTaskForNative";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45761);
        s sVar2 = sVar;
        AppBrandMainProcessService.a(new AddDownloadTask(this, sVar2, i2, jSONObject));
        d.n(sVar2);
        AppMethodBeat.o(45761);
    }

    static class AddDownloadTask extends MainProcessTask {
        public static final Parcelable.Creator<AddDownloadTask> CREATOR = new Parcelable.Creator<AddDownloadTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskForNative.AddDownloadTask.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AddDownloadTask[] newArray(int i2) {
                return new AddDownloadTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AddDownloadTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45753);
                AddDownloadTask addDownloadTask = new AddDownloadTask(parcel);
                AppMethodBeat.o(45753);
                return addDownloadTask;
            }
        };
        private JSONObject csi;
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
        private int lCZ;
        private boolean lDa;
        private String lDb;
        private String mAppId;
        private String mPackageName;
        private int mScene;

        public AddDownloadTask(p pVar, s sVar, int i2, JSONObject jSONObject) {
            AppMethodBeat.i(45754);
            bDJ();
            this.lAi = pVar;
            this.kAr = sVar;
            this.csv = i2;
            this.csi = jSONObject;
            this.lAj = jSONObject.optString("taskName");
            this.lAk = jSONObject.optString("taskUrl");
            this.lAl = jSONObject.optString("fileMd5");
            this.lAn = (long) jSONObject.optInt("taskSize", 0);
            this.lAo = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
            this.lAp = jSONObject.optString("fileType");
            this.mAppId = jSONObject.optString("appId");
            this.mPackageName = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
            this.lBG = jSONObject.optBoolean("downloadInWifi", false);
            this.lCZ = jSONObject.optInt("downloaderType", 0);
            this.lDa = jSONObject.optBoolean("useDownloaderWidget", false);
            this.mScene = jSONObject.optInt("scene", TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE);
            this.lDb = jSONObject.optString("alterUrl");
            this.lAq = true;
            AppMethodBeat.o(45754);
        }

        public AddDownloadTask(Parcel parcel) {
            AppMethodBeat.i(45755);
            f(parcel);
            AppMethodBeat.o(45755);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String format;
            AppMethodBeat.i(45757);
            bDK();
            if (this.lAq) {
                if (Util.isNullOrNil(this.lAr)) {
                    format = "fail";
                } else {
                    format = String.format("fail:%s", this.lAr);
                }
                this.kAr.i(this.csv, this.lAi.h(format, null));
                AppMethodBeat.o(45757);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("downloadId", Long.valueOf(this.lAs));
            this.kAr.i(this.csv, this.lAi.n("ok", hashMap));
            AppMethodBeat.o(45757);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(45758);
            this.lAj = parcel.readString();
            this.lAk = parcel.readString();
            this.lAl = parcel.readString();
            this.lAn = parcel.readLong();
            this.lAo = parcel.readString();
            this.lAp = parcel.readString();
            this.mAppId = parcel.readString();
            this.mPackageName = parcel.readString();
            this.lBG = parcel.readInt() == 1;
            this.lCZ = parcel.readInt();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.lAq = z;
            this.lAr = parcel.readString();
            this.lAs = parcel.readLong();
            this.mScene = parcel.readInt();
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.lDa = z2;
            try {
                this.csi = new JSONObject(parcel.readString());
            } catch (Exception e2) {
                Log.d("MicroMsg.JsApiAddDownloadTaskForNative", e2.getMessage());
            }
            this.lDb = parcel.readString();
            AppMethodBeat.o(45758);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            int i3;
            int i4 = 1;
            AppMethodBeat.i(45759);
            parcel.writeString(this.lAj);
            parcel.writeString(this.lAk);
            parcel.writeString(this.lAl);
            parcel.writeLong(this.lAn);
            parcel.writeString(this.lAo);
            parcel.writeString(this.lAp);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.mPackageName);
            parcel.writeInt(this.lBG ? 1 : 0);
            parcel.writeInt(this.lCZ);
            if (this.lAq) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeString(this.lAr);
            parcel.writeLong(this.lAs);
            parcel.writeInt(this.mScene);
            if (!this.lDa) {
                i4 = 0;
            }
            parcel.writeInt(i4);
            parcel.writeString(this.csi != null ? this.csi.toString() : "");
            parcel.writeString(this.lDb);
            AppMethodBeat.o(45759);
        }

        static {
            AppMethodBeat.i(45760);
            AppMethodBeat.o(45760);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            long a2;
            a aVar;
            boolean z = true;
            AppMethodBeat.i(45756);
            g.aAi();
            if (!g.aAh().isSDCardAvailable()) {
                this.lAr = "fail_sdcard_not_ready";
            } else if (this.lAn > 0 && !e.yV(this.lAn)) {
                this.lAr = "fail_sdcard_has_not_enough_space";
            } else if (Util.isNullOrNil(this.lAk)) {
                this.lAr = "fail_invalid_url";
            } else if (this.lDa) {
                Context context = MMApplicationContext.getContext();
                JSONObject jSONObject = this.csi;
                a aVar2 = new a();
                if (jSONObject == null) {
                    aVar = aVar2;
                } else {
                    aVar2.appName = jSONObject.optString("taskName");
                    aVar2.downloadUrl = jSONObject.optString("taskUrl");
                    aVar2.qKt = jSONObject.optString("alterUrl");
                    aVar2.qKv = jSONObject.optLong("taskSize");
                    aVar2.mYc = jSONObject.optString("fileMd5");
                    aVar2.extInfo = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
                    aVar2.fileType = Util.getInt(jSONObject.optString("fileType"), 0);
                    aVar2.appId = jSONObject.optString("appId");
                    aVar2.qKu = jSONObject.optString("rawAppId");
                    aVar2.packageName = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
                    aVar2.scene = jSONObject.optInt("scene", 1000);
                    aVar2.dNv = jSONObject.optInt("downloaderType", 1);
                    aVar2.qJg = jSONObject.optBoolean("downloadInWifi", false);
                    if (jSONObject.optInt("ignoreNetwork", 0) != 1) {
                        z = false;
                    }
                    aVar2.qKA = z;
                    aVar = aVar2;
                }
                o.a(context, aVar, new o.a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskForNative.AddDownloadTask.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.downloader.model.o.a
                    public final void i(String str, JSONObject jSONObject) {
                        AppMethodBeat.i(45752);
                        if (jSONObject == null) {
                            AddDownloadTask.this.lAq = true;
                            AppMethodBeat.o(45752);
                            return;
                        }
                        AddDownloadTask.this.lAs = (long) jSONObject.optInt("download_id", -1);
                        if (AddDownloadTask.this.lAs <= 0) {
                            AddDownloadTask.this.lAq = true;
                            AppMethodBeat.o(45752);
                            return;
                        }
                        AddDownloadTask.this.lAq = false;
                        AppMethodBeat.o(45752);
                    }
                });
                com.tencent.mm.modelstat.d.d(10, "JsApiAddDownloadTaskForNative", hashCode());
            } else {
                Log.i("MicroMsg.JsApiAddDownloadTaskForNative", "runInMainProcess taskUrl:%s md5:%s", this.lAk, this.lAl);
                g.a aVar3 = new g.a();
                aVar3.alj(this.lAk);
                aVar3.setFileSize(this.lAn);
                aVar3.all(this.lAj);
                aVar3.setFileMD5(this.lAl);
                aVar3.setAppId(this.mAppId);
                aVar3.gm(this.mPackageName);
                aVar3.kS(true);
                aVar3.Fl(Util.getInt(this.lAp, 1));
                aVar3.setScene(this.mScene);
                aVar3.Rv(this.lAo);
                aVar3.cBD();
                aVar3.alk(this.lDb);
                com.tencent.mm.plugin.downloader.model.g gVar = aVar3.qIY;
                if (this.lCZ == 1) {
                    a2 = f.cBv().b(gVar);
                } else {
                    a2 = f.cBv().a(gVar);
                }
                Log.i("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(a2)));
                if (a2 <= 0) {
                    Log.e("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(a2)));
                    this.lAr = "";
                } else {
                    this.lAq = false;
                    this.lAs = a2;
                }
            }
            bDU();
            AppMethodBeat.o(45756);
        }
    }
}
