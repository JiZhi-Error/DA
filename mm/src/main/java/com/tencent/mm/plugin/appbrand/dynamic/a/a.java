package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.ac.h;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class a implements e {
    private final h<Object, View> lmz = new h<>();

    a() {
        AppMethodBeat.i(121207);
        AppMethodBeat.o(121207);
    }

    @Override // com.tencent.mm.modelappbrand.e
    public final boolean d(Object obj, View view) {
        AppMethodBeat.i(121208);
        boolean r = this.lmz.r(obj, view);
        AppMethodBeat.o(121208);
        return r;
    }

    @Override // com.tencent.mm.modelappbrand.e
    public final boolean e(Object obj, View view) {
        AppMethodBeat.i(121209);
        boolean J = this.lmz.J(obj, view);
        AppMethodBeat.o(121209);
        return J;
    }

    @Override // com.tencent.mm.modelappbrand.e
    public final Set<View> ch(Object obj) {
        AppMethodBeat.i(121210);
        Set<View> cM = this.lmz.cM(obj);
        AppMethodBeat.o(121210);
        return cM;
    }

    @Override // com.tencent.mm.modelappbrand.e
    public final Set<View> ci(Object obj) {
        AppMethodBeat.i(121211);
        Set<View> cN = this.lmz.cN(obj);
        AppMethodBeat.o(121211);
        return cN;
    }

    @Override // com.tencent.mm.modelappbrand.e
    public final Map<Object, Set<View>> aXG() {
        AppMethodBeat.i(121212);
        Map<Object, Set<View>> bZl = this.lmz.bZl();
        AppMethodBeat.o(121212);
        return bZl;
    }
}
