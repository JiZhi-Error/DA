package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0006*\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0006*\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t¨\u0006\n"}, hxF = {"unsafeLazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "bind", "Landroid/view/View;", "Landroid/app/Activity;", "idRes", "", "plugin-radar_release"})
public final class i {
    public static final <T extends View> f<T> aq(View view, int i2) {
        AppMethodBeat.i(138793);
        p.h(view, "$this$bind");
        f<T> a2 = g.a(k.NONE, new b(view, i2));
        AppMethodBeat.o(138793);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "T", "Landroid/view/View;", "invoke", "()Landroid/view/View;"})
    static final class a extends q implements kotlin.g.a.a<T> {
        final /* synthetic */ Activity BBP;
        final /* synthetic */ int BBQ = R.id.gq_;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Activity activity) {
            super(0);
            this.BBP = activity;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(138791);
            View findViewById = this.BBP.findViewById(this.BBQ);
            if (findViewById == null) {
                t tVar = new t("null cannot be cast to non-null type T");
                AppMethodBeat.o(138791);
                throw tVar;
            }
            AppMethodBeat.o(138791);
            return findViewById;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "T", "Landroid/view/View;", "invoke", "()Landroid/view/View;"})
    static final class b extends q implements kotlin.g.a.a<T> {
        final /* synthetic */ int BBQ;
        final /* synthetic */ View BBR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(View view, int i2) {
            super(0);
            this.BBR = view;
            this.BBQ = i2;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(138792);
            View findViewById = this.BBR.findViewById(this.BBQ);
            if (findViewById == null) {
                t tVar = new t("null cannot be cast to non-null type T");
                AppMethodBeat.o(138792);
                throw tVar;
            }
            AppMethodBeat.o(138792);
            return findViewById;
        }
    }
}
