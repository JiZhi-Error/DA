package com.tencent.mm.plugin.appbrand.jsapi.lab;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiSetLabInfo extends d {
    public static final int CTRL_INDEX = 558;
    public static final String NAME = "setLabInfo";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46372);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiSetLabInfo", "fail:data is null");
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46372);
            return;
        }
        String optString = jSONObject.optString("labId");
        if (Util.isNullOrNil(optString) || !jSONObject.has("enabled")) {
            Log.e("MicroMsg.JsApiSetLabInfo", "fail:labId is null or no enabled");
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46372);
            return;
        }
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCSetLabInfoRequest(optString, jSONObject.optBoolean("enabled")), a.class, new com.tencent.mm.ipcinvoker.d<IPCBoolean>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCBoolean iPCBoolean) {
                AppMethodBeat.i(46366);
                IPCBoolean iPCBoolean2 = iPCBoolean;
                if (iPCBoolean2 == null || !iPCBoolean2.value) {
                    fVar.i(i2, JsApiSetLabInfo.this.h("fail", null));
                    AppMethodBeat.o(46366);
                    return;
                }
                fVar.i(i2, JsApiSetLabInfo.this.h("ok", null));
                AppMethodBeat.o(46366);
            }
        });
        AppMethodBeat.o(46372);
    }

    static final class a implements b<IPCSetLabInfoRequest, IPCBoolean> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCSetLabInfoRequest iPCSetLabInfoRequest, com.tencent.mm.ipcinvoker.d<IPCBoolean> dVar) {
            AppMethodBeat.i(46367);
            IPCSetLabInfoRequest iPCSetLabInfoRequest2 = iPCSetLabInfoRequest;
            com.tencent.mm.plugin.welab.a.a.a aVar = (com.tencent.mm.plugin.welab.a.a.a) g.af(com.tencent.mm.plugin.welab.a.a.a.class);
            if (iPCSetLabInfoRequest2 == null || Util.isNullOrNil(iPCSetLabInfoRequest2.dNI) || aVar == null) {
                dVar.bn(null);
                AppMethodBeat.o(46367);
            } else if (!aVar.bbD(iPCSetLabInfoRequest2.dNI)) {
                dVar.bn(new IPCBoolean(false));
                AppMethodBeat.o(46367);
            } else {
                aVar.cR(iPCSetLabInfoRequest2.dNI, iPCSetLabInfoRequest2.enabled);
                dVar.bn(new IPCBoolean(true));
                AppMethodBeat.o(46367);
            }
        }
    }

    static final class IPCSetLabInfoRequest implements Parcelable {
        public static final Parcelable.Creator<IPCSetLabInfoRequest> CREATOR = new Parcelable.Creator<IPCSetLabInfoRequest>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo.IPCSetLabInfoRequest.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IPCSetLabInfoRequest[] newArray(int i2) {
                return new IPCSetLabInfoRequest[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IPCSetLabInfoRequest createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46368);
                IPCSetLabInfoRequest iPCSetLabInfoRequest = new IPCSetLabInfoRequest(parcel);
                AppMethodBeat.o(46368);
                return iPCSetLabInfoRequest;
            }
        };
        private String dNI;
        private boolean enabled;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46369);
            parcel.writeString(this.dNI);
            parcel.writeByte(this.enabled ? (byte) 1 : 0);
            AppMethodBeat.o(46369);
        }

        public IPCSetLabInfoRequest() {
        }

        public IPCSetLabInfoRequest(String str, boolean z) {
            this.dNI = str;
            this.enabled = z;
        }

        protected IPCSetLabInfoRequest(Parcel parcel) {
            AppMethodBeat.i(46370);
            this.dNI = parcel.readString();
            this.enabled = parcel.readByte() != 0;
            AppMethodBeat.o(46370);
        }

        static {
            AppMethodBeat.i(46371);
            AppMethodBeat.o(46371);
        }
    }
}
