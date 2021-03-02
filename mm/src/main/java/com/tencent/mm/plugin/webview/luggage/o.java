package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;

public class o {
    g ISU;
    n IUo;
    e oXS = new e(this.ISU.mContext, 0, false);

    public o(g gVar, n nVar) {
        AppMethodBeat.i(78411);
        this.ISU = gVar;
        this.IUo = nVar;
        this.oXS.HLX = new o.f() {
            /* class com.tencent.mm.plugin.webview.luggage.o.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(78407);
                o oVar = o.this;
                oVar.IUo.b(oVar.ISU.mContext, oVar.ISU, mVar);
                AppMethodBeat.o(78407);
            }
        };
        this.oXS.QNH = new o.f() {
            /* class com.tencent.mm.plugin.webview.luggage.o.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(78408);
                o oVar = o.this;
                oVar.IUo.c(oVar.ISU.mContext, oVar.ISU, mVar);
                AppMethodBeat.o(78408);
            }
        };
        this.oXS.HLY = new o.g() {
            /* class com.tencent.mm.plugin.webview.luggage.o.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(78409);
                o.this.d(menuItem);
                o.this.oXS.bMo();
                AppMethodBeat.o(78409);
            }
        };
        this.oXS.QNK = new o.g() {
            /* class com.tencent.mm.plugin.webview.luggage.o.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(78410);
                o.this.d(menuItem);
                o.this.oXS.bMo();
                AppMethodBeat.o(78410);
            }
        };
        this.oXS.dGm();
        AppMethodBeat.o(78411);
    }

    /* access modifiers changed from: protected */
    public final void d(MenuItem menuItem) {
        AppMethodBeat.i(78412);
        this.IUo.a(this.ISU.mContext, this.ISU, menuItem);
        AppMethodBeat.o(78412);
    }

    public final void gca() {
        AppMethodBeat.i(78413);
        if (this.oXS != null) {
            this.oXS.bMo();
        }
        AppMethodBeat.o(78413);
    }
}
