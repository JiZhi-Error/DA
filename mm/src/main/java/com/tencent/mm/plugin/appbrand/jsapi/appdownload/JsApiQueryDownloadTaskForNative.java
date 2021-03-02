package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiQueryDownloadTaskForNative extends d<s> {
    public static final int CTRL_INDEX = 661;
    public static final String NAME = "queryDownloadTaskForNative";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45891);
        s sVar2 = sVar;
        Log.d("MicroMsg.JsApiQueryDownloadTaskForNative", "invoke");
        AppBrandMainProcessService.a(new QueryDownloadTask(this, sVar2, i2, jSONObject));
        d.n(sVar2);
        AppMethodBeat.o(45891);
    }

    static class QueryDownloadTask extends MainProcessTask {
        public static final Parcelable.Creator<QueryDownloadTask> CREATOR = new Parcelable.Creator<QueryDownloadTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTaskForNative.QueryDownloadTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ QueryDownloadTask[] newArray(int i2) {
                return new QueryDownloadTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ QueryDownloadTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45880);
                QueryDownloadTask queryDownloadTask = new QueryDownloadTask(parcel);
                AppMethodBeat.o(45880);
                return queryDownloadTask;
            }
        };
        private int csv;
        private s kAr;
        private p lAi;
        private boolean lAq;
        private String lAr;
        private long lAs;
        private boolean lDA;
        private JSONArray lDu;
        private JSONArray lDv;
        private JSONArray lDw;
        private String lDx;
        private long lDy;
        private float lDz;

        public QueryDownloadTask(p pVar, s sVar, int i2, JSONObject jSONObject) {
            AppMethodBeat.i(45881);
            bDJ();
            this.lAi = pVar;
            this.kAr = sVar;
            this.csv = i2;
            this.lAs = jSONObject.optLong("downloadId");
            this.lDu = jSONObject.optJSONArray("downloadIdArray");
            this.lDv = jSONObject.optJSONArray("appIdArray");
            this.lAq = true;
            AppMethodBeat.o(45881);
        }

        public QueryDownloadTask(Parcel parcel) {
            AppMethodBeat.i(45882);
            f(parcel);
            AppMethodBeat.o(45882);
        }

        private JSONObject a(long j2, FileDownloadTaskInfo fileDownloadTaskInfo) {
            AppMethodBeat.i(45884);
            JSONObject a2 = a(fileDownloadTaskInfo);
            if (fileDownloadTaskInfo != null) {
                try {
                    a2.put("downloadId", j2);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiQueryDownloadTaskForNative", e2.getMessage());
                }
            }
            AppMethodBeat.o(45884);
            return a2;
        }

        private JSONObject a(String str, FileDownloadTaskInfo fileDownloadTaskInfo) {
            AppMethodBeat.i(45885);
            JSONObject a2 = a(fileDownloadTaskInfo);
            try {
                a2.put("appId", str);
            } catch (JSONException e2) {
                Log.e("MicroMsg.JsApiQueryDownloadTaskForNative", e2.getMessage());
            }
            AppMethodBeat.o(45885);
            return a2;
        }

        private JSONObject a(FileDownloadTaskInfo fileDownloadTaskInfo) {
            String str;
            long j2 = 0;
            AppMethodBeat.i(45886);
            JSONObject jSONObject = new JSONObject();
            switch (fileDownloadTaskInfo.status) {
                case -1:
                    this.lAr = "fail_apilevel_too_low";
                    AppMethodBeat.o(45886);
                    return jSONObject;
                case 0:
                default:
                    str = BuildConfig.KINDA_DEFAULT;
                    break;
                case 1:
                    str = "downloading";
                    break;
                case 2:
                    str = "download_pause";
                    break;
                case 3:
                    if (!com.tencent.mm.vfs.s.YS(fileDownloadTaskInfo.path)) {
                        str = BuildConfig.KINDA_DEFAULT;
                        break;
                    } else {
                        str = "download_succ";
                        break;
                    }
                case 4:
                    str = "download_fail";
                    break;
            }
            Log.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", str);
            float f2 = 0.0f;
            if (fileDownloadTaskInfo.oJj != 0) {
                j2 = (fileDownloadTaskInfo.qJe * 100) / fileDownloadTaskInfo.oJj;
                f2 = (((float) fileDownloadTaskInfo.qJe) * 100.0f) / ((float) fileDownloadTaskInfo.oJj);
            }
            try {
                jSONObject.put("appId", fileDownloadTaskInfo.appId);
                jSONObject.put("downloadId", fileDownloadTaskInfo.id);
                jSONObject.put("state", str);
                jSONObject.put("progress", j2);
                jSONObject.put("progress_float", (double) f2);
                jSONObject.put("reserve_for_wifi", fileDownloadTaskInfo.qJh ? 1 : 0);
            } catch (JSONException e2) {
                Log.e("MicroMsg.JsApiQueryDownloadTaskForNative", e2.getMessage());
            }
            AppMethodBeat.o(45886);
            return jSONObject;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(45887);
            bDK();
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.kAr == null);
            Log.d("MicroMsg.JsApiQueryDownloadTaskForNative", "callback, service is null: %b", objArr);
            if (this.lAq) {
                this.kAr.i(this.csv, this.lAi.h(Util.isNullOrNil(this.lAr) ? "fail" : String.format("fail:%s", this.lAr), null));
                AppMethodBeat.o(45887);
                return;
            }
            HashMap hashMap = new HashMap();
            if (this.lDw != null) {
                hashMap.put("result", this.lDw);
            } else {
                hashMap.put("downloadId", Long.valueOf(this.lAs));
                hashMap.put("state", this.lDx);
                hashMap.put("progress", Long.valueOf(this.lDy));
                hashMap.put("progress_float", Float.valueOf(this.lDz));
                hashMap.put("reserve_for_wifi", Boolean.valueOf(this.lDA));
            }
            this.kAr.i(this.csv, this.lAi.n("ok", hashMap));
            AppMethodBeat.o(45887);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(45888);
            this.lAs = parcel.readLong();
            this.lAq = parcel.readInt() == 1;
            this.lAr = parcel.readString();
            this.lDx = parcel.readString();
            this.lDy = parcel.readLong();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (readString != null) {
                try {
                    this.lDu = new JSONArray(readString);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.JsApiQueryDownloadTaskForNative", e2, "", new Object[0]);
                }
            }
            if (readString2 != null) {
                this.lDv = new JSONArray(readString2);
            }
            if (readString3 != null) {
                this.lDw = new JSONArray(readString3);
            }
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.lDA = z;
            AppMethodBeat.o(45888);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            String str;
            String str2;
            int i3 = 1;
            String str3 = null;
            AppMethodBeat.i(45889);
            parcel.writeLong(this.lAs);
            parcel.writeInt(this.lAq ? 1 : 0);
            parcel.writeString(this.lAr);
            parcel.writeString(this.lDx);
            parcel.writeLong(this.lDy);
            if (this.lDu != null) {
                str = this.lDu.toString();
            } else {
                str = null;
            }
            parcel.writeString(str);
            if (this.lDv != null) {
                str2 = this.lDv.toString();
            } else {
                str2 = null;
            }
            parcel.writeString(str2);
            if (this.lDw != null) {
                str3 = this.lDw.toString();
            }
            parcel.writeString(str3);
            if (!this.lDA) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            AppMethodBeat.o(45889);
        }

        static {
            AppMethodBeat.i(45890);
            AppMethodBeat.o(45890);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x00cc  */
        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bjj() {
            /*
            // Method dump skipped, instructions count: 294
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTaskForNative.QueryDownloadTask.bjj():void");
        }
    }
}
