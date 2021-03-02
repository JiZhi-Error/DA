package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiGetInstallStateForNative extends d<s> {
    public static final int CTRL_INDEX = 656;
    public static final String NAME = "getInstallStateForNative";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45801);
        Log.d("MicroMsg.JsApiGetInstallStateForNative", "invoke");
        AppBrandMainProcessService.a(new GetInstallStateTask(this, sVar, i2, jSONObject));
        AppMethodBeat.o(45801);
    }

    static class GetInstallStateTask extends MainProcessTask {
        public static final Parcelable.Creator<GetInstallStateTask> CREATOR = new Parcelable.Creator<GetInstallStateTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallStateForNative.GetInstallStateTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetInstallStateTask[] newArray(int i2) {
                return new GetInstallStateTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetInstallStateTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45793);
                GetInstallStateTask getInstallStateTask = new GetInstallStateTask(parcel);
                AppMethodBeat.o(45793);
                return getInstallStateTask;
            }
        };
        private int csv;
        private s kAr;
        private p lAi;
        private boolean lAq;
        private String lDg;
        private JSONArray lDh;
        private boolean lDi;
        private String mPackageName;
        private String mVersionName;

        public GetInstallStateTask(p pVar, s sVar, int i2, JSONObject jSONObject) {
            AppMethodBeat.i(45794);
            bDJ();
            this.lAi = pVar;
            this.kAr = sVar;
            this.csv = i2;
            this.mPackageName = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("packageNameArray");
            if (optJSONArray != null) {
                this.lDg = optJSONArray.toString();
            }
            this.lAq = true;
            AppMethodBeat.o(45794);
        }

        public GetInstallStateTask(Parcel parcel) {
            AppMethodBeat.i(45795);
            f(parcel);
            AppMethodBeat.o(45795);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            boolean z = true;
            AppMethodBeat.i(45797);
            Object[] objArr = new Object[1];
            if (this.kAr != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.d("MicroMsg.JsApiGetInstallStateForNative", "callback, service is null: %b", objArr);
            bDK();
            if (this.lAq) {
                this.kAr.i(this.csv, this.lAi.h("fail", null));
                AppMethodBeat.o(45797);
                return;
            }
            HashMap hashMap = new HashMap();
            if (this.lDh != null) {
                hashMap.put("result", this.lDh);
            } else {
                hashMap.put("versionName", this.mVersionName);
                hashMap.put("isInstalled", Boolean.valueOf(this.lDi));
            }
            this.kAr.i(this.csv, this.lAi.n("ok", hashMap));
            AppMethodBeat.o(45797);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(45798);
            this.mPackageName = parcel.readString();
            this.lDg = parcel.readString();
            this.lAq = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.lDi = z;
            this.mVersionName = parcel.readString();
            String readString = parcel.readString();
            if (readString != null) {
                try {
                    this.lDh = new JSONArray(readString);
                    AppMethodBeat.o(45798);
                    return;
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiGetInstallStateForNative", "parseFromParcel: " + e2.getMessage());
                }
            }
            AppMethodBeat.o(45798);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            int i3;
            int i4 = 1;
            AppMethodBeat.i(45799);
            parcel.writeString(this.mPackageName);
            parcel.writeString(this.lDg);
            if (this.lAq) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeInt(i3);
            if (!this.lDi) {
                i4 = 0;
            }
            parcel.writeInt(i4);
            parcel.writeString(this.mVersionName);
            parcel.writeString(this.lDh != null ? this.lDh.toString() : null);
            AppMethodBeat.o(45799);
        }

        static {
            AppMethodBeat.i(45800);
            AppMethodBeat.o(45800);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45796);
            if (!Util.isNullOrNil(this.lDg)) {
                try {
                    JSONArray jSONArray = new JSONArray(this.lDg);
                    this.lDh = new JSONArray();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        String optString = jSONArray.optString(i2);
                        PackageInfo packageInfo = b.getPackageInfo(MMApplicationContext.getContext(), optString);
                        int i3 = packageInfo == null ? 0 : packageInfo.versionCode;
                        String str = packageInfo == null ? BuildConfig.COMMAND : packageInfo.versionName;
                        Log.i("MicroMsg.JsApiGetInstallStateForNative", "getInstallState, packageName = " + optString + ", packageInfo = " + packageInfo + ", version = " + i3 + ", versionName = " + str);
                        boolean z = packageInfo != null;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, optString);
                            jSONObject.put("isInstalled", z);
                            if (z) {
                                jSONObject.put(AssistantStore.DownloadInfos.DownloadInfoColumns.VERSIONCODE, i3);
                                jSONObject.put("versionName", str);
                            }
                            this.lDh.put(jSONObject);
                        } catch (JSONException e2) {
                            Log.i("MicroMsg.JsApiGetInstallStateForNative", e2.getMessage());
                        }
                    }
                    this.lAq = false;
                } catch (JSONException e3) {
                    Log.e("MicroMsg.JsApiGetInstallStateForNative", e3.getMessage());
                    this.lAq = true;
                }
            } else {
                PackageInfo packageInfo2 = b.getPackageInfo(MMApplicationContext.getContext(), this.mPackageName);
                int i4 = packageInfo2 == null ? 0 : packageInfo2.versionCode;
                String str2 = packageInfo2 == null ? BuildConfig.COMMAND : packageInfo2.versionName;
                Log.i("MicroMsg.JsApiGetInstallStateForNative", "doGetInstallState, packageName = " + this.mPackageName + ", packageInfo = " + packageInfo2 + ", version = " + i4 + ", versionName = " + str2);
                if (packageInfo2 == null) {
                    this.lDi = false;
                } else {
                    this.mVersionName = str2;
                    this.lDi = true;
                }
                this.lAq = false;
            }
            bDU();
            AppMethodBeat.o(45796);
        }
    }
}
