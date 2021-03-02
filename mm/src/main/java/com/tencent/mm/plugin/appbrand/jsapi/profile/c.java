package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class c extends d<f> {
    private static final int CTRL_INDEX = 508;
    private static final String NAME = "profile";
    public static final a mnE = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
    static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult> implements AppBrandProxyUIProcessTask.b<ProfileResult> {
        final /* synthetic */ int $scene;
        final /* synthetic */ String hLl;
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;
        final /* synthetic */ String mnA;
        final /* synthetic */ c mnF;
        final /* synthetic */ String mnG;

        b(c cVar, f fVar, int i2, String str, int i3, String str2, String str3) {
            this.mnF = cVar;
            this.lyn = fVar;
            this.lyo = i2;
            this.mnA = str;
            this.$scene = i3;
            this.mnG = str2;
            this.hLl = str3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
        public final /* synthetic */ void a(ProfileResult profileResult) {
            AppMethodBeat.i(50641);
            ProfileResult profileResult2 = profileResult;
            Log.i("MicroMsg.JsApiProfile", "onReceiveResult resultCode:%d", Integer.valueOf(profileResult2.resultCode));
            switch (profileResult2.resultCode) {
                case 0:
                    this.lyn.i(this.lyo, this.mnF.Zf("fail"));
                    AppMethodBeat.o(50641);
                    return;
                case 1:
                    Intent intent = new Intent();
                    if (!Util.isNullOrNil(this.mnA)) {
                        intent.putExtra("key_add_contact_report_info", this.mnA);
                    }
                    if ((profileResult2.mnH & 1) != 0) {
                        intent.putExtra("Contact_Scene", this.$scene);
                    }
                    String str = this.mnG;
                    p.g(str, "tabTypeStr");
                    if ((str.length() > 0) && Util.safeParseInt(this.mnG) == 2) {
                        intent.putExtra("biz_profile_tab_type", 1);
                    }
                    intent.putExtra("Contact_User", this.hLl);
                    intent.putExtra("key_use_new_contact_profile", true);
                    com.tencent.mm.br.c.b(this.lyn.getContext(), "profile", ".ui.ContactInfoUI", intent);
                    this.lyn.i(this.lyo, this.mnF.Zf("ok"));
                    AppMethodBeat.o(50641);
                    return;
                case 2:
                    this.lyn.i(this.lyo, this.mnF.Zf("cancel"));
                    AppMethodBeat.o(50641);
                    return;
                default:
                    this.lyn.i(this.lyo, this.mnF.Zf("fail"));
                    AppMethodBeat.o(50641);
                    return;
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(50642);
        p.h(fVar, "env");
        p.h(jSONObject, "data");
        String optString = jSONObject.optString(ch.COL_USERNAME);
        int optInt = jSONObject.optInt("scene", 122);
        String optString2 = jSONObject.optString("profileReportInfo");
        String optString3 = jSONObject.optString("tabType");
        if (Util.isNullOrNil(optString)) {
            fVar.i(i2, Zf("fail:invalid data"));
            AppMethodBeat.o(50642);
            return;
        }
        ProfileRequest profileRequest = new ProfileRequest();
        profileRequest.username = optString;
        profileRequest.scene = optInt;
        com.tencent.mm.plugin.appbrand.ipc.a.a(fVar.getContext(), profileRequest, new b(this, fVar, i2, optString2, optInt, optString3, optString));
        AppMethodBeat.o(50642);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiProfile$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "JSAPI_Profile_Tab_Video", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(50643);
        AppMethodBeat.o(50643);
    }
}
