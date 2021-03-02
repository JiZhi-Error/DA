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
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiQueryDownloadTask extends d<s> {
    public static final int CTRL_INDEX = 441;
    public static final String NAME = "queryDownloadTask";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45879);
        s sVar2 = sVar;
        Log.d("MicroMsg.JsApiQueryDownloadTask", "invoke");
        AppBrandMainProcessService.a(new QueryDownloadTask(this, sVar2, i2, jSONObject));
        c.n(sVar2);
        AppMethodBeat.o(45879);
    }

    static class QueryDownloadTask extends MainProcessTask {
        public static final Parcelable.Creator<QueryDownloadTask> CREATOR = new Parcelable.Creator<QueryDownloadTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask.QueryDownloadTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ QueryDownloadTask[] newArray(int i2) {
                return new QueryDownloadTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ QueryDownloadTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45868);
                QueryDownloadTask queryDownloadTask = new QueryDownloadTask(parcel);
                AppMethodBeat.o(45868);
                return queryDownloadTask;
            }
        };
        private int csv;
        private s kAr;
        private p lAi;
        private boolean lAq;
        private String lAr;
        private long lAs;
        private JSONArray lDu;
        private JSONArray lDv;
        private JSONArray lDw;
        private String lDx;
        private long lDy;

        public QueryDownloadTask(p pVar, s sVar, int i2, JSONObject jSONObject) {
            AppMethodBeat.i(45869);
            bDJ();
            this.lAi = pVar;
            this.kAr = sVar;
            this.csv = i2;
            this.lAs = jSONObject.optLong("downloadId");
            this.lDu = jSONObject.optJSONArray("downloadIdArray");
            this.lDv = jSONObject.optJSONArray("appIdArray");
            this.lAq = true;
            AppMethodBeat.o(45869);
        }

        public QueryDownloadTask(Parcel parcel) {
            AppMethodBeat.i(45870);
            f(parcel);
            AppMethodBeat.o(45870);
        }

        private JSONObject a(long j2, FileDownloadTaskInfo fileDownloadTaskInfo) {
            AppMethodBeat.i(45872);
            JSONObject a2 = a(fileDownloadTaskInfo);
            if (fileDownloadTaskInfo != null) {
                try {
                    a2.put("downloadId", j2);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiQueryDownloadTask", e2.getMessage());
                }
            }
            AppMethodBeat.o(45872);
            return a2;
        }

        private JSONObject a(String str, FileDownloadTaskInfo fileDownloadTaskInfo) {
            AppMethodBeat.i(45873);
            JSONObject a2 = a(fileDownloadTaskInfo);
            try {
                a2.put("appId", str);
            } catch (JSONException e2) {
                Log.e("MicroMsg.JsApiQueryDownloadTask", e2.getMessage());
            }
            AppMethodBeat.o(45873);
            return a2;
        }

        private JSONObject a(FileDownloadTaskInfo fileDownloadTaskInfo) {
            String str;
            long j2 = 0;
            AppMethodBeat.i(45874);
            JSONObject jSONObject = new JSONObject();
            switch (fileDownloadTaskInfo.status) {
                case -1:
                    this.lAr = "fail_apilevel_too_low";
                    AppMethodBeat.o(45874);
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
            Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", str);
            if (fileDownloadTaskInfo.qJg && !NetStatusUtil.isWifi(MMApplicationContext.getContext()) && fileDownloadTaskInfo.status != 3 && fileDownloadTaskInfo.status != 1) {
                str = "download_wait_wifi";
            }
            if ((str == "downloading" || str == "download_pause") && fileDownloadTaskInfo.oJj != 0) {
                j2 = (long) ((((float) fileDownloadTaskInfo.qJe) / ((float) fileDownloadTaskInfo.oJj)) * 100.0f);
            }
            try {
                jSONObject.put("appId", fileDownloadTaskInfo.appId);
                jSONObject.put("downloadId", fileDownloadTaskInfo.id);
                jSONObject.put("state", str);
                jSONObject.put("progress", j2);
            } catch (JSONException e2) {
                Log.e("MicroMsg.JsApiQueryDownloadTask", e2.getMessage());
            }
            AppMethodBeat.o(45874);
            return jSONObject;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(45875);
            bDK();
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.kAr == null);
            Log.d("MicroMsg.JsApiQueryDownloadTask", "callback, service is null: %b", objArr);
            if (this.lAq) {
                this.kAr.i(this.csv, this.lAi.h(Util.isNullOrNil(this.lAr) ? "fail" : String.format("fail:%s", this.lAr), null));
                AppMethodBeat.o(45875);
                return;
            }
            HashMap hashMap = new HashMap();
            if (this.lDw != null) {
                hashMap.put("result", this.lDw);
            } else {
                hashMap.put("downloadId", Long.valueOf(this.lAs));
                hashMap.put("state", this.lDx);
                hashMap.put("progress", Long.valueOf(this.lDy));
            }
            this.kAr.i(this.csv, this.lAi.n("ok", hashMap));
            AppMethodBeat.o(45875);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(45876);
            this.lAs = parcel.readLong();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.lAq = z;
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
                    Log.printErrStackTrace("MicroMsg.JsApiQueryDownloadTask", e2, "", new Object[0]);
                    AppMethodBeat.o(45876);
                    return;
                }
            }
            if (readString2 != null) {
                this.lDv = new JSONArray(readString2);
            }
            if (readString3 != null) {
                this.lDw = new JSONArray(readString3);
            }
            AppMethodBeat.o(45876);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            String str;
            String str2;
            String str3 = null;
            AppMethodBeat.i(45877);
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
            AppMethodBeat.o(45877);
        }

        static {
            AppMethodBeat.i(45878);
            AppMethodBeat.o(45878);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45871);
            Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", Long.valueOf(this.lAs));
            if (this.lDu != null && this.lDu.length() > 0) {
                this.lDw = new JSONArray();
                for (int i2 = 0; i2 < this.lDu.length(); i2++) {
                    long optLong = this.lDu.optLong(i2);
                    this.lDw.put(a(optLong, f.cBv().Co(optLong)));
                }
                this.lAq = false;
            } else if (this.lDv != null && this.lDv.length() > 0) {
                this.lDw = new JSONArray();
                for (int i3 = 0; i3 < this.lDv.length(); i3++) {
                    String optString = this.lDv.optString(i3);
                    this.lDw.put(a(optString, f.cBv().alg(optString)));
                }
                this.lAq = false;
            } else if (this.lAs > 0) {
                FileDownloadTaskInfo Co = f.cBv().Co(this.lAs);
                if (!(!Co.qJg || Co.status == 1 || Co.status == 3)) {
                    this.lDx = "download_wait_wifi";
                }
                switch (Co.status) {
                    case -1:
                        this.lAr = "fail_apilevel_too_low";
                        break;
                    case 0:
                    default:
                        this.lDx = BuildConfig.KINDA_DEFAULT;
                        Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", this.lDx);
                        if ((this.lDx == "downloading" || this.lDx == "download_pause") && Co.oJj != 0) {
                            this.lDy = (long) ((((float) Co.qJe) / ((float) Co.oJj)) * 100.0f);
                        }
                        if (Co.qJg && !NetStatusUtil.isWifi(MMApplicationContext.getContext()) && Co.status != 3 && Co.status != 1) {
                            this.lDx = "download_wait_wifi";
                        }
                        this.lAq = false;
                        break;
                    case 1:
                        this.lDx = "downloading";
                        Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", this.lDx);
                        this.lDy = (long) ((((float) Co.qJe) / ((float) Co.oJj)) * 100.0f);
                        this.lDx = "download_wait_wifi";
                        this.lAq = false;
                        break;
                    case 2:
                        this.lDx = "download_pause";
                        Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", this.lDx);
                        this.lDy = (long) ((((float) Co.qJe) / ((float) Co.oJj)) * 100.0f);
                        this.lDx = "download_wait_wifi";
                        this.lAq = false;
                        break;
                    case 3:
                        if (com.tencent.mm.vfs.s.YS(Co.path)) {
                            this.lDx = "download_succ";
                        } else {
                            this.lDx = BuildConfig.KINDA_DEFAULT;
                        }
                        Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", this.lDx);
                        this.lDy = (long) ((((float) Co.qJe) / ((float) Co.oJj)) * 100.0f);
                        this.lDx = "download_wait_wifi";
                        this.lAq = false;
                        break;
                    case 4:
                        this.lDx = "download_fail";
                        Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", this.lDx);
                        this.lDy = (long) ((((float) Co.qJe) / ((float) Co.oJj)) * 100.0f);
                        this.lDx = "download_wait_wifi";
                        this.lAq = false;
                        break;
                }
            } else {
                this.lAr = "downloadId invalid";
            }
            bDU();
            AppMethodBeat.o(45871);
        }
    }
}
