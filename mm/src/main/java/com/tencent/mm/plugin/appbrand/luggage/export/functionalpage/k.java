package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.support.v4.content.b;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.ui.ao;
import java.util.Map;

public class k extends ag implements p {
    private String naA;

    static /* synthetic */ void a(k kVar) {
        AppMethodBeat.i(227143);
        kVar.ii(false);
        AppMethodBeat.o(227143);
    }

    k() {
        super(a.class);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ag, com.tencent.luggage.sdk.b.a.c
    public final void NW() {
        AppMethodBeat.i(227141);
        bRi().setNavHidden(false);
        AppMethodBeat.o(227141);
    }

    public final void acu(String str) {
        this.naA = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ag
    public final void bOE() {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ag, com.tencent.luggage.sdk.b.a.c, com.tencent.mm.plugin.appbrand.page.ac
    public final void NR() {
        AppMethodBeat.i(47522);
        try {
            super.NR();
            AppMethodBeat.o(47522);
        } catch (NullPointerException e2) {
            AppMethodBeat.o(47522);
        }
    }

    static final class a extends com.tencent.mm.plugin.appbrand.page.a<k> {
        public a(k kVar) {
            super(kVar);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.a
        public final bb ee(Context context) {
            AppMethodBeat.i(47517);
            com.tencent.luggage.game.page.a aVar = new com.tencent.luggage.game.page.a();
            AppMethodBeat.o(47517);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.page.a.c, com.tencent.mm.plugin.appbrand.page.a
        public final Map<String, p> Nf() {
            AppMethodBeat.i(162530);
            Map<String, p> bOM = com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.k.bOM();
            AppMethodBeat.o(162530);
            return bOM;
        }

        @Override // com.tencent.mm.plugin.appbrand.page.a, com.tencent.mm.plugin.appbrand.page.ae
        public final boolean dy(String str) {
            AppMethodBeat.i(47518);
            ((k) NN()).P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(47516);
                    ((k) a.this.NN()).bRi().gz(false);
                    ((k) a.this.NN()).bRi().setNavHidden(false);
                    ((k) a.this.NN()).bRi().setMainTitle(a.this.getContext().getResources().getString(R.string.a0p));
                    ((k) a.this.NN()).bRi().setBackgroundColor(b.n(a.this.getContext(), R.color.a2r));
                    ((k) a.this.NN()).bRi().setForegroundStyle((ao.isDarkMode() ? e.a.WHITE : e.a.BLACK).name());
                    ((k) a.this.NN()).YP((ao.isDarkMode() ? e.a.WHITE : e.a.BLACK).name());
                    ((k) a.this.NN()).getContentView().setBackgroundColor(b.n(a.this.getContext(), R.color.a2s));
                    k.a((k) a.this.NN());
                    ((k) a.this.NN()).adM("onLoadURL");
                    AppMethodBeat.o(47516);
                }
            });
            AppMethodBeat.o(47518);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ag, com.tencent.mm.plugin.appbrand.page.ac
    public final void bOF() {
        AppMethodBeat.i(227142);
        super.bOF();
        bRi().setNavHidden(true);
        AppMethodBeat.o(227142);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final void i(int i2, String str) {
        AppMethodBeat.i(47521);
        ((l) super.getRuntime()).naC.a(this, i2, str);
        AppMethodBeat.o(47521);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ag, com.tencent.luggage.sdk.b.a.c
    public final /* synthetic */ d NP() {
        AppMethodBeat.i(47524);
        l lVar = (l) super.getRuntime();
        AppMethodBeat.o(47524);
        return lVar;
    }
}
