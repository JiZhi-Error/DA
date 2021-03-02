package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends i {
    public static final int CTRL_INDEX = 521;
    public static final String NAME = "updateVoIPChatMuteConfig";
    boolean mkb = false;
    boolean mkc = false;
    private boolean mkd = false;

    public f() {
        AppMethodBeat.i(174848);
        c.aem(NAME);
        AppMethodBeat.o(174848);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.openvoice.i
    public final void a(final com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46690);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("muteConfig");
            final boolean z = jSONObject2.getBoolean("muteMicrophone");
            boolean z2 = jSONObject2.getBoolean("muteEarphone");
            boolean optBoolean = jSONObject.optBoolean("handsFree", false);
            Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: muteMicroPhone:%b, muteEarPhone:%b, handsFree:%b", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(optBoolean));
            q.INSTANCE.a(z2, new b<String>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.f.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                    AppMethodBeat.i(46688);
                    Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: earphone done! %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 && i3 == 0) {
                        f.this.mkc = true;
                        f.a(f.this, cVar, i2);
                        AppMethodBeat.o(46688);
                        return;
                    }
                    cVar.i(i2, f.this.h("fail: ".concat(String.valueOf(str)), null));
                    AppMethodBeat.o(46688);
                }
            });
            q.INSTANCE.b(z, new b<String>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.f.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                    boolean z = true;
                    AppMethodBeat.i(46689);
                    Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: microphone done! %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 && i3 == 0) {
                        f.this.mkb = true;
                        f fVar = f.this;
                        if (z) {
                            z = false;
                        }
                        fVar.hl(z);
                        f.a(f.this, cVar, i2);
                        AppMethodBeat.o(46689);
                        return;
                    }
                    cVar.i(i2, f.this.h("fail: ".concat(String.valueOf(str)), null));
                    AppMethodBeat.o(46689);
                }
            });
            q.INSTANCE.c(optBoolean, new b<String>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.f.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b
                public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                    AppMethodBeat.i(226928);
                    Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: setHandsFree done! %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    AppMethodBeat.o(226928);
                }
            });
            AppMethodBeat.o(46690);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", e2, "", new Object[0]);
            AppMethodBeat.o(46690);
        }
    }

    static /* synthetic */ void a(f fVar, s sVar, int i2) {
        AppMethodBeat.i(46691);
        if (fVar.mkb && fVar.mkc) {
            sVar.i(i2, fVar.h("ok", null));
        }
        AppMethodBeat.o(46691);
    }
}
