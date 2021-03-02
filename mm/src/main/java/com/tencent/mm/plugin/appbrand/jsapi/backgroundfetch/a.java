package com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenParcel;
import com.tencent.mm.plugin.appbrand.backgroundfetch.l;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends d {
    public static final int CTRL_INDEX = 654;
    public static final String NAME = "getBackgroundFetchToken";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46123);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(fVar.getAppId()), C0649a.class, new com.tencent.mm.ipcinvoker.d<IPCString>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCString iPCString) {
                AppMethodBeat.i(46121);
                IPCString iPCString2 = iPCString;
                if (iPCString2 == null || Util.isNullOrNil(iPCString2.value)) {
                    Log.i("MicroMsg.AppBrand.JsApiGetBackgroundFetchToken", "getBackgroundFetchToken fail");
                    fVar.i(i2, a.this.h("fail", null));
                    AppMethodBeat.o(46121);
                    return;
                }
                Log.i("MicroMsg.AppBrand.JsApiGetBackgroundFetchToken", "getBackgroundFetchToken success");
                String str = iPCString2.value;
                HashMap hashMap = new HashMap();
                hashMap.put("token", str);
                Log.i("MicroMsg.AppBrand.JsApiGetBackgroundFetchToken", "getBackgroundFetchToken, token:%s", str);
                fVar.i(i2, a.this.n("ok", hashMap));
                AppMethodBeat.o(46121);
            }
        });
        AppMethodBeat.o(46123);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.a$a  reason: collision with other inner class name */
    static class C0649a implements b<IPCString, IPCString> {
        private C0649a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCString iPCString, com.tencent.mm.ipcinvoker.d<IPCString> dVar) {
            AppBrandBackgroundFetchDataTokenParcel Wy;
            AppMethodBeat.i(46122);
            IPCString iPCString2 = iPCString;
            if (iPCString2 != null && !Util.isNullOrNil(iPCString2.value)) {
                String Xy = y.Xy(iPCString2.value);
                if (!Util.isNullOrNil(Xy) && g.af(l.class) != null && (Wy = ((l) g.af(l.class)).Wy(Xy)) != null && !Util.isNullOrNil(Wy.token)) {
                    dVar.bn(new IPCString(Wy.token));
                    AppMethodBeat.o(46122);
                    return;
                }
            }
            dVar.bn(new IPCString());
            AppMethodBeat.o(46122);
        }
    }
}
