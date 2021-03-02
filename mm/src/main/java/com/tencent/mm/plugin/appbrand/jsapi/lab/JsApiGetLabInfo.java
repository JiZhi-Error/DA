package com.tencent.mm.plugin.appbrand.jsapi.lab;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiGetLabInfo extends d {
    public static final int CTRL_INDEX = 557;
    public static final String NAME = "getLabInfo";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46365);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiGetLabInfo", "fail:data is null");
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46365);
            return;
        }
        String optString = jSONObject.optString("labId");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiGetLabInfo", "fail:labId is null");
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46365);
            return;
        }
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(optString), a.class, new com.tencent.mm.ipcinvoker.d<GetLabInfoResult>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(GetLabInfoResult getLabInfoResult) {
                AppMethodBeat.i(46359);
                GetLabInfoResult getLabInfoResult2 = getLabInfoResult;
                if (getLabInfoResult2 != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("exist", Boolean.valueOf(getLabInfoResult2.eek));
                    hashMap.put("enabled", Boolean.valueOf(getLabInfoResult2.enabled));
                    fVar.i(i2, JsApiGetLabInfo.this.n("ok", hashMap));
                    AppMethodBeat.o(46359);
                    return;
                }
                fVar.i(i2, JsApiGetLabInfo.this.h("fail", null));
                AppMethodBeat.o(46359);
            }
        });
        AppMethodBeat.o(46365);
    }

    static final class a implements b<IPCString, GetLabInfoResult> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, com.tencent.mm.ipcinvoker.d<GetLabInfoResult> dVar) {
            AppMethodBeat.i(46364);
            IPCString iPCString2 = iPCString;
            com.tencent.mm.plugin.welab.a.a.a aVar = (com.tencent.mm.plugin.welab.a.a.a) g.af(com.tencent.mm.plugin.welab.a.a.a.class);
            if (iPCString2 == null || Util.isNullOrNil(iPCString2.value) || aVar == null) {
                dVar.bn(null);
                AppMethodBeat.o(46364);
                return;
            }
            GetLabInfoResult getLabInfoResult = new GetLabInfoResult();
            getLabInfoResult.eek = aVar.bbD(iPCString2.value);
            getLabInfoResult.enabled = aVar.Uw(iPCString2.value);
            dVar.bn(getLabInfoResult);
            AppMethodBeat.o(46364);
        }
    }

    static final class GetLabInfoResult implements Parcelable {
        public static final Parcelable.Creator<GetLabInfoResult> CREATOR = new Parcelable.Creator<GetLabInfoResult>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo.GetLabInfoResult.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetLabInfoResult[] newArray(int i2) {
                return new GetLabInfoResult[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetLabInfoResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46360);
                GetLabInfoResult getLabInfoResult = new GetLabInfoResult(parcel);
                AppMethodBeat.o(46360);
                return getLabInfoResult;
            }
        };
        private boolean eek = false;
        private boolean enabled = false;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            byte b2;
            byte b3 = 1;
            AppMethodBeat.i(46361);
            if (this.eek) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            parcel.writeByte(b2);
            if (!this.enabled) {
                b3 = 0;
            }
            parcel.writeByte(b3);
            AppMethodBeat.o(46361);
        }

        public GetLabInfoResult() {
        }

        protected GetLabInfoResult(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(46362);
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.eek = z;
            this.enabled = parcel.readByte() == 0 ? false : z2;
            AppMethodBeat.o(46362);
        }

        static {
            AppMethodBeat.i(46363);
            AppMethodBeat.o(46363);
        }
    }
}
