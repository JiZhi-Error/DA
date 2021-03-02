package com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiTriggerBackgroundFetch extends d<c> {
    public static final int CTRL_INDEX = 685;
    public static final String NAME = "triggerBackgroundFetch";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46137);
        final c cVar2 = cVar;
        AppBrandInitConfigWC bsC = cVar2.getRuntime().bsC();
        String str = bsC.appId;
        String str2 = bsC.username;
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            cVar2.i(i2, h("fail", null));
            AppMethodBeat.o(46137);
            return;
        }
        XIPCInvoker.a(MainProcessIPCService.dkO, new TriggerBackgroundFetchParcel(str, str2), a.class, new com.tencent.mm.ipcinvoker.d<IPCString>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.JsApiTriggerBackgroundFetch.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCString iPCString) {
                AppMethodBeat.i(46131);
                IPCString iPCString2 = iPCString;
                Log.i("MicroMsg.AppBrand.JsApiTriggerBackgroundFetch", "result:%s", iPCString2);
                if (iPCString2 == null || Util.isNullOrNil(iPCString2.value)) {
                    cVar2.i(i2, JsApiTriggerBackgroundFetch.this.h("fail", null));
                    AppMethodBeat.o(46131);
                    return;
                }
                cVar2.i(i2, JsApiTriggerBackgroundFetch.this.h(iPCString2.value, null));
                AppMethodBeat.o(46131);
            }
        });
        AppMethodBeat.o(46137);
    }

    static class a implements b<TriggerBackgroundFetchParcel, IPCString> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(TriggerBackgroundFetchParcel triggerBackgroundFetchParcel, com.tencent.mm.ipcinvoker.d<IPCString> dVar) {
            AppMethodBeat.i(46136);
            TriggerBackgroundFetchParcel triggerBackgroundFetchParcel2 = triggerBackgroundFetchParcel;
            String cM = com.tencent.mm.plugin.appbrand.backgroundfetch.b.cM(triggerBackgroundFetchParcel2.userName, triggerBackgroundFetchParcel2.appId);
            if (dVar != null) {
                dVar.bn(new IPCString(cM));
            }
            AppMethodBeat.o(46136);
        }
    }

    static class TriggerBackgroundFetchParcel implements Parcelable {
        public static final Parcelable.Creator<TriggerBackgroundFetchParcel> CREATOR = new Parcelable.Creator<TriggerBackgroundFetchParcel>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.JsApiTriggerBackgroundFetch.TriggerBackgroundFetchParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ TriggerBackgroundFetchParcel[] newArray(int i2) {
                return new TriggerBackgroundFetchParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TriggerBackgroundFetchParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46132);
                TriggerBackgroundFetchParcel triggerBackgroundFetchParcel = new TriggerBackgroundFetchParcel(parcel);
                AppMethodBeat.o(46132);
                return triggerBackgroundFetchParcel;
            }
        };
        String appId;
        String userName;

        public TriggerBackgroundFetchParcel(String str, String str2) {
            this.appId = str;
            this.userName = str2;
        }

        protected TriggerBackgroundFetchParcel(Parcel parcel) {
            AppMethodBeat.i(46133);
            this.appId = parcel.readString();
            this.userName = parcel.readString();
            AppMethodBeat.o(46133);
        }

        static {
            AppMethodBeat.i(46135);
            AppMethodBeat.o(46135);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46134);
            parcel.writeString(this.appId);
            parcel.writeString(this.userName);
            AppMethodBeat.o(46134);
        }
    }
}
