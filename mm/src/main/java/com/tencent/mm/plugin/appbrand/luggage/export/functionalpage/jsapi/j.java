package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiOpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class j extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 201;
    public static final String NAME = "openUrl";
    @Deprecated
    public static final a nbC = new a((byte) 0);

    static {
        AppMethodBeat.i(228918);
        AppMethodBeat.o(228918);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<MMActivity, x> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lBv;
        final /* synthetic */ int lyo;
        final /* synthetic */ String mkH;
        final /* synthetic */ j nbD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(j jVar, com.tencent.mm.plugin.appbrand.d dVar, int i2, String str) {
            super(1);
            this.nbD = jVar;
            this.lBv = dVar;
            this.lyo = i2;
            this.mkH = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(MMActivity mMActivity) {
            AppMethodBeat.i(228916);
            final MMActivity mMActivity2 = mMActivity;
            p.h(mMActivity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            mMActivity2.mmSetOnActivityResultCallback(new MMActivity.a(this) {
                /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.j.b.AnonymousClass1 */
                final /* synthetic */ b nbE;

                {
                    this.nbE = r1;
                }

                @Override // com.tencent.mm.ui.MMActivity.a
                public final void d(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(228915);
                    com.tencent.mm.plugin.appbrand.d dVar = this.nbE.lBv;
                    if (dVar != null) {
                        dVar.i(this.nbE.lyo, this.nbE.nbD.Zf("ok"));
                    }
                    mMActivity2.finish();
                    AppMethodBeat.o(228915);
                }
            });
            MMApplicationContext.getContext().getString(R.string.zb);
            h.a((Context) mMActivity2, MMApplicationContext.getContext().getString(R.string.j5o), false, (DialogInterface.OnCancelListener) null);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.mkH);
            c.a((Context) mMActivity2, "webview", ".ui.tools.WebViewUI", intent, com.tencent.luggage.sdk.g.a.aK(this.nbD), true);
            x xVar = x.SXb;
            AppMethodBeat.o(228916);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiOpenUrl$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(228917);
        com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        if (jSONObject != null && jSONObject.has("url")) {
            d.b(dVar2 != null ? dVar2.getContext() : null, new b(this, dVar2, i2, jSONObject.getString("url")));
            AppMethodBeat.o(228917);
        } else if (dVar2 != null) {
            dVar2.i(i2, Zf("fail:invalid data"));
            AppMethodBeat.o(228917);
        } else {
            AppMethodBeat.o(228917);
        }
    }
}
