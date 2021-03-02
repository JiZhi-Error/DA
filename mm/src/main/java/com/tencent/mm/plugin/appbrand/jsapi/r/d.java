package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d<ac> {
    private static final int CTRL_INDEX = 280;
    private static final String NAME = "getRegionData";
    private static final AtomicReference<String> mmR = new AtomicReference<>();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(ac acVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46748);
        final WeakReference weakReference = new WeakReference(acVar);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.r.d.AnonymousClass1 */

            public final void run() {
                String str;
                String str2 = null;
                AppMethodBeat.i(46746);
                String str3 = (String) d.mmR.get();
                if (Util.isNullOrNil(str3)) {
                    if (MMApplicationContext.isMMProcessExist()) {
                        try {
                            str = ((IPCString) XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, a.class)).value;
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e2, "query updated address path", new Object[0]);
                            str = null;
                        }
                    } else {
                        Log.e("MicroMsg.AppBrand.JsApiGetRegionData", "MMProcessExist==FALSE, will fallback assets file");
                        str = "";
                    }
                    if (!Util.isNullOrNil(str)) {
                        Log.i("MicroMsg.AppBrand.JsApiGetRegionData", "read file use updatedAddressPath[%s]", str);
                        try {
                            str2 = s.boY(str);
                        } catch (Exception e3) {
                            Log.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e3, "read address from file %s", str);
                        }
                    } else {
                        str2 = str3;
                    }
                    if (Util.isNullOrNil(str2)) {
                        Log.i("MicroMsg.AppBrand.JsApiGetRegionData", "read file use assets");
                        try {
                            str2 = Util.convertStreamToString(MMApplicationContext.getContext().getAssets().open("address"));
                        } catch (Exception e4) {
                            Log.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e4, "read address from assets", new Object[0]);
                        }
                    }
                    if (!Util.isNullOrNil(str2)) {
                        Log.i("MicroMsg.AppBrand.JsApiGetRegionData", "update process shared data, size[%d]", Integer.valueOf(str2.length()));
                        d.mmR.set(str2);
                    } else {
                        Log.e("MicroMsg.AppBrand.JsApiGetRegionData", "get invalid data");
                    }
                } else {
                    Log.i("MicroMsg.AppBrand.JsApiGetRegionData", "use process shared cache, size[%d]", Integer.valueOf(str3.length()));
                    str2 = str3;
                }
                ac acVar = (ac) weakReference.get();
                if (acVar != null && acVar.isRunning()) {
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("data", str2);
                    acVar.i(i2, d.this.n("ok", hashMap));
                }
                AppMethodBeat.o(46746);
            }
        }, "MicroMsg.AppBrand.JsApiGetRegionData");
        AppMethodBeat.o(46748);
    }

    static final class a implements k<IPCVoid, IPCString> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCString invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(46747);
            String str = g.aAh().cachePath + "address";
            if (s.YS(str)) {
                IPCString iPCString = new IPCString(str);
                AppMethodBeat.o(46747);
                return iPCString;
            }
            IPCString iPCString2 = new IPCString("");
            AppMethodBeat.o(46747);
            return iPCString2;
        }
    }

    static {
        AppMethodBeat.i(46749);
        AppMethodBeat.o(46749);
    }
}
