package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiOpenLocation;", "Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiOpenLocation;", "()V", "invoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "data", "Lorg/json/JSONObject;", "callbackId", "", "plugin-appbrand-integration_release"})
public final class i extends p {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
    static final class a extends q implements b<MMActivity, x> {
        final /* synthetic */ JSONObject lFq;
        final /* synthetic */ f lLf;
        final /* synthetic */ int lyo;
        final /* synthetic */ i nbz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(i iVar, f fVar, int i2, JSONObject jSONObject) {
            super(1);
            this.nbz = iVar;
            this.lLf = fVar;
            this.lyo = i2;
            this.lFq = jSONObject;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(MMActivity mMActivity) {
            AppMethodBeat.i(228913);
            final MMActivity mMActivity2 = mMActivity;
            kotlin.g.b.p.h(mMActivity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            mMActivity2.mmSetOnActivityResultCallback(new MMActivity.a(this) {
                /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.i.a.AnonymousClass1 */
                final /* synthetic */ a nbA;

                {
                    this.nbA = r1;
                }

                @Override // com.tencent.mm.ui.MMActivity.a
                public final void d(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(228912);
                    f fVar = this.nbA.lLf;
                    if (fVar != null) {
                        fVar.i(this.nbA.lyo, this.nbA.nbz.Zf("ok"));
                    }
                    mMActivity2.finish();
                    AppMethodBeat.o(228912);
                }
            });
            Intent X = i.X(this.lFq);
            if (X == null) {
                f fVar = this.lLf;
                if (fVar != null) {
                    fVar.i(this.lyo, this.nbz.Zf("fail:invalid data"));
                }
                mMActivity2.finish();
            } else {
                c.b(mMActivity2, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", X, com.tencent.luggage.sdk.g.a.aK(this.nbz));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(228913);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.i.p
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        Context context;
        AppMethodBeat.i(228914);
        if (fVar != null) {
            context = fVar.getContext();
        } else {
            context = null;
        }
        d.b(context, new a(this, fVar, i2, jSONObject));
        AppMethodBeat.o(228914);
    }
}
