package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.jsapi.cl;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalPrivateOpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiPrivateOpenUrl;", "()V", "startWebViewUI", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class l extends cl {
    public static final int CTRL_INDEX = 406;
    public static final String NAME = "private_openUrl";
    @Deprecated
    public static final a nbG = new a((byte) 0);

    static {
        AppMethodBeat.i(228925);
        AppMethodBeat.o(228925);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<MMActivity, x> {
        final /* synthetic */ Intent $intent;
        final /* synthetic */ int lyo;
        final /* synthetic */ l nbH;
        final /* synthetic */ k nbI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(l lVar, k kVar, int i2, Intent intent) {
            super(1);
            this.nbH = lVar;
            this.nbI = kVar;
            this.lyo = i2;
            this.$intent = intent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(MMActivity mMActivity) {
            AppMethodBeat.i(228923);
            final MMActivity mMActivity2 = mMActivity;
            p.h(mMActivity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            mMActivity2.mmSetOnActivityResultCallback(new MMActivity.a(this) {
                /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.l.b.AnonymousClass1 */
                final /* synthetic */ b nbJ;

                {
                    this.nbJ = r1;
                }

                @Override // com.tencent.mm.ui.MMActivity.a
                public final void d(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(228922);
                    this.nbJ.nbI.i(this.nbJ.lyo, this.nbJ.nbH.Zf("ok"));
                    mMActivity2.finish();
                    AppMethodBeat.o(228922);
                }
            });
            MMApplicationContext.getContext().getString(R.string.zb);
            h.a((Context) mMActivity2, MMApplicationContext.getContext().getString(R.string.j5o), false, (DialogInterface.OnCancelListener) null);
            c.a((Context) mMActivity2, "webview", ".ui.tools.WebViewUI", this.$intent, com.tencent.luggage.sdk.g.a.aK(this.nbH), true);
            x xVar = x.SXb;
            AppMethodBeat.o(228923);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalPrivateOpenUrl$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.cl
    public final void a(Context context, Intent intent, k kVar, int i2) {
        AppMethodBeat.i(228924);
        p.h(intent, "intent");
        p.h(kVar, "component");
        d.b(context, new b(this, kVar, i2, intent));
        AppMethodBeat.o(228924);
    }
}
