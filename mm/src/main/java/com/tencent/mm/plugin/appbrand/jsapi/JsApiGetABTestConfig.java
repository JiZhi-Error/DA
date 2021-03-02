package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiGetABTestConfig extends ab<f> {
    public static final int CTRL_INDEX = 527;
    public static final String NAME = "getABTestConfig";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(f fVar, JSONObject jSONObject) {
        AppMethodBeat.i(45480);
        Log.i("MicroMsg.JsApiGetABTestConfig", "JSONObject = ".concat(String.valueOf(jSONObject)));
        String optString = jSONObject.optString("experimentId");
        boolean equals = "Expt".equals(jSONObject.optString("experimentType"));
        if (TextUtils.isEmpty(optString)) {
            String h2 = h("fail:experimentId is empty", null);
            AppMethodBeat.o(45480);
            return h2;
        } else if (equals) {
            HashMap hashMap = new HashMap();
            hashMap.put("testConfig", d.cRY().b(optString, "", true, true));
            String n = n("ok", hashMap);
            AppMethodBeat.o(45480);
            return n;
        } else {
            a aVar = a.C0356a.hnM;
            c Fu = a.Fu(optString);
            HashMap hashMap2 = new HashMap();
            if (Fu == null || !Fu.isValid()) {
                hashMap2.put("testConfig", new HashMap(0));
            } else {
                hashMap2.put("testConfig", Fu.gzz());
            }
            String n2 = n("ok", hashMap2);
            AppMethodBeat.o(45480);
            return n2;
        }
    }

    public static class GetABTestConfigTask extends MainProcessTask {
        public static final Parcelable.Creator<GetABTestConfigTask> CREATOR = new Parcelable.Creator<GetABTestConfigTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig.GetABTestConfigTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetABTestConfigTask[] newArray(int i2) {
                return new GetABTestConfigTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetABTestConfigTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45473);
                GetABTestConfigTask getABTestConfigTask = new GetABTestConfigTask(parcel);
                AppMethodBeat.o(45473);
                return getABTestConfigTask;
            }
        };
        private String lzA;
        private Map<String, String> lzB = new HashMap();

        GetABTestConfigTask(Parcel parcel) {
            AppMethodBeat.i(45475);
            f(parcel);
            AppMethodBeat.o(45475);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45476);
            Log.i("MicroMsg.JsApiGetABTestConfig", "runInMainProcess");
            c Fu = com.tencent.mm.model.c.d.aXu().Fu(this.lzA);
            if (Fu.isValid()) {
                this.lzB.putAll(Fu.gzz());
            }
            bDU();
            AppMethodBeat.o(45476);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(45477);
            this.lzB.clear();
            this.lzB.putAll(parcel.readHashMap(HashMap.class.getClassLoader()));
            this.lzA = parcel.readString();
            AppMethodBeat.o(45477);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45478);
            parcel.writeMap(this.lzB);
            parcel.writeString(this.lzA);
            AppMethodBeat.o(45478);
        }

        static {
            AppMethodBeat.i(45479);
            AppMethodBeat.o(45479);
        }
    }
}
