package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.IPCSetCurrentPaySpeech;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import org.json.JSONObject;

public final class c extends d {
    public static final int CTRL_INDEX = 634;
    public static final String NAME = "setCurrentPaySpeech";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46660);
        Log.i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "invoke JsApiSetCurrentPaySpeech!");
        if (fVar == null) {
            Log.e("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:component is null");
            AppMethodBeat.o(46660);
        } else if (fVar.getContext() == null) {
            Log.e("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:context is null");
            fVar.i(i2, h("fail：service.getContext() is null ", null));
            AppMethodBeat.o(46660);
        } else {
            String optString = jSONObject.optString("dialectPackId");
            String optString2 = jSONObject.optString("tempFilePath");
            String optString3 = jSONObject.optString("md5Sum");
            String optString4 = jSONObject.optString("version");
            boolean optBoolean = jSONObject.optBoolean("isOnlyDownload");
            Log.d("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "tempFilePath:%s dialectPackId:%s md5Sum:%s isOnlyDownload:%s", optString2, optString, optString3, Boolean.valueOf(optBoolean));
            String str = "";
            if (!Util.isNullOrNil(optString2)) {
                o VY = fVar.getFileSystem().VY(optString2);
                if (VY == null || !VY.exists()) {
                    Log.i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "fail:tempFile no exist");
                    fVar.i(i2, h("fail:tempFile no exist", null));
                    AppMethodBeat.o(46660);
                    return;
                }
                str = aa.z(VY.her());
            }
            h.a(MainProcessIPCService.dkO, new IPCSetCurrentPaySpeech.IPCSetCurrentPaySpeechParam(optString, optString2, str, optBoolean, optString3, optString4), IPCSetCurrentPaySpeech.class, new com.tencent.mm.ipcinvoker.d<Bundle>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(46659);
                    Bundle bundle2 = bundle;
                    if (bundle2 != null) {
                        String string = bundle2.getString("IPCResultInfo");
                        Log.i("MicroMsg.OfflineVoice.JsApiSetCurrentPaySpeech", "onCallback() IPCResultInfo：%s", string);
                        fVar.i(i2, c.this.h(string, null));
                    }
                    AppMethodBeat.o(46659);
                }
            });
            AppMethodBeat.o(46660);
        }
    }
}
