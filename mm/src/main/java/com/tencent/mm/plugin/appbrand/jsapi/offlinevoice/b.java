package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends d {
    public static final int CTRL_INDEX = 635;
    public static final String NAME = "loadPaySpeechDialectConfig";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46658);
        Log.i("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "invoke JsApiLoadPaySpeechDialectConfig!");
        if (fVar == null) {
            Log.e("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "fail:component is null");
            AppMethodBeat.o(46658);
        } else if (fVar.getContext() == null) {
            Log.e("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "fail:context is null");
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(46658);
        } else {
            h.a(MainProcessIPCService.dkO, null, a.class, new com.tencent.mm.ipcinvoker.d<Bundle>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(46657);
                    Bundle bundle2 = bundle;
                    HashMap hashMap = new HashMap();
                    String string = bundle2.getString("idsStr", "");
                    if (!Util.isNullOrNil(string)) {
                        Vector vector = new Vector();
                        String[] split = string.split(",");
                        Vector vector2 = new Vector();
                        Vector vector3 = new Vector();
                        for (String str : split) {
                            vector.add(str);
                            if (Util.isEqual(str, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                d.bIh();
                                String aax = d.aax(str);
                                Log.i("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "resPath:%s", aax);
                                if (Util.isNullOrNil(aax) || !s.YS(aax)) {
                                    d.bIh();
                                    vector2.add(d.aay(str));
                                    vector3.add("");
                                } else {
                                    d.bIh();
                                    vector2.add(d.aay("0-1"));
                                    d.bIh();
                                    vector3.add(d.aaz("0-1"));
                                }
                            } else {
                                d.bIh();
                                vector2.add(d.aay(str));
                                d.bIh();
                                vector3.add(d.aaz(str));
                            }
                        }
                        if (vector.size() > 0) {
                            hashMap.put("downloadedPackId", new JSONArray((Collection) vector));
                            hashMap.put("downloadedPackMD5", new JSONArray((Collection) vector2));
                            hashMap.put("downloadedPackVersions", new JSONArray((Collection) vector3));
                            Log.i("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "downloadedPackId:%s  ，downloadedPackMD5：%s, downloadedPackVersions:%s", new JSONArray((Collection) vector).toString(), new JSONArray((Collection) vector2).toString(), new JSONArray((Collection) vector3).toString());
                        }
                    }
                    String string2 = bundle2.getString("resId", "");
                    Log.i("MicroMsg.OfflineVoice.JsApiLoadPaySpeechDialectConfig", "resId:%s", string2);
                    hashMap.put("dialectPackId", string2);
                    fVar.i(i2, b.this.n("ok", hashMap));
                    AppMethodBeat.o(46657);
                }
            });
            AppMethodBeat.o(46658);
        }
    }
}
