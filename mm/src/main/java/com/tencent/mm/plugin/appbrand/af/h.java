package com.tencent.mm.plugin.appbrand.af;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import org.json.JSONObject;

public final class h extends d<f> {
    public static final int CTRL_INDEX = 621;
    public static final String NAME = "showShareActionSheet";
    e ojT;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        final ag agVar;
        AppMethodBeat.i(49360);
        if (fVar instanceof c) {
            agVar = ((c) fVar).bsz();
        } else if (fVar instanceof ag) {
            agVar = (ag) fVar;
        } else {
            agVar = null;
        }
        if (agVar == null) {
            Log.e("MicroMsg.JsApiShowShareActionSheet", "fail, page view is null");
            fVar.i(i2, h("fail:page don't exist", null));
            AppMethodBeat.o(49360);
            return;
        }
        Log.i("MicroMsg.JsApiShowShareActionSheet", "weishi show share action sheet");
        agVar.getRuntime().i(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.af.h.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(49355);
                h hVar = h.this;
                ag agVar = agVar;
                hVar.ojT = new e(agVar.getContext(), false, 1);
                hVar.ojT.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.appbrand.af.h.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(49356);
                        mVar.kV(0, R.string.g5c);
                        AppMethodBeat.o(49356);
                    }
                };
                hVar.ojT.HLY = new o.g(agVar) {
                    /* class com.tencent.mm.plugin.appbrand.af.h.AnonymousClass3 */
                    final /* synthetic */ ag lyx;

                    {
                        this.lyx = r2;
                    }

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(49357);
                        if (menuItem.getItemId() == 0) {
                            new com.tencent.mm.plugin.appbrand.menu.o().a(this.lyx.getContext(), this.lyx, this.lyx.getAppId(), this.lyx.yK(u.ShareAppMsg.ordinal()));
                            h.a(h.this);
                        }
                        AppMethodBeat.o(49357);
                    }
                };
                hVar.ojT.mLN = true;
                hVar.ojT.mLO = true;
                hVar.ojT.dGm();
                agVar.a(new i.b(agVar) {
                    /* class com.tencent.mm.plugin.appbrand.af.h.AnonymousClass4 */
                    final /* synthetic */ ag lyx;

                    {
                        this.lyx = r2;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
                    public final void onBackground() {
                        AppMethodBeat.i(49358);
                        h.a(h.this);
                        this.lyx.b(this);
                        AppMethodBeat.o(49358);
                    }
                });
                agVar.a(new i.c(agVar) {
                    /* class com.tencent.mm.plugin.appbrand.af.h.AnonymousClass5 */
                    final /* synthetic */ ag lyx;

                    {
                        this.lyx = r2;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
                    public final void onDestroy() {
                        AppMethodBeat.i(49359);
                        h.a(h.this);
                        this.lyx.b(this);
                        AppMethodBeat.o(49359);
                    }
                });
                AppMethodBeat.o(49355);
            }
        }, 0);
        fVar.i(i2, h("ok", null));
        AppMethodBeat.o(49360);
    }

    static /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(49361);
        try {
            if (hVar.ojT != null) {
                hVar.ojT.bMo();
            }
            AppMethodBeat.o(49361);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiShowShareActionSheet", "hideActionSheet exception:%s", e2);
            AppMethodBeat.o(49361);
        }
    }
}
