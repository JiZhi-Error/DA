package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class j extends i {
    public static final int CTRL_INDEX = 874;
    public static final String NAME = "adOperateWXData";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.i
    public final void a(final d dVar, JSONObject jSONObject, final int i2, e eVar) {
        l OT;
        AppMethodBeat.i(226688);
        String appId = dVar.getAppId();
        if (appId == null) {
            Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "appId is null");
            dVar.i(i2, h("fail:internal error", null));
            AppMethodBeat.o(226688);
            return;
        }
        e.M(appId, System.currentTimeMillis());
        try {
            String string = jSONObject.getString("data");
            com.tencent.mm.ak.d aXF = f.id(this.iLM).aXF();
            ceu ceu = (ceu) aXF.iLK.iLR;
            ceu.jfi = dVar.getAppId();
            ceu.oTm = new b(string.getBytes() == null ? new byte[0] : string.getBytes());
            AppBrandRuntime runtime = dVar.getRuntime();
            if (!(runtime == null || (OT = runtime.OT()) == null)) {
                ceu.MjZ = OT.leE.kNW;
            }
            if (dVar instanceof s) {
                if (ceu.Mka == null) {
                    ceu.Mka = new fdg();
                }
                ceu.Mka.NyS = 1;
            } else if (dVar instanceof ac) {
                if (ceu.Mka == null) {
                    ceu.Mka = new fdg();
                }
                ceu.Mka.NyS = 2;
            }
            if ((dVar.getRuntime() instanceof q) && ((q) dVar.getRuntime()).ON().cyA != null) {
                if (ceu.Mka == null) {
                    ceu.Mka = new fdg();
                }
                ceu.Mka.scene = ((q) dVar.getRuntime()).ON().cyA.scene;
            }
            IPCRunCgi.a(aXF, new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.auth.j.AnonymousClass1 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                    AppMethodBeat.i(226687);
                    if (!dVar.bsV() && !dVar.isRunning()) {
                        Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi callback, callbackId:%s, service not running or preloaded", Integer.valueOf(i2));
                        AppMethodBeat.o(226687);
                    } else if (i2 == 0 && i3 == 0 && (dVar.iLL.iLR instanceof cev)) {
                        cev cev = (cev) dVar.iLL.iLR;
                        if (cev.Mkb.dIZ == 0) {
                            String yO = cev.oTm.yO();
                            if (Util.isNullOrNil(yO)) {
                                Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi success, data is null");
                                dVar.i(i2, j.this.h("fail invalid response", null));
                                AppMethodBeat.o(226687);
                                return;
                            }
                            e.N(dVar.getAppId(), System.currentTimeMillis());
                            Log.i("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi success, callbackId:%s, callback data:%s", Integer.valueOf(i2), cev.oTm);
                            HashMap hashMap = new HashMap();
                            hashMap.put("data", yO);
                            dVar.i(i2, j.this.n("ok", hashMap));
                            AppMethodBeat.o(226687);
                            return;
                        }
                        dVar.i(i2, j.this.h("fail:errorCode:" + cev.Mkb.dIZ + ",errorMsg:" + cev.Mkb.dJa, null));
                        AppMethodBeat.o(226687);
                    } else {
                        Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi fail, errType:%s, errCode:%s, errMsg:%s, response:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, dVar.iLL.iLR);
                        dVar.i(i2, j.this.h("fail invalid response", null));
                        AppMethodBeat.o(226687);
                    }
                }
            });
            AppMethodBeat.o(226688);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "data exception %s", e2.getMessage());
            dVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(226688);
        }
    }
}
