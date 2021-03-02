package com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundfetch.l;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiSetBackgroundFetchToken extends d {
    public static final int CTRL_INDEX = 641;
    public static final String NAME = "setBackgroundFetchToken";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46130);
        if (jSONObject == null) {
            Log.e("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "fail:data is null");
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46130);
            return;
        }
        String optString = jSONObject.optString("token");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "fail:token is null");
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46130);
        } else if (optString.length() > 1024) {
            Log.e("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "fail:token is too long");
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46130);
        } else {
            XIPCInvoker.a(MainProcessIPCService.dkO, new SetBackgroundFetchTokenParcel(fVar.getAppId(), optString), a.class, new com.tencent.mm.ipcinvoker.d<IPCBoolean>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.JsApiSetBackgroundFetchToken.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(IPCBoolean iPCBoolean) {
                    AppMethodBeat.i(46124);
                    IPCBoolean iPCBoolean2 = iPCBoolean;
                    if (iPCBoolean2 == null || !iPCBoolean2.value) {
                        Log.i("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "setBackgroundFetchToken fail");
                        fVar.i(i2, JsApiSetBackgroundFetchToken.this.h("fail", null));
                        AppMethodBeat.o(46124);
                        return;
                    }
                    Log.i("MicroMsg.AppBrand.JsApiSetBackgroundFetchToken", "setBackgroundFetchToken success");
                    fVar.i(i2, JsApiSetBackgroundFetchToken.this.h("ok", null));
                    AppMethodBeat.o(46124);
                }
            });
            AppMethodBeat.o(46130);
        }
    }

    static class a implements b<SetBackgroundFetchTokenParcel, IPCBoolean> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(SetBackgroundFetchTokenParcel setBackgroundFetchTokenParcel, com.tencent.mm.ipcinvoker.d<IPCBoolean> dVar) {
            AppMethodBeat.i(46129);
            SetBackgroundFetchTokenParcel setBackgroundFetchTokenParcel2 = setBackgroundFetchTokenParcel;
            if (setBackgroundFetchTokenParcel2 != null && !Util.isNullOrNil(setBackgroundFetchTokenParcel2.appId) && !Util.isNullOrNil(setBackgroundFetchTokenParcel2.token)) {
                String Xy = y.Xy(setBackgroundFetchTokenParcel2.appId);
                if (!Util.isNullOrNil(Xy) && g.af(l.class) != null) {
                    ((l) g.af(l.class)).cN(Xy, setBackgroundFetchTokenParcel2.token);
                    dVar.bn(new IPCBoolean(true));
                    AppMethodBeat.o(46129);
                    return;
                }
            }
            dVar.bn(new IPCBoolean(false));
            AppMethodBeat.o(46129);
        }
    }

    static class SetBackgroundFetchTokenParcel implements Parcelable {
        public static final Parcelable.Creator<SetBackgroundFetchTokenParcel> CREATOR = new Parcelable.Creator<SetBackgroundFetchTokenParcel>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.JsApiSetBackgroundFetchToken.SetBackgroundFetchTokenParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SetBackgroundFetchTokenParcel[] newArray(int i2) {
                return new SetBackgroundFetchTokenParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SetBackgroundFetchTokenParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46125);
                SetBackgroundFetchTokenParcel setBackgroundFetchTokenParcel = new SetBackgroundFetchTokenParcel(parcel);
                AppMethodBeat.o(46125);
                return setBackgroundFetchTokenParcel;
            }
        };
        String appId;
        String token;

        public SetBackgroundFetchTokenParcel(String str, String str2) {
            this.appId = str;
            this.token = str2;
        }

        protected SetBackgroundFetchTokenParcel(Parcel parcel) {
            AppMethodBeat.i(46126);
            this.appId = parcel.readString();
            this.token = parcel.readString();
            AppMethodBeat.o(46126);
        }

        static {
            AppMethodBeat.i(46128);
            AppMethodBeat.o(46128);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46127);
            parcel.writeString(this.appId);
            parcel.writeString(this.token);
            AppMethodBeat.o(46127);
        }
    }
}
