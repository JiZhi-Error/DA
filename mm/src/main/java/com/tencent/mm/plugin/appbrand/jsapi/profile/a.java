package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Intent;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiOpenBizProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a extends d<f> {
    private static final int CTRL_INDEX = 560;
    private static final String NAME = NAME;
    public static final C0696a mny = new C0696a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
    static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult> implements AppBrandProxyUIProcessTask.b<ProfileResult> {
        final /* synthetic */ int $scene;
        final /* synthetic */ String hLl;
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;
        final /* synthetic */ String mnA;
        final /* synthetic */ a mnz;

        b(a aVar, f fVar, int i2, String str, int i3, String str2) {
            this.mnz = aVar;
            this.lyn = fVar;
            this.lyo = i2;
            this.mnA = str;
            this.$scene = i3;
            this.hLl = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
        public final /* synthetic */ void a(ProfileResult profileResult) {
            boolean z = false;
            AppMethodBeat.i(50635);
            ProfileResult profileResult2 = profileResult;
            if (profileResult2 == null) {
                Log.e("MicroMsg.JsApiOpenBizProfile", "onReceiveResult, null result");
            } else {
                Log.i("MicroMsg.JsApiOpenBizProfile", "onReceiveResult resultCode:%d", Integer.valueOf(profileResult2.resultCode));
                switch (profileResult2.resultCode) {
                    case 0:
                        this.lyn.i(this.lyo, this.mnz.Zf("fail"));
                        AppMethodBeat.o(50635);
                        return;
                    case 1:
                        final Intent intent = new Intent();
                        if (!Util.isNullOrNil(this.mnA)) {
                            intent.putExtra("key_add_contact_report_info", this.mnA);
                        }
                        if ((profileResult2.mnH & 1) != 0) {
                            z = true;
                        }
                        if (z) {
                            intent.putExtra("Contact_Scene", this.$scene);
                            intent.putExtra("Contact_User", this.hLl);
                            intent.putExtra("key_use_new_contact_profile", true);
                            this.lyn.i(new Runnable(this) {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.profile.a.b.AnonymousClass1 */
                                final /* synthetic */ b mnB;

                                {
                                    this.mnB = r1;
                                }

                                public final void run() {
                                    AppMethodBeat.i(228448);
                                    c.b(this.mnB.lyn.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                                    AppMethodBeat.o(228448);
                                }
                            }, 100);
                            this.lyn.i(this.lyo, this.mnz.Zf("ok"));
                            AppMethodBeat.o(50635);
                            return;
                        }
                        Log.i("MicroMsg.JsApiOpenBizProfile", "onReceiveResult, fail:not biz contact");
                        this.lyn.i(this.lyo, this.mnz.Zf("fail:not biz contact"));
                        AppMethodBeat.o(50635);
                        return;
                    case 2:
                        this.lyn.i(this.lyo, this.mnz.Zf("cancel"));
                        AppMethodBeat.o(50635);
                        return;
                }
            }
            this.lyn.i(this.lyo, this.mnz.Zf("fail"));
            AppMethodBeat.o(50635);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(50636);
        p.h(fVar, "env");
        p.h(jSONObject, "data");
        String optString = jSONObject.optString(ch.COL_USERNAME);
        int optInt = jSONObject.optInt("scene", 122);
        String optString2 = jSONObject.optString("profileReportInfo");
        if (Util.isNullOrNil(optString)) {
            fVar.i(i2, Zf("fail:invalid data"));
            AppMethodBeat.o(50636);
            return;
        }
        ProfileRequest profileRequest = new ProfileRequest();
        profileRequest.username = optString;
        profileRequest.scene = optInt;
        com.tencent.mm.plugin.appbrand.ipc.a.a(fVar.getContext(), profileRequest, new b(this, fVar, i2, optString2, optInt, optString));
        AppMethodBeat.o(50636);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiOpenBizProfile$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.profile.a$a  reason: collision with other inner class name */
    public static final class C0696a {
        private C0696a() {
        }

        public /* synthetic */ C0696a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(50637);
        AppMethodBeat.o(50637);
    }
}
